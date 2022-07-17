package com.ruoyi.project.record.offsite.caseFile.service;

import com.ruoyi.project.record.offsite.caseFile.domain.CaseFile;
import com.ruoyi.project.record.offsite.company.domain.Company;
import com.ruoyi.project.record.offsite.company.mapper.CompanyMapper;
import com.ruoyi.project.record.offsite.caseInfo.domain.CaseInfo;
import com.ruoyi.project.record.offsite.overload.domain.Overload;
import com.ruoyi.project.record.offsite.overload.mapper.OverloadMapper;
import com.ruoyi.project.record.offsite.person.domain.Person;
import com.ruoyi.project.record.offsite.person.mapper.PersonMapper;
import com.ruoyi.project.record.offsite.vehicle.domain.Vehicle;
import com.ruoyi.project.record.offsite.caseFile.mapper.CaseFileMapper;
import com.ruoyi.project.record.offsite.caseInfo.mapper.CaseInfoMapper;
import com.ruoyi.project.record.offsite.vehicle.mapper.VehicleMapper;
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
//        // 获取车牌号
//        String vehPlate = vehicle.getVehPlateNum();
//        //【案件，超限信息】注入车牌号
//        caseInfo.setVehPlateNum(vehPlate);
//        overload.setVehPlateNum(vehPlate);

        if (!isAllFieldNull(person) && caseInfo.getCaseObject().equals("个人")) {
            personMapper.insertPerson(person);
            // 1. [案件信息]关联个人Id
            caseInfo.setPersonId(person.getPersonId());
        }
        if (!isAllFieldNull(company) && caseInfo.getCaseObject().equals("公司")) {
            personMapper.insertPerson(person);
            System.out.println(person.getPersonId());
            // 2. [案件信息]关联个人（受委托人）id
            caseInfo.setPersonId(person.getPersonId());
            companyMapper.insertCompany(company);
            System.out.println(company.getCompanyId());
            // 3. [案件信息]关联个人（受委托人），公司id
            caseInfo.setCompanyId(company.getCompanyId());
        }
        // 3. 插入车辆信息
        vehicleMapper.insertVehicle(vehicle);
        System.out.println(vehicle.getVehId());
        // 4. [案件信息]关联上车牌id
        caseInfo.setVehId(vehicle.getVehId());
        // 5. 插入[案件信息]
        caseInfoMapper.insertCase(caseInfo);
        // 6. [超限信息]id依赖[案件信息]id
        overload.setOverloadId(caseInfo.getCaseId());
        // 7. [超限信息]关联上车牌id
        overload.setVehId(vehicle.getVehId());
        // 8. 插入[超限信息]
        int row = overloadMapper.insertOverload(overload);
        return row;
    }

    /**
     * 修改案件信息
     *
     * @param caseFile 案件信息
     * @return 结果
     */
    @Override
    //@Transactional
    public int updateCaseFile(CaseFile caseFile) {
        // 接收实体
        CaseInfo caseInfo = caseFile.getCaseInfo();

        Person person = caseFile.getPerson();
        Company company = caseFile.getCompany();
        Vehicle vehicle = caseFile.getVehicle();

        Overload overload = caseFile.getOverload();

//        // 校验案件编号是否存在
//        if ("1".equals(caseInfoService.checkCaseNumUnique(caseInfo.getCaseNumber()))) {
//            return error("该案件编号已存在！");
//        }

        // 执行更新
        int row = caseInfoMapper.updateCaseInfo(caseInfo);
        personMapper.updatePerson(person);
        companyMapper.updateCompany(company);
        vehicleMapper.updateVehicle(vehicle);
        overloadMapper.updateOverload(overload);
        return row;
    }

    /**
     * 根据条件分页查询笔录列表
     *
     * @param
     * @return 案件信息集合信息
     */
    @Override
    public List<CaseInfo> selectRecordList() {
        return caseFileMapper.selectRecordList();
    }

    /**
     * 通过案件ID查询笔录
     *
     * @param caseId 用户ID
     * @return 用户对象信息
     */
    @Override
    public CaseFile selectRecordById(Integer caseId) {
        return caseFileMapper.selectRecordById(caseId);
    }

}
