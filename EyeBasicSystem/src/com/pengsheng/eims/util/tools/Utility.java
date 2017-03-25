package com.pengsheng.eims.util.tools;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class Utility {
	public static final String ZERO = "0";
	public static final String ONE = "1";
	public static final String EMPTY = "";
	public static final String MESSAGES = "messages";
	/*
	 如果是null返回""
	 否则返回原值
	 */
	public static String getName(String name){
		String returnValue = "";
		if(name == null){
			returnValue = "";
		}else {
			returnValue = name.trim();
		}
		return returnValue;
	}
	
	public static float getNumber(String money,String number){
		return (Float.parseFloat(money)*Float.parseFloat(number));
	}
	public static boolean isMobile(String mobiles)
	{
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[^4,\\D]))\\d{8}$");
		Matcher m = p.matcher(mobiles);
		///^(13[0-9]|15[012356789]|18[0236789]|14[57])[0-9]{8}$/ 
		return m.matches();

	}


	/*
	 * 返回0.00
	 */
	public static String getNameTwoPoint(String name){
		if(name == null)
			return "0.00";
		else if(name.equals(""))
			return "0.00";
		else
			return name.trim();
	}
	
	/*
	 返回0或者名称
	 用于下拉菜单初始值
	 */
	public static String getNameNum(String name){
		if(name == null)
			return "0";
		else if(name.equals(""))
			return "0";
		else
			return name.trim();
	}
	
	public int Check(String[] str,String name){
		for(int i=0;i<str.length;i++){
			if(name.equals(str[i].toString())){
				return i;
			}
		}
		return 0;
	}
	
	public static void setMessageInfo(HttpServletRequest request,String message){
		request.setAttribute("message", message);
	}
	
	public static String getMsgFromFile(String fieldName){
		Locale locale = Locale.getDefault();
		String value = null;
		try{
			ResourceBundle bundle = ResourceBundle.getBundle(MESSAGES,locale);
			value = bundle.getString(fieldName);
		}catch(Exception e){
			value = EMPTY;
		}
		return value;
	}
	
	public static String getMsgFromFile(String fileName,String fieldName){
		Locale locale = Locale.getDefault();
		String value = null;
		try{
			ResourceBundle bundle = ResourceBundle.getBundle(fileName,locale);
			value = bundle.getString(fieldName);	
		}catch(Exception e){
			value = EMPTY;
		}
		return value;
	}
	
	public static void main(String[] args){
//		System.out.println(new Integer(""));
//		System.out.println(isMobile(""));
	}
}
