package com.ruoyi.project.record.caseFile.mapper;

import com.ruoyi.project.record.caseFile.domain.CaseFile;

/**
 * @Author: 庞沛东
 * @Description: 定义  接口层
 * @Date: create in 2022/4/1 13:08
 */
public interface CaseFileMapper {

    /**
     * 新增案件信息
     *
     * @param caseFile 用户信息
     * @return 结果
     */
    public  int insertCaseFile(CaseFile caseFile);
}
