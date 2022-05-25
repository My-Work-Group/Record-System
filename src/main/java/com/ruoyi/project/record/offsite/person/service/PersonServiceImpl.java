package com.ruoyi.project.record.offsite.person.service;

import com.ruoyi.project.record.offsite.person.domain.Person;
import com.ruoyi.project.record.offsite.person.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 庞沛东
 * @Description:
 * @Date: create in 2022/4/2 14:11
 */

@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public int insertPerson(Person person) {
        return personMapper.insertPerson(person);
    }
}
