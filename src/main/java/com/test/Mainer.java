package com.test;

import com.util.WebServiceHelper;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.util.*;


/**
 * Created by liuhongbing on 2018/3/22.
 */
public class Mainer {
    public static final String KEY = "BD6061593FEB11AB";
    public static final String USER_ID = "DYYSSXM_WX";
    public static final Logger log = Logger.getLogger(Mainer.class);


    public static void main(String[] args) {
        try {
            //设置请求的实体
            PatientInfo patientInfo = new PatientInfo();
            patientInfo.setHOSP_PATIENT_ID("");
            patientInfo.setPATIENT_TYPE(1);
            patientInfo.setID_TYPE(1);
            patientInfo.setID_NO("510623195007173917");
            patientInfo.setCARD_TYPE(0);
            patientInfo.setCARD_NO("");
            patientInfo.setNAME("刘永全");
            patientInfo.setSEX(1);
            patientInfo.setBIRTHDAY("1990-01-01");
            List<PatientInfo> list = new ArrayList<PatientInfo>();
            list.add(patientInfo);
            GetInPatientInfoRequest getInPatientInfoRequest = new GetInPatientInfoRequest();
            getInPatientInfoRequest.setHOS_ID("510603001");
            getInPatientInfoRequest.setPATIENT_INFO(list);

            String xml = XmlHelper.toXml(getInPatientInfoRequest, GetInPatientInfoRequest.class);
            log.info("发送的明文信息:" + xml);
            String encryptReq = encrypt(KEY, xml);

            RequestRoot requestRoot = new RequestRoot();
            requestRoot.setFUN_CODE("1020");
            requestRoot.setUSER_ID(USER_ID);
            requestRoot.setREQ_ENCRYPTED(encryptReq);
            SortedMap<String, String> signMap = sortMapByKey(object2Map(requestRoot), Boolean.TRUE);
            requestRoot.setSIGN(createSign(signMap, KEY));
            requestRoot.setSIGN_TYPE("MD5");
            //得到发送的报文
            String inParam = XmlHelper.toXml(requestRoot, RequestRoot.class);
            log.info("发送的密文信息:" + inParam);
            String url = "http://218.6.146.70:8889/SpiService.asmx";
            String out = WebServiceHelper.invokeWebService(url, ServiceMethodName.UserService.name(), inParam);
            log.info("得到返回的密文信息:" + out);
            //获取返回的数据
            ResponseRoot responseRoot = XmlHelper.toBean(out, ResponseRoot.class);
            if (checkSign(responseRoot, KEY)) {
                if (responseRoot.getRETURN_CODE() == 0) {
                    String response = decrypt(KEY, responseRoot.getRES_ENCRYPTED());
                    GetInPatientInfoResponse getInPatientInfoResponse = XmlHelper.toBean(response, GetInPatientInfoResponse.class);
                    System.out.println("住院号:" + getInPatientInfoResponse.getPATIENT_NO());
                    System.out.println("住院预交金:" + Double.parseDouble(getInPatientInfoResponse.getPREPAID_AMOUNT()) / 100);
                    System.out.println("住院账户余额:" + getInPatientInfoResponse.getBALANCE() / 100);
                    System.out.println("住院总费用:" + Double.parseDouble(getInPatientInfoResponse.getTOTAL_AMOUNT()) / 100);
                    //System.out.println();
                    log.info("返回的明文信息:" + XmlHelper.toXml(getInPatientInfoResponse, GetInPatientInfoResponse.class));
                } else {
                    System.out.println("HIS执行错误:错误码-》:" + responseRoot.getRETURN_CODE() + "->" + responseRoot.getRETURN_MSG());
                }
            } else {
                System.out.println("返回的数据格式签名错误!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    /**
     * AES解密
     *
     * @param sKey key
     * @param sSrc 要加密的字符串
     * @return 加密的密文
     */
    public static String decrypt(String sKey, String sSrc) {
        try {
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = new Base64().decode(sSrc);
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original, "utf-8");
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return e.getMessage();
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return ex.getMessage();
        }
    }

    /**
     * AES 加密
     *
     * @param sKey 加密的密钥
     * @param sSrc 需加密的字符串
     * @return 返回的密文
     */
    public static String encrypt(String sKey, String sSrc) {
        try {
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));
            return new Base64().encodeToString(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 创建签名
     *
     * @param packageParams 待签名的信息
     * @param API_KEY       KEY
     * @return 获取的签名
     */
    public static String createSign(SortedMap<String, String> packageParams, String API_KEY) {
        StringBuffer sb = new StringBuffer();
        Set es = packageParams.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey().toString();
            String v = (String) entry.getValue().toString();
            if (null != v && !"".equals(v) && !"SIGN".equals(k) && !"SIGN_TYPE".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("KEY=" + API_KEY);
        String sign = MD5Util.MD5Encode(sb.toString(), "utf-8").toUpperCase();
        return sign;
    }

    /**
     * 验证调用接口返回的签名
     *
     * @param responseRoot 返回的实体
     * @param API_KEY      密钥
     * @return FALSE:签名不正确 TRUE:签名正确
     */
    public static boolean checkSign(ResponseRoot responseRoot, String API_KEY) {
        SortedMap<String, String> packageParams = sortMapByKey(object2Map(responseRoot), Boolean.TRUE);
        StringBuffer sb = new StringBuffer();
        Set es = packageParams.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey().toString();
            String v = (String) entry.getValue().toString();
            if (null != v && !"".equals(v) && !"SIGN".equals(k) && !"SIGN_TYPE".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("KEY=" + API_KEY);
        String sign = MD5Util.MD5Encode(sb.toString(), "utf-8").toUpperCase();
        return sign.equals(responseRoot.getSIGN().toUpperCase());
    }

    /**
     * 对Map的key进行排序
     *
     * @param oriMap 要排序的Map
     * @param isRise true:key升序  false  降序
     * @return
     */
    public static SortedMap<String, String> sortMapByKey(Map<String, String> oriMap, final boolean isRise) {
        if (oriMap == null || oriMap.isEmpty()) {
            return null;
        }
        SortedMap<String, String> sortMap = new TreeMap<String, String>(new Comparator<String>() {
            public int compare(String o1, String o2) {
                if (isRise) {
                    // 升序排序
                    return o1.compareTo(o2);
                } else {
                    // 降序排序
                    return o2.compareTo(o1);
                }
            }
        });
        sortMap.putAll(oriMap);
        return sortMap;
    }

    /**
     * 实体对象转map
     *
     * @param obj 对象
     * @return
     */
    public static Map<String, String> object2Map(Object obj) {
        Map<String, String> map = new HashMap<String, String>();
        if (obj == null) {
            return map;
        }
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.get(obj) != null)
                    map.put(field.getName(), field.get(obj).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
