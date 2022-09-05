package com.ruoyi.common.utils;

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
     * @return String类型
     */
    public static String formatDecimal(double value) {
        final DecimalFormat formatter = new DecimalFormat();
        formatter.setMaximumFractionDigits(2);
        formatter.setGroupingSize(0);

        formatter.setRoundingMode(RoundingMode.FLOOR);
        return formatter.format(value);
    }
}
