package com.ruoyi.project.record.personnel.service;

import com.ruoyi.project.record.offsite.person.mapper.PersonMapper;
import com.ruoyi.project.record.personnel.domain.Personnel;
import com.ruoyi.project.record.personnel.mapper.PersonnelMapper;
import com.ruoyi.project.system.post.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @Author: 庞沛东
 * @Description:
 * @Date: create in 2022/8/30 13:48
 */

@Service
public class PersonnelServiceImpl implements IPersonnelService {

    @Autowired
    PersonnelMapper personnelMapper;

    /**
     * 通过id查询ZF人员
     *
     * @param personnelId
     * @return
     */
    @Override
    public Personnel selectPersonnelById(Integer personnelId) {
        return personnelMapper.selectPersonnelById(personnelId);
    }

    /**
     * 查询所有执法人员
     *
     * @return
     */
    @Override
    public List<Personnel> selectPersonnelAll() {
        return personnelMapper.selectPersonnelAll();
    }

    /**
     * 根据ids批量查询ZF人员信息
     *
     * @return
     */
    @Override
    public List<Personnel> selectPersonnelListByIds(String[] personnelIds) {
        return personnelMapper.selectPersonnelListByIds(personnelIds);
    }


    /**
     * 根据ids批量查询ZF人员信息，标记已选中的zf人员。
     *
     * @return
     */
    @Override
    public List<Personnel> selectedPersonnelListByIds(String[] personnelIds) {

        List<Personnel> partPersonnel = personnelMapper.selectPersonnelListByIds(personnelIds);
        List<Personnel> personnels = personnelMapper.selectPersonnelAll();
        for (Personnel personnel : personnels) {
            for (Personnel partPerson : partPersonnel) {
                if (Objects.equals(personnel.getPersonnelId(), partPerson.getPersonnelId())) {
                    personnel.setFlag(true);
                    break;
                }
            }
        }
        return personnels;
    }
}
