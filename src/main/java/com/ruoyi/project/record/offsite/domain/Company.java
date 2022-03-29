package com.ruoyi.project.record.offsite.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;

public class Company {
    private static final long serialVersionUID = 1L;
    // 案卷编号
    @Excel(name = "案卷编号", cellType = Excel.ColumnType.NUMERIC, prompt = "案卷编号")
    private Long fileId;
    // 受案时间
    @Excel(name = "受案时间", type = Excel.Type.IMPORT)
    private String time;
    // 罚款金额
    private Long fine;

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Long getFine() {
        return fine;
    }

    public void setFine(Long fine) {
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "Company{" +
                "fileId=" + fileId +
                ", time='" + time + '\'' +
                ", fine=" + fine +
                '}';
    }
}
