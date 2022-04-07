package com.ruoyi.test;

import com.ruoyi.project.record.caseFile.domain.CaseFile;
import com.ruoyi.project.record.company.domain.Company;
import com.ruoyi.project.record.person.domain.Person;

import static com.ruoyi.common.utils.StringUtils.isAllFieldNull;
import static com.ruoyi.common.utils.uuid.IdUtils.randomUUID;

public class test {
    public static void main(String[] args) {
//        CaseFile caseFile =  new CaseFile();
        Company company = new Company();
        company.setCompanyId(null);
        company.setCompanyAddress("");
        company.setCompanyName("");
        company.setCompanyPhone("");
        company.setCreditCode("");
        company.setDirectorNumId("");
        company.setDirectorName("");
        System.out.println(company.toString());
        if (!isAllFieldNull(company)) {
            System.out.println("不是空的");
        } else {
            System.out.println("空的");
        }
    }
}
