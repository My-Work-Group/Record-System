package com.ruoyi.project.record.offsite.service;
import com.ruoyi.project.record.offsite.domain.OffSiteCase;


import java.util.List;

/**
 * @Author: 庞沛东
 * @Description: 定义 案件的 接口层
 * @Date: create in 2022/3/30 11:58
 */
public interface ICaseService {
        /**
         * 根据条件分页查询案件信息
         *
         * @param offSiteCaseEntity 案件信息
         * @return 用户信息集合信息
         */
        public List<OffSiteCase> selectCaseList(OffSiteCase offSiteCaseEntity);


        /**
         * 保存案件信息
         *
         * @param offSiteCaseEntity 案件信息
         * @return 结果
         */
        public int insertCase(OffSiteCase offSiteCaseEntity);


        /**
         * 修改后，保存用户信息
         *
         * @param offSiteCaseEntity 保存案件信息
         * @return 结果
         */
        public int updateCase(OffSiteCase offSiteCaseEntity);

        /**
         * 修改用户详细信息
         *
         * @param offSiteCaseEntity 用户信息
         * @return 结果
         */
        public int updateCaseInfo(OffSiteCase offSiteCaseEntity);


    }


