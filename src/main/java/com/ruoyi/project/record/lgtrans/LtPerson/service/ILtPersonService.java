package com.ruoyi.project.record.lgtrans.LtPerson.service;

import com.ruoyi.project.record.lgtrans.LtPerson.domain.LtPerson;

/**
 * @Author: 庞沛东
 * @Description:
 * @Date: create in 2022/4/2 14:10
 */

public interface ILtPersonService {
    public int insertPerson(LtPerson ltPerson);

    public int updatePerson(LtPerson ltPerson);

    public LtPerson selectPersonById(Integer personId);

    public LtPerson selectPersonByNumId(String personNumId);

    public String checkPersonUnique(LtPerson ltPerson);
}
