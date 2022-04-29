package com.ruoyi.project.record.caseFile.contorller;

import com.ruoyi.common.utils.XWPFHandler.WordUtil;
import com.ruoyi.common.utils.zip.FileRequest;
import com.ruoyi.common.utils.zip.ZipUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.record.caseFile.domain.CaseFile;
import com.ruoyi.project.record.caseFile.service.ICaseFileService;
import com.ruoyi.project.record.caseInfo.domain.CaseInfo;
import com.ruoyi.project.record.caseInfo.service.ICaseInfoService;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;

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
        mmap.put("caseFile",caseFile);
        return prefix + "/exportRecord";
    }

    /**
     * 下载笔录案件
     * @param caseId  案件id
     * @param docxFileId  笔录文件id
     * @return
     */
    @RequiresPermissions("record:offsite:export")
    @PostMapping("/exportRecord/download")
    @ResponseBody
    public AjaxResult recordDownLoad(Integer caseId, Integer docxFileId) {
        CaseFile caseFile = caseFileService.selectRecordById(caseId);
        return WordUtil.ExportDocument(caseFile,docxFileId);
    }

    /**
     * 批量下载案件word文档（一键导出）
     */
    //@RequiresPermissions("tool:gen:code")
    //@Log(title = "代码生成", businessType = BusinessType.GENCODE)
    @GetMapping("/batchExportRecord")
    @ResponseBody
    public AjaxResult zipDownload(@RequestBody List<FileRequest> requestList){
        if(requestList.size() <= 0){
            return new AjaxResult(AjaxResult.Type.ERROR,"文件路径为空");
        }
        String zipName = new SimpleDateFormat("yyyyMMdd").format(new Date());
        ZipUtil.downZip(requestList, "test");
        return new AjaxResult(AjaxResult.Type.SUCCESS,"压缩包下载完成");
    }

    /**
     *
     * 展示案件信息
     * @param caseInfo
     * @return
     */

    @RequiresPermissions("record:offsite:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CaseInfo caseInfo)
    {
        startPage();
        List<CaseInfo> list = caseFileService.selectRecordList();
        return getDataTable(list);
    }

    /**
     * 新增案件
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
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

        String caseNum = caseFile.getCaseInfo().getCaseNumber();
        // 校验案件编号是否存在
        if ("1".equals(caseInfoService.checkCaseNumUnique(caseNum)))
        {
            return error( caseNum + "，该案件编号已存在！");
        }
        return toAjax(caseFileService.insertCaseFile(caseFile));
    }

}