package com.ruoyi.project.record.caseFile.domain;

import com.ruoyi.project.record.company.domain.Company;
import com.ruoyi.project.record.offsite.domain.OffSiteCase;
import com.ruoyi.project.record.overload.domain.Overload;
import com.ruoyi.project.record.person.domain.Person;
import com.ruoyi.project.record.vehicle.domain.Vehicle;

public class CaseFile {

    // 案件概览
    private OffSiteCase offSiteCase;

    // 公司实体
    private Company company;

    // 个人实体
    private Person person;

    // 车辆实体
    private Vehicle vehicle;

    //超限信息实体
    private Overload overload;

    public OffSiteCase getOffSiteCase() {
        return offSiteCase;
    }

    public void setOffSiteCase(OffSiteCase offSiteCase) {
        this.offSiteCase = offSiteCase;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Overload getOverload() {
        return overload;
    }

    public void setOverload(Overload overload) {
        this.overload = overload;
    }

    @Override
    public String toString() {
        return "CaseFile{" +
                "offSiteCase=" + offSiteCase +
                ", company=" + company +
                ", person=" + person +
                ", vehicle=" + vehicle +
                ", overload=" + overload +
                '}';
    }
}
