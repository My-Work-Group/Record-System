package com.ruoyi.project.record.offsite.person.service;

import com.ruoyi.project.record.offsite.person.domain.Person;

/**
 * @Author: 庞沛东
 * @Description:
 * @Date: create in 2022/4/2 14:10
 */

public interface IPersonService {
    public int insertPerson(Person person);

    public int updatePerson(Person person);

    public Person selectPersonById(Integer personId);

    public Person selectPersonByNumId(String personNumId);

    public String checkPersonUnique(Person person);
}
