package com.ruoyi.project.record.vehicle.mapper;

import com.ruoyi.project.record.vehicle.domain.Vehicle;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: 庞沛东
 * @Description: 定义  接口层
 * @Date: create in 2022/4/1 13:40
 */
public interface VehicleMapper {

    public  int insertVehicle(@Param("vehicle") Vehicle vehicle);
}
