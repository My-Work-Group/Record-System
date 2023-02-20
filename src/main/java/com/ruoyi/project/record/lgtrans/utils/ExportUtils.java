package com.ruoyi.project.record.lgtrans.utils;


import com.ruoyi.common.utils.XWPFHandler.WordTemplate;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.record.lgtrans.LtCaseFile.domain.LtCaseFile;
import com.ruoyi.project.record.offsite.enumerate.DocxFileName;
import com.ruoyi.project.record.personnel.domain.Personnel;

import java.io.*;
import java.util.*;

import static com.ruoyi.common.utils.DateUtils.*;
import static com.ruoyi.common.utils.DateUtils.getMinute;
import static com.ruoyi.common.utils.NumberUtils.formatDecimalTo2;
import static com.ruoyi.common.utils.file.FileUtils.getFileNameWithSuffix;
import static com.ruoyi.common.utils.file.FileUtils.getAbsoluteFile;
import static com.ruoyi.project.record.offsite.enumerate.DocxFileName.getName;


public class ExportUtils {

    private static WordTemplate template;


    /**
     * @param caseFile
     * @param docxFileId
     * @return
     */
    public static AjaxResult ExportDocument(LtCaseFile caseFile, Map<String, List<Personnel>> personnels, int docxFileId) {
        String absoluteFileName = replaceTag(caseFile, personnels, docxFileId);
        String fileName = getFileNameWithSuffix(absoluteFileName);
        return AjaxResult.success(fileName);
    }

