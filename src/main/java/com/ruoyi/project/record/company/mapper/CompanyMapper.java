package com.ruoyi.project.record.company.mapper;

import com.ruoyi.project.record.company.domain.Company;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: 庞沛东
 * @Description: 定义  接口层
 * @Date: create in 2022/4/2 9:57
 */
public interface CompanyMapper {

    public int insertCompany(@Param("company") Company company);

}
