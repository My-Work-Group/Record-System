package com.ruoyi.project.record.caseInfo.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.project.record.caseFile.domain.CaseFile;
import com.ruoyi.project.record.caseInfo.domain.CaseInfo;
import com.ruoyi.project.record.caseInfo.service.ICaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/record/offsite")
public class CaseInfoController extends BaseController {

    @Autowired
    private ICaseInfoService caseInfoService;

    /**
     * 检验案件编号是否唯一
     */
    @PostMapping("/caseInfo/checkCaseNumUnique")
    @ResponseBody
    public String checkCaseNumUnique(String caseNum) {
//        CaseInfo caseInfo = caseFile.getCaseInfo();
//        return caseInfoService.checkCaseNumUnique(caseInfo);
        return caseInfoService.checkCaseNumUnique(caseNum);

    }
}

