package com.ruoyi.project.record.lgtrans.LtCompany.mapper;

import com.ruoyi.project.record.lgtrans.LtCompany.domain.LtCompany;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: 庞沛东
 * @Description: 定义  接口层
 * @Date: create in 2022/4/2 9:57
 */
public interface LtCompanyMapper {

    public int insertCompany(@Param("ltCompany") LtCompany ltCompany);

    public int updateCompany(@Param("ltCompany") LtCompany ltCompany);

    public LtCompany selectCompanyById(Integer companyId);

    public LtCompany selectCompanyByNameAndCreditCode(String companyName, String creditCode);

    public LtCompany selectCompanyByCreditCode(String creditCode);

    public LtCompany selectCompanyByName(String companyName);

    public LtCompany checkCompanyUnique(String companyName, String creditCode);

}
