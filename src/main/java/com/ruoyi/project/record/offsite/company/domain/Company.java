package com.ruoyi.project.record.offsite.company.domain;


public class Company {
    //    private static final long serialVersionUID = 1L;
    // 公司id
    private Integer companyId;
    // 公司名称
    private String companyName;
    // 统一社会信用代码
    private String creditCode;
    // 法人姓名
    private String directorName;
    // 法人身份证
    private String directorNumId;
    //公司地址
    private String companyAddress;
    // 公司电话
    private String companyPhone;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getDirectorNumId() {
        return directorNumId;
    }

    public void setDirectorNumId(String directorNumId) {
        this.directorNumId = directorNumId;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", creditCode='" + creditCode + '\'' +
                ", directorName='" + directorName + '\'' +
                ", directorNumId='" + directorNumId + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", companyPhone='" + companyPhone + '\'' +
                '}';
    }
}
