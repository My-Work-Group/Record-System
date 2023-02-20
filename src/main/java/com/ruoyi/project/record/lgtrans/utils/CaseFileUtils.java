package com.ruoyi.project.record.lgtrans.utils;

import com.ruoyi.project.record.lgtrans.LtCaseFile.domain.LtCaseFile;
import com.ruoyi.project.record.lgtrans.LtCaseInfo.domain.LtCaseInfo;
import com.ruoyi.project.record.personnel.domain.Personnel;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ruoyi.common.utils.DateUtils.*;
import static com.ruoyi.common.utils.NumberUtils.formatDecimalTo2;
import static com.ruoyi.common.utils.StringUtils.isFieldNull;
import static com.ruoyi.common.utils.StringUtils.isNull;

/**
 * @Author: 庞沛东
 * @Description:
 * @Date: create in 2022/9/13 9:57
 */

public class CaseFileUtils {


    /**
     * 判断填入的案件信息内容是否完整
     */
    public static boolean isNotCaseFileComplete(LtCaseFile caseFile) {
        LtCaseInfo ltCaseInfo = caseFile.getLtCaseInfo();
        String caseObject = ltCaseInfo.getCaseObject();

        if (isFieldNull(caseFile.getLtVehicle()) || isFieldNull(caseFile.getLtOverload())) {
            if ("个人".equals(caseObject) && isFieldNull(caseFile.getLtPerson()) && isNull(ltCaseInfo.getPersonId())) {
                return true;
            }
            if ("公司".equals(caseObject) && isFieldNull(caseFile.getLtCompany()) && isNull(ltCaseInfo.getVehId())) {
                return true;
            }
            return true;
        }
        return false;
    }


}
