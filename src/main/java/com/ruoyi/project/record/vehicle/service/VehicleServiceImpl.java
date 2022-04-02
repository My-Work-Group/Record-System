package com.ruoyi.project.record.vehicle.service;

import com.ruoyi.project.record.vehicle.domain.Vehicle;
import com.ruoyi.project.record.vehicle.mapper.VehicleMapper;
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
}
