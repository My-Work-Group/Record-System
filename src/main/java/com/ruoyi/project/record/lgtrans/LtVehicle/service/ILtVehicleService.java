package com.ruoyi.project.record.lgtrans.LtVehicle.service;

import com.ruoyi.project.record.lgtrans.LtVehicle.domain.LtVehicle;

/**
 * @Author: 庞沛东
 * @Description:
 * @Date: create in 2022/4/1 13:40
 */

public interface ILtVehicleService {
    public int insertVehicle(LtVehicle vehicle);

    public int updateVehicle(LtVehicle vehicle);

    public LtVehicle selectVehicleById(Integer vehId);

    public LtVehicle selectVehicleByPlateNum(String vehPlateNum);

    public String checkVehicleUnique(LtVehicle vehicle);
}
