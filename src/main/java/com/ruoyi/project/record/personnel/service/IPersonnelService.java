package com.ruoyi.project.record.personnel.service;

import com.ruoyi.project.record.personnel.domain.Personnel;

import java.util.List;

/**
 * @Author: 庞沛东
 * @Description:
 * @Date: create in 2022/8/30 13:48
 */

public interface IPersonnelService {

    /**
     * 通过id查询ZF人员
     * @param personnelId
     * @return
     */
    public Personnel selectPersonnelById(Integer personnelId);

    /**
     * 查询所有ZF人员
     *
     * @return
     */
    public List<Personnel> selectPersonnelAll();


    /**
     * 根据ids批量查询ZF人员信息,标记已选中的ZF人员
     * @return
     */
    public List<Personnel> selectedPersonnelListByIds(String[] personnelIds);

    /**
     * 根据ids批量查询ZF人员信息
     * @return
     */
    public List<Personnel> selectPersonnelListByIds(String[] personnelIds);
}
