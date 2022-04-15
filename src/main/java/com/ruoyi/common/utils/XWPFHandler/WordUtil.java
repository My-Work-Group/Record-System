package com.ruoyi.common.utils.XWPFHandler;

import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.*;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.*;


public class DocxUtil{
    /**
     * @Description: 将t中的字段转换成替换模板需要的数据${字段}-->字段值
     *      在word模板中变量为${valuename},为每个值建一个以‘${valuename}’为键，‘value’为值的Map集合，
     *      利用键去和Word模板中寻找相等的变量
     */
    public <T> Map<String, String> copyParamFromBean(T t, Map<String, String> params) {
        Field[] fields = t.getClass().getDeclaredFields();
        String key;
        String value;
        for (Field field : fields) {
            String fieldName = field.getName();
            key = "${" + fieldName + "}";
            String name = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            try {
                value = String.valueOf(t.getClass().getMethod(name).invoke(t));
                params.put(key, value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return params;
    }
    /***
     *替换Word模板中的对应变量。
     *两种情况：1-段落中的变量。 2-表格中的变量
     */
    public static void searchAndReplace(XWPFDocument document,Map<String, String> map) {
        try {
            // 替换段落中的指定文字
            Iterator<XWPFParagraph> itPara = document.getParagraphsIterator();//获得word中段落
            while (itPara.hasNext()) {       //遍历段落
                XWPFParagraph paragraph = (XWPFParagraph) itPara.next();
                Set<String> set = map.keySet();
                Iterator<String> iterator = set.iterator();
                while (iterator.hasNext()) {
                    String key = iterator.next();
                    List<XWPFRun> run=paragraph.getRuns();
                    for(int i=0;i<run.size();i++)
                    {
                        if(run.get(i).getText(run.get(i).getTextPosition())!=null &&
                                run.get(i).getText(run.get(i).getTextPosition()).equals(key))
                        {
                            /**
                             * 参数0表示生成的文字是要从哪一个地方开始放置,设置文字从位置0开始
                             * 就可以把原变量替换掉
                             */
                            run.get(i).setText(map.get(key),0);
                        }
                    }
                }
            }
            // 替换表格中的指定文字
            Iterator<XWPFTable> itTable = document.getTablesIterator();//获得Word的表格
            while (itTable.hasNext()) { //遍历表格
                XWPFTable table = (XWPFTable) itTable.next();
                int count = table.getNumberOfRows();//获得表格总行数
                for (int i = 0; i < count; i++) { //遍历表格的每一行
                    XWPFTableRow row = table.getRow(i);//获得表格的行
                    List<XWPFTableCell> cells = row.getTableCells();//在行元素中，获得表格的单元格
                    for (XWPFTableCell cell : cells) {   //遍历单元格
                        for (Entry<String, String> e : map.entrySet()) {
                            if (cell.getText().equals(e.getKey())) {//如果单元格中的变量和‘键’相等，就用‘键’所对应的‘值’代替。
                                cell.removeParagraph(0);//所以这里就要求每一个单元格只能有唯一的变量。
                                cell.setText(e.getValue());
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 关闭输出流
     *
     * @param os
     */
    public void close(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
            XWPFDocument doc = null;
            OutputStream out = null;
            FileInputStream in = null;
            DocxUtil docxUtil = null;
            try {
                String rootPath = "";

                Map<String, String> params = new HashMap<String, String>();
                docxUtil = new DocxUtil();
                XWPFDocument document = new XWPFDocument(POIXMLDocument.openPackage(rootPath));//读取Word模板
                docxUtil.copyParamFromBean(docVo, params);//调用DocxUtil中的copyParamFromBean方法，为VO的每个值建立“${valuename}”键
                docxUtil.searchAndReplace(document, params);//替换模板中的对应变量。
                String realname = "学生信息文档_"+docVo.getXm()+".docx";//最终导出文档的新文档名

                document.write(out);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (null != docxUtil) {
                    docxUtil.close(out);//关闭流
                }
            }
        }
}
//public class WordUtil {
//
//    private static WordTemplate template;
//    private static final String DOCX_MODEL_PATH = "D:\\Codes\\Java\\Record-System\\src\\main\\resources\\docxTemplate\\";
//    private static final String DOCX_FILE_WRITE = "C:\\Users\\pangpd\\Desktop\\templates\\generate-document.docx";
//
//    public static void ExportDocument(Map<String, String> map, int docxFileId) {
//
//        File file = new File(DOCX_MODEL_PATH+ docxFileId);
//        FileInputStream fileInputStream = null;
//        try {
//            fileInputStream = new FileInputStream(file);
//            template = new WordTemplate(fileInputStream);
//        } catch (IOException exception) {
//            exception.printStackTrace();
//        }
//        template.replaceTag(map);
//        File newDocx = new File(DOCX_FILE_WRITE );
//        FileOutputStream out;
//        try {
//            out = new FileOutputStream(newDocx);
//            BufferedOutputStream bos = new BufferedOutputStream(out);
//            template.write(bos);
//            bos.flush();
//            bos.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("成功！");
//    }
//
//
//
//    public static void main(String[] args) throws InvalidFormatException, IOException {
//        XWPFDocument document = new XWPFDocument(OPCPackage.open(DOCX_MODEL_PATH+ "1.docx"));
//
//    }
//
//}


