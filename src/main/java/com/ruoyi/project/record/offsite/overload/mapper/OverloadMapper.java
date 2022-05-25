package com.ruoyi.project.record.offsite.overload.mapper;

import com.ruoyi.project.record.offsite.overload.domain.Overload;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: 庞沛东
 * @Description: 定义  接口层
 * @Date: create in 2022/4/2 10:11
 */
public interface OverloadMapper {
    public int insertOverload(@Param("overload") Overload overload);
}
