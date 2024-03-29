package com.ruoyi.project.record.common;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author: 庞沛东
 * @Description:
 * @Date: create in 2022/4/2 10:11
 */

public class CommonOverload {

    private static final long serialVersionUID = 1L;

    // 超限id
    private Integer overloadId;

    // 处罚车辆的车辆id
    private Integer vehId;

    // 超限检测时间
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date checkTime;

    //检测站点（地点）
    private String checkSite;

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

    public Integer getVehId() {
        return vehId;
    }

    public void setVehId(Integer vehId) {
        this.vehId = vehId;
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
                ", vehId='" + vehId + '\'' +
                ", checkTime=" + checkTime +
                ", checkSite=" + checkSite +
                ", goods='" + goods + '\'' +
                ", loadTime=" + loadTime +
                ", loadSite='" + loadSite + '\'' +
                ", dest='" + dest + '\'' +
                '}';
    }
}
