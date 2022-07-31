package com.ruoyi.project.record.offsite.caseInfo.service;

import com.ruoyi.project.record.offsite.caseInfo.domain.CaseInfo;


import java.util.List;

/**
 * @Author: 庞沛东
 * @Description: 定义 案件的 接口层
 * @Date: create in 2022/3/30 11:58
 */
public interface ICaseInfoService {
    /**
     * 根据条件分页查询案件信息
     *
     * @param caseInfoEntity 案件信息
     * @return 用户信息集合信息
     */
    public List<CaseInfo> selectCaseList(CaseInfo caseInfoEntity);

    /**
     * 保存案件信息
     *
     * @param caseInfoEntity 案件信息
     * @return 结果
     */
    public int insertCase(CaseInfo caseInfoEntity);


    /**
     * 更新案件信息
     *
     * @param caseInfoEntity 保存案件信息
     * @return 结果
     */
    public int updateCaseInfo(CaseInfo caseInfoEntity);

    /**
     * 删除案件信息
     *
     * @param caseId
     * @return
     */
    public int deleteCaseInfoByIds(String caseId);

    /**
     * 通过案件编号查询案件信息
     *
     * @param caseNum
     * @return
     */

    public CaseInfo selectCaseInfoByNum(String caseNum);

    /**
     * 通过案件id和编号查询案件信息
     *
     * @param caseId
     * @param caseNum
     * @return
     */
    public CaseInfo selectCaseInfoByIdAndNum(Integer caseId, String caseNum);


    /**
     * 校验案件编号名称是否唯一
     *
     * @param caseNum
     * @return 结果
     */
    public String checkCaseNumUnique(String caseNum);

    /**
     * 校验案件（id，编号）是否唯一
     *
     * @param caseId
     * @param caseInfo
     * @return
     */
    public String checkCaseInfoUnique(Integer caseId, String caseInfo);


}


