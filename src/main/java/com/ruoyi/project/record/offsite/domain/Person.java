package com.ruoyi.project.record.offsite.domain;

public class Person {
    private static final long serialVersionUID = 1L;

    // 姓名
    private String name;

    // 年龄
    private int age;

    // 身份证号
    private String numberId;

    // 联系电话
    private String telephone;

    //住址
    private String address;

    // 工作单位
    private String workUnit;

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

    public String getNumberId() {
        return numberId;
    }

    public void setNumberId(String numberId) {
        this.numberId = numberId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
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
                ", numberId='" + numberId + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", workUnit='" + workUnit + '\'' +
                ", post='" + post + '\'' +
                '}';
    }
}
