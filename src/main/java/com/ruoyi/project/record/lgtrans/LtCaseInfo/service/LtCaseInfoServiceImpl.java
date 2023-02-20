package com.ruoyi.project.record.lgtrans.LtCaseInfo.service;


import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.record.lgtrans.LtCaseInfo.domain.LtCaseInfo;
import com.ruoyi.project.record.lgtrans.LtCaseInfo.mapper.LtCaseInfoMapper;
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
public class LtCaseInfoServiceImpl implements ILtCaseInfoService {

    @Autowired
    private LtCaseInfoMapper ltCaseInfoMapper;

    @Override
    public List<LtCaseInfo> selectCaseList(LtCaseInfo ltCaseInfo) {
        return null;
    }

    // 新增案件信息
    @Override
    @Transactional
    public int insertCase(LtCaseInfo ltCaseInfo) {
        return ltCaseInfoMapper.insertCase(ltCaseInfo);
    }

    // 删除信息
    @Override
    public int deleteCaseInfoByIds(String caseId) {
        Integer[] id = Convert.toIntArray(caseId);
        return ltCaseInfoMapper.deleteCaseInfoByIds(id);
    }

    // 更新案件信息
    @Override
    public int updateCaseInfo(LtCaseInfo ltCaseInfo) {
        return ltCaseInfoMapper.updateCaseInfo(ltCaseInfo);
    }

    // 通过案件编号查询案件信息
    @Override
    public LtCaseInfo selectCaseInfoByNum(String caseNum) {
        return ltCaseInfoMapper.selectCaseInfoByNum(caseNum);
    }

    // 通过案件id和编号查询案件信息
    public LtCaseInfo selectCaseInfoByIdAndNum(Integer caseId, String caseNum) {
        return ltCaseInfoMapper.selectCaseInfoByIdAndNum(caseId, caseNum);
    }

    /**
     * 校验案件编号名称是否唯一
     *
     * @param caseNum
     * @return 结果
     */
    @Override
    public String checkCaseNumUnique(String caseNum) {
        LtCaseInfo info = selectCaseInfoByNum(caseNum);
        if (StringUtils.isNotNull(info)) {
            // 状态码：1为存在该案件编号
            return "1";
        }
        return "0";
    }

    /**
     * 校验案件是否唯一
     *
     * @param caseId  案件id
     * @param caseNum 案件编号
     * @return
     */
    @Override
    public String checkCaseInfoUnique(Integer caseId, String caseNum) {
        LtCaseInfo info = selectCaseInfoByIdAndNum(caseId, caseNum);
        if (StringUtils.isNotNull(info)) {
            // 状态码：1为存在该案件编号
            return "1";
        }
        return "0";
    }
}
