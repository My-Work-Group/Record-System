package com.ruoyi.project.record.lgtrans.LtOverload.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.project.record.common.CommonOverload;

import java.util.Date;

/**
 * @Author: 庞沛东
 * @Description:
 * @Date: create in 2022/4/2 10:11
 */

public class LtOverload{


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

    // 货物长度
    private double goodsLength;

    // 车货整体宽度
    private double goodsWidth;

    // 车货整体高度
    private double goodsHeight;


    // 车货整体长度
    private double overallLength;

    // 车货整体宽度
    private double overallWidth;

    // 车货整体高度
    private double overallHeight;

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

    public double getGoodsLength() {
        return goodsLength;
    }

    public void setGoodsLength(double goodsLength) {
        this.goodsLength = goodsLength;
    }

    public double getGoodsWidth() {
        return goodsWidth;
    }

    public void setGoodsWidth(double goodsWidth) {
        this.goodsWidth = goodsWidth;
    }

    public double getGoodsHeight() {
        return goodsHeight;
    }

    public void setGoodsHeight(double goodsHeight) {
        this.goodsHeight = goodsHeight;
    }

    public double getOverallLength() {
        return overallLength;
    }

    public void setOverallLength(double overallLength) {
        this.overallLength = overallLength;
    }

    public double getOverallWidth() {
        return overallWidth;
    }

    public void setOverallWidth(double overallWidth) {
        this.overallWidth = overallWidth;
    }

    public double getOverallHeight() {
        return overallHeight;
    }

    public void setOverallHeight(double overallHeight) {
        this.overallHeight = overallHeight;
    }

    @Override
    public String toString() {
        return "OverLoad{" +
                "overloadId=" + overloadId +
                ", vehId='" + vehId + '\'' +
                ", checkTime=" + checkTime +
                ", checkSite=" + checkSite +
                ", goods='" + goods + '\'' +
                ", goodsLength='" + goodsLength + '\'' +
                ", goodsWidth='" + goodsWidth + '\'' +
                ", goodsHeight='" + goodsHeight + '\'' +
                ", overallLength='" + overallLength + '\'' +
                ", overallWidth='" + overallWidth + '\'' +
                ", overallHeight='" + overallHeight + '\'' +
                ", loadTime=" + loadTime +
                ", loadSite='" + loadSite + '\'' +
                ", dest='" + dest + '\'' +
                '}';
    }

}
