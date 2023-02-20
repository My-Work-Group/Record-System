package com.ruoyi.project.record.lgtrans.LtPerson.service;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.record.lgtrans.LtPerson.domain.LtPerson;
import com.ruoyi.project.record.lgtrans.LtPerson.mapper.LtPersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 庞沛东
 * @Description:
 * @Date: create in 2022/4/2 14:11
 */

@Service
public class LtPersonServiceImpl implements ILtPersonService {

    @Autowired
    private LtPersonMapper ltPersonMapper;

    @Override
    public int insertPerson(LtPerson ltPerson) {
        return ltPersonMapper.insertPerson(ltPerson);
    }

    @Override
    public int updatePerson(LtPerson ltPerson) {
        int personId;
        // 校验更新的个人信息是否存在
        if ("1".equals(checkPersonUnique(ltPerson))) {
            LtPerson oldLtPerson = selectPersonByNumId(ltPerson.getNumberId());
            ltPerson.setPersonId(oldLtPerson.getPersonId());
            ltPersonMapper.updatePerson(ltPerson);
            personId = oldLtPerson.getPersonId();
        } else {
            ltPerson.setPersonId(null);
            ltPersonMapper.insertPerson(ltPerson);
            personId = ltPerson.getPersonId();
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
    public LtPerson selectPersonById(Integer personId) {
        return ltPersonMapper.selectPersonById(personId);
    }

    /**
     * 通过身份证号查询个人信息
     *
     * @param personNumId
     * @return
     */
    @Override
    public LtPerson selectPersonByNumId(String personNumId) {
        return ltPersonMapper.selectPersonByNumId(personNumId);
    }

    /**
     * 校验个人是否唯一（通过身份号即可）
     *
     * @param ltPerson
     * @return
     */
    @Override
    public String checkPersonUnique(LtPerson ltPerson) {
        LtPerson info = selectPersonByNumId(ltPerson.getNumberId());
        if (StringUtils.isNotNull(info)) {
            return "1";
        }
        return "0";
    }

}
