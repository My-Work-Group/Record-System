package com.ruoyi.project.record.offsite.vehicle.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Vehicle {

    private static final long serialVersionUID = 1L;
    // 车辆id
    private Long vehId;
    // 车牌号
    private String plateNumber;
    // 车牌颜色
    private String plateColor;
    // 轴数
    private int vehAxleNum;
    // 车型
    private String vehType;

    private Long personId;

    private Long companyId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getVehId() {
        return vehId;
    }

    public void setVehId(Long vehId) {
        this.vehId = vehId;
    }

    public String getVehPlate() {
        return plateNumber;
    }

    public void setVehPlate(String vehPlate) {
        this.plateNumber = vehPlate;
    }

    public String getVehPlateColor() {
        return plateColor;
    }

    public void setVehPlateColor(String vehPlateColor) {
        this.plateColor = vehPlateColor;
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

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).
                append("vehId", getVehId()).
                append("personId",getPersonId()).
                append("companyId",getCompanyId()).
                append("vehPlate", getVehPlate()).
                append("vehPlateColor", getVehPlateColor()).
                append("VehAxleNum", getVehAxleNum()).
                append("vehType", getVehType()).toString();

//        return "Vehicle{" +
//                "vehId=" + vehId +
//                ", vehPlate='" + vehPlate + '\'' +
//                ", vehPlateColor='" + vehPlateColor + '\'' +
//                ", VehAxleNum=" + VehAxleNum +
//                ", vehType='" + vehType + '\'' +
//                '}';
    }
}
