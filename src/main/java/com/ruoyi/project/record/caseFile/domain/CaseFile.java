package com.ruoyi.project.record.caseFile.domain;

import com.ruoyi.project.record.offsite.domain.Company;
import com.ruoyi.project.record.offsite.domain.OffSiteCase;
import com.ruoyi.project.record.offsite.domain.Person;
import com.ruoyi.project.record.vehicle.domain.Vehicle;

public class CaseFile {
    private OffSiteCase offSiteCase;
    private Company company;
    private com.ruoyi.project.record.offsite.domain.Person Person;
    private Vehicle vehicle;

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
        return Person;
    }

    public void setPerson(Person person) {
        Person = person;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }


    @Override
    public String toString() {
        return "Param{" +
                "offSiteCase=" + offSiteCase +
                ", company=" + company +
                ", Person=" + Person +
                ", vehicle=" + vehicle +
                '}';
    }
}
