package com.ruoyi.common.utils.zip;
import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: 庞沛东
 * @Description:
 * @Date: create in 2022/4/29 15:26
 */

@Component
public class ZipUtil {

    private static HttpServletResponse response;

    @Autowired
    private HttpServletResponse response2;

    private static HttpServletRequest request;

    @Autowired
    private HttpServletRequest request2;

    @PostConstruct
    public void beforeInit() {
        request=request2;
        response=response2;
    }

    /**
     * 批量文件压缩下载
     * @param urlList 需要批量下载文件的链接地址列表
     * @param zipName 输出的压缩包名称
     */
    public static void downZip(List<FileRequest> urlList,String zipName){
        //响应头的设置
        response.reset();
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        String downloadName = zipName+".zip";
        //返回客户端浏览器的版本号、类型
        String agent = request.getHeader("USER-AGENT");
        try {
            //针对IE或者以IE为内核的浏览器：
            if (agent.contains("MSIE")||agent.contains("Trident")) {
                downloadName = java.net.URLEncoder.encode(downloadName, "UTF-8");
            } else {
                //非IE浏览器的处理：
                downloadName = new String(downloadName.getBytes("UTF-8"),"ISO-8859-1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setHeader("Content-Disposition", "attachment;fileName=\"" + downloadName + "\"");

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

        for (FileRequest request : urlList) {
            try {
                File file = new File(request.getRealUrl());
                //此处应该加个文件是否存在的判断
                String filename = request.getFileName();
                //添加ZipEntry，并ZipEntry中写入文件流
                zipos.putNextEntry(new ZipEntry(filename));
                os = new DataOutputStream(zipos);
                FileInputStream is =  new FileInputStream(file);
                byte[] b = new byte[1024];
                int length = 0;
                while((length = is.read(b))!= -1){
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
}
