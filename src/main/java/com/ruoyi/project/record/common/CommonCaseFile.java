package com.ruoyi.project.record.common;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class CommonCaseFile {

    // 案件概览
    private CommonCaseInfo caseInfo;

    // 公司实体
    private CommonCompany company;

    // 个人实体
    private CommonPerson person;

    // 车辆实体
    private CommonVehicle vehicle;

    //超限信息实体
    private CommonOverload overload;

    public CommonCaseInfo getCaseInfo() {
        return caseInfo;
    }

    public void setCaseInfo(CommonCaseInfo caseInfo) {
        this.caseInfo = caseInfo;
    }

    public CommonCompany getCompany() {
        return company;
    }

    public void setCompany(CommonCompany company) {
        this.company = company;
    }

    public CommonPerson getPerson() {
        return person;
    }

    public void setPerson(CommonPerson person) {
        this.person = person;
    }

    public CommonVehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(CommonVehicle vehicle) {
        this.vehicle = vehicle;
    }

    public CommonOverload getOverload() {
        return overload;
    }

    public void setOverload(CommonOverload overload) {
        this.overload = overload;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("caseInfo",getCaseInfo())
                .append("company",getCompany())
                .append("person",getPerson())
                .append("vehicle",getVehicle())
                .append("overload",getOverload())
                .toString();

    }
}
