package com.ruoyi.project.record.caseFile.mapper;

import com.ruoyi.project.record.caseFile.domain.CaseFile;
import com.ruoyi.project.record.caseInfo.domain.CaseInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 庞沛东
 * @Description: 定义  接口层
 * @Date: create in 2022/4/1 13:08
 */
public interface CaseFileMapper {

    /**
     *
     * @param caseInfo 查询笔录，用于显示首页的笔录列表
     * @return
     */
    public String selectRecordList();
}
