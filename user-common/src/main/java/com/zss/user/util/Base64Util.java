package com.zss.user.util;

import org.apache.commons.codec.binary.Base64;

import com.zss.user.constants.UserRespEnum;
import com.zss.user.exception.UserException;

/**
 * Base64工具类
 * @author zhuss
 * 2016年9月29日下午2:36:00
 */
public class Base64Util {

	/**
	 * 加密
	 * @param bytes
	 * @return
	 */
	public static String encrypt(byte[] bytes) {
		byte[] arr = Base64.encodeBase64(bytes, true);
		if(null == arr)
			throw new UserException(UserRespEnum.DATA_ENCRYPT_ERROR);
		return new String(arr);
	}


	/**
	 * 解密
	 * @param encryptString
	 * @return
	 */
	public static byte[] decrypt(String encryptString) {
		byte[] arr = Base64.decodeBase64(encryptString.getBytes());
		if(null == arr)
			throw new UserException(UserRespEnum.DATA_DECRYPT_ERROR);
		return arr;
	}
}