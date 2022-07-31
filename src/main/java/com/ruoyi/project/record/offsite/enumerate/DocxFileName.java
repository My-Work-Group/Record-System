package com.ruoyi.project.record.offsite.enumerate;

public enum DocxFileName{
    FilE_1(1,"立案登记表"),
    FilE_2(2,"询问笔录"),
    FilE_3(3,"案卷调查报告"),
    FilE_4(4,"违法行为通知书"),
    FilE_5(5,"违法行为通知书送达回证"),
    FilE_6(6,"陈述申辩笔录"),
    FilE_7(7,"行政处罚决定书"),
    FilE_8(8,"行政处罚决定书送达回证"),
    FilE_9(9,"结案报告"),
    FilE_10(10,"送达信息确认书");
    private  int fileId;
    private String fileName;
    // 构造方法
    private DocxFileName(int fileId, String fileName) {
        this.fileId = fileId;
        this.fileName = fileName;
    }

    // 普通方法
    public static String getName(int fileId) {
        for (DocxFileName c : DocxFileName.values()) {
            if (c.getFileId() == fileId) {
                return c.fileName;
            }
        }
        return null;
    }

    // get set 方法
    public String getName() {
        return fileName;
    }

    public void setName(String fileName) {
        this.fileName = fileName;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }
}
