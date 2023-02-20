package com.ruoyi.project.record.lgtrans.LtOverload.mapper;

import com.ruoyi.project.record.lgtrans.LtOverload.domain.LtOverload;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: 庞沛东
 * @Description: 定义  接口层
 * @Date: create in 2022/4/2 10:11
 */
public interface LtOverloadMapper {
    public int insertOverload(@Param("ltOverload") LtOverload ltOverload);
    public int updateOverload(@Param("ltOverload") LtOverload ltOverload);
}
