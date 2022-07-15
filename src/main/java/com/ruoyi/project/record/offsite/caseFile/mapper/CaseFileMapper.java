package com.ruoyi.project.record.offsite.caseFile.mapper;

import com.ruoyi.project.record.offsite.caseFile.domain.CaseFile;
import com.ruoyi.project.record.offsite.caseInfo.domain.CaseInfo;

import java.util.List;

/**
 * @Author: 庞沛东
 * @Description: 定义  接口层
 * @Date: create in 2022/4/1 13:08
 */
public interface CaseFileMapper {

    /**
     * 用于显示首页的笔录列表
     *
     * @return
     */
    public List<CaseInfo> selectRecordList();

    /**
     * 通过案件ID查询笔录
     *
     * @param caseId 用户ID
     * @return 用户对象信息
     */
    public CaseFile selectRecordById(Integer caseId);


}
