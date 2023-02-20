package com.ruoyi.project.record.lgtrans.LtCaseFile.contorller;

import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.common.utils.zip.ZipUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.record.lgtrans.LtCaseFile.domain.LtCaseFile;
import com.ruoyi.project.record.lgtrans.LtCaseFile.service.ILtCaseFileService;
import com.ruoyi.project.record.lgtrans.LtCaseInfo.domain.LtCaseInfo;
import com.ruoyi.project.record.lgtrans.LtCaseInfo.service.ILtCaseInfoService;
import com.ruoyi.project.record.lgtrans.LtCompany.domain.LtCompany;
import com.ruoyi.project.record.lgtrans.LtPerson.domain.LtPerson;
import com.ruoyi.project.record.lgtrans.utils.ExportUtils;
import com.ruoyi.project.record.personnel.domain.Personnel;
import com.ruoyi.project.record.personnel.service.IPersonnelService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ruoyi.common.utils.zip.ZipUtil.encodingFileName;
import static com.ruoyi.project.record.lgtrans.utils.CaseFileUtils.isNotCaseFileComplete;
import static com.ruoyi.project.record.lgtrans.utils.ExportUtils.filePathList;

/**
 * @Author: 庞沛东
 * @Description:
 * @Date: create in 2022/4/1 12:57
 */


@Controller
@RequestMapping("/record/lgtrans")
public class LtCaseFileController extends BaseController {

    private String prefix = "record/lgtrans";

    @Autowired
    private ILtCaseFileService caseFileService;

    @Autowired
    private ILtCaseInfoService caseInfoService;

    @Autowired
    private IPersonnelService personnelService;

    @RequiresPermissions("record:lgtrans:view")
    @GetMapping()
    public String lgtrans() {
        return prefix + "/lgtrans";
    }

    /**
     * 显示案件信息
     *
     * @param ltCaseInfo
     * @return
     */
    @RequiresPermissions("record:lgtrans:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LtCaseInfo ltCaseInfo) {
        startPage();
        List<LtCaseInfo> list = caseFileService.selectRecordList();
        return getDataTable(list);
    }

    /**
     * 新增案件
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        mmap.put("enforcementPeoples", personnelService.selectPersonnelAll());
        return prefix + "/add";
    }

    /**
     * 新增保存案件
     */
    @RequiresPermissions("record:lgtrans:add")
    @Log(title = "案件管理", businessType = BusinessType.INSERT)
    @PostMapping(value = "/add")
    @ResponseBody
    public AjaxResult addSave(@RequestBody LtCaseFile caseFile) {
        LtCaseInfo ltCaseInfo = caseFile.getLtCaseInfo();
        // 校验案件编号是否存在
        if ("1".equals(caseInfoService.checkCaseNumUnique(ltCaseInfo.getCaseNumber()))) {
            return error("该案件编号已存在！");
        }
        return toAjax(caseFileService.insertCaseFile(caseFile));
    }

    /**
     * 修改案件信息页面
     */
    @RequiresPermissions("record:lgtrans:edit")
    @GetMapping("/edit/{caseId}")
    public String edit(@PathVariable("caseId") Integer caseId, ModelMap mmap) {
        LtCaseFile caseFile = caseFileService.selectRecordById(caseId);
        String[] eIds = Convert.toStrArray(caseFile.getLtCaseInfo().getEnquirePerson());
        String[] rIds = Convert.toStrArray(caseFile.getLtCaseInfo().getRecordPerson());

        LtCaseInfo ltCaseInfo = caseFile.getLtCaseInfo();
        LtPerson ltPerson = caseFile.getLtPerson();
        LtCompany ltcompany = caseFile.getLtCompany();
        mmap.put("ltCaseInfo", ltCaseInfo);
        mmap.put("ltPerson", ltPerson);
        mmap.put("ltCompany", ltcompany);
        mmap.put("ltVehicle", caseFile.getLtVehicle());
        mmap.put("ltOverload", caseFile.getLtOverload());
        mmap.put("enquirePersons", personnelService.selectedPersonnelListByIds(eIds));
        mmap.put("recordPersons", personnelService.selectedPersonnelListByIds(rIds));
        return prefix + "/edit";
    }

