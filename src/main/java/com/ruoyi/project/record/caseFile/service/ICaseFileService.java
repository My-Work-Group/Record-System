package com.ruoyi.project.record.caseFile.service;

import com.ruoyi.project.record.caseFile.domain.CaseFile;
import com.ruoyi.project.record.caseInfo.domain.CaseInfo;
import com.ruoyi.project.system.user.domain.User;

import java.util.List;

/**
 * @Author: 庞沛东
 * @Description:
 * @Date: create in 2022/4/1 13:00
 */

public interface ICaseFileService {

    /**
     * 保存案件信息
     *
     * @param caseFile 案件信息
     * @return 结果
     */
    public int insertCaseFile(CaseFile caseFile);
    /**
     * 根据条件分页查询笔录列表
     *
     * @param caseInfo 案件基本信息
     * @return 案件信息集合信息
     */
    public List<CaseFile> selectRecordList(CaseInfo caseInfo);

}


