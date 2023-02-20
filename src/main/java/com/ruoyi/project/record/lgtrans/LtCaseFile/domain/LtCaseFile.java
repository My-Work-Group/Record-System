package com.ruoyi.project.record.lgtrans.LtCaseFile.domain;

import com.ruoyi.project.record.lgtrans.LtCaseInfo.domain.LtCaseInfo;
import com.ruoyi.project.record.lgtrans.LtCompany.domain.LtCompany;
import com.ruoyi.project.record.lgtrans.LtOverload.domain.LtOverload;
import com.ruoyi.project.record.lgtrans.LtPerson.domain.LtPerson;
import com.ruoyi.project.record.lgtrans.LtVehicle.domain.LtVehicle;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class LtCaseFile {

    // 案件概览
    private LtCaseInfo ltCaseInfo;

    // 公司实体
    private LtCompany ltCompany;

    // 个人实体
    private LtPerson ltPerson;

    // 车辆实体
    private LtVehicle ltVehicle;

    //超限信息实体
    private LtOverload ltOverload;

    public LtCaseInfo getLtCaseInfo() {
        return ltCaseInfo;
    }

    public void setLtCaseInfo(LtCaseInfo ltCaseInfo) {
        this.ltCaseInfo = ltCaseInfo;
    }

    public LtCompany getLtCompany() {
        return ltCompany;
    }

    public void setLtCompany(LtCompany ltCompany) {
        this.ltCompany = ltCompany;
    }

    public LtPerson getLtPerson() {
        return ltPerson;
    }

    public void setLtPerson(LtPerson ltPerson) {
        this.ltPerson = ltPerson;
    }

    public LtVehicle getLtVehicle() {
        return ltVehicle;
    }

    public void setLtVehicle(LtVehicle ltVehicle) {
        this.ltVehicle = ltVehicle;
    }

    public LtOverload getLtOverload() {
        return ltOverload;
    }

    public void setLtOverload(LtOverload ltOverload) {
        this.ltOverload = ltOverload;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("caseInfo", getLtCaseInfo())
                .append("company", getLtCompany())
                .append("person", getLtPerson())
                .append("vehicle", getLtVehicle())
                .append("overload", getLtOverload())
                .toString();
    }
}
