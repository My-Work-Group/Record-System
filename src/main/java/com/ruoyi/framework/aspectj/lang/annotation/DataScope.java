package com.ruoyi.framework.aspectj.lang.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据权限过滤注解
 *
 * @author ruoyi
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataScope {
    /**
     * 部门表的别名
     */
    public String deptAlias() default "";

    /**
     * 用户表的别名
     */
    public String userAlias() default "";

    /**
     * 案件表的别名
     */
    public String caseAlias() default "";

    /**
     * 个人信息表的别名
     */
    public String personAlias() default "";

    /**
     * 公司表的别名
     */
    public String companyAlias() default "";

    /**
     * 车辆的别名
     */
    public String vehicleAlias() default "";

    /**
     * 超限信息的别名
     */
    public String overloadAlias() default "";


}
