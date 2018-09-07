package com.zss.user.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * BigDecimal工具类
 *
 */
public class DecimalUtil {
	/**数值为0的BigDecimal*/
	public static final BigDecimal ZERO = new BigDecimal(0);
	
	public static final BigDecimal HUNDRED = new BigDecimal(100);
	
	public static Double doubleFloorValue(BigDecimal bd){
		if(bd == null) return 0d;
		DecimalFormat formater = new DecimalFormat("0.00");
        formater.setGroupingSize(0);
        formater.setMaximumFractionDigits(2);
        formater.setRoundingMode(RoundingMode.FLOOR);
        return Double.valueOf(formater.format(bd.doubleValue()));
	}
	
	public static String doubleFloorString(BigDecimal bd){
		if(bd == null) return "0.00";
        DecimalFormat formater = new DecimalFormat("0.00");
        formater.setGroupingSize(0);
        formater.setMaximumFractionDigits(2);
        formater.setRoundingMode(RoundingMode.FLOOR);
        return formater.format(bd.doubleValue());
	}
	
	public static BigDecimal mutiply(BigDecimal bd1, BigDecimal bd2){
		if(bd1 == null) bd1 = ZERO;
		if(bd2 == null) bd2 = ZERO;
		return bd1.multiply(bd2);
	}
	
	public static BigDecimal mutiply100(BigDecimal bd1){
		return bd1.multiply(HUNDRED);
	}
	
	public static BigDecimal Str2Decimal(String num){
		if(num == null) return null;
		return new BigDecimal(num);
	}

	/**
	 * 空返回0
	 * @param num
	 * @return
	 */
	public static BigDecimal Str2DecimalNull2Zero(String num){
		if(num == null) return ZERO;
		return new BigDecimal(num);
	}
}
