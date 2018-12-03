package com.cx.util;

import java.text.DecimalFormat;

/**
 * 数学工具类
 */
public class MathUtil {
    public static String formatDouble4(double d) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(d);
    }
}
