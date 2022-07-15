package com.ruoyi.project.record.offsite.caseInfo.service;


import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.record.offsite.caseInfo.domain.CaseInfo;
import com.ruoyi.project.record.offsite.caseInfo.mapper.CaseInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: 庞沛东
 * @Description:
 * @Date: create in 2022/3/30 11:50
 */
@Service
public class CaseInfoServiceImpl implements ICaseInfoService {

    @Autowired
    private CaseInfoMapper caseInfoMapper;

    @Override
    public List<CaseInfo> selectCaseList(CaseInfo caseInfo) {
        return null;
    }

    // 新增案件信息
    @Override
    @Transactional
    public int insertCase(CaseInfo caseInfo) {
        return caseInfoMapper.insertCase(caseInfo);
    }

    // 删除信息
    @Override
    public int deleteCaseInfoByIds(String caseId) {
        Integer[] id = Convert.toIntArray(caseId);
        return caseInfoMapper.deleteCaseInfoByIds(id);
    }

    // 更新案件信息
    @Override
    public int updateCaseInfo(CaseInfo caseInfo) {
        return caseInfoMapper.updateCaseInfo(caseInfo);
    }

    /**
     * 校验案件编号名称是否唯一
     *
     * @param caseNum
     * @return 结果
     */
    @Override
    public String checkCaseNumUnique(String caseNum) {
        CaseInfo info = caseInfoMapper.checkCaseNumUnique(caseNum);
        if (StringUtils.isNotNull(info)) {
            // 状态码：1为存在该案件编号
            return "1";
        }
        return "0";
    }
}
