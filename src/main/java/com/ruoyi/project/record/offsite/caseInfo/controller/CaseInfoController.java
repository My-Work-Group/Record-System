package com.ruoyi.project.record.offsite.caseInfo.controller;

import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.record.offsite.caseInfo.service.ICaseInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/record/offsite")
public class CaseInfoController extends BaseController {

    @Autowired
    private ICaseInfoService caseInfoService;

    /**
     * 删除案件信息（可批量删除）
     *
     * @param caseId
     * @return
     */
    @RequiresPermissions("system:user:caseInfo:remove")
    @Log(title = "案件管理", businessType = BusinessType.DELETE)
    @PostMapping("/caseInfo/remove")
    @ResponseBody
    public AjaxResult remove(@RequestParam("ids") String caseId) {
        return toAjax(caseInfoService.deleteCaseInfoByIds(caseId));
    }

    /**
     * 检验案件编号是否唯一
     */
    @PostMapping("/caseInfo/checkCaseNumUnique")
    @ResponseBody
    public String checkCaseNumUnique(String caseNum) {
        return caseInfoService.checkCaseNumUnique(caseNum);

    }
}

