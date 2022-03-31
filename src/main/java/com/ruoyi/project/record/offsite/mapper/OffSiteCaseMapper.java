package com.ruoyi.project.record.offsite.mapper;

import com.ruoyi.project.record.offsite.domain.OffSiteCase;

import java.util.List;

/**
 * @Author: 庞沛东
 * @Description: 定义  接口层
 * @Date: create in 2022/3/30 12:09
 */
public interface OffSiteCaseMapper {
    /**
     * 根据条件分页查询案件信息
     *
     * @param offSiteCase 案件信息
     * @return 用户信息集合信息
     */
    public List<OffSiteCase> selectCaseList(OffSiteCase offSiteCase);


    /**
     * 保存案件信息
     *
     * @param offSiteCase 案件信息
     * @return 结果
     */
    public  int insertCase(OffSiteCase offSiteCase);


    /**
     * 修改后，保存用户信息
     *
     * @param offSiteCase 保存案件信息
     * @return 结果
     */
    public int updateCase(OffSiteCase offSiteCase);

    /**
     * 修改用户详细信息
     *
     * @param offSiteCase 用户信息
     * @return 结果
     */
    public int updateCaseInfo(OffSiteCase offSiteCase);
}

