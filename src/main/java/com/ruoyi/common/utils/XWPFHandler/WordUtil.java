package com.ruoyi.common.utils.XWPFHandler;

import com.ruoyi.project.record.caseFile.domain.CaseFile;

import java.io.*;
import java.util.*;

import static com.ruoyi.common.utils.DateUtils.*;
import static com.ruoyi.common.utils.DateUtils.getMinute;
import static com.ruoyi.common.utils.file.FileUtils.createDir;


public class WordUtil {

    private static WordTemplate template;
    // docx模板路径
    //private static final String DOCX_TEMPLATES_PATH = "main/resources/docxTemplate/";
    private static final String DOCX_TEMPLATES_PATH = "D:\\Codes\\Java\\Record-System\\src\\main\\resources\\docxTemplate\\";
    // 生成文件产生路径
    private static final String DOCX_GEN_PATH = "C:\\Users\\pangpd\\Desktop\\templates\\";

    public static boolean ExportDocument(CaseFile caseFile, int docxFileId) {
        Map<String, String> map = data(caseFile);
        String docxTemplatesFile = DOCX_TEMPLATES_PATH + docxFileId + ".docx";
        String docxGenFile = DOCX_GEN_PATH + docxFileId + ".docx";

        File file = new File(docxTemplatesFile);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            template = new WordTemplate(fileInputStream);
        } catch (IOException exception) {
            exception.printStackTrace();
            return false;
        }

        template.replaceTag(map);
        createDir(DOCX_GEN_PATH);
        File newDocx = new File(docxGenFile);
        FileOutputStream out;
        try {
            out = new FileOutputStream(newDocx);
            BufferedOutputStream bos = new BufferedOutputStream(out);
            template.write(bos);
            bos.flush();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

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

}


