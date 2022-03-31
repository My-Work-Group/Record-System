package com.ruoyi.project.record.offsite.domain;

import com.ruoyi.project.record.offsite.vehicle.domain.Vehicle;

public class Param {
    private OffSiteCase offSiteCase;
    private Company company;
    private Person Person;
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

    public com.ruoyi.project.record.offsite.domain.Person getPerson() {
        return Person;
    }

    public void setPerson(com.ruoyi.project.record.offsite.domain.Person person) {
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
