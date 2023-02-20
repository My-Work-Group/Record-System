package com.ruoyi.project.record.lgtrans.LtCaseFile.service;

import com.ruoyi.project.record.lgtrans.LtCaseFile.domain.LtCaseFile;
import com.ruoyi.project.record.lgtrans.LtCaseInfo.domain.LtCaseInfo;

import java.util.List;

/**
 * @Author: 庞沛东
 * @Description:
 * @Date: create in 2022/4/1 13:00
 */

public interface ILtCaseFileService {

    /**
     * 保存案件信息
     *
     * @param caseFile 案件信息
     * @return 结果
     */
    public int insertCaseFile(LtCaseFile caseFile);

    /**
     * 更新案件信息
     *
     * @param caseFile 案件信息
     * @return 结果
     */
    public int updateCaseFile(LtCaseFile caseFile);

    /**
     * 根据条件分页查询笔录列表
     *
     * @return 案件信息集合信息
     */
    public List<LtCaseInfo> selectRecordList();

    /**
     * 通过案件ID查询笔录
     *
     * @param caseId 案件id
     * @return 用户对象信息
     */
    public LtCaseFile selectRecordById(Integer caseId);

}


