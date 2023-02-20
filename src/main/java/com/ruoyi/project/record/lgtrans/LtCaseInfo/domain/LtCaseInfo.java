package com.ruoyi.project.record.lgtrans.LtCaseInfo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.project.record.common.CommonCaseInfo;

import java.util.Date;

/**
 * @Author: 庞沛东
 * @Description: 案件对象
 * @Date: create in 2022/3/30 11:38
 */

public class LtCaseInfo {
    private static final long serialVersionUID = 1L;
    // 案件id
    private Integer caseId;
    // 个人id
    private Integer personId;
    // 公司id
    private Integer companyId;

    // 处罚车辆的车辆id
    private Integer vehId;

    // 案卷编号
    private String caseNumber;

    // 处罚对象
    private String caseObject;
    // 询问人员
    private String enquirePerson;
    // 记录人员
    private String recordPerson;
    // 罚款金额
    private String fine;

    // 受案时间
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date createTime;

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCaseObject() {
        return caseObject;
    }

    public void setCaseObject(String caseObject) {
        this.caseObject = caseObject;
    }

    public Integer getVehId() {
        return vehId;
    }

    public void setVehId(Integer vehId) {
        this.vehId = vehId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getEnquirePerson() {
        return enquirePerson;
    }

    public void setEnquirePerson(String enquirePerson) {
        this.enquirePerson = enquirePerson;
    }

    public String getRecordPerson() {
        return recordPerson;
    }

    public void setRecordPerson(String recordPerson) {
        this.recordPerson = recordPerson;
    }

    public String getFine() {
        return fine;
    }

    public void setFine(String fine) {
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "CaseInfo{" +
                "caseId=" + caseId +
                ", personId=" + personId +
                ", companyId=" + companyId +
                ", vehId='" + vehId + '\'' +
                ", caseNumber='" + caseNumber + '\'' +
                ", caseObject='" + caseObject + '\'' +
                ", enquirePerson='" + enquirePerson + '\'' +
                ", recordPerson='" + recordPerson + '\'' +
                ", fine='" + fine + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
