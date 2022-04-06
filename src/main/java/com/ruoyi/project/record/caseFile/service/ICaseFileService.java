package com.ruoyi.project.record.caseFile.service;

import com.ruoyi.project.record.caseFile.domain.CaseFile;

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


}


