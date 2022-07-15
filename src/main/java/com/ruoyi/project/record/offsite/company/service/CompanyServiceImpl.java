package com.ruoyi.project.record.offsite.company.service;

import com.ruoyi.project.record.offsite.company.domain.Company;
import com.ruoyi.project.record.offsite.company.mapper.CompanyMapper;
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

    @Override
    public int updateCompany(Company company) {

        return companyMapper.updateCompany(company);
    }
}
