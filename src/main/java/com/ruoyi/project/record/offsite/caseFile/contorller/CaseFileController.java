package com.ruoyi.project.record.offsite.caseFile.contorller;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.XWPFHandler.WordUtil;
import com.ruoyi.common.utils.security.AuthorizationUtils;
import com.ruoyi.common.utils.zip.ZipUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.enumerate.CheckSite;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.record.offsite.caseFile.domain.CaseFile;
import com.ruoyi.project.record.offsite.caseFile.service.ICaseFileService;
import com.ruoyi.project.record.offsite.caseInfo.domain.CaseInfo;
import com.ruoyi.project.record.offsite.caseInfo.service.ICaseInfoService;
import com.ruoyi.project.record.offsite.company.domain.Company;
import com.ruoyi.project.record.offsite.person.domain.Person;
import com.ruoyi.project.system.role.domain.Role;
import com.ruoyi.project.system.user.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

import static com.ruoyi.common.utils.StringUtils.isAllFieldNull;
import static com.ruoyi.common.utils.XWPFHandler.WordUtil.filePathList;
import static com.ruoyi.common.utils.zip.ZipUtil.encodingFileName;

/**
 * @Author: 庞沛东
 * @Description:
 * @Date: create in 2022/4/1 12:57
 */


@Controller
@RequestMapping("/record/offsite")
public class CaseFileController extends BaseController {

    private String prefix = "record/offsite";

    @Autowired
    private ICaseFileService caseFileService;

    @Autowired
    private ICaseInfoService caseInfoService;

    @RequiresPermissions("record:offsite:view")
    @GetMapping()
    public String offsite() {
        return prefix + "/offsite";
    }

    /**
     * 显示案件信息
     *
     * @param caseInfo
     * @return
     */
    @RequiresPermissions("record:offsite:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CaseInfo caseInfo) {
        startPage();
        List<CaseInfo> list = caseFileService.selectRecordList();
        return getDataTable(list);
    }

    /**
     * 新增案件
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        // 获取治超点位（枚举类）信息
        CheckSite[] sites = CheckSite.values();
        mmap.put("sites", sites);
        return prefix + "/add";
    }

    /**
     * 新增保存案件
     */
    @RequiresPermissions("record:offsite:add")
    @Log(title = "案件管理", businessType = BusinessType.INSERT)
    @PostMapping(value = "/add")
    @ResponseBody
    public AjaxResult addSave(@RequestBody CaseFile caseFile) {
        CaseInfo caseInfo = caseFile.getCaseInfo();
        // 校验案件编号是否存在
        if ("1".equals(caseInfoService.checkCaseNumUnique(caseInfo.getCaseNumber()))) {
            return error("该案件编号已存在！");
        }
        return toAjax(caseFileService.insertCaseFile(caseFile));
    }

    /**
     * 修改案件信息页面
     */
    @RequiresPermissions("record:offsite:edit")
    @GetMapping("/edit/{caseId}")
    public String edit(@PathVariable("caseId") Integer caseId, ModelMap mmap) {
        CaseFile caseFile = caseFileService.selectRecordById(caseId);
        CaseInfo caseInfo = caseFile.getCaseInfo();
        Person person = caseFile.getPerson();
        Company company = caseFile.getCompany();
        // 获取治超点位（枚举类）信息
        CheckSite[] sites = CheckSite.values();
        mmap.put("caseInfo", caseInfo);
        mmap.put("person", person);
        mmap.put("company", company);
        mmap.put("vehicle", caseFile.getVehicle());
        mmap.put("overload", caseFile.getOverload());
        mmap.put("sites", sites);
        return prefix + "/edit";
    }

    /**
     * 提交修改案件信息
     */
    @RequiresPermissions("record:offsite:edit")
    @Log(title = "案件管理", businessType = BusinessType.UPDATE)
    @PostMapping(value = "/edit")
    @ResponseBody
    public AjaxResult editSave(@RequestBody CaseFile caseFile) {
        return toAjax(caseFileService.updateCaseFile(caseFile));
    }

    /**
     * 导出笔录页面
     *
     * @param caseId 案件id
     * @param
     * @param mmap
     * @return
     */
    @RequiresPermissions("record:offsite:export")
    @GetMapping("/exportRecord/{caseId}")
    public String exportRecord(@PathVariable(value = "caseId") Integer caseId, ModelMap mmap) {
        CaseFile caseFile = caseFileService.selectRecordById(caseId);
        mmap.put("caseFile", caseFile);
        return prefix + "/exportRecord";
    }

    /**
     * 下载笔录案件
     *
     * @param caseId     案件id
     * @param docxFileId 笔录文件id
     * @return
     */
    @RequiresPermissions("record:offsite:export")
    @PostMapping("/exportRecord/download")
    @ResponseBody
    public AjaxResult recordDownLoad(Integer caseId, Integer docxFileId) {
        CaseFile caseFile = caseFileService.selectRecordById(caseId);
        return WordUtil.ExportDocument(caseFile, docxFileId);
    }

    /**
     * 批量下载案件word文档（一键导出）
     */
    @GetMapping("/batchExportRecord/download")
    @ResponseBody
    public void zipDownload(HttpServletResponse response, Integer caseId) {
        CaseFile caseFile = caseFileService.selectRecordById(caseId);
        String zipName = caseFile.getCaseInfo().getCaseNumber() + ".zip";
        List<String> filePathList = filePathList(caseFile);
        genZip(response, zipName, filePathList);
    }

    /**
     * 生成导出的zip文件
     */
    private void genZip(HttpServletResponse response, String zipName, List<String> filePathList) {
        //响应头的设置
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=" + encodingFileName(zipName) + "");
        response.setContentType("application/zip; charset=UTF-8");
        response.setHeader("Content-type", "application-download");
        ZipUtil.downZip(response, filePathList);
    }
}