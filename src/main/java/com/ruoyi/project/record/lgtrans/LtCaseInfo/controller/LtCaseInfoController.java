package com.ruoyi.project.record.lgtrans.LtCaseInfo.controller;

import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.record.lgtrans.LtCaseInfo.service.ILtCaseInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/record/lgtrans")
public class LtCaseInfoController extends BaseController {

    @Autowired
    private ILtCaseInfoService  ltCaseInfoService;

    /**
     * 删除案件信息（可批量删除）
     *
     * @param caseId
     * @return
     */
    @RequiresPermissions("system:user:ltCaseInfo:remove")
    @Log(title = "案件管理", businessType = BusinessType.DELETE)
    @PostMapping("/caseInfo/remove")
    @ResponseBody
    public AjaxResult remove(@RequestParam("ids") String caseId) {
        return toAjax(ltCaseInfoService.deleteCaseInfoByIds(caseId));
    }

    /**
     * 检验案件编号是否唯一
     */
    @PostMapping("/caseInfo/checkCaseNumUnique")
    @ResponseBody
    public String checkCaseNumUnique(String caseNum) {
        return ltCaseInfoService.checkCaseNumUnique(caseNum);
    }
}

