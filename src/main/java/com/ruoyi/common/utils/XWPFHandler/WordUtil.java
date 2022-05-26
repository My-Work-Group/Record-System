package com.ruoyi.common.utils.XWPFHandler;

import com.ruoyi.framework.enumerate.DocxFileName;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.record.offsite.caseFile.domain.CaseFile;

import java.io.*;
import java.net.URL;
import java.util.*;

import static com.ruoyi.common.utils.DateUtils.*;
import static com.ruoyi.common.utils.DateUtils.getMinute;
import static com.ruoyi.common.utils.StringUtils.containsAnyIgnoreCase;
import static com.ruoyi.common.utils.StringUtils.deleteCharString;
import static com.ruoyi.common.utils.file.FileUtils.getAbsoluteFile;
import static com.ruoyi.common.utils.file.FileUtils.getFileNameWithSuffix;
import static com.ruoyi.framework.enumerate.DocxFileName.getName;


public class WordUtil {

    private static WordTemplate template;

    /**
     * @param caseFile
     * @param docxFileId
     * @return
     */
    public static AjaxResult ExportDocument(CaseFile caseFile, int docxFileId) {
        String absoluteFileName = replaceTag(caseFile, docxFileId);
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
    public static String replaceTag(CaseFile caseFile, int docxFileId) {
        Map<String, String> map = data(caseFile);
        String vehPlateNum = map.get("vehPlateNum");
        String docxTemplatesFile = getDocxTemplatesPath() + "/" + docxFileId + ".docx";
        // FileId + 表名
        String filename = docxFileId + "." + getName(docxFileId) + ".docx";
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
    public static List<String> filePathList(CaseFile caseFile) {
        String filePath;
        List<String> filePathList = new ArrayList<>();
        for (int i = 0; i < DocxFileName.values().length; i++) {
            filePath = replaceTag(caseFile, i + 1);
            filePathList.add(filePath);
        }
        return filePathList;
    }

    /**
     * @return 获取resources 目录下docxTemplate路径
     */
    public static String getDocxTemplatesPath() {
        /* URL url = WordUtil.class.getClassLoader().getResource("");
        String path = url.getPath() + "docxTemplate";
        if (containsAnyIgnoreCase(path, "!")) {
            path = deleteCharString(path, '!');
        }
        return path; */

        //模板文件和jar包同一路径
        return getJarPath() +"\\docxTemplate\\";
    }

    /**
     * 将要导出的数据封装成map
     *
     * @param caseFile
     * @return
     */
    public static Map<String, String> data(CaseFile caseFile) {

        Map<String, String> map = new HashMap<>();//要插入的数据
        Date createDate = caseFile.getCaseInfo().getcreateTime();
        Date checkDate = caseFile.getOverload().getCheckTime();
        Date loadDate = caseFile.getOverload().getLoadTime();

        // 案件信息
        map.put("createYear", String.valueOf(getYear(createDate)));
        map.put("createMonth", String.valueOf(getMonth(createDate)));
        map.put("createDay", String.valueOf(getDay(createDate)));
        map.put("createHour", String.valueOf(getHour(createDate)));
        map.put("createMinute", String.valueOf(getMinute(createDate)));
        map.put("caseNumber", caseFile.getCaseInfo().getCaseNumber());
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
        map.put("totalWeight", Double.toString(caseFile.getOverload().getTotalWeight()));
        map.put("outWeight", Double.toString(caseFile.getOverload().getOutWeight()));
        map.put("goods", caseFile.getOverload().getGoods());
        map.put("dest", caseFile.getOverload().getDest());
        return map;
    }

    /**
     * 获取jar包中的绝对路径
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


