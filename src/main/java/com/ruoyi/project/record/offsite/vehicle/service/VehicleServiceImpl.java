package com.ruoyi.project.record.offsite.vehicle.service;

import com.ruoyi.project.record.offsite.vehicle.domain.Vehicle;
import com.ruoyi.project.record.offsite.vehicle.mapper.VehicleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements IVehicleService {
    private static final Logger log = LoggerFactory.getLogger(VehicleServiceImpl.class);

    @Autowired
    private VehicleMapper vehicleMapper;


    @Override
    public List<Vehicle> selectCaseList(Vehicle vehicle) {
        return null;
    }

    @Override
    public int insertVehicle(Vehicle vehicle) {
        int row = vehicleMapper.insertVehicle(vehicle);
        return row;
    }

    @Override
    public int vehicle(Vehicle vehicle) {
        return 0;
    }

    @Override
    public int updateCaseInfo(Vehicle vehicle) {
        return 0;
    }
}
