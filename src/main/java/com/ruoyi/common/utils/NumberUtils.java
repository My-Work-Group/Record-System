package com.ruoyi.common.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @Author: 庞沛东
 * @Description: 对数字进行格式化处理
 * @Date: create in 2022/9/5 14:37
 */

public class NumberUtils {

    /***
     * 不四舍五入保留小数点后两位的方法
     * @param value  double类型
     * @return String类型，这里必须要用String类型接受返回值，如果是double，58.00则又变成58.0；
     */
    public static String formatDecimalTo2(double value) {
        DecimalFormat decimal = new DecimalFormat("0.00");
        decimal.setRoundingMode(RoundingMode.DOWN);
        return decimal.format(value);
    }

    /**
     * 提供精确的乘法运算
     *
     * @param a
     * @param b
     * @return
     */
    public static double multiplication(double a, double b) {
        BigDecimal a2 = new BigDecimal(Double.toString(a));
        BigDecimal b2 = new BigDecimal(Double.toString(b));
        return a2.multiply(b2).doubleValue();
    }

    /**
     * 提供精确的加法运算
     *
     * @param a 被加数
     * @param b 加数
     * @return 两个参数的和
     */
    public static double addition(double a, double b) {
        BigDecimal b1 = new BigDecimal(Double.toString(a));
        BigDecimal b2 = new BigDecimal(Double.toString(b));
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精确的减法运算
     *
     * @param a 被减数
     * @param b 减数
     * @return 两个参数的差
     */
    public static double subtraction(double a, double b) {
        BigDecimal b1 = new BigDecimal(Double.toString(a));
        BigDecimal b2 = new BigDecimal(Double.toString(b));
        return b1.subtract(b2).doubleValue();
    }
}
