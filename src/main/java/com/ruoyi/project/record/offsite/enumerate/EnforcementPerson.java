package com.ruoyi.project.record.offsite.enumerate;

public enum EnforcementPerson {
    Person_1(1, "於民", "10020617250"),
    Person_2(2, "雷海华", "10020617025"),
    Person_3(3, "高一平", "10020617022"),
    Person_4(4, "许云江", "10020617026"),
    Person_5(5, "赵鹰", "10020617024"),
    Person_6(6, "谢涛", "10020617251"),
    Person_7(7, "梅强", "10020617023"),
    Person_8(8, "庞沛东", "10020617248");
    private Integer id;
    private String name;
    private String number;

    EnforcementPerson(Integer id, String name, String number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
