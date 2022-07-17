package com.ruoyi.project.record.offsite.vehicle.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.ibatis.annotations.Param;

public class Vehicle {

    private static final long serialVersionUID = 1L;
    // 车辆id
    private Integer vehId;
    // 车牌号
    private String vehPlateNum;
    // 车牌颜色
    private String vehPlateColor;
    // 轴数
    private int vehAxleNum;
    // 车型
    private String vehType;

    public Integer getVehId() {
        return vehId;
    }

    public void setVehId(Integer vehId) {
        this.vehId = vehId;
    }

    public String getVehPlateNum() {
        return vehPlateNum;
    }

    public void setVehPlateNum(String vehPlateNum) {
        this.vehPlateNum = vehPlateNum;
    }

    public String getVehPlateColor() {
        return vehPlateColor;
    }

    public void setVehPlateColor(String vehPlateColor) {
        this.vehPlateColor = vehPlateColor;
    }

    public int getVehAxleNum() {
        return vehAxleNum;
    }

    public void setVehAxleNum(int vehAxleNum) {
        this.vehAxleNum = vehAxleNum;
    }

    public String getVehType() {
        return vehType;
    }

    public void setVehType(String vehType) {
        this.vehType = vehType;
    }



    @Override
    public String toString() {
        return "Vehicle{" +
                "vehId=" + vehId +
                ", vehPlateNum='" + vehPlateNum + '\'' +
                ", vehPlateColor='" + vehPlateColor + '\'' +
                ", vehAxleNum=" + vehAxleNum +
                ", vehType='" + vehType + '\'' +
                '}';
    }

    //    @Override
//    public String toString() {
//        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).
//                append("vehId", getVehId()).
//                append("personId",getPersonId()).
//                append("companyId",getCompanyId()).
//                append("vehPlate", getVehPlateNum()).
//                append("vehPlateColor", getVehPlateColor()).
//                append("VehAxleNum", getVehAxleNum()).
//                append("vehType", getVehType()).toString();
//
//    }
}
