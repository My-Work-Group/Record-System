package com.ruoyi.project.record.offsite.caseFile.service;

import com.ruoyi.project.record.offsite.caseFile.domain.CaseFile;
import com.ruoyi.project.record.offsite.caseInfo.domain.CaseInfo;


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
     * 更新案件信息
     *
     * @param caseFile 案件信息
     * @return 结果
     */
    public int updateCaseFile(CaseFile caseFile);

    /**
     * 根据条件分页查询笔录列表
     *
     * @return 案件信息集合信息
     */
    public List<CaseInfo> selectRecordList();

    /**
     * 通过案件ID查询笔录
     *
     * @param caseId 案件id
     * @return 用户对象信息
     */
    public CaseFile selectRecordById(Integer caseId);

}


