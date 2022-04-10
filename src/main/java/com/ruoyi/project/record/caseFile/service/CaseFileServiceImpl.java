package com.ruoyi.project.record.caseFile.service;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.framework.aspectj.lang.annotation.DataScope;
import com.ruoyi.project.record.caseFile.domain.CaseFile;
import com.ruoyi.project.record.company.domain.Company;
import com.ruoyi.project.record.company.mapper.CompanyMapper;
import com.ruoyi.project.record.caseInfo.domain.CaseInfo;
import com.ruoyi.project.record.overload.domain.Overload;
import com.ruoyi.project.record.overload.mapper.OverloadMapper;
import com.ruoyi.project.record.person.domain.Person;
import com.ruoyi.project.record.person.mapper.PersonMapper;
import com.ruoyi.project.record.vehicle.domain.Vehicle;
import com.ruoyi.project.record.caseFile.mapper.CaseFileMapper;
import com.ruoyi.project.record.caseInfo.mapper.CaseInfoMapper;
import com.ruoyi.project.record.vehicle.mapper.VehicleMapper;
import com.ruoyi.project.system.user.domain.User;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.ruoyi.common.utils.StringUtils.isAllFieldNull;

/**
 * @Author: 庞沛东
 * @Description:
 * @Date: create in 2022/4/1 13:02
 */

@Service
public class CaseFileServiceImpl implements ICaseFileService {
    private static final Logger log = LoggerFactory.getLogger(CaseFileServiceImpl.class);

    @Autowired
    private CaseFileMapper caseFileMapper;

    @Autowired
    private CaseInfoMapper caseInfoMapper;

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private VehicleMapper vehicleMapper;

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private OverloadMapper overloadMapper;

    @Override
    @Transactional
    public int insertCaseFile(CaseFile caseFile) {
        // 接受实体
        CaseInfo caseInfo = caseFile.getCaseInfo();
        Vehicle vehicle = caseFile.getVehicle();
        Person person = caseFile.getPerson();
        Company company = caseFile.getCompany();
        Overload overload = caseFile.getOverload();
        // 获取车牌号
        String vehPlate = vehicle.getVehPlateNum();
        //【案件， 超限信息】注入车牌号
        caseInfo.setVehPlateNum(vehPlate);
        overload.setVehPlateNum(vehPlate);
        if (!isAllFieldNull(person) && caseInfo.getCaseObject().equals("个人")) {
            personMapper.insertPerson(person);
            // 案件信息关联个人Id
            caseInfo.setPersonId(person.getPersonId());
        }
        if (!isAllFieldNull(company) && caseInfo.getCaseObject().equals("公司")) {
            companyMapper.insertCompany(company);
            // 案件信息关联公司id
            caseInfo.setCompanyId(company.getCompanyId());
        }
        // 插入案件信息
        caseInfoMapper.insertCase(caseInfo);
        // 案件id关联到超限信息
        overload.setOverloadId(caseInfo.getCaseId());
        // 插入车辆信息
        vehicleMapper.insertVehicle(vehicle);
        // 插入超限信息
        int row = overloadMapper.insertOverload(overload);
        return row;
    }

    /**
     * 根据条件分页查询笔录列表
     *
     * @param caseInfo 案件信息
     * @return 案件信息集合信息
     */
    @Override
    //@DataScope(caseAlias = "a", vehicleAlias = "v", personAlias = "p", companyAlias = "c", overloadAlias = "o")
    public List<CaseInfo> selectRecordList() {
        return caseFileMapper.selectRecordList();

    }


}
