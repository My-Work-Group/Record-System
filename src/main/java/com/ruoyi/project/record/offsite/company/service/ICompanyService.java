package com.ruoyi.project.record.offsite.company.service;

import com.ruoyi.project.record.offsite.company.domain.Company;

/**
 * @Author: 庞沛东
 * @Description: 定义  接口层
 * @Date: create in 2022/4/2 9:56
 */
public interface ICompanyService {

    /**
     * 添加公司信息
     *
     * @param company 公司信息
     * @return 结果
     */
    public int insertCompany(Company company);

    /**
     * 修改公司信息
     *
     * @param company 公司信息
     * @return 结果
     */
    public int updateCompany(Company company);
}
