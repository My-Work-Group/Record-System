package com.ruoyi.project.record.offsite.vehicle.service;
import com.ruoyi.project.record.offsite.vehicle.domain.Vehicle;


import java.util.List;

/**
 * @Author: 庞沛东
 * @Description: 定义 案件的 接口层
 * @Date: create in 2022/3/30 11:58
 */
public interface IVehicleService {
        public List<Vehicle> selectCaseList(Vehicle vehicle);


        public  int insertVehicle(Vehicle vehicle);



        public int vehicle(Vehicle vehicle);



        public int updateCaseInfo(Vehicle vehicle);


    }


