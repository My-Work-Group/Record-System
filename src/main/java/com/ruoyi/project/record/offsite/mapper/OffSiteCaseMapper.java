package com.ruoyi.project.record.offsite.mapper;

import com.ruoyi.project.record.offsite.domain.OffSiteCase;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 庞沛东
 * @Description: 定义  接口层
 * @Date: create in 2022/3/30 12:09
 */
public interface OffSiteCaseMapper {


    /**
     * 保存案件信息
     *
     * @param offSiteCase 案件信息
     * @return 结果
     */
    public  int insertCase(@Param("offSiteCase") OffSiteCase offSiteCase);



}

