//package com.ruoyi.project.record.offsite.controller;
//import com.ruoyi.framework.aspectj.lang.annotation.Log;
//import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
//import com.ruoyi.framework.web.controller.BaseController;
//import com.ruoyi.framework.web.domain.AjaxResult;
//import com.ruoyi.project.record.offsite.domain.OffSiteCase;
//import com.ruoyi.project.record.caseFile.domain.CaseFile;
//import com.ruoyi.project.record.offsite.service.ICaseService;
//
//import com.ruoyi.project.record.vehicle.domain.Vehicle;
//
//
//import org.apache.shiro.authz.annotation.RequiresPermissions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.*;
//
//
//@Controller
//@RequestMapping("/record/offsite")
//public class OffsiteController extends BaseController {
//
//    private String prefix = "record/offsite";
//
//    @Autowired
//    private ICaseService caseService;
//
////    @Autowired
////    private IVehicleService vehicleService;
//
//    @RequiresPermissions("record:offsite:view")
//    @GetMapping()
//    public String offsite() {
//        return prefix + "/offsite";
//    }
//
//
//    /**
//     * 新增用户
//     */
//    @GetMapping("/add")
//    public String add(ModelMap mmap) {
//        return prefix + "/add";
//    }
//
//    /**
//     * 新增保存用户
//     */
//    @RequiresPermissions("record:offsite:add")
//    @Log(title = "案件管理", businessType = BusinessType.INSERT)
//    @PostMapping(value = "/add")
//    @ResponseBody
//    public AjaxResult addSave(@RequestBody CaseFile param ) {
//        OffSiteCase offSiteCase =   param.getOffSiteCase();
//        Vehicle vehicle =   param.getVehicle();
//        caseService.insertCase(offSiteCase);
////        return toAjax(caseService.insertVehicle(vehicle));
//        //return toAjax(1);
//
//    }
//
//    public void addSave1(OffSiteCase offSiteCase) {
//        caseService.selectCaseList(offSiteCase);
//    }
//
//    public void addSave2(OffSiteCase offSiteCase) {
//        caseService.updateCase(offSiteCase);
//
//    }
//
//    public void addSave3(OffSiteCase offSiteCase) {
//        caseService.updateCaseInfo(offSiteCase);
//    }
//
//    public void addSave4(OffSiteCase offSiteCase) {
//
//    }
//}
//
