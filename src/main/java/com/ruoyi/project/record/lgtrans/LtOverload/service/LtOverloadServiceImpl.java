package com.ruoyi.project.record.lgtrans.LtOverload.service;

import com.ruoyi.project.record.lgtrans.LtOverload.domain.LtOverload;
import com.ruoyi.project.record.lgtrans.LtOverload.mapper.LtOverloadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 庞沛东
 * @Description:
 * @Date: create in 2022/4/2 10:12
 */
@Service
public class LtOverloadServiceImpl implements ILtOverloadService {

    @Autowired
    private LtOverloadMapper ltOverloadMapper;

    @Override
    public int insertOverload(LtOverload ltOverload) {
        return ltOverloadMapper.insertOverload(ltOverload);
    }

    @Override
    public int updateOverload(LtOverload ltOverload) {
        return ltOverloadMapper.updateOverload(ltOverload);
    }
}
