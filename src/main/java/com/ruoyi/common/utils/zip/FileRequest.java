package com.ruoyi.common.utils.zip;

/**
 * @Author: 庞沛东
 * @Description:
 * @Date: create in 2022/4/29 15:25
 */


public class FileRequest{
    private String realUrl;
    private String fileName;

    public FileRequest(){}
    public FileRequest(String realUrl, String fileName) {
        this.realUrl = realUrl;
        this.fileName = fileName;
    }

    public String getRealUrl() {
        return realUrl;
    }

    public void setRealUrl(String realUrl) {
        this.realUrl = realUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}