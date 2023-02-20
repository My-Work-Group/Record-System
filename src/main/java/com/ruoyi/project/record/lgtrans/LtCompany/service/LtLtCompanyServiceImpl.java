package com.ruoyi.project.record.lgtrans.LtCompany.service;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.record.lgtrans.LtCompany.domain.LtCompany;
import com.ruoyi.project.record.lgtrans.LtCompany.mapper.LtCompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 庞沛东
 * @Description:
 * @Date: create in 2022/4/2 9:56
 */
@Service
public class LtLtCompanyServiceImpl implements ILtCompanyService {

    @Autowired
    private LtCompanyMapper ltCompanyMapper;

    @Override
    public int insertCompany(LtCompany ltCompany) {

        return ltCompanyMapper.insertCompany(ltCompany);
    }

    @Override
    public int updateCompany(LtCompany ltCompany) {
        int companyId;
        // 校验更新的公司是否存在
        // 公司名和社会信用代码都应该唯一。
        // 所以，这里有个问题，即使不同名，同信用代码或（同名，不同信用代码）也会被添加表中。
        // 该问题暂时被记录于此。
        if ("1".equals(checkCompanyUnique(ltCompany))) {
            LtCompany oldCompany = selectCompanyByNameAndCreditCode(ltCompany.getCompanyName(), ltCompany.getCreditCode());
            ltCompany.setCompanyId(oldCompany.getCompanyId());
            ltCompanyMapper.updateCompany(ltCompany);
            companyId = oldCompany.getCompanyId();
        } else {
            ltCompany.setCompanyId(null);
            ltCompanyMapper.insertCompany(ltCompany);
            companyId = ltCompany.getCompanyId();
        }
        return companyId;
    }

    @Override
    public LtCompany selectCompanyById(Integer companyId) {
        return ltCompanyMapper.selectCompanyById(companyId);
    }

    @Override
    public LtCompany selectCompanyByName(String companyName) {
        return ltCompanyMapper.selectCompanyByName(companyName);
    }

    @Override
    public LtCompany selectCompanyByNameAndCreditCode(String companyName, String creditCode) {
        return ltCompanyMapper.selectCompanyByNameAndCreditCode(companyName, creditCode);
    }

    @Override
    public LtCompany selectCompanyByCreditCode(String creditCode) {
        return ltCompanyMapper.selectCompanyByCreditCode(creditCode);
    }

    @Override
    public String checkCompanyUnique(LtCompany company) {
        LtCompany info = selectCompanyByNameAndCreditCode(company.getCompanyName(),company.getCreditCode());
        if (StringUtils.isNotNull(info)) {
            return "1";
        }
        return "0";
    }
}
