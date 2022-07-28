package com.ruoyi.project.record.offsite.person.service;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.record.offsite.company.domain.Company;
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

    @Override
    public int updatePerson(Person person) {
        int row;
        // 校验更新的信息用户名和身份证是否存在
        if ("1".equals(checkPersonUnique(person))) {
            row = insertPerson(person);// 存在即更新
        } else {
            row = personMapper.updatePerson(person);
        }

        return row;
    }

    @Override
    public Person selectPersonById(Person person) {
        return personMapper.selectPersonById(person.getPersonId());
    }

    @Override
    public String checkPersonUnique(Person person) {
        Person info = personMapper.checkPersonUnique(person.getPersonName(), person.getNumberId());
        if (StringUtils.isNotNull(info)) {
            // 状态码：1为存在该案件编号
            return "1";
        }
        return "0";
    }

}
