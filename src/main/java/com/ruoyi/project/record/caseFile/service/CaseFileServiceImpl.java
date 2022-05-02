package com.ruoyi.project.record.caseFile.service;


import com.ruoyi.common.constant.Constants;
import com.ruoyi.framework.enumerate.DocxFileName;
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
import com.ruoyi.project.tool.gen.domain.GenTable;
import com.ruoyi.project.tool.gen.util.VelocityInitializer;
import com.ruoyi.project.tool.gen.util.VelocityUtils;
import org.apache.commons.io.IOUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

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

//
//    /**
//     * 批量生成代码（下载方式）
//     *
//     * @param tableNames 表数组
//     * @return 数据
//     */
//    @Override
//    public byte[] downloadCode(String[] tableNames) {
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        ZipOutputStream zip = new ZipOutputStream(outputStream);
//        for (String tableName : tableNames) {
//            generatorCode(tableName, zip);
//        }
//        IOUtils.closeQuietly(zip);
//        return outputStream.toByteArray();
//    }
//
//    /**
//     * 查询表信息并生成
//     */
//    private void generatorCode(Integer caseId, ZipOutputStream zip) {
//        // 查询表信息
//        CaseFile caseFile = caseFileMapper.selectRecordById(caseId);
//        // 获取模板列表
//        for (int i = 0; i < DocxFileName.values().length; i++) {
//            // 渲染模板
//            try {
//                // 添加到zip
//                zip.putNextEntry(new ZipEntry(getAbsoluteFile(DocxFileName.getName(i+1))));
//                IOUtils.write(sw.toString(), zip, Constants.UTF8);
//                IOUtils.closeQuietly(sw);
//                zip.flush();
//                zip.closeEntry();
//            } catch (IOException e) {
//                log.error("渲染模板失败，表名：" + DocxFileName.getName(i+1), e);
//            }
//        }
//    }


}
