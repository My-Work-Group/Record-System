package com.ruoyi.project.record.person.domain;

public class Person {
    private static final long serialVersionUID = 1L;

    // 姓名
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", numberId='" + numberId + '\'' +
                ", personPhone='" + personPhone + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", workUnit='" + workUnit + '\'' +
                ", contactAddress='" + contactAddress + '\'' +
                ", post='" + post + '\'' +
                '}';
    }
}
