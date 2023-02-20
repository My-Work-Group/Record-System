package com.ruoyi.project.record.lgtrans.LtCompany.service;

import com.ruoyi.project.record.lgtrans.LtCompany.domain.LtCompany;

/**
 * @Author: 庞沛东
 * @Description: 定义  接口层
 * @Date: create in 2022/4/2 9:56
 */
public interface ILtCompanyService {

    /**
     * 添加公司信息
     *
     * @param company 公司信息
     * @return 结果
     */
    public int insertCompany(LtCompany company);

    /**
     * 修改公司信息
     *
     * @param company 公司信息
     * @return 结果
     */
    public int updateCompany(LtCompany company);

    /**
     * 根据公司id查询公司信息
     *
     * @param companyId
     * @return 结果
     */
    public LtCompany selectCompanyById(Integer companyId);

    /**
     * 校验公司是否唯一
     *
     * @param company
     * @return
     */
    public String checkCompanyUnique(LtCompany company);

    /**
     * 通过公司名和社会信用代码查询公司
     * @param companyName 公司名
     * @param creditCode  社会信息代码
     * @return
     */
    public LtCompany selectCompanyByNameAndCreditCode(String companyName, String creditCode);


    /**
     * 通过公司名查询公司
     * @param companyName 公司名
     * @return
     */
    public LtCompany selectCompanyByName(String companyName);

    /**
     *  通过社会信用代码查询公司
     * @param creditCode 社会信息代码
     * @return
     */
    public LtCompany selectCompanyByCreditCode(String creditCode);

}
