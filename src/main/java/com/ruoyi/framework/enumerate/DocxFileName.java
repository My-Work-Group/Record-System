package com.ruoyi.framework.enumerate;

public enum DocxFileName{
    FilE_1(1,"立案登记表"),
    FilE_2(2,"询问笔录"),
    FilE_3(3,"案卷调查报告"),
    FilE_4(4,"违法行为通知书"),
    FilE_6(6,"通知书送达回证"),
    FilE_7(7,"陈述申辩笔录"),
    FilE_8(8,"行政处罚决定书"),
    FilE_9(9,"决定书送达回证"),
    FilE_10(10,"结案报告");
    private final int fileId;
    private final String fileName;
    // 构造方法
    private DocxFileName(int fileId, String fileName) {
        this.fileId = fileId;
        this.fileName = fileName;
    }
}
