package com.ruoyi.project.record.offsite.service;


import com.ruoyi.project.record.offsite.domain.OffSiteCase;
import com.ruoyi.project.record.offsite.mapper.OffSiteCaseMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class CaseServiceImpl implements ICaseService {

    @Autowired
    private OffSiteCaseMapper offSiteCaseMapper;

    @Override
    public List<OffSiteCase> selectCaseList(OffSiteCase offSiteCase) {
        return null;
    }

    @Override
    @Transactional
    public int insertCase(OffSiteCase offSiteCase) {

        // 新增案件信息
        return offSiteCaseMapper.insertCase(offSiteCase);

    }

    @Override
    public int updateCase(OffSiteCase offSiteCaseEntity) {
        return 0;
    }

    @Override
    public int updateCaseInfo(OffSiteCase offSiteCaseEntity) {
        return 0;
    }
}
