package com.ruoyi.project.record.lgtrans.LtCaseInfo.mapper;

import com.ruoyi.project.record.lgtrans.LtCaseInfo.domain.LtCaseInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: 庞沛东
 * @Description: 定义  接口层
 * @Date: create in 2022/3/30 12:09
 */
public interface LtCaseInfoMapper {

    /**
     * 保存案件信息
     *
     * @param ltCaseInfo 案件信息
     * @return 结果
     */
    public int insertCase(@Param("ltCaseInfo") LtCaseInfo ltCaseInfo);

    /**
     * 更新案件信息
     *
     * @param ltCaseInfo 案件信息
     * @return 结果
     */
    public int updateCaseInfo(@Param("ltCaseInfo") LtCaseInfo ltCaseInfo);

    /**
     * 删除案件信息
     *
     * @param caseId
     * @return
     */
    public int deleteCaseInfoByIds(Integer[] caseId);


    /**
     * 通过案件编号查询案件信息
     *
     * @param caseNum
     * @return 结果
     */
    public LtCaseInfo selectCaseInfoByNum(String caseNum);

    /**
     * 通过案件id和编号查询案件信息
     *
     * @param caseId
     * @param caseNum
     * @return
     */
    public LtCaseInfo selectCaseInfoByIdAndNum(@Param("caseId")Integer caseId, @Param("caseNum")String caseNum);

}

