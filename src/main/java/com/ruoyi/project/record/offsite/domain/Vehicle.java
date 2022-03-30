package com.ruoyi.project.record.offsite.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Vehicle {

    private static final long serialVersionUID = 1L;
    // 车辆id
    private Long vehId;
    // 车牌号
    private String vehPlate;
    // 车牌颜色
    private String vehPlateColor;
    // 轴数
    private int VehAxleNum;
    // 车型
    private String vehType;

    public Long getVehId() {
        return vehId;
    }

    public void setVehId(Long vehId) {
        this.vehId = vehId;
    }

    public String getVehPlate() {
        return vehPlate;
    }

    public void setVehPlate(String vehPlate) {
        this.vehPlate = vehPlate;
    }

    public String getVehPlateColor() {
        return vehPlateColor;
    }

    public void setVehPlateColor(String vehPlateColor) {
        this.vehPlateColor = vehPlateColor;
    }

    public int getVehAxleNum() {
        return VehAxleNum;
    }

    public void setVehAxleNum(int vehAxleNum) {
        VehAxleNum = vehAxleNum;
    }

    public String getVehType() {
        return vehType;
    }

    public void setVehType(String vehType) {
        this.vehType = vehType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).
                append("vehId", getVehId()).
                append("vehPlate", getVehPlate()).
                append("vehPlateColor", getVehPlateColor()).
                append("VehAxleNum", getVehAxleNum()).
                append("vehType", getVehType()).
                append("vehPlate", getVehPlate()).toString();

//        return "Vehicle{" +
//                "vehId=" + vehId +
//                ", vehPlate='" + vehPlate + '\'' +
//                ", vehPlateColor='" + vehPlateColor + '\'' +
//                ", VehAxleNum=" + VehAxleNum +
//                ", vehType='" + vehType + '\'' +
//                '}';
    }
}
