package com.ruoyi.project.record.offsite.domain;

import com.ruoyi.framework.web.controller.BaseController;

import java.util.Date;

/**
 * @Author: 庞沛东
 * @Description: 案件对象
 * @Date: create in 2022/3/30 11:38
 */

public class OffSiteCase extends BaseController {
    private static final long serialVersionUID = 1L;
    // 案件id
    private Long caseId;
    // 案卷编号
    private String caseNumber;
    // 受案时间
    private Date caseTime;
    // 处罚对象
    private String caseObject;

    // 处罚的车辆id
    private Long vehId;
    // 处罚车辆
    private Vehicle vehicle;

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public Long getVehId() {
        return vehId;
    }

    public void setVehId(Long vehId) {
        this.vehId = vehId;
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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "OffSiteCase{" +
                "caseId=" + caseId +
                ", vehId=" + vehId +
                ", caseNumber='" + caseNumber + '\'' +
                ", caseTime=" + caseTime +
                ", caseObject='" + caseObject + '\'' +
                ", vehicle=" + vehicle +
                '}';
    }

    // 罚款金额
//    private int fine;

//
//    // 车牌号
//    private String plateNum;
//    // 轴数
//    @Excel(name = "轴数")
//    private String axleNum;
//    //车货总重
//    @Excel(name = "车货总重")
//    private String totalWeight;
//    // 检测时间
//    private String checkTime;
//    // 检测站点
//    @Excel(name = "检测站点")
//    private String siteCode;
//    //超限吨位
//    private String overLoad;
//    // 超限比例
//    private String overRate;
//    //	装载的货物
//    private String goods;
//    //	装载时间
//    private String loadingTime;
//    //	装载地点
//    private String loadAdd;
//    //	运往目的地
//    private String destination;


}
