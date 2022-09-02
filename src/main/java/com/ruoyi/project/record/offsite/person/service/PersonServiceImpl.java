package com.ruoyi.project.record.offsite.person.service;

import com.ruoyi.common.utils.StringUtils;
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
        int personId;
        // 校验更新的个人信息是否存在
        if ("1".equals(checkPersonUnique(person))) {

            Person oldPerson = selectPersonByNumId(person.getNumberId());
            person.setPersonId(oldPerson.getPersonId());
            personMapper.updatePerson(person);
            personId = oldPerson.getPersonId();
        } else {
            person.setPersonId(null);
            personMapper.insertPerson(person);
            personId = person.getPersonId();
        }
        return personId;
    }

    /**
     * 通过表中的id查询个人信息
     *
     * @param personId
     * @return
     */
    @Override
    public Person selectPersonById(Integer personId) {
        return personMapper.selectPersonById(personId);
    }

    /**
     * 通过身份证号查询个人信息
     *
     * @param personNumId
     * @return
     */
    @Override
    public Person selectPersonByNumId(String personNumId) {
        return personMapper.selectPersonByNumId(personNumId);
    }

    /**
     * 校验个人是否唯一（通过身份号即可）
     *
     * @param person
     * @return
     */
    @Override
    public String checkPersonUnique(Person person) {
        Person info = selectPersonByNumId(person.getNumberId());
        if (StringUtils.isNotNull(info)) {
            return "1";
        }
        return "0";
    }

}
