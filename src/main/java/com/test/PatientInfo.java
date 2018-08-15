package com.test;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by liuhongbing on 2018/8/15.
 */
@XStreamAlias("PATIENT_INFO")
public class PatientInfo {
    @XStreamAlias("HOSP_PATIENT_ID")
    private String HOSP_PATIENT_ID;

    @XStreamAlias("PATIENT_TYPE")
    private Integer PATIENT_TYPE;

    @XStreamAlias("ID_TYPE")
    private Integer ID_TYPE;

    @XStreamAlias("ID_NO")
    private String ID_NO;

    @XStreamAlias("CARD_TYPE")
    private Integer CARD_TYPE;

    @XStreamAlias("CARD_NO")
    private String CARD_NO;

    @XStreamAlias("NAME")
    private String NAME;

    @XStreamAlias("SEX")
    private Integer SEX;

    @XStreamAlias("BIRTHDAY")
    private String BIRTHDAY;

    public String getHOSP_PATIENT_ID() {
        return HOSP_PATIENT_ID;
    }

    public Integer getPATIENT_TYPE() {
        return PATIENT_TYPE;
    }

    public Integer getID_TYPE() {
        return ID_TYPE;
    }

    public String getID_NO() {
        return ID_NO;
    }

    public Integer getCARD_TYPE() {
        return CARD_TYPE;
    }

    public String getCARD_NO() {
        return CARD_NO;
    }

    public String getNAME() {
        return NAME;
    }

    public Integer getSEX() {
        return SEX;
    }

    public String getBIRTHDAY() {
        return BIRTHDAY;
    }

    public void setHOSP_PATIENT_ID(String HOSP_PATIENT_ID) {
        this.HOSP_PATIENT_ID = HOSP_PATIENT_ID;
    }

    public void setPATIENT_TYPE(Integer PATIENT_TYPE) {
        this.PATIENT_TYPE = PATIENT_TYPE;
    }

    public void setID_TYPE(Integer ID_TYPE) {
        this.ID_TYPE = ID_TYPE;
    }

    public void setID_NO(String ID_NO) {
        this.ID_NO = ID_NO;
    }

    public void setCARD_TYPE(Integer CARD_TYPE) {
        this.CARD_TYPE = CARD_TYPE;
    }

    public void setCARD_NO(String CARD_NO) {
        this.CARD_NO = CARD_NO;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public void setSEX(Integer SEX) {
        this.SEX = SEX;
    }

    public void setBIRTHDAY(String BIRTHDAY) {
        this.BIRTHDAY = BIRTHDAY;
    }
}
