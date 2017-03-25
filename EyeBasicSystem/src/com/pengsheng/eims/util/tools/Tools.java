package com.pengsheng.eims.util.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * @company Systex
 * @author Liuqian
 * 
 * @project VIBO_APS
 * @version 1.0 Creation Date 2007-11-26
 * @package com.systex.athena.vibo.util
 * @file Tools.java
 * 
 */
public class Tools {
	private static Logger logger = Logger.getLogger(new Tools().getClass()
			.getName());

	public static String getClassPath(String classPath) throws Exception {

		String path = Tools.class.getResource(classPath).getPath();
		return java.net.URLDecoder.decode(path, "UTF-8");
	}

	/**
	 * 得到Properties文件实例
	 * 
	 * @param class /config/vibo/config/ 相对路径
	 * @param fileName
	 *            文件名 viboInfo.properties
	 * @return
	 */
	public static Properties getProperty(String classPath, String fileName) {
		InputStream in = Tools.class.getResourceAsStream(classPath + fileName);
		try {
			Properties properties = new Properties();

			if (in != null) {
				properties.load(in);
			} else {
				String path = Tools.class.getResource(classPath).getPath();
				path = java.net.URLDecoder.decode(path, "UTF-8");
				in = new FileInputStream(path + fileName);
				properties.load(in);
			}

			return properties;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 得到文件流
	 * 
	 * @param class /config/vibo/config/ 相对路径
	 * @param fileName
	 *            文件名 viboInfo.properties
	 * @return
	 */
	public static InputStream getFileInputStream(String classPath,String fileName) {
		InputStream in = null;
		
		try {
			in = Tools.class.getResourceAsStream(classPath + fileName);
			if (in == null) {
				URL resourcepath = Tools.class.getResource(classPath);
				if (resourcepath != null){
					String path = resourcepath.getPath();
					path = java.net.URLDecoder.decode(path, "UTF-8");
					in = new FileInputStream(path + fileName);
				}
			}
		} catch (Exception e) {
			in = null;
			e.printStackTrace();
		}
		return in;
	}

	public static String toUTF(String str) throws UnsupportedEncodingException {
		return toDecode(str, "UTF-8");
	}

	/**
	 * 字符串转换编码
	 * 
	 * @param str
	 *            - 要解码的 String 待转换字符串
	 * @param enc
	 *            - 所支持的字符编码的名称 *
	 * @return - 新解码的 String
	 * @throws UnsupportedEncodingException
	 */
	public static String toDecode(String str, String enc)
			throws UnsupportedEncodingException {
		return java.net.URLDecoder.decode(str, enc);
	}


	/**
	 * 中文转unicode
	 * 
	 * @param str
	 * @return 反回unicode编码
	 */
	public static String GBK2Unicode(String str) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			char chr1 = (char) str.charAt(i);
			if (!isNeedConvert(chr1)) {
				result.append(chr1);
				continue;
			}
			result.append("\\u" + Integer.toHexString((int) chr1));
		}
		return result.toString();
	}

	/**
	 * unicode转中文
	 * 
	 * @param str
	 * @return 中文
	 */
	public static String Unicode2GBK(String dataStr) {
		int index = 0;
		StringBuffer buffer = new StringBuffer();

		while (index < dataStr.length()) {
			if (!"\\u".equals(dataStr.substring(index, index + 2))) {
				buffer.append(dataStr.charAt(index));
				index++;
				continue;
			}
			String charStr = "";
			charStr = dataStr.substring(index + 2, index + 6);

			char letter = (char) Integer.parseInt(charStr, 16);
			buffer.append(letter);
			index += 6;
		}
		return buffer.toString();
	}

	public static boolean isNeedConvert(char para) {
		return ((para & (0x00FF)) != para);
	}

}
