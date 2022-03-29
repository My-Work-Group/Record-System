package com.ruoyi.project.record.offsite.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ruoyi.common.xss.Xss;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.aspectj.lang.annotation.Excel.ColumnType;
import com.ruoyi.framework.aspectj.lang.annotation.Excel.Type;
import com.ruoyi.framework.aspectj.lang.annotation.Excels;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.project.system.dept.domain.Dept;
import com.ruoyi.project.system.role.domain.Role;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * 用户对象 sys_user
 *
 * @author ruoyi
 */
public class File extends BaseEntity {
    private static final long serialVersionUID = 1L;
    // 案卷编号
    @Excel(name = "案卷编号", cellType = ColumnType.NUMERIC, prompt = "案卷编号")
    private Long fileId;
    // 受案时间
    @Excel(name = "受案时间", type = Type.IMPORT)
    private String time;
    // 罚款金额
    private Long fine;

    // 车牌号
    private String plateNum;
    // 轴数
    @Excel(name = "轴数")
    private String axleNum;
    //车货总重
    @Excel(name = "车货总重")
    private String totalWeight;
    // 检测时间
    private String checkTime;
    // 检测站点
    @Excel(name = "检测站点")
    private String siteCode;
    //超限吨位
    private String overLoad;
    // 超限比例
    private String overRate;
    //	装载的货物
    private String goods;
    //	装载时间
    private String loadingTime;
    //	装载地点
    private String loadAdd;
    //	运往目的地
    private String destination;



}
