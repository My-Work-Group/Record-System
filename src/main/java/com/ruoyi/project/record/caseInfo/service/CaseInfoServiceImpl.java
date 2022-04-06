package com.ruoyi.project.record.caseInfo.service;


import com.ruoyi.project.record.caseInfo.domain.CaseInfo;
import com.ruoyi.project.record.caseInfo.mapper.CaseInfoMapper;
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
     * @param caseNum 登录名称
     * @return 结果
     */
    @Override
    public String checkCaseNumUnique(String caseNum) {
        int count = caseInfoMapper.checkCaseNumUnique(caseNum);
        if (count > 0) {
            // 状态码：1为存在该案件编号
            return "1";
        }
        //状态码：0 为不存在该案件编号
        return "0";
    }

}
