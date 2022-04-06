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
        caseInfoMapper.insertCase(caseInfo);
        if (!isAllFieldNull(person) && caseInfo.getCaseObject().equals("个人")) {
            personMapper.insertPerson(person);
        }
        if (!isAllFieldNull(company) && caseInfo.getCaseObject().equals("公司")) {
            companyMapper.insertCompany(company);
        }
        vehicleMapper.insertVehicle(vehicle);
        overloadMapper.insertOverload(overload);
        return 1;
    }

    /**
     * 根据条件分页查询笔录列表
     *
     * @param caseInfo 案件信息
     * @return 案件信息集合信息
     */
    @Override
    @DataScope(caseAlias = "a", vehicleAlias = "v", personAlias = "p", companyAlias = "c", overloadAlias = "o")
    public List<CaseFile> selectRecordList(CaseInfo caseInfo) {
        // 生成数据权限过滤条件
        return caseFileMapper.selectRecordList(caseInfo);
    }


}
