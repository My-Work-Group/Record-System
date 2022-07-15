package com.ruoyi.project.record.offsite.vehicle.service;

import com.ruoyi.project.record.offsite.vehicle.mapper.VehicleMapper;
import com.ruoyi.project.record.offsite.vehicle.domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: 庞沛东
 * @Description:
 * @Date: create in 2022/4/1 13:41
 */

public class VehicleServiceImpl implements IVehicleService {

    @Autowired
    private VehicleMapper vehicleMapper;

    @Override
    public int insertVehicle(Vehicle vehicle) {
        return vehicleMapper.insertVehicle(vehicle);
    }

    @Override
    public int updateVehicle(Vehicle vehicle) {
        return vehicleMapper.updateVehicle(vehicle);
    }

}
