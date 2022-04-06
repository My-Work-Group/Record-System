package com.ruoyi.project.record.caseInfo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.framework.web.controller.BaseController;

import java.util.Date;

/**
 * @Author: 庞沛东
 * @Description: 案件对象
 * @Date: create in 2022/3/30 11:38
 */

public class CaseInfo extends BaseController {
    private static final long serialVersionUID = 1L;
    // 案件id
    private Integer caseId;

    //处罚车辆的车牌号
    private String vehPlateNum;

    // 案卷编号
    private String caseNumber;
    // 处罚对象
    private String caseObject;

    // 受案时间
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date caseTime;

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

    public Date getCaseTime() {
        return caseTime;
    }

    public void setCaseTime(Date caseTime) {
        this.caseTime = caseTime;
    }

    public String getCaseObject() {
        return caseObject;
    }

    public void setCaseObject(String caseObject) {
        this.caseObject = caseObject;
    }

    public String getVehPlateNum() {
        return vehPlateNum;
    }

    public void setVehPlateNum(String vehPlateNum) {
        this.vehPlateNum = vehPlateNum;
    }

    @Override
    public String toString() {
        return "caseInfo{" +
                "caseId=" + caseId +
                ", vehPlateNum=" + vehPlateNum +
                ", caseNumber='" + caseNumber + '\'' +
                ", caseTime=" + caseTime +
                ", caseObject='" + caseObject + '\'' +
                '}';
    }

}
