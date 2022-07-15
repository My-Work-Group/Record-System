package com.ruoyi.project.record.offsite.overload.service;

import com.ruoyi.project.record.offsite.overload.domain.Overload;
import com.ruoyi.project.record.offsite.overload.mapper.OverloadMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: 庞沛东
 * @Description:
 * @Date: create in 2022/4/2 10:12
 */

public class OverloadServiceImpl implements IOverloadService {

    @Autowired
    private OverloadMapper overloadMapper;

    @Override
    public int insertOverload(Overload overload) {
        return overloadMapper.insertOverload(overload);
    }

    @Override
    public int updateOverload(Overload overload) {
        return overloadMapper.updateOverload(overload);
    }
}
