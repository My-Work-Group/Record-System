package com.ruoyi.project.record.offsite.caseInfo.mapper;

import com.ruoyi.project.record.offsite.caseInfo.domain.CaseInfo;
import com.ruoyi.project.record.offsite.person.domain.Person;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: 庞沛东
 * @Description: 定义  接口层
 * @Date: create in 2022/3/30 12:09
 */
public interface CaseInfoMapper {

    /**
     * 保存案件信息
     *
     * @param caseInfo 案件信息
     * @return 结果
     */
    public  int insertCase(@Param("caseInfo") CaseInfo caseInfo);

    /**
     * 更新案件信息
     *
     * @param caseInfo 案件信息
     * @return 结果
     */
    public  int updateCaseInfo(@Param("caseInfo") CaseInfo caseInfo);

    /**
     * 删除案件信息
     * @param caseId
     * @return
     */
    public int deleteCaseInfoByIds(Integer[] caseId);


    /**
     * 校验案件编号名称是否唯一
     *
     * @param caseInfo
     * @return 结果
     */
    public CaseInfo checkCaseNumUnique(String caseInfo);

}

