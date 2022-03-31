//package com.ruoyi.project.record.offsite.vehicle.controller;
//
//
//import com.ruoyi.framework.aspectj.lang.annotation.Log;
//import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
//import com.ruoyi.framework.web.controller.BaseController;
//import com.ruoyi.framework.web.domain.AjaxResult;
//import com.ruoyi.project.record.offsite.domain.Param;
//import com.ruoyi.project.record.offsite.vehicle.service.IVehicleService;
//import org.apache.shiro.authz.annotation.RequiresPermissions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//@RequestMapping("/record/offsite")
//public class VehicleController extends BaseController {
//
//    private String prefix = "record/offsite";
//
//    @Autowired
//    private IVehicleService vehicleService;
//
//    @RequiresPermissions("record:offsite:view")
//    @GetMapping()
//    public String offsite() {
//        return prefix + "/offsite";
//    }
//
//
////    /**
////     * 新增案件
////     */
////    @GetMapping("/add")
////    public String add(ModelMap mmap) {
////        return prefix + "/add";
////    }
////
////    /**
////     * 新增保存用户
////     */
////    @RequiresPermissions("record:offsite:add")
////    @Log(title = "车辆管理", businessType = BusinessType.INSERT)
////    @PostMapping(value = "/add")
////    @ResponseBody
////    public AjaxResult addSave(@RequestBody Param param) {
////
////        return toAjax(vehicleService.insertVehicle(param.getVehicle()));
////
////    }
//
//}
