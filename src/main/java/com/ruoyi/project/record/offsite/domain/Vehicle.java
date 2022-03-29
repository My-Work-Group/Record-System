package com.ruoyi.project.record.offsite.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;

public class Vehicle {

    private static final long serialVersionUID = 1L;
    // 车牌号
    private String plateNum;
    // 轴数
    @Excel(name = "轴数")
    private String axleNum;
    //车货总重
    @Excel(name = "车货总重")
    private String totalWeight;
    // 检测时间
    private String checkTime;
    // 检测站点
    @Excel(name = "检测站点")
    private String siteCode;
    //超限吨位
    private String overLoad;
    // 超限比例
    private String overRate;
    //	装载的货物
    private String goods;
    //	装载时间
    private String loadingTime;
    //	装载地点
    private String loadAdd;
    //	运往目的地
    private String destination;

    public String getPlateNum() {
        return plateNum;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }

    public String getAxleNum() {
        return axleNum;
    }

    public void setAxleNum(String axleNum) {
        this.axleNum = axleNum;
    }

    public String getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(String totalWeight) {
        this.totalWeight = totalWeight;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getOverLoad() {
        return overLoad;
    }

    public void setOverLoad(String overLoad) {
        this.overLoad = overLoad;
    }

    public String getOverRate() {
        return overRate;
    }

    public void setOverRate(String overRate) {
        this.overRate = overRate;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public String getLoadingTime() {
        return loadingTime;
    }

    public void setLoadingTime(String loadingTime) {
        this.loadingTime = loadingTime;
    }

    public String getLoadAdd() {
        return loadAdd;
    }

    public void setLoadAdd(String loadAdd) {
        this.loadAdd = loadAdd;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "plateNum='" + plateNum + '\'' +
                ", axleNum='" + axleNum + '\'' +
                ", totalWeight='" + totalWeight + '\'' +
                ", checkTime='" + checkTime + '\'' +
                ", siteCode='" + siteCode + '\'' +
                ", overLoad='" + overLoad + '\'' +
                ", overRate='" + overRate + '\'' +
                ", goods='" + goods + '\'' +
                ", loadingTime='" + loadingTime + '\'' +
                ", loadAdd='" + loadAdd + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}
