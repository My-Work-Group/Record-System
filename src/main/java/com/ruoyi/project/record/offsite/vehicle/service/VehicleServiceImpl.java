package com.ruoyi.project.record.offsite.vehicle.service;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.record.offsite.company.domain.Company;
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

    @Override
    public String checkVehicleUnique(Vehicle vehicle) {
        Vehicle info = vehicleMapper.checkVehicleUnique(vehicle.getVehPlateNum());
        if (StringUtils.isNotNull(info)) {
            // 状态码：1为存在该案件编号
            return "1";
        }
        return "0";
    }

}