    /**
     * 根据数据替换模板中关键字
     *
     * @param caseFile
     * @param docxFileId docx文档id号
     * @return 返回当前docx文件的绝对路径
     */
    public static String replaceTag(LtCaseFile caseFile, Map<String, List<Personnel>> personnels, int docxFileId) {
        Map<String, String> map = data(caseFile, personnels);
        // 获取处罚对象
        String object = caseFile.getLtCaseInfo().getCaseObject();
        String vehPlate = caseFile.getLtVehicle().getVehPlateNum();
        String date = convertDate2String(caseFile.getLtOverload().getCheckTime(), "yyyy-MM-dd");
        String docxTemplatesFile;
        docxTemplatesFile = getDocxTemplatesPath(object, docxFileId);
        // FileId + 表名
        String filename = docxFileId + "." + getName(docxFileId) + ".docx";
        if (docxFileId == 11) {
            filename = date + "-" + vehPlate + "-" + getName(docxFileId) + ".docx";
            if (filename.contains("/")) {
                vehPlate = vehPlate.substring(0, vehPlate.indexOf("/")); // 去掉挂车车牌
                filename = date + "-" + vehPlate + "-" + getName(docxFileId) + ".docx";
            }
        }
        File file = new File(docxTemplatesFile);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            template = new WordTemplate(fileInputStream);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        template.replaceTag(map);
        FileOutputStream out;
        try {
            out = new FileOutputStream(getAbsoluteFile(filename));
            BufferedOutputStream bos = new BufferedOutputStream(out);
            template.write(bos);
            bos.flush();
            bos.close();
            template.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getAbsoluteFile(filename);
    }

    /**
     * @param caseFile
     * @return 批量下载的文件路径 list
     */
    public static List<String> filePathList(LtCaseFile caseFile, Map<String, List<Personnel>> personnelMap) {
        String filePath;
        List<String> filePathList = new ArrayList<>();
        // 长度-1的目的是，不让[一键导出]的zip包中包含视听资料说明书
        for (int i = 0; i < DocxFileName.values().length - 1; i++) {
            filePath = replaceTag(caseFile, personnelMap, i + 1);
            filePathList.add(filePath);
        }
        return filePathList;
    }

    /**
     * @return 获取resources 目录下docxTemplate路径
     */
    public static String getDocxTemplatesPath(String object, int docxFileId) {
        String docxTemplatesFile;
        String path = getJarPath() + "\\docxTemplate\\lgtrans";
        docxTemplatesFile = path + "\\person\\" + docxFileId + ".docx";
        if (object.equals("公司")) {
            docxTemplatesFile = path + "\\company\\" + docxFileId + ".docx";
        }
        //模板文件和jar包同一路径
        return docxTemplatesFile;
    }


    /**
     * 获取jar包中的绝对路径
     *
     * @return
     */
    public static String getJarPath() {
        //jar包编译后的相对路径
        String path = ExportUtils.class.getProtectionDomain().getCodeSource().getLocation().getFile();
        //消除乱码
        try {
            path = java.net.URLDecoder.decode(path, "UTF-8");
        } catch (java.io.UnsupportedEncodingException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        //根据路径获取目标文件
        java.io.File jarFile = new java.io.File(path);
        //获取文件的绝对路径
        String jarFilepath = jarFile.getAbsolutePath();
        //我们需要得到 file 的上级目录
        int end = jarFilepath.indexOf("file");
        if (end > 0) {
            return jarFilepath.substring(0, end);
        }
        return jarFilepath + "\\";
    }
    /**
     * 将要导出的数据封装成map
     *
     * @param caseFile
     * @return
     */
    public static Map<String, String> data(LtCaseFile caseFile, Map<String, List<Personnel>> personnels) {

        Map<String, String> map = new HashMap<>();//要插入的数据
        Date createDate = caseFile.getLtCaseInfo().getCreateTime();
        Date checkDate = caseFile.getLtOverload().getCheckTime();
        Date loadDate = caseFile.getLtOverload().getLoadTime();
        //  获取处罚对象
        String object = caseFile.getLtCaseInfo().getCaseObject();
        // 罚款金额
        String fine = caseFile.getLtCaseInfo().getFine();
        // 货物尺寸
        String overallLength = formatDecimalTo2(caseFile.getLtOverload().getOverallLength());
        String overallWidth = formatDecimalTo2(caseFile.getLtOverload().getOverallWidth());
        String overallHeight = formatDecimalTo2(caseFile.getLtOverload().getOverallHeight());
        // 车货总尺寸
        String goodsLength = formatDecimalTo2(caseFile.getLtOverload().getGoodsLength());
        String goodsWidth = formatDecimalTo2(caseFile.getLtOverload().getGoodsWidth());
        String goodsHeight = formatDecimalTo2(caseFile.getLtOverload().getGoodsHeight());
        // 案件信息
        map.put("createYear", String.valueOf(getYear(createDate)));
        map.put("createMonth", String.valueOf(getMonth(createDate)));
        map.put("createDay", String.valueOf(getDay(createDate)));
        map.put("createHour", String.valueOf(getHour(createDate)));
        map.put("createMinute", String.valueOf(getMinute(createDate)));
        map.put("caseNumber", caseFile.getLtCaseInfo().getCaseNumber());
        map.put("fine",fine); // 罚款金额
        // ZF人员信息
        Personnel enquirePerson1 = personnels.get("enquirePerson").get(0);
        Personnel enquirePerson2 = personnels.get("enquirePerson").get(1);
        Personnel recordPerson = personnels.get("recordPerson").get(0);
        map.put("enquirePerson1Name", enquirePerson1.getPersonnelName());  // ZF人员1
        map.put("enquirePerson1EnfId", enquirePerson1.getEnforcementId());
        map.put("enquirePerson2Name", enquirePerson2.getPersonnelName());  // ZF人员2
        map.put("enquirePerson2EnfId", enquirePerson2.getEnforcementId());
        map.put("recordPersonName", recordPerson.getPersonnelName());     // 记录人员
        map.put("recordPersonEnfId", recordPerson.getPersonnelName());
        // 个人信息
        map.put("personName", caseFile.getLtPerson().getPersonName());
        map.put("age", Integer.toString(caseFile.getLtPerson().getAge()));
        map.put("sex", caseFile.getLtPerson().getSex());
        map.put("numberId", caseFile.getLtPerson().getNumberId());
        map.put("personPhone", caseFile.getLtPerson().getPersonPhone());
        map.put("homeAddress", caseFile.getLtPerson().getHomeAddress());
        map.put("contactAddress", caseFile.getLtPerson().getContactAddress());
        map.put("workUnit", caseFile.getLtPerson().getWorkUnit());
        map.put("post", caseFile.getLtPerson().getPost());
        map.put("postCode", caseFile.getLtPerson().getPostCode());
        // 公司信息
        if (object.equals("公司")) {
            map.put("companyName", caseFile.getLtCompany().getCompanyName());
            map.put("companyAddress", caseFile.getLtCompany().getCompanyAddress());
            map.put("companyPhone", caseFile.getLtCompany().getCompanyPhone());
            map.put("creditCode", caseFile.getLtCompany().getCreditCode());
            map.put("directorName", caseFile.getLtCompany().getDirectorName());
            map.put("directorNumId", caseFile.getLtCompany().getDirectorNumId());
        }

        // 车辆信息
        map.put("vehPlateNum", caseFile.getLtVehicle().getVehPlateNum());
        map.put("vehPlateColor", caseFile.getLtVehicle().getVehPlateColor());
        map.put("vehAxleNum", Integer.toString(caseFile.getLtVehicle().getVehAxleNum()));
        map.put("vehType", caseFile.getLtVehicle().getVehType());
        // 超限信息
        map.put("checkYear", getYear(checkDate));
        map.put("checkMonth", getMonth(checkDate));
        map.put("checkDay", getDay(checkDate));
        map.put("checkHour", getHour(checkDate));
        map.put("checkMinute", getMinute(checkDate));
        map.put("loadYear", getYear(loadDate));
        map.put("loadMonth", (getMonth(loadDate)));
        map.put("loadDay", getDay(loadDate));
        map.put("loadHour", getHour(loadDate));
        map.put("loadMinute", getMinute(loadDate));
        map.put("goods", caseFile.getLtOverload().getGoods());
        map.put("loadSite", caseFile.getLtOverload().getLoadSite());
        map.put("checkSite", caseFile.getLtOverload().getCheckSite());
        map.put("goodsLength", goodsLength);
        map.put("goodsWidth",goodsWidth);
        map.put("goodsHeight", goodsHeight);
        map.put("overallLength", overallLength);
        map.put("overallWidth",overallWidth);
        map.put("overallHeight", overallHeight);
        map.put("dest", caseFile.getLtOverload().getDest());
        return map;
    }

}


