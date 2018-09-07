package com.zss.user.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Double工具类
 *
 */
public class DoubleUtil {

	public static Double doubleFloorValue(Double bd) {
		if (bd == null) return 0d;
		DecimalFormat formater = new DecimalFormat("0.00");
		formater.setGroupingSize(0);
		formater.setMaximumFractionDigits(2);
		formater.setRoundingMode(RoundingMode.FLOOR);
		return Double.valueOf(formater.format(bd));
	}

	public static String doubleFloorString(Double bd) {
		if (bd == null) return "0.00";
		DecimalFormat formater = new DecimalFormat("0.00");
		formater.setGroupingSize(0);
		formater.setMaximumFractionDigits(2);
		formater.setRoundingMode(RoundingMode.FLOOR);
		return formater.format(bd);
	}
}
