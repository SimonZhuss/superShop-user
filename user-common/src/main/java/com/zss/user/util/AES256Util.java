package com.zss.user.util;


import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zss.user.constants.UserRespEnum;
import com.zss.user.exception.UserException;


/**
 * AES加密工具类
 * @author zhuss
 * 2016年9月29日下午2:29:35
 */
public class AES256Util {

private static Logger logger = LoggerFactory.getLogger(AES256Util.class);

	
	/**
	 * 密钥算法 java6支持56位密钥，bouncycastle支持64位
	 * */
	public static final String KEY_ALGORITHM = "AES";

	/**
	 * 加密/解密算法/工作模式/填充方式
	 * 
	 * JAVA6 支持PKCS5PADDING填充方式 Bouncy castle支持PKCS7Padding填充方式
	 * */
	public static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

	public static final String SECRET_KEY = "1234567890123456";
	
	/**
     * 加密
     * @param content 需要加密的内容
     * @param password  加密密码
     * @return
	 * @throws UserException 
	 * @throws Exception 
     */
	public static byte[] encrypt(String content,String secretKey){
		try {
		  /*KeyGenerator kgen = KeyGenerator.getInstance(KEY_ALGORITHM);
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(SECRET_KEY.getBytes());
			kgen.init(128, secureRandom);
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();*/
			SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(), KEY_ALGORITHM);
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);// 创建密码器
			byte[] byteContent = content.getBytes("utf-8");
			cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(byteContent);
			return result; // 加密
		} catch (Exception e) {
			logger.error("[AES加密 error] = {}",e.getMessage());
			throw new UserException(UserRespEnum.DATA_ENCRYPT_ERROR);
		}
	}
	
	/**
	 * AES加密后用Base64进行二次加密
	 * @param str
	 * @return
	 * @throws UserException 
	 * @throws Exception 
	 */
	public static String encryptBase64(String str,String key){
		byte[] data; // 加密数据
		try {
			data = encrypt(str,key);
			return Base64Util.encrypt(data).trim();
		} catch (UserException e) {
			logger.debug("[Base64加密 AES密文 error] = {}" ,e.getMessage());
			throw new UserException(e.getCode(),e.getMsg());
		}
	}
	
	/**
	 * AES加密后用Base64进行二次加密
	 * @param str
	 * @return
	 * @throws UserException 
	 * @throws Exception 
	 */
	public static String encrypt16(String str,String key){
		byte[] data; // 加密数据
		try {
			data = encrypt(str,key);
			return parseByte2HexStr(data);
		} catch (UserException e) {
			logger.debug("[AES密文转16进制 error] = {}" ,e.getMessage());
			throw new UserException(e.getCode(),e.getMsg());
		}
	}
    
    /**解密
     * @param content  待解密内容
     * @return
     * @throws UserException 
     * @throws Exception 
     */
	public static byte[] decrypt(byte[] content,String secretKey){
		try {
			/*KeyGenerator kgen = KeyGenerator.getInstance(KEY_ALGORITHM);
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(SECRET_KEY.getBytes());
			kgen.init(128, secureRandom);
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();*/
			SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(), KEY_ALGORITHM);
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);// 创建密码器
			cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(content);
			return result; 
		} catch (Exception e) {
			logger.error("[AES解密 error ]= {}" ,e.getMessage());
			throw new UserException(UserRespEnum.DATA_DECRYPT_ERROR);
		}
	}
	
	/**
	 *  解密数据
	 * @param value：base加密后的数据
	 * @return
	 * @throws UserException 
	 * @throws Exception 
	 */
	public static String decryptBase64(String value,String secretKey){
		byte[] base64Data; // base64解密数据
		byte[] aes256Data; // base64解密数据
		try {
			base64Data = Base64Util.decrypt(value);//base64解密 base64数据
			aes256Data = decrypt(base64Data,secretKey);
			return new String(aes256Data);
		} catch (UserException e) {
			logger.error("[Base64解密 AES密文 error] ={} ",e.getMessage());
			throw new UserException(e.getCode(),e.getMessage());
		}
	}
	
	/**
	 *  解密数据
	 * @param value：base加密后的数据
	 * @return
	 * @throws UserException 
	 * @throws Exception 
	 */
	public static String decrypt16(String value,String secretKey){
		byte[] hex2Data; 
		byte[] aes128Data; 
		try {
			hex2Data = parseHexStr2Byte(value);
			aes128Data = decrypt(hex2Data,secretKey);
			return new String(aes128Data);
		} catch (UserException e) {
			logger.error("[十六进制转换 AES密文 error] ={} ",e.getMessage());
			throw new UserException(e.getCode(),e.getMessage());
		}
	}
	
	private static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    private static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length()/2];
        for (int i = 0;i< hexStr.length()/2; i++) {
            int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
            int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }
}
