package com.test;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * Created by liuhongbing on 2018/8/15.
 */
@XStreamAlias("ROOT")
@XStreamConverter(value = XmlHelper.class)
public class ResponseRoot {
    @XStreamAlias("RETURN_CODE")
    private Integer RETURN_CODE;

    @XStreamAlias("RETURN_MSG")
    private String RETURN_MSG;

    @XStreamAlias("SIGN")
    private String SIGN;

    @XStreamAlias("SIGN_TYPE")
    private String SIGN_TYPE;

    @XStreamAlias("RES_ENCRYPTED")
    private String RES_ENCRYPTED;

    public Integer getRETURN_CODE() {
        return RETURN_CODE;
    }

    public String getRETURN_MSG() {
        return RETURN_MSG;
    }

    public String getSIGN() {
        return SIGN;
    }

    public String getSIGN_TYPE() {
        return SIGN_TYPE;
    }

    public String getRES_ENCRYPTED() {
        return RES_ENCRYPTED;
    }

    public void setRETURN_CODE(Integer RETURN_CODE) {
        this.RETURN_CODE = RETURN_CODE;
    }

    public void setRETURN_MSG(String RETURN_MSG) {
        this.RETURN_MSG = RETURN_MSG;
    }

    public void setSIGN(String SIGN) {
        this.SIGN = SIGN;
    }

    public void setSIGN_TYPE(String SIGN_TYPE) {
        this.SIGN_TYPE = SIGN_TYPE;
    }

    public void setRES_ENCRYPTED(String RES_ENCRYPTED) {
        this.RES_ENCRYPTED = RES_ENCRYPTED;
    }
}
