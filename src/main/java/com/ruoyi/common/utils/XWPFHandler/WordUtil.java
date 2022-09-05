package com.ruoyi.common.utils.XWPFHandler;

import com.ruoyi.project.record.offsite.enumerate.DocxFileName;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.record.offsite.caseFile.domain.CaseFile;
import com.ruoyi.project.record.personnel.domain.Personnel;

import java.io.*;
import java.util.*;

import static com.ruoyi.common.utils.DateUtils.*;
import static com.ruoyi.common.utils.DateUtils.getMinute;
import static com.ruoyi.common.utils.NumberUtils.formatDecimal;
import static com.ruoyi.common.utils.StringUtils.inStringIgnoreCase;
import static com.ruoyi.common.utils.file.FileUtils.getAbsoluteFile;
import static com.ruoyi.common.utils.file.FileUtils.getFileNameWithSuffix;
import static com.ruoyi.project.record.offsite.enumerate.DocxFileName.getName;
import static com.ruoyi.project.record.offsite.enumerate.WeightLimit.getWeightLimit;


public class WordUtil {

    private static WordTemplate template;


    /**
     * @param caseFile
     * @param docxFileId
     * @return
     */
    public static AjaxResult ExportDocument(CaseFile caseFile, Map<String, List<Personnel>> personnels, int docxFileId) {
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
    public static String replaceTag(CaseFile caseFile, Map<String, List<Personnel>> personnels, int docxFileId) {
        Map<String, String> map = data(caseFile, personnels);
        // 获取处罚对象
        String object = caseFile.getCaseInfo().getCaseObject();
        String vehPlate = caseFile.getVehicle().getVehPlateNum();
        String date = convertDate2String(caseFile.getOverload().getCheckTime(), "yyyy-MM-dd");
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
    public static List<String> filePathList(CaseFile caseFile, Map<String, List<Personnel>> personnelMap) {
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
        String path = getJarPath() + "\\docxTemplate\\";
        docxTemplatesFile = path + "\\person\\" + docxFileId + ".docx";
        if (object.equals("公司")) {
            docxTemplatesFile = path + "\\company\\" + docxFileId + ".docx";
        }
        //模板文件和jar包同一路径
        return docxTemplatesFile;
    }

    /**
     * 将要导出的数据封装成map
     *
     * @param caseFile
     * @return
     */
    public static Map<String, String> data(CaseFile caseFile, Map<String, List<Personnel>> personnels) {

        Map<String, String> map = new HashMap<>();//要插入的数据
        Date createDate = caseFile.getCaseInfo().getCreateTime();
        Date checkDate = caseFile.getOverload().getCheckTime();
        Date loadDate = caseFile.getOverload().getLoadTime();
        //  获取处罚对象
        String object = caseFile.getCaseInfo().getCaseObject();
        // 获取车货总重
        //String str1 = String.format("%.2f", caseFile.getOverload().getTotalWeight());
        double totalWeight = caseFile.getOverload().getTotalWeight();
        System.out.println(totalWeight);
        // 获取车辆轴数
        int vehAxleNum = caseFile.getVehicle().getVehAxleNum();
        // 根据轴数获取车辆限重吨位
        double weightLimit = getWeightLimit(vehAxleNum);
        // 总重扣除5%计重误差
        double finalTotalWeight = totalWeight * 0.95;
        // 扣除5%的计重误差后，超限的吨位，保留两位小数
        double outWeight = Double.parseDouble(formatDecimal(finalTotalWeight - weightLimit));

        // 向下取整吨位，以便计算罚金
        double IntOutWeight = Math.floor(outWeight); // 向下取整
        int fine = (int) (500 * IntOutWeight);
        // 案件信息
        map.put("createYear", String.valueOf(getYear(createDate)));
        map.put("createMonth", String.valueOf(getMonth(createDate)));
        map.put("createDay", String.valueOf(getDay(createDate)));
        map.put("createHour", String.valueOf(getHour(createDate)));
        map.put("createMinute", String.valueOf(getMinute(createDate)));
        map.put("caseNumber", caseFile.getCaseInfo().getCaseNumber());
        map.put("letterNumber", caseFile.getCaseInfo().getLetterNumber());
        map.put("fine", String.valueOf(fine)); // 罚款金额，没有存储到数据库
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
        map.put("personName", caseFile.getPerson().getPersonName());
        map.put("age", Integer.toString(caseFile.getPerson().getAge()));
        map.put("sex", caseFile.getPerson().getSex());
        map.put("numberId", caseFile.getPerson().getNumberId());
        map.put("personPhone", caseFile.getPerson().getPersonPhone());
        map.put("homeAddress", caseFile.getPerson().getHomeAddress());
        map.put("contactAddress", caseFile.getPerson().getContactAddress());
        map.put("workUnit", caseFile.getPerson().getWorkUnit());
        map.put("post", caseFile.getPerson().getPost());
        map.put("postCode", caseFile.getPerson().getPostCode());
        // 公司信息
        if (object.equals("公司")) {
            map.put("companyName", caseFile.getCompany().getCompanyName());
            map.put("companyAddress", caseFile.getCompany().getCompanyAddress());
            map.put("companyPhone", caseFile.getCompany().getCompanyPhone());
            map.put("creditCode", caseFile.getCompany().getCreditCode());
            map.put("directorName", caseFile.getCompany().getDirectorName());
            map.put("directorNumId", caseFile.getCompany().getDirectorNumId());
        }

        // 车辆信息
        map.put("vehPlateNum", caseFile.getVehicle().getVehPlateNum());
        map.put("vehPlateColor", caseFile.getVehicle().getVehPlateColor());
        map.put("vehAxleNum", Integer.toString(caseFile.getVehicle().getVehAxleNum()));
        map.put("vehType", caseFile.getVehicle().getVehType());
        // 超限信息
        map.put("checkYear", String.valueOf(getYear(checkDate)));
        map.put("checkMonth", String.valueOf(getMonth(checkDate)));
        map.put("checkDay", String.valueOf(getDay(checkDate)));
        map.put("checkHour", String.valueOf(getHour(checkDate)));
        map.put("checkMinute", String.valueOf(getMinute(checkDate)));
        map.put("loadYear", String.valueOf(getYear(loadDate)));
        map.put("loadMonth", String.valueOf(getMonth(loadDate)));
        map.put("loadDay", String.valueOf(getDay(loadDate)));
        map.put("loadHour", String.valueOf(getHour(loadDate)));
        map.put("loadMinute", String.valueOf(getMinute(loadDate)));
        map.put("loadSite", caseFile.getOverload().getLoadSite());
        map.put("checkSite", caseFile.getOverload().getCheckSite());
        map.put("totalWeight", Double.toString(totalWeight));
        map.put("outWeight", Double.toString(outWeight));
        map.put("goods", caseFile.getOverload().getGoods());
        map.put("dest", caseFile.getOverload().getDest());
        return map;
    }

    /**
     * 获取jar包中的绝对路径
     *
     * @return
     */
    public static String getJarPath() {
        //jar包编译后的相对路径
        String path = WordUtil.class.getProtectionDomain().getCodeSource().getLocation().getFile();
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
}


