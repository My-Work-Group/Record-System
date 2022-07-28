package com.ruoyi.project.record.offsite.vehicle.service;

import com.ruoyi.project.record.offsite.vehicle.domain.Vehicle;

/**
 * @Author: 庞沛东
 * @Description:
 * @Date: create in 2022/4/1 13:40
 */

public interface IVehicleService {
    public int insertVehicle(Vehicle vehicle);

    public int updateVehicle(Vehicle vehicle);

    public int selectVehicleById(Vehicle vehicle);

    public String checkVehicleUnique(Vehicle vehicle);
}
