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

    @Override
    @Transactional
    public int insertCase(CaseInfo caseInfo) {
        // 新增案件信息
        return caseInfoMapper.insertCase(caseInfo);
    }

    @Override
    public int deleteCaseInfoByIds(String caseId) {
        Integer[] id = Convert.toIntArray(caseId);
        return caseInfoMapper.deleteCaseInfoByIds(id);
    }

    @Override
    public int updateCase(CaseInfo caseInfoEntity) {
        return 0;
    }

    @Override
    public int updateCaseInfo(CaseInfo caseInfoEntity) {
        return 0;
    }

    /**
     * 校验案件编号名称是否唯一
     *
     * @param caseNum
     * @return 结果
     */
    @Override
    public String checkCaseNumUnique(String caseNum) {
        System.out.println(caseNum);
        CaseInfo info = caseInfoMapper.checkCaseNumUnique(caseNum);
        if (StringUtils.isNotNull(info)) {
            // 状态码：1为存在该案件编号
            return "1";
        }
        return "0";
    }
}
