package com.pt.core.utils;

import java.security.Key;

import javax.crypto.Cipher;

/**
 * 加密解密工具类
 * 
 * @author kuangxf
 * 
 */
public class EncryptUtils {

	/**
	 * 将byte数组转换为表示16进制值的字符串， 如：byte[]{8,18}转换为：0813， 和public static byte[]
	 * hexStr2ByteArr(String strIn) 互为可逆的转换过程
	 * 
	 * @param arrB
	 *            需要转换的byte数组
	 * @return 转换后的字符串
	 * @throws Exception
	 *             本方法不处理任何异常，所有异常全部抛出
	 */
	public static String byteArr2HexStr(byte[] arrB) throws Exception {
		int iLen = arrB.length;
		// 每个byte用两个字符才能表示，所以字符串的长度是数组长度的两倍
		StringBuffer sb = new StringBuffer(iLen * 2);
		for (int i = 0; i < iLen; i++) {
			int intTmp = arrB[i];
			// 把负数转换为正数
			while (intTmp < 0) {
				intTmp = intTmp + 256;
			}
			// 小于0F的数需要在前面补0
			if (intTmp < 16) {
				sb.append("0");
			}
			sb.append(Integer.toString(intTmp, 16));
		}
		return sb.toString();
	}

	/**
	 * 将表示16进制值的字符串转换为byte数组， 和public static String byteArr2HexStr(byte[] arrB)
	 * 互为可逆的转换过程
	 * 
	 * @param strIn
	 *            需要转换的字符串
	 * @return 转换后的byte数组
	 * @throws Exception
	 *             本方法不处理任何异常，所有异常全部抛出
	 */
	public static byte[] hexStr2ByteArr(String strIn) throws Exception {
		byte[] arrB = strIn.getBytes();
		int iLen = arrB.length;

		// 两个字符表示一个字节，所以字节数组长度是字符串长度除以2
		byte[] arrOut = new byte[iLen / 2];
		for (int i = 0; i < iLen; i = i + 2) {
			String strTmp = new String(arrB, i, 2);
			arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
		}
		return arrOut;
	}

	/**
	 * 从指定字符串生成密钥，密钥所需的字节数组长度为8位 不足8位时后面补0，超出8位只取前8位
	 * 
	 * @param arrBTmp
	 *            构成该字符串的字节数组
	 * @return 生成的密钥
	 * @throws java.lang.Exception
	 */
	private static Key getKey(String keyStr) throws Exception {
		byte[] arrBTmp = keyStr.getBytes();
		// 创建一个空的8位字节数组（默认值为0）
		byte[] arrB = new byte[8];

		// 将原始字节数组转换为8位
		for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
			arrB[i] = arrBTmp[i];
		}

		// 生成密钥
		Key key = new javax.crypto.spec.SecretKeySpec(arrB, "DES");

		return key;
	}

	/**
	 * 加密数据
	 * 
	 * @param data 被加密的数据
	 * @param strKey 密钥
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String data, String strKey) throws Exception {
		Key key = getKey(strKey);
		Cipher encryptCipher = null;
		encryptCipher = Cipher.getInstance("DES");
		encryptCipher.init(Cipher.ENCRYPT_MODE, key);
		return byteArr2HexStr(encryptCipher.doFinal(data.getBytes()));
	}

	/**
	 * 解密数据
	 * 
	 * @param data 已经加密的数据
	 * @param strKey 密钥
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String data, String strKey) throws Exception {
		Key key = getKey(strKey);
		Cipher decryptCipher = Cipher.getInstance("DES");
		decryptCipher.init(Cipher.DECRYPT_MODE, key);
		return new String(decryptCipher.doFinal(hexStr2ByteArr(data)));
	}

	public static void main(String[] args) throws Exception {
		String encrypt = EncryptUtils.encrypt("提供密钥规范和算法参数规范的类和接口", "123456");
		System.out.println(encrypt);
		String decrypt = EncryptUtils.decrypt(encrypt, "123456");
		System.out.println(decrypt);
	}
}
