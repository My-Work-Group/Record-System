package com.ruoyi.project.record.overload.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author: 庞沛东
 * @Description:
 * @Date: create in 2022/4/2 10:11
 */

public class Overload {

    private static final long serialVersionUID = 1L;

    // 超限id
    private Integer overloadId;

    // 车牌号
    private String vehPlateNum;

    // 超限检测时间
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date checkTime;
    //检测站点
    private String checkSite;
    // 车货总重
    private double totalWeight;
    // 超限吨位
    private double outWeight;
    // 装载的货物
    private String goods;
    // 装载时间
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date loadTime;
    //装载地点
    private String loadSite;
    //送往目的地
    private String dest;

    public Integer getOverloadId() {
        return overloadId;
    }

    public void setOverloadId(Integer overloadId) {
        this.overloadId = overloadId;
    }

    public String getVehPlateNum() {
        return vehPlateNum;
    }

    public void setVehPlateNum(String vehPlateNum) {
        this.vehPlateNum = vehPlateNum;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getCheckSite() {
        return checkSite;
    }

    public void setCheckSite(String checkSite) {
        this.checkSite = checkSite;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public double getOutWeight() {
        return outWeight;
    }

    public void setOutWeight(double outWeight) {
        this.outWeight = outWeight;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public Date getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(Date loadTime) {
        this.loadTime = loadTime;
    }

    public String getLoadSite() {
        return loadSite;
    }

    public void setLoadSite(String loadSite) {
        this.loadSite = loadSite;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }




    @Override
    public String toString() {
        return "OverLoad{" +
                "overloadId=" + overloadId +
                ", vehPlateNum='" + vehPlateNum + '\'' +
                ", checkTime=" + checkTime +
                ", checkSiteCode='" + checkSite + '\'' +
                ", totalWeight=" + totalWeight +
                ", outWeight=" + outWeight +
                ", goods='" + goods + '\'' +
                ", loadTime=" + loadTime +
                ", loadSite='" + loadSite + '\'' +
                ", dest='" + dest + '\'' +
                '}';
    }
}
