package com.ruoyi.project.record.company.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Company {
    private static final long serialVersionUID = 1L;
    // 公司id
    private Long companyId;
    // 公司名称
    private String companyName;
    // 统一社会信用代码
    private String creditCode ;
    // 法人姓名
    private String directorName ;
    // 法人身份证
    private String directorNumId;
    //公司地址
    private String companyAddress;
    // 公司电话
    private String companyPhone;
}
