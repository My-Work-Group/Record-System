package com.ruoyi.project.record.offsite.company.mapper;

import com.ruoyi.project.record.offsite.caseInfo.domain.CaseInfo;
import com.ruoyi.project.record.offsite.company.domain.Company;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: 庞沛东
 * @Description: 定义  接口层
 * @Date: create in 2022/4/2 9:57
 */
public interface CompanyMapper {

    public int insertCompany(@Param("company") Company company);

    public int updateCompany(@Param("company") Company company);

    /**
     * 校验公司名是否唯一
     *
     * @param companyName
     * @return 结果
     */
    public  Company checkCompanyUnique(String companyName,String creditCode);
}
