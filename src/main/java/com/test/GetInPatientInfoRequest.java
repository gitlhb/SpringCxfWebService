package com.test;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * Created by liuhongbing on 2018/8/15.
 */
@XStreamAlias("REQ")
@XStreamConverter(value = XmlHelper.class)
public class GetInPatientInfoRequest {
    @XStreamAlias("HOS_ID")
    private String HOS_ID;

    public void setPATIENT_INFO(List<PatientInfo> PATIENT_INFO) {
        this.PATIENT_INFO = PATIENT_INFO;
    }

    @XStreamImplicit(itemFieldName = "PATIENT_INFO")
    @XStreamAlias("PATIENT_INFO")
    private List<PatientInfo> PATIENT_INFO;

    public String getHOS_ID() {
        return HOS_ID;
    }

    public List<PatientInfo> getPATIENT_INFO() {
        return PATIENT_INFO;
    }

    public void setHOS_ID(String HOS_ID) {
        this.HOS_ID = HOS_ID;
    }


}
