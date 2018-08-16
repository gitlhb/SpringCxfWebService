package com.test;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * Created by liuhongbing on 2018/8/16.
 */
@XStreamAlias("RES")
@XStreamConverter(value = XmlHelper.class)
public class GetInPatientInfoResponse {
    @XStreamAlias("HOS_ID")
    private String HOS_ID;

    @XStreamAlias("HOSP_PATIENT_ID")
    private String HOSP_PATIENT_ID;

    @XStreamAlias("PATIENT_NO")
    private String PATIENT_NO;

    @XStreamAlias("BED_NO")
    private String BED_NO;

    @XStreamAlias("DAY_COUNT")
    private String DAY_COUNT;

    @XStreamAlias("IS_INHOSPITAL")
    private String IS_INHOSPITAL;

    @XStreamAlias("PREPAID_AMOUNT")
    private String PREPAID_AMOUNT;

    @XStreamAlias("TOTAL_AMOUNT")
    private String TOTAL_AMOUNT;

    @XStreamAlias("BALANCE")
    private double BALANCE;

    @XStreamAlias("INHOPITAL_TIME")
    private String INHOPITAL_TIME;

    @XStreamAlias("WARD_CODE")
    private String WARD_CODE;

    @XStreamAlias("WARD_NAME")
    private String WARD_NAME;

    @XStreamAlias("DEPT_CODE")
    private String DEPT_CODE;

    @XStreamAlias("DEPT_NAME")
    private String DEPT_NAME;

    @XStreamAlias("DOCTOR_CODE")
    private String DOCTOR_CODE;

    @XStreamAlias("DOCTOR_NAME")
    private String DOCTOR_NAME;

    @XStreamAlias("NURSE_CODE")
    private String NURSE_CODE;

    @XStreamAlias("NURSE_NAME")
    private String NURSE_NAME;

    @XStreamAlias("ID_TYPE")
    private String ID_TYPE;

    @XStreamAlias("ID_NO")
    private String ID_NO;

    @XStreamAlias("NAME")
    private String NAME;

    @XStreamAlias("SEX")
    private String SEX;

    @XStreamAlias("BIRTHDAY")
    private String BIRTHDAY;

    @XStreamAlias("MOBILE")
    private String MOBILE;

    @XStreamAlias("REMARK")
    private String REMARK;

    public String getHOS_ID() {
        return HOS_ID;
    }

    public String getHOSP_PATIENT_ID() {
        return HOSP_PATIENT_ID;
    }

    public String getPATIENT_NO() {
        return PATIENT_NO;
    }

    public String getBED_NO() {
        return BED_NO;
    }

    public String getDAY_COUNT() {
        return DAY_COUNT;
    }

    public String getIS_INHOSPITAL() {
        return IS_INHOSPITAL;
    }

    public String getPREPAID_AMOUNT() {
        return PREPAID_AMOUNT;
    }

    public String getTOTAL_AMOUNT() {
        return TOTAL_AMOUNT;
    }

    public double getBALANCE() {
        return BALANCE;
    }

    public String getINHOPITAL_TIME() {
        return INHOPITAL_TIME;
    }

    public String getWARD_CODE() {
        return WARD_CODE;
    }

    public String getWARD_NAME() {
        return WARD_NAME;
    }

    public String getDEPT_CODE() {
        return DEPT_CODE;
    }

    public String getDEPT_NAME() {
        return DEPT_NAME;
    }

    public String getDOCTOR_CODE() {
        return DOCTOR_CODE;
    }

    public String getDOCTOR_NAME() {
        return DOCTOR_NAME;
    }

    public String getNURSE_CODE() {
        return NURSE_CODE;
    }

    public String getNURSE_NAME() {
        return NURSE_NAME;
    }

    public String getID_TYPE() {
        return ID_TYPE;
    }

    public String getID_NO() {
        return ID_NO;
    }

    public String getNAME() {
        return NAME;
    }

    public String getSEX() {
        return SEX;
    }

    public String getBIRTHDAY() {
        return BIRTHDAY;
    }

    public String getMOBILE() {
        return MOBILE;
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setHOS_ID(String HOS_ID) {
        this.HOS_ID = HOS_ID;
    }

    public void setHOSP_PATIENT_ID(String HOSP_PATIENT_ID) {
        this.HOSP_PATIENT_ID = HOSP_PATIENT_ID;
    }

    public void setPATIENT_NO(String PATIENT_NO) {
        this.PATIENT_NO = PATIENT_NO;
    }

    public void setBED_NO(String BED_NO) {
        this.BED_NO = BED_NO;
    }

    public void setDAY_COUNT(String DAY_COUNT) {
        this.DAY_COUNT = DAY_COUNT;
    }

    public void setIS_INHOSPITAL(String IS_INHOSPITAL) {
        this.IS_INHOSPITAL = IS_INHOSPITAL;
    }

    public void setPREPAID_AMOUNT(String PREPAID_AMOUNT) {
        this.PREPAID_AMOUNT = PREPAID_AMOUNT;
    }

    public void setTOTAL_AMOUNT(String TOTAL_AMOUNT) {
        this.TOTAL_AMOUNT = TOTAL_AMOUNT;
    }

    public void setBALANCE(double BALANCE) {
        this.BALANCE = BALANCE;
    }

    public void setINHOPITAL_TIME(String INHOPITAL_TIME) {
        this.INHOPITAL_TIME = INHOPITAL_TIME;
    }

    public void setWARD_CODE(String WARD_CODE) {
        this.WARD_CODE = WARD_CODE;
    }

    public void setWARD_NAME(String WARD_NAME) {
        this.WARD_NAME = WARD_NAME;
    }

    public void setDEPT_CODE(String DEPT_CODE) {
        this.DEPT_CODE = DEPT_CODE;
    }

    public void setDEPT_NAME(String DEPT_NAME) {
        this.DEPT_NAME = DEPT_NAME;
    }

    public void setDOCTOR_CODE(String DOCTOR_CODE) {
        this.DOCTOR_CODE = DOCTOR_CODE;
    }

    public void setDOCTOR_NAME(String DOCTOR_NAME) {
        this.DOCTOR_NAME = DOCTOR_NAME;
    }

    public void setNURSE_CODE(String NURSE_CODE) {
        this.NURSE_CODE = NURSE_CODE;
    }

    public void setNURSE_NAME(String NURSE_NAME) {
        this.NURSE_NAME = NURSE_NAME;
    }

    public void setID_TYPE(String ID_TYPE) {
        this.ID_TYPE = ID_TYPE;
    }

    public void setID_NO(String ID_NO) {
        this.ID_NO = ID_NO;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public void setSEX(String SEX) {
        this.SEX = SEX;
    }

    public void setBIRTHDAY(String BIRTHDAY) {
        this.BIRTHDAY = BIRTHDAY;
    }

    public void setMOBILE(String MOBILE) {
        this.MOBILE = MOBILE;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK;
    }
}
