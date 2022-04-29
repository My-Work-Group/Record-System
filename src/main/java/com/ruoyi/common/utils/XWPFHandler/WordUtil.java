package com.ruoyi.common.utils.XWPFHandler;

import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.record.caseFile.domain.CaseFile;

import java.io.*;
import java.util.*;

import static com.ruoyi.common.utils.DateUtils.*;
import static com.ruoyi.common.utils.DateUtils.getMinute;
import static com.ruoyi.framework.enumerate.DocxFileName.getName;


public class WordUtil {

    private static WordTemplate template;
    // docx模板路径
    private static final String DOCX_TEMPLATES_PATH = "D:\\Codes\\Java\\Record-System\\src\\main\\resources\\docxTemplate\\";

    public static AjaxResult ExportDocument(CaseFile caseFile, int docxFileId) {
        Map<String, String> map = data(caseFile);
        String vehPlateNum = map.get("vehPlateNum");
        String docxTemplatesFile = DOCX_TEMPLATES_PATH + docxFileId + ".docx";
        // 车牌号+表名
        String docxName = vehPlateNum + "_" + getName(docxFileId);
        String filename = encodingFilename(docxName);
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return AjaxResult.success(filename);
    }

//    /**
//     * 批量下载
//     * @param caseFile
//     */
//    public static void ExportDocumentToZip(CaseFile caseFile) {
//        Map<String, String> map = data(caseFile);
//        String vehPlateNum = map.get("vehPlateNum");
//        String docxTemplatesFile = DOCX_TEMPLATES_PATH + docxFileId + ".docx";
//        // 车牌号+表名
//        String docxName = vehPlateNum + "_" + getName(docxFileId);
//        String filename = encodingFilename(docxName);
//        File file = new File(docxTemplatesFile);
//        FileInputStream fileInputStream = null;
//        try {
//            fileInputStream = new FileInputStream(file);
//            template = new WordTemplate(fileInputStream);
//        } catch (IOException exception) {
//            exception.printStackTrace();
//        }
//        template.replaceTag(map);
//        FileOutputStream out;
//        try {
//            out = new FileOutputStream(getAbsoluteFile(filename));
//            BufferedOutputStream bos = new BufferedOutputStream(out);
//            template.write(bos);
//            bos.flush();
//            bos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


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
     * 编码文件名
     */
    public static String encodingFilename(String name) {

        String fileName;
        fileName = name + "_" + UUID.randomUUID().toString() + ".docx";
        return fileName;
    }

    /**
     * 获取下载路径
     *
     * @param filename 文件名称
     */
    public static String getAbsoluteFile(String filename) {
        String downloadPath = RuoYiConfig.getDownloadPath() + filename;
        File desc = new File(downloadPath);
        if (!desc.getParentFile().exists()) {
            desc.getParentFile().mkdirs();
        }
        return downloadPath;
    }


}


