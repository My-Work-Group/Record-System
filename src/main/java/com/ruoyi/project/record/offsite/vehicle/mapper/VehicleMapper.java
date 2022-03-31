package com.ruoyi.project.record.offsite.vehicle.mapper;



import com.ruoyi.project.record.offsite.vehicle.domain.Vehicle;

import java.util.List;

public interface VehicleMapper {

    public List<Vehicle> selectCaseList(Vehicle vehicle);


    public  int insertVehicle(Vehicle vehicle);



    public int vehicle(Vehicle vehicle);



    public int updateCaseInfo(Vehicle vehicle);
}
