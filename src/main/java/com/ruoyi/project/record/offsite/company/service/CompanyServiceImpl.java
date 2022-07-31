package com.ruoyi.project.record.offsite.company.service;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.record.offsite.company.domain.Company;
import com.ruoyi.project.record.offsite.company.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 庞沛东
 * @Description:
 * @Date: create in 2022/4/2 9:56
 */
@Service
public class CompanyServiceImpl implements ICompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public int insertCompany(Company company) {

        return companyMapper.insertCompany(company);
    }

    @Override
    public int updateCompany(Company company) {
        int companyId;
        // 校验更新的公司是否存在
        // 公司名和社会信用代码都应该唯一。
        // 所以，这里有个问题，即使不同名，同信用代码或（同名，不同信用代码）也会被添加表中。
        // 该问题暂时被记录于此。
        if ("1".equals(checkCompanyUnique(company))) {
            Company oldCompany = selectCompanyByNameAndCreditCode(company.getCompanyName(), company.getCreditCode());
            company.setCompanyId(oldCompany.getCompanyId());
            companyMapper.updateCompany(company);
            companyId = oldCompany.getCompanyId();
        } else {
            company.setCompanyId(null);
            companyMapper.insertCompany(company);
            companyId = company.getCompanyId();
        }
        return companyId;
    }

    @Override
    public Company selectCompanyById(Integer companyId) {
        return companyMapper.selectCompanyById(companyId);
    }

    @Override
    public Company selectCompanyByName(String companyName) {
        return companyMapper.selectCompanyByName(companyName);
    }

    @Override
    public Company selectCompanyByNameAndCreditCode(String companyName, String creditCode) {
        return companyMapper.selectCompanyByNameAndCreditCode(companyName, creditCode);
    }

    @Override
    public Company selectCompanyByCreditCode(String creditCode) {
        return companyMapper.selectCompanyByCreditCode(creditCode);
    }

    @Override
    public String checkCompanyUnique(Company company) {
        Company info = selectCompanyByNameAndCreditCode(company.getCompanyName(),company.getCreditCode());
        if (StringUtils.isNotNull(info)) {
            return "1";
        }
        return "0";
    }
}
