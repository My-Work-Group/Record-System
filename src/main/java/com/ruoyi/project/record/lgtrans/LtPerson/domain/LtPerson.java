package com.ruoyi.project.record.lgtrans.LtPerson.domain;


public class LtPerson {
    private static final long serialVersionUID = 1L;
    // id
    private Integer personId;

    // 姓名
    private String personName;

    // 年龄
    private int age;

    //性别
    private String sex;

    // 身份证号
    private String numberId;

    // 联系电话
    private String personPhone;

    //家庭住址
    private String homeAddress;

    // 工作单位
    private String workUnit;

    // 联系地址
    private String contactAddress;

    // 职务
    private String post;

    // 邮编
    private String postCode;

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNumberId() {
        return numberId;
    }

    public void setNumberId(String numberId) {
        this.numberId = numberId;
    }

    public String getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(String personPhone) {
        this.personPhone = personPhone;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + personName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", numberId='" + numberId + '\'' +
                ", personPhone='" + personPhone + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", workUnit='" + workUnit + '\'' +
                ", contactAddress='" + contactAddress + '\'' +
                ", post='" + post + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }
}
