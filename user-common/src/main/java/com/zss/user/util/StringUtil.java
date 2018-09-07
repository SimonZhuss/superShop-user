package com.zss.user.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import java.lang.reflect.Type;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class StringUtil {
	private static final String BLANK_REGEX = "\t|\r|\n|";
	private static final String BLANK_REGEX_SPACE = "\t|\r|\n|\\s|";

	/**
	 * @param bean
	 */

	public static String bean2json(Object bean) {
		return JSONObject.toJSONString(bean);
	}
    
	public static String bean2jsonByDCRD(Object bean) {//禁止循环引用检测
		return JSONObject.toJSONString(bean,SerializerFeature.DisableCircularReferenceDetect);
		//return gsonForBean.toJson(bean);
	}
    
	public static String bean2jsonString(Object bean){
		return JSONObject.toJSONString(bean);
	}
	public static Object fromJson(String jsonString, Class<?> calss) {
		return JSONObject.parseObject(jsonString,calss);
		//return gsonForBean.fromJson(jsonString, calss);
	}

	public static String replaceStr(String str,int start,int end,String rChar){
		String repStr = str.substring(start,end);
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<repStr.length();i++){
			sb.append(rChar);
		}
		return str.replace(repStr,sb.toString());
	}
	/**
	 * 随机生成n位数字字母组合的str字符
	 *
	 * @return type=1 数字字母组合。 type=2 数字only.
	 */
	public static String generateRandomString(int n, int type) {
		int length = n;
		if (length < 1)
			throw new IllegalArgumentException();

		char[] randomChar = new char[length];
		int index = 0;

		while (index < length) {
			double rand = Math.random() * 74;
			int num = (int) (rand + '0');

			if (type == 1) {
				if (num >= 48 && num <= 57 || num >= 65 && num <= 90 || num >= 97 && num <= 122) // /ascii
																									// things.
				{
					randomChar[index] = (char) num;
					index++;
				}
			} else if (type == 2) {
				if (num >= 48 && num <= 57) // /numbers.
				{
					randomChar[index] = (char) num;
					index++;
				}
			} else {
				return "";
			}

		}
		return new String(randomChar).toLowerCase();
	}
	
	/**
	 * 去除起始空格以及换行符
	 * @param str
	 * @return
	 */
	public static String replaceBlank(String str) {
		String dest = null;
		if (str!=null) {
			Pattern p = Pattern.compile(BLANK_REGEX);
			Matcher m = p.matcher(str);
			dest = m.replaceAll("").trim();
		}
		return dest;
	}
	/**
	 * 去除起始空格以及换行符 空格
	 * @param str
	 * @return
	 */
	public static String replaceBlankS(String str) {
		String dest = null;
		if (str!=null) {
			Pattern p = Pattern.compile(BLANK_REGEX_SPACE);
			Matcher m = p.matcher(str);
			dest = m.replaceAll("").trim();
		}
		return dest;
	}
}
