package com.ruoyi.project.record.lgtrans.LtPerson.mapper;

import com.ruoyi.project.record.lgtrans.LtPerson.domain.LtPerson;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: 庞沛东
 * @Description: 定义  接口层
 * @Date: create in 2022/4/2 14:11
 */
public interface LtPersonMapper {
    public int insertPerson(@Param("ltPerson") LtPerson ltPerson);

    public int updatePerson(@Param("ltPerson") LtPerson ltPerson);

    public LtPerson selectPersonById(Integer personId);

    public LtPerson selectPersonByNumId(String numberId);

    public LtPerson selectPersonByNameAndId(String personName, String personId);

}
