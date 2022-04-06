package com.ruoyi.project.record.caseInfo.mapper;

import com.ruoyi.project.record.caseInfo.domain.CaseInfo;
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
     * 校验案件编号名称是否唯一
     *
     * @param caseNum 登录名称
     * @return 结果
     */
    public int checkCaseNumUnique(String caseNum);

}

