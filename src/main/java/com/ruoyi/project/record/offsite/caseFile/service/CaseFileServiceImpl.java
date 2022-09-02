package com.ruoyi.project.record.offsite.caseFile.service;

import com.ruoyi.project.record.offsite.caseFile.domain.CaseFile;
import com.ruoyi.project.record.offsite.caseInfo.service.ICaseInfoService;
import com.ruoyi.project.record.offsite.company.domain.Company;
import com.ruoyi.project.record.offsite.caseInfo.domain.CaseInfo;
import com.ruoyi.project.record.offsite.company.service.ICompanyService;
import com.ruoyi.project.record.offsite.overload.domain.Overload;
import com.ruoyi.project.record.offsite.overload.service.IOverloadService;
import com.ruoyi.project.record.offsite.person.domain.Person;
import com.ruoyi.project.record.offsite.person.service.IPersonService;
import com.ruoyi.project.record.offsite.vehicle.domain.Vehicle;
import com.ruoyi.project.record.offsite.caseFile.mapper.CaseFileMapper;
import com.ruoyi.project.record.offsite.vehicle.service.IVehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

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
    private ICaseInfoService caseInfoService;
    @Autowired
    private IPersonService personService;
    @Autowired
    private IVehicleService vehicleService;
    @Autowired
    private ICompanyService companyService;
    @Autowired
    private IOverloadService overloadService;


    @Override
    @Transactional
    public int insertCaseFile(CaseFile caseFile) {
        // 接受实体
        CaseInfo caseInfo = caseFile.getCaseInfo();
        Vehicle vehicle = caseFile.getVehicle();
        Person person = caseFile.getPerson();
        Company company = caseFile.getCompany();
        Overload overload = caseFile.getOverload();

        if (!isAllFieldNull(person) && caseInfo.getCaseObject().equals("个人")) {
            personService.insertPerson(person);
            // 1. [案件信息]关联个人Id
            caseInfo.setPersonId(person.getPersonId());
        }
        if (!isAllFieldNull(company) && caseInfo.getCaseObject().equals("公司")) {
            personService.insertPerson(person);
            // 2. [案件信息]关联个人（受委托人）id
            caseInfo.setPersonId(person.getPersonId());
            companyService.insertCompany(company);
            // 3. [案件信息]关联个人（受委托人），公司id
            caseInfo.setCompanyId(company.getCompanyId());
        }
        // 3. 插入车辆信息
        vehicleService.insertVehicle(vehicle);
        // 4. [案件信息]关联上车牌id
        caseInfo.setVehId(vehicle.getVehId());
        // 5. 插入[案件信息]
        caseInfoService.insertCase(caseInfo);
        // 6. [超限信息]id依赖[案件信息]id
        overload.setOverloadId(caseInfo.getCaseId());
        // 7. [超限信息]关联上车牌id
        overload.setVehId(vehicle.getVehId());
        // 8. 插入[超限信息]
        int row = overloadService.insertOverload(overload);
        return row;
    }

    /**
     * 修改/编辑案件信息
     *
     * @param caseFile 案件信息
     * @return 结果
     */
    @Override
    public int updateCaseFile(CaseFile caseFile) {
        // 接收实体
        CaseInfo caseInfo = caseFile.getCaseInfo();
        Person person = caseFile.getPerson();
        Company company = caseFile.getCompany();
        Vehicle vehicle = caseFile.getVehicle();
        Overload overload = caseFile.getOverload();
        int personId = personService.updatePerson(person);
        if(!isAllFieldNull(company) && caseInfo.getCaseObject().equals("公司")){
            int companyId = companyService.updateCompany(company);
            caseInfo.setCompanyId(companyId);
        }
        int vehicleId = vehicleService.updateVehicle(vehicle);
        caseInfo.setPersonId(personId);
        caseInfo.setVehId(vehicleId);
        overload.setVehId(vehicleId);
        // 超限信息中绑定了vehId，更新车辆信息后再更新超限信息！
        overloadService.updateOverload(overload);
        // 案件信息中绑定了personId, comanyId和vehId，一定要最后更新！
        return caseInfoService.updateCaseInfo(caseInfo);
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
