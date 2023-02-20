package com.ruoyi.project.record.lgtrans.LtCaseFile.service;

import com.ruoyi.project.record.lgtrans.LtCaseFile.domain.LtCaseFile;
import com.ruoyi.project.record.lgtrans.LtCaseFile.mapper.LtCaseFileMapper;
import com.ruoyi.project.record.lgtrans.LtCaseInfo.domain.LtCaseInfo;
import com.ruoyi.project.record.lgtrans.LtCaseInfo.service.ILtCaseInfoService;
import com.ruoyi.project.record.lgtrans.LtCompany.domain.LtCompany;
import com.ruoyi.project.record.lgtrans.LtCompany.service.ILtCompanyService;
import com.ruoyi.project.record.lgtrans.LtOverload.domain.LtOverload;
import com.ruoyi.project.record.lgtrans.LtOverload.service.ILtOverloadService;
import com.ruoyi.project.record.lgtrans.LtPerson.domain.LtPerson;
import com.ruoyi.project.record.lgtrans.LtPerson.service.ILtPersonService;
import com.ruoyi.project.record.lgtrans.LtVehicle.domain.LtVehicle;
import com.ruoyi.project.record.lgtrans.LtVehicle.service.ILtVehicleService;
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
public class LtCaseFileServiceImpl implements ILtCaseFileService {
    private static final Logger log = LoggerFactory.getLogger(LtCaseFileServiceImpl.class);

    @Autowired
    private LtCaseFileMapper caseFileMapper;
    @Autowired
    private ILtCaseInfoService caseInfoService;
    @Autowired
    private ILtPersonService personService;
    @Autowired
    private ILtVehicleService vehicleService;
    @Autowired
    private ILtCompanyService companyService;
    @Autowired
    private ILtOverloadService overloadService;


    @Override
    @Transactional
    public int insertCaseFile(LtCaseFile caseFile) {
        // 接受实体
        LtCaseInfo ltCaseInfo = caseFile.getLtCaseInfo();
        LtVehicle ltVehicle = caseFile.getLtVehicle();
        LtPerson ltPerson = caseFile.getLtPerson();
        LtCompany ltCompany = caseFile.getLtCompany();
        LtOverload ltOverload = caseFile.getLtOverload();

        if (!isAllFieldNull(ltPerson) && ltCaseInfo.getCaseObject().equals("个人")) {
            personService.insertPerson(ltPerson);
            // 1. [案件信息]关联个人Id
            ltCaseInfo.setPersonId(ltPerson.getPersonId());
        }
        if (!isAllFieldNull(ltCompany) && ltCaseInfo.getCaseObject().equals("公司")) {
            personService.insertPerson(ltPerson);
            // 2. [案件信息]关联个人（受委托人）id
            ltCaseInfo.setPersonId(ltPerson.getPersonId());
            companyService.insertCompany(ltCompany);
            // 3. [案件信息]关联个人（受委托人），公司id
            ltCaseInfo.setCompanyId(ltCompany.getCompanyId());
        }
        // 3. 插入车辆信息
        vehicleService.insertVehicle(ltVehicle);
        // 4. [案件信息]关联上车牌id
        ltCaseInfo.setVehId(ltVehicle.getVehId());
        // 5. 插入[案件信息]
        caseInfoService.insertCase(ltCaseInfo);
        // 6. [超限信息]id依赖[案件信息]id
        ltOverload.setOverloadId(ltCaseInfo.getCaseId());
        // 7. [超限信息]关联上车牌id
        ltOverload.setVehId(ltVehicle.getVehId());
        // 8. 插入[超限信息]
        int row = overloadService.insertOverload(ltOverload);
        return row;
    }

    /**
     * 修改/编辑案件信息
     *
     * @param caseFile 案件信息
     * @return 结果
     */
    @Override
    public int updateCaseFile(LtCaseFile caseFile) {
        // 接收实体
        LtCaseInfo ltCaseInfo = caseFile.getLtCaseInfo();
        LtPerson ltPerson = caseFile.getLtPerson();
        LtCompany ltCompany = caseFile.getLtCompany();
        LtVehicle ltVehicle = caseFile.getLtVehicle();
        LtOverload ltOverload = caseFile.getLtOverload();
        int personId = personService.updatePerson(ltPerson);
        if (!isAllFieldNull(ltCompany) && ltCaseInfo.getCaseObject().equals("公司")) {
            int companyId = companyService.updateCompany(ltCompany);
            ltCaseInfo.setCompanyId(companyId);
        }
        int vehicleId = vehicleService.updateVehicle(ltVehicle);
        ltCaseInfo.setPersonId(personId);
        ltCaseInfo.setVehId(vehicleId);
        ltOverload.setVehId(vehicleId);
        // 超限信息中绑定了vehId，更新车辆信息后再更新超限信息！
        overloadService.updateOverload(ltOverload);
        // 案件信息中绑定了personId, comanyId和vehId，一定要最后更新！
        return caseInfoService.updateCaseInfo(ltCaseInfo);
    }

    /**
     * 根据条件分页查询笔录列表
     *
     * @param
     * @return 案件信息集合信息
     */
    @Override
    public List<LtCaseInfo> selectRecordList() {
        return caseFileMapper.selectRecordList();
    }

    /**
     * 通过案件ID查询笔录
     *
     * @param caseId 用户ID
     * @return 用户对象信息
     */
    @Override
    public LtCaseFile selectRecordById(Integer caseId) {
        return caseFileMapper.selectRecordById(caseId);
    }

}
