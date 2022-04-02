package com.ruoyi.project.record.caseFile.service;

import com.ruoyi.project.record.caseFile.domain.CaseFile;
import com.ruoyi.project.record.company.domain.Company;
import com.ruoyi.project.record.company.mapper.CompanyMapper;
import com.ruoyi.project.record.offsite.domain.OffSiteCase;
import com.ruoyi.project.record.overload.domain.Overload;
import com.ruoyi.project.record.person.domain.Person;
import com.ruoyi.project.record.person.mapper.PersonMapper;
import com.ruoyi.project.record.vehicle.domain.Vehicle;
import com.ruoyi.project.record.caseFile.mapper.CaseFileMapper;
import com.ruoyi.project.record.offsite.mapper.OffSiteCaseMapper;
import com.ruoyi.project.record.vehicle.mapper.VehicleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private OffSiteCaseMapper offSiteCaseMapper;

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private VehicleMapper vehicleMapper;

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    @Transactional
    public int insertCaseFile(CaseFile caseFile) {

        // 接受实体
        OffSiteCase offSiteCase = caseFile.getOffSiteCase();
        Vehicle vehicle = caseFile.getVehicle();
        Person person = caseFile.getPerson();
        Company company = caseFile.getCompany();
        Overload overload = caseFile.getOverload();
        // 获取车牌号
        String vehPlate = vehicle.getVehPlateNum();

        //【案件， 超限信息】注入车牌号
        offSiteCase.setVehPlateNum(vehPlate);
        overload.setVehPlateNum(vehPlate);

        offSiteCaseMapper.insertCase(offSiteCase);
        companyMapper.insertCompany(company);
        personMapper.insertPerson(person);
        vehicleMapper.insertVehicle(vehicle);
        return 1 ;
    }
}
