package com.test;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * Created by liuhongbing on 2018/8/15.
 */
@XStreamAlias("ROOT")
@XStreamConverter(value = XmlHelper.class)
public class RequestRoot {
    @XStreamAlias("FUN_CODE")
    private String FUN_CODE;

    @XStreamAlias("USER_ID")
    private String USER_ID;

    @XStreamAlias("SIGN")
    private String SIGN;

    @XStreamAlias("SIGN_TYPE")
    private String SIGN_TYPE;

    @XStreamAlias("REQ_ENCRYPTED")
    private String REQ_ENCRYPTED;

    public void setFUN_CODE(String FUN_CODE) {
        this.FUN_CODE = FUN_CODE;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    public void setSIGN(String SIGN) {
        this.SIGN = SIGN;
    }

    public void setSIGN_TYPE(String SIGN_TYPE) {
        this.SIGN_TYPE = SIGN_TYPE;
    }

    public void setREQ_ENCRYPTED(String REQ_ENCRYPTED) {
        this.REQ_ENCRYPTED = REQ_ENCRYPTED;
    }

    public String getFUN_CODE() {
        return FUN_CODE;
    }

    public String getUSER_ID() {
        return USER_ID;
    }

    public String getSIGN() {
        return SIGN;
    }

    public String getSIGN_TYPE() {
        return SIGN_TYPE;
    }

    public String getREQ_ENCRYPTED() {
        return REQ_ENCRYPTED;
    }
}
