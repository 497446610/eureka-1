
package com.pt.core.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.lang.StringUtils;

/**
 * 对象的工具类.
 * 
 * @version 1.0 2009-8-11
 * @author yzhu
 * @history
 * 
 */
public class ObjectUtil {

	public static final BigDecimal D1B = new BigDecimal(100);
	public static final BigDecimal D1K = new BigDecimal(1000);
	public static final BigDecimal D1W = new BigDecimal(10000);
	public static final BigDecimal D100W = new BigDecimal(1000000);

	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 *            字符串
	 * @return 是否为空
	 */
	public static boolean isNull(String str) {
		return (str == null || "".equals(str.trim()));
	}

	public static boolean isNotNull(String id) {
		return isNull(id) == false;
	}

	/**
	 * 将类似￥1280.00元转化为金额1280.00
	 * 
	 * @param amountStr
	 *            金额字符串
	 * @return 金额数值
	 */
	public static double getAmount(String amountStr) {
		String str = amountStr;
		if (amountStr.indexOf("￥") != -1) {
			str = amountStr.substring("￥".length());
		}
		if (str.indexOf("元") != -1) {
			str = str.substring(0, str.indexOf("元"));
		}
		try {
			return Double.parseDouble(str);
		} catch (Exception ex) {
			return 0;
		}
	}

	/**
	 * 将以元为单位的金额转化为以分为单位的金额
	 * 
	 * @param amount
	 *            以元为单位的金额
	 * @return 以分为单位的金额
	 */
	public static int moneyConvertYuan2Fen(double amount) {
		if (amount > 0)
			return (int) (amount * 100 + 0.5d);
		else
			return (int) (amount * 100 - 0.5d);
	}

	/**
	 * 将以分为单位的金额转化为以元为单位的金额
	 * 
	 * @param amount
	 *            以分为单位的金额
	 * @return 以元为单位的金额
	 */
	public static double moneyConvertFen2Yuan(Integer amount) {
		if (amount == null) {
			return 0.00d;
		}
		return (double) (amount / 100.00d);
	}

	public static int moneyConvertYuan2Fen(BigDecimal amount) {
		BigDecimal fen = amount.multiply(BigDecimal.valueOf(100));
		return fen.intValue();
	}

	/**
	 * 将模板template中所有出现$key的字串替换为substitute
	 * 
	 * @param template
	 *            模板字符串
	 * @param findStr
	 *            匹配子串
	 * @param substitute
	 *            替换子串
	 * @return 替换完成后的字符串
	 */
	public static String replaceSubString(String template, String findStr, String substitute) {
		String result = template.toString();
		while (true) {
			int index = result.indexOf(findStr);
			if (index == -1)
				break;

			result = result.substring(0, index) + substitute + result.substring(index + findStr.length());
		}

		return result;
	}

	/**
	 * 获得当前日期的格式化表示
	 * 
	 * @param formatStr
	 *            格式化字符串
	 * @return
	 */
	public static String getCurrentDateStr(String formatStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		return sdf.format(new Date());
	}

	/**
	 * 对象属性拷贝 拷贝非null的属性
	 * 
	 * @param dest
	 *            目标对象
	 * @param src
	 *            源对象
	 */
	@SuppressWarnings("rawtypes")
	public static void copyProperties(Object dest, Object src) {
		PropertyUtilsBean util = new PropertyUtilsBean();
		PropertyDescriptor[] srcProps = util.getPropertyDescriptors(src.getClass());
		for (int i = 0; i < srcProps.length; i++) {
			Method srcMethod = srcProps[i].getReadMethod();
			Object srcValue = null;
			try {
				srcValue = srcMethod.invoke(src);
			} catch (Exception ex) {
				continue;
			}
			if (srcValue == null) {
				continue;
			}
			Class type = srcProps[i].getPropertyType();
			String merthodName = "set" + srcProps[i].getName().substring(0, 1).toUpperCase()
					+ srcProps[i].getName().substring(1);
			Method destMethod = null;
			try {
				destMethod = dest.getClass().getMethod(merthodName, type);
			} catch (Exception ex) {
				continue;
			}
			if (destMethod == null) {
				continue;
			}
			try {
				destMethod.invoke(dest, srcValue);
			} catch (Exception ex) {
				continue;
			}
		}
	}

	/**
	 * 将整数转化为定长的字符串
	 * 
	 * @param value
	 *            整数
	 * @param strLength
	 *            字符串长度
	 * @return
	 */
	public static String convertInt2String(Integer value, int strLength) {
		if (value == null) {
			return null;
		}

		String result = value.toString();
		if (result.length() < strLength) {
			int count = strLength - result.length();
			for (int i = 0; i < count; i++) {
				result = "0" + result;
			}
		}

		return result;
	}

	/**
	 * 将整数转化为定长的字符串
	 * 
	 * @param value
	 *            整数
	 * @param strLength
	 *            字符串长度
	 * @return
	 */
	public static String convertInt2String(Long value, int strLength) {
		if (value == null) {
			return null;
		}

		String result = value.toString();
		if (result.length() < strLength) {
			int count = strLength - result.length();
			for (int i = 0; i < count; i++) {
				result = "0" + result;
			}
		}

		return result;
	}

	/**
	 * 转换数字型的字符串，去掉无用的"0",如：00004
	 * 
	 * @param value
	 * @return
	 */
	public static Long String2Long(String value) {
		if (value == null) {
			return null;
		}
		while (value.startsWith("0")) {
			value = value.substring(1);
		}
		return Long.valueOf(value);
	}

