package com.ruoyi.project.record.offsite.company.service;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.record.offsite.caseInfo.domain.CaseInfo;
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

    @Override
    public int selectCompanyById(Company company) {
        return companyMapper.selectCompanyById(company.getCompanyId());
    }

    @Override
    public String checkCompanyUnique(Company company) {
        Company info = companyMapper.checkCompanyUnique(company.getCompanyName(), company.getCreditCode());
        if (StringUtils.isNotNull(info)) {
            // 状态码：1为存在该案件编号
            return "1";
        }
        return "0";
    }
}
