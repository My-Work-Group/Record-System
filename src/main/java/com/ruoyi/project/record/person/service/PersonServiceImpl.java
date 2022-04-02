package com.ruoyi.project.record.person.service;

import com.ruoyi.project.record.person.domain.Person;
import com.ruoyi.project.record.person.mapper.PersonMapper;
import com.ruoyi.project.system.user.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
