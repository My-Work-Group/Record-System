package com.ruoyi.project.record.offsite.caseFile.util;

import com.ruoyi.project.record.offsite.caseFile.domain.CaseFile;

import static com.ruoyi.common.utils.StringUtils.isFieldNull;

public class CaseFileUtils {

    /**
     * 判断填入的案件信息内容是否完整
     */
    public static boolean isCaseFileComplete(CaseFile caseFile) {
        if (isFieldNull(caseFile.getCaseInfo()) || isFieldNull(caseFile.getPerson()) ||
                isFieldNull(caseFile.getCompany()) || isFieldNull(caseFile.getVehicle()) ||
                isFieldNull(caseFile.getOverload())) {
            return true;
        }
        return false;
    }
}