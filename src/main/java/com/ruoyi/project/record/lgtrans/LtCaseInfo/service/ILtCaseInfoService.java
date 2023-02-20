package com.ruoyi.project.record.lgtrans.LtCaseInfo.service;


import com.ruoyi.project.record.lgtrans.LtCaseInfo.domain.LtCaseInfo;

import java.util.List;

/**
 * @Author: 庞沛东
 * @Description: 定义 案件的 接口层
 * @Date: create in 2022/3/30 11:58
 */
public interface ILtCaseInfoService {
    /**
     * 根据条件分页查询案件信息
     *
     * @param ltCaseInfoEntity 案件信息
     * @return 用户信息集合信息
     */
    public List<LtCaseInfo> selectCaseList(LtCaseInfo ltCaseInfoEntity);

    /**
     * 保存案件信息
     *
     * @param ltCaseInfoEntity 案件信息
     * @return 结果
     */
    public int insertCase(LtCaseInfo ltCaseInfoEntity);


    /**
     * 更新案件信息
     *
     * @param ltCaseInfoEntity 保存案件信息
     * @return 结果
     */
    public int updateCaseInfo(LtCaseInfo ltCaseInfoEntity);

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

    public LtCaseInfo selectCaseInfoByNum(String caseNum);

    /**
     * 通过案件id和编号查询案件信息
     *
     * @param caseId
     * @param caseNum
     * @return
     */
    public LtCaseInfo selectCaseInfoByIdAndNum(Integer caseId, String caseNum);


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