	/**
	 * 将二进制的字符串转化为字符串
	 * 
	 * @param hexStr
	 *            二进制的字符串
	 * @return
	 */
	public static String convertHexStr2Str(String hexStr) {
		if (isNull(hexStr)) {
			return null;
		}

		int length = hexStr.length() / 2;
		byte[] bytes = new byte[length];
		for (int i = 0; i < length; i++) {
			byte high = convertChar2Digit(hexStr.charAt(i * 2));
			byte low = convertChar2Digit(hexStr.charAt(i * 2 + 1));
			bytes[i] = (byte) ((high << 4) + low);
		}

		return new String(bytes);
	}

	/**
	 * 将数字字符转化为数字
	 * 
	 * @param value
	 * @return
	 */
	private static byte convertChar2Digit(char value) {
		if (value >= '0' && value <= '9') {
			return (byte) (value - '0');
		}

		if (value >= 'a' && value <= 'f') {
			return (byte) (10 + value - 'a');
		}

		if (value >= 'A' && value <= 'F') {
			return (byte) (10 + value - 'A');
		}

		return 0;

	}

	/**
	 * 产生随机数字符串
	 * 
	 * @param digitNumber
	 *            字符串的长度
	 * @param modeNum
	 *            模数
	 * @return
	 */
	public static String createRandomDigitStr(int digitNumber, int modeNum) {
		StringBuffer buffer = new StringBuffer();
		Random rand = new Random(System.currentTimeMillis());
		for (int i = 0; i < digitNumber; i++) {
			buffer.append(rand.nextInt(modeNum));
		}
		return buffer.toString();
	}

	/**
	 * 格式化金额 以元为单位
	 * 
	 * @param amount
	 *            金额(必须能转成Number型的)
	 * @return 30格式成30.00返回
	 */
	public static String formartNumber(Object amount) {
		BigDecimal b = new BigDecimal("" + amount);
		return String.format("%.2f", b.doubleValue());
	}

	/**
	 * 判断是否是一个有效的身份证
	 * 
	 * @param idNo
	 *            身份证号
	 * @return 如果是(true),否则(false)
	 */
	public static boolean isIdCard(String idNo) {
		if (isNull(idNo)) {
			return false;
		}
		return Pattern.matches("([0-9]{14}||[0-9]{17})[0-9a-zA-Z]", idNo);
	}

	/**
	 * 判断是否是一个有效的用户名(最长为50位)
	 * 
	 * @param name
	 *            用户名
	 * @return 如果是(true),否则(false)
	 */
	public static boolean isValidName(String name) {
		if (isNull(name)) {
			return false;
		}
		return Pattern.matches("[\u4e00-\u9fa5a-zA-Z0-9]{1,15}", name);
	}

	/**
	 * 判断是否是为数字
	 * 
	 * @param number
	 *            数字
	 * @return 如果是(true),否则(false)
	 */
	public static boolean isNumber(String number) {
		if (isNull(number)) {
			return false;
		}
		return Pattern.matches("[0-9]*", number);
	}

	/**
	 * 判断是否是为字母
	 * 
	 * @param letters
	 *            大小写字母的字符串
	 * @return 如果是(true),否则(false)
	 */
	public static boolean isLetters(String letters) {
		if (isNull(letters)) {
			return false;
		}
		return Pattern.matches("[A-Za-z]*", letters);
	}

	/**
	 * 判断是否是为字母,和数字的组成
	 * 
	 * @param 字串
	 * @return 如果是(true),否则(false)
	 */
	public static boolean isLettersAndNumber(String str) {
		if (isNull(str)) {
			return false;
		}
		return Pattern.matches("[A-Za-z0-9]*", str);
	}

	/**
	 * 判断是否是为字母,和数字的组成
	 * 
	 * @param mobile
	 *            手机号
	 * @return 如果是(true),否则(false)
	 */
	public static boolean isMobile(String mobile) {
		if (isNull(mobile)) {
			return false;
		}
		return Pattern.matches("[1][0-9]{10}", mobile);
	}

	/**
	 * 将固有格式的字符串转化为一个map 字符串格式为 “a=b|c=d|e=f” a、c、e为相应的键 b、d、f为相应的值
	 * 
	 * @param str
	 * @return
	 */
	public static Map<String, String> string2Map(String str, String splitStr) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		if (ObjectUtil.isNull(str)) {
			return null;
		} else {
			if (str.indexOf("=") == -1) {
				throw new Exception("Params style error[" + str + "]");

			}

			StringTokenizer token = new StringTokenizer(str, splitStr);
			int count = token.countTokens();
			for (int i = 0; i < count; i++) {
				String string = token.nextToken();
				if (ObjectUtil.isNull(string)) {
					continue;
				}
				String[] ps = string.split("=");
				if (ps.length != 2) {
					throw new Exception("Params style error[" + str + "]");
				}
				map.put(ps[0], ps[1]);
			}
		}
		return map;
	}

	/**
	 * 把map转为String key separator1 value separator2 key separator1 value
	 * 
	 * @param map
	 * @param separator1
	 * @param separator2
	 * @return
	 */
	public static String mapToString(Map<String, String> map, String separator1, String separator2) {
		if (map == null) {
			return "";
		}
		if (StringUtils.isBlank(separator1)) {
			return "";
		}
		if (StringUtils.isBlank(separator2)) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		Set<String> set = map.keySet();
		Iterator<String> iter = set.iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			String value = map.get(key);
			sb.append(key).append(separator1).append(value).append(separator2);
		}
		if (sb.length() > 0) {
			sb.setLength(sb.length() - separator2.length());
		}
		return sb.toString();
	}
}
