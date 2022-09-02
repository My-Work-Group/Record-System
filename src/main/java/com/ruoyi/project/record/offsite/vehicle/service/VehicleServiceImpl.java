package com.ruoyi.project.record.offsite.vehicle.service;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.record.offsite.vehicle.mapper.VehicleMapper;
import com.ruoyi.project.record.offsite.vehicle.domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 庞沛东
 * @Description:
 * @Date: create in 2022/4/1 13:41
 */
@Service
public class VehicleServiceImpl implements IVehicleService {

    @Autowired
    private VehicleMapper vehicleMapper;

    @Override
    public int insertVehicle(Vehicle vehicle) {
        return vehicleMapper.insertVehicle(vehicle);
    }

    @Override
    public int updateVehicle(Vehicle vehicle) {
        int vehicleId;
        // 校验车辆是否存在
        if ("1".equals(checkVehicleUnique(vehicle))) {
            Vehicle oldVehicle = selectVehicleByPlateNum(vehicle.getVehPlateNum());
            vehicle.setVehId(oldVehicle.getVehId());
            vehicleMapper.updateVehicle(vehicle);
            vehicleId = oldVehicle.getVehId();
        } else {
            vehicle.setVehId(null);
            vehicleMapper.insertVehicle(vehicle);
            vehicleId = vehicle.getVehId();
        }
        return vehicleId;
    }

    @Override
    public Vehicle selectVehicleById(Integer vehId) {
        return vehicleMapper.selectVehicleById(vehId);
    }

    @Override
    public Vehicle selectVehicleByPlateNum(String vehPlateNum) {
        return vehicleMapper.selectVehicleByPlateNum(vehPlateNum);
    }

    @Override
    public String checkVehicleUnique(Vehicle vehicle) {
        Vehicle info = selectVehicleByPlateNum(vehicle.getVehPlateNum());
        if (StringUtils.isNotNull(info)) {
            // 状态码：1为存在该案件编号
            return "1";
        }
        return "0";
    }

}