    /**
     * 提交重新编辑/修改后案件信息
     */
    @RequiresPermissions("record:lgtrans:edit")
    @Log(title = "案件管理", businessType = BusinessType.UPDATE)
    @PostMapping(value = "/edit")
    @ResponseBody
    public AjaxResult editSave(@RequestBody LtCaseFile caseFile) {
        LtCaseInfo ltCaseInfo = caseFile.getLtCaseInfo();
        Integer caseInfoId = ltCaseInfo.getCaseId();
        String caseNumber = ltCaseInfo.getCaseNumber();
        // 校验案件是否存在：
        // 1.判断修改的案件信息是否存在
        // 2.且案件信息的id与当前id是否相等，不等即已存在，要做提示！相等说明是同一个案件信息，不做提示。
        if ("1".equals(caseInfoService.checkCaseNumUnique(caseNumber))
                && !(caseInfoId).equals(caseInfoService.selectCaseInfoByNum(caseNumber).getCaseId())) {
            return error("该案件编号已存在！");
        }
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
    @RequiresPermissions("record:lgtrans:export")
    @GetMapping("/exportRecord/{caseId}")
    public String exportRecord(@PathVariable(value = "caseId") Integer caseId, ModelMap mmap) {
        LtCaseFile caseFile = caseFileService.selectRecordById(caseId);
        mmap.put("ltCaseFile", caseFile);
        return prefix + "/exportRecord";
    }

    /**
     * 下载笔录案件
     *
     * @param caseId     案件id
     * @param docxFileId 笔录文件id
     * @return
     */
    @RequiresPermissions("record:lgtrans:export")
    @PostMapping("/exportRecord/download")
    @ResponseBody
    public AjaxResult recordDownLoad(Integer caseId, Integer docxFileId) {
        LtCaseFile caseFile = caseFileService.selectRecordById(caseId);
        if (isNotCaseFileComplete(caseFile)) {
            return error("导出失败，该案件信息填写不完整，请仔细检查！");
        }
        Map<String, List<Personnel>> personnels = getPersonnel(caseFile);
        return ExportUtils.ExportDocument(caseFile, personnels, docxFileId);
    }


    /**
     * 批量下载案件word文档（一键导出）
     */
    @RequiresPermissions("record:lgtrans:export")
    @GetMapping("/batchExportRecord/download")
    @ResponseBody
    public void zipDownload(HttpServletResponse response, Integer caseId) {
        LtCaseFile caseFile = caseFileService.selectRecordById(caseId);
        String zipName = caseFile.getLtCaseInfo().getCaseNumber() + ".zip";
        Map<String, List<Personnel>> personnelMap = getPersonnel(caseFile);
        List<String> filePathList = filePathList(caseFile, personnelMap);
        genZip(response, zipName, filePathList);
    }

    /**
     * 生成导出的zip文件
     */
    private void genZip(HttpServletResponse response, String zipName, List<String> filePathList) {
        //响应头的设置
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=" + encodingFileName(zipName) + "");
        response.setContentType("application/zip; charset=utf-8");
        response.setHeader("Content-type", "application-download");
        ZipUtil.downZip(response, filePathList);
    }


    public Map<String, List<Personnel>> getPersonnel(LtCaseFile caseFile) {
        Map<String, List<Personnel>> personnelMap = new HashMap<>();
        // 获取两名ZF人员id
        String[] eIds = Convert.toStrArray(caseFile.getLtCaseInfo().getEnquirePerson());
        // 获取记录人员id
        String[] rIds = Convert.toStrArray(caseFile.getLtCaseInfo().getRecordPerson());
        // 封装ZF人员
        List<Personnel> enquirePerson = personnelService.selectPersonnelListByIds(eIds);
        List<Personnel> recordPerson = personnelService.selectPersonnelListByIds(rIds);
        personnelMap.put("enquirePerson", enquirePerson);
        personnelMap.put("recordPerson", recordPerson);
        return personnelMap;
    }

}