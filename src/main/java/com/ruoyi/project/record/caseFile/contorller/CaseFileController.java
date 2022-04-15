package com.ruoyi.project.record.caseFile.contorller;

import com.ruoyi.common.utils.XWPFHandler.WordTemplate;
import com.ruoyi.common.utils.XWPFHandler.WordUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.record.caseFile.domain.CaseFile;
import com.ruoyi.project.record.caseFile.service.ICaseFileService;
import com.ruoyi.project.record.caseInfo.domain.CaseInfo;
import com.ruoyi.project.record.caseInfo.service.ICaseInfoService;
import com.ruoyi.project.system.role.domain.Role;
import com.ruoyi.project.system.user.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.ruoyi.common.utils.DateUtils.*;

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
     * 下载笔录
     * @param caseId  案件id
     * @param docxFileId  笔录文件id
     * @return
     */
    @RequiresPermissions("record:offsite:export")
    @PostMapping("/exportRecord/download")
    @ResponseBody
    public String recordDownLoad(Integer caseId, Integer docxFileId) {
        CaseFile caseFile = caseFileService.selectRecordById(caseId);

        Date createDate= caseFile.getCaseInfo().getcreateTime();
        String createYear =String.valueOf(getYear(createDate));
        String createMonth =String.valueOf(getMonth(createDate));
        String createDay =String.valueOf(getDay(createDate));
        String createHour =String.valueOf(getHour(createDate));
        String createMinute =String.valueOf(getMinute(createDate));

        String caseNumber = caseFile.getCaseInfo().getCaseNumber();
        String personName =caseFile.getPerson().getPersonName();
        System.out.println(personName);
        String age = Integer.toString(caseFile.getPerson().getAge());
        String sex = caseFile.getPerson().getSex();
        String numberId = caseFile.getPerson().getNumberId();
        String personPhone =caseFile.getPerson().getPersonPhone();
        String homeAddress = caseFile.getPerson().getHomeAddress();

        Date checkDate = caseFile.getOverload().getCheckTime();
        String checkYear =String.valueOf(getYear(checkDate));
        String checkMonth =String.valueOf(getMonth(checkDate));
        String checkDay =String.valueOf(getDay(checkDate));
        String checkHour =String.valueOf(getHour(checkDate));
        String checkMinute =String.valueOf(getMinute(checkDate));

        String vehPlateNum = caseFile.getVehicle().getVehPlateNum();
        String vehAxleNum =  Integer.toString(caseFile.getVehicle().getVehAxleNum());
        String vehType = caseFile.getVehicle().getVehType();
        String checkSite = caseFile.getOverload().getCheckSite();
        String totalWeight = Double.toString(caseFile.getOverload().getTotalWeight());
        String outWeight = Double.toString(caseFile.getOverload().getOutWeight());
        WordUtil wordUtil = new WordUtil();

        Map<String, String> map = new HashMap<>();
        map.put("createYear",createYear );
        map.put("createMonth",createMonth );
        map.put("createDay",createDay );
        map.put("createHour",createHour);
        map.put("createMinute",createMinute);

        map.put("caseNumber",caseNumber);
        map.put("personName" , personName);
        map.put("age" ,age);
        map.put("sex" ,sex );
        map.put("numberId" ,numberId);
        map.put("personPhone" ,personPhone);
        map.put("homeAddress" ,homeAddress);

        map.put("checkYear",checkYear );
        map.put("checkMonth", checkMonth);
        map.put("checkDay", checkDay);
        map.put("checkHour", checkHour);
        map.put("checkMinute", checkMinute);

        map.put("vehPlateNum" ,vehPlateNum);
        map.put("vehAxleNum" ,vehAxleNum );
        map.put("vehType" ,vehType);
        map.put("checkSite" ,checkSite);
        map.put("totalWeight" ,totalWeight);
        map.put("outWeight" ,outWeight);
        wordUtil.ExportDocument(map,docxFileId);

        return null;
    }


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