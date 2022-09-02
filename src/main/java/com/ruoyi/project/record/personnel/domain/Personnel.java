package com.ruoyi.project.record.personnel.domain;

/**
 * @Author: 庞沛东
 * @Description: zf人员实体类
 * @Date: create in 2022/8/30 13:42
 */

public class Personnel {
    // id
    private Integer personnelId;

    // zf人员姓名
    private String personnelName;

    // zf编号
    private String enforcementId;

    private boolean flag = false;


    public Integer getPersonnelId() {
        return personnelId;
    }

    public void setPersonnelId(Integer personnelId) {
        this.personnelId = personnelId;
    }

    public String getPersonnelName() {
        return personnelName;
    }

    public void setPersonnelName(String personnelName) {
        this.personnelName = personnelName;
    }

    public String getEnforcementId() {
        return enforcementId;
    }

    public void setEnforcementId(String enforcementId) {
        this.enforcementId = enforcementId;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Personnel{" +
                "personnelId='" + personnelId + '\'' +
                "personnelName='" + personnelName + '\'' +
                ", enforcementId=" + enforcementId +
                '}';
    }
}
