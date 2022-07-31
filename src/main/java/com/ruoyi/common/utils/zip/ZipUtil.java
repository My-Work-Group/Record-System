package com.ruoyi.common.utils.zip;

import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @Author: 庞沛东
 * @Description:
 * @Date: create in 2022/4/29 15:26
 */

@Component
public class ZipUtil {

    /**
     * 批量文件压缩下载
     *
     * @param filePath 需要批量下载文件的文件路径
     */
    public static void downZip(HttpServletResponse response, List<String> filePath) {
        //设置压缩流：直接写入response，实现边压缩边下载
        ZipOutputStream zipos = null;
        try {
            zipos = new ZipOutputStream(new BufferedOutputStream(response.getOutputStream()));
            zipos.setMethod(ZipOutputStream.DEFLATED); //设置压缩方法
        } catch (Exception e) {
            e.printStackTrace();
        }
        //循环将文件写入压缩流
        DataOutputStream os = null;
        for (String list : filePath) {
            try {
                File file = new File(list);
                //此处应该加个文件是否存在的判断
                String filename = file.getName();
                //添加ZipEntry，并ZipEntry中写入文件流
                zipos.putNextEntry(new ZipEntry(filename));
                os = new DataOutputStream(zipos);
                FileInputStream is = new FileInputStream(file);
                byte[] b = new byte[1024];
                int length = 0;
                while ((length = is.read(b)) != -1) {
                    os.write(b, 0, length);
                }
                is.close();
                zipos.closeEntry();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //关闭流
        try {
            os.flush();
            os.close();
            zipos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param fileName 编码文件名
     * @return
     */
    public static String encodingFileName(String fileName) {
        String returnFileName = "";
        try {
            returnFileName = URLEncoder.encode(fileName, "utf-8");
            returnFileName = StringUtils.replace(returnFileName, "+", "%20");
            if (returnFileName.length() > 150) {
                returnFileName = new String(fileName.getBytes("GB2312"), "ISO8859-1");
                returnFileName = StringUtils.replace(returnFileName, " ", "%20");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return returnFileName;
    }
}