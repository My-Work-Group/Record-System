package com.ruoyi.project.record.offsite.caseFile.util;

import com.ruoyi.project.record.offsite.caseFile.domain.CaseFile;
import com.ruoyi.project.record.offsite.caseInfo.domain.CaseInfo;

import static com.ruoyi.common.utils.StringUtils.*;

public class CaseFileUtils {

    /**
     * 判断填入的案件信息内容是否完整
     */
    public static boolean isNotCaseFileComplete(CaseFile caseFile) {
        CaseInfo caseInfo = caseFile.getCaseInfo();
        String caseObject = caseInfo.getCaseObject();
        if (isFieldNull(caseFile.getVehicle()) ||
                isFieldNull(caseFile.getOverload())) {
            if ("个人".equals(caseObject) && isFieldNull(caseFile.getPerson()) && isNull(caseInfo.getPersonId())) {
                return true;
            }
            if ("公司".equals(caseObject) && isFieldNull(caseFile.getCompany()) && isNull(caseInfo.getVehId())) {
                return true;
            }
            return true;
        }
        return false;
    }
}