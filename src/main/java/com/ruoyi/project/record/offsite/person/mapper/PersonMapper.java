package com.ruoyi.project.record.offsite.person.mapper;

import com.ruoyi.project.record.offsite.person.domain.Person;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: 庞沛东
 * @Description: 定义  接口层
 * @Date: create in 2022/4/2 14:11
 */
public interface PersonMapper {
    public int insertPerson(@Param("person") Person person);
    public int updatePerson(@Param("person") Person person);
}
