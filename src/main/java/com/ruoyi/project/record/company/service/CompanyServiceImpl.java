package com.ruoyi.project.record.company.service;

import com.ruoyi.project.record.company.domain.Company;
import com.ruoyi.project.record.company.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: 庞沛东
 * @Description:
 * @Date: create in 2022/4/2 9:56
 */

public class CompanyServiceImpl implements ICompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public int insertCompany(Company company) {

        return companyMapper.insertCompany(company);
    }
}
