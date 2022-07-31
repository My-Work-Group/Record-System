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

    /**
     * 根据公司id查询公司信息
     *
     * @param companyId
     * @return 结果
     */
    public Company selectCompanyById(Integer companyId);

    /**
     * 校验公司是否唯一
     *
     * @param company
     * @return
     */
    public String checkCompanyUnique(Company company);

    /**
     * 通过公司名和社会信用代码查询公司
     * @param companyName 公司名
     * @param creditCode  社会信息代码
     * @return
     */
    public Company selectCompanyByNameAndCreditCode(String companyName, String creditCode);


    /**
     * 通过公司名查询公司
     * @param companyName 公司名
     * @return
     */
    public Company selectCompanyByName(String companyName);

    /**
     *  通过社会信用代码查询公司
     * @param creditCode 社会信息代码
     * @return
     */
    public Company selectCompanyByCreditCode(String creditCode);

}
