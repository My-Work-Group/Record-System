package com.ruoyi.project.record.lgtrans.LtVehicle.mapper;

import com.ruoyi.project.record.lgtrans.LtVehicle.domain.LtVehicle;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: 庞沛东
 * @Description: 定义  接口层
 * @Date: create in 2022/4/1 13:40
 */
public interface LtVehicleMapper {

    public int insertVehicle(@Param("ltVehicle") LtVehicle ltVehicle);

    public int updateVehicle(@Param("ltVehicle") LtVehicle ltVehicle);

    public LtVehicle selectVehicleById(Integer vehId);

    public LtVehicle selectVehicleByPlateNum(String vehPlateNum);
}
