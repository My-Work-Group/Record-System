package com.ruoyi.project.record.caseFile.service;

import com.ruoyi.project.record.caseFile.domain.CaseFile;
import com.ruoyi.project.record.offsite.domain.OffSiteCase;
import com.ruoyi.project.record.vehicle.domain.Vehicle;
import com.ruoyi.project.record.caseFile.mapper.CaseFileMapper;
import com.ruoyi.project.record.offsite.mapper.OffSiteCaseMapper;
import com.ruoyi.project.record.vehicle.mapper.VehicleMapper;
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


    @Autowired
    private CaseFileMapper caseFileMapper;

    @Autowired
    private OffSiteCaseMapper offSiteCaseMapper;

    @Autowired
    private VehicleMapper vehicleMapper;

    @Override
    @Transactional
    public int insertCaseFile(CaseFile caseFile) {
        OffSiteCase offSiteCase = caseFile.getOffSiteCase();
        Vehicle vehicle = caseFile.getVehicle();
        offSiteCaseMapper.insertCase(offSiteCase);
        int row = vehicleMapper.insertVehicle(vehicle);
        return row ;
    }
}
