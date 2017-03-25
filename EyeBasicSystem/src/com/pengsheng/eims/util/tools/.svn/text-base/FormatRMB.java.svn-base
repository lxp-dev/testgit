/**
 * 
 */
package com.pengsheng.eims.util.tools;

import java.util.regex.Pattern;

/**
 * @company Systex
 * @author Liuqian
 * 
 * @project eyehospital
 * @package com.systex.utils.tools
 * @file.name FormatRMB.java
 * 
 * @create Date 2008-3-6
 * 
 */
public class FormatRMB {
	public static String[] unit = new String[] { "", "万", "亿" };
	public static String[] qq = new String[] { "", "拾", "佰", "仟" };
	public static String[] num = new String[] { "零", "壹", "贰", "叁", "肆", "伍",
			"陆", "柒", "捌", "玖" };

	public static String formatRMB(String str) {
		Pattern p = Pattern.compile("\\.");
		String[] rmb = p.split(str);
		
		// System.out.println(rmb.length);
		// for (String s : rmb)
		// System.out.println(s);
		
		String daxiermb = new String();
		if (rmb.length != 2) {
			//System.out.println("数字格式错误！");
			return "数字格式有误";
		}

		int len = rmb[0].length();
		if (len == 0) {
			daxiermb = "零";
			return daxiermb;
		}
		int u, l;
		// String temStr = new String(rmb[1]);
		String s = new String();
		String tem = new String();
		int n, x;
		while (len > 1)// 处理整数部分
		{
//			System.out.println("len = " + len);
			u = (len - 1) / 4;// 看是亿或者万或者千
			l = (len - 1) % 4;
			x = 0;
//			System.out.println("u = " + u + " l = " + l);
			while (l >= 0) {
//				System.out.println("l = (len-1) %4 = " + l);
				s = String.valueOf(rmb[0].charAt(x++));// 从头开始取出字符串的值
				tem += s;
//				System.out.println(" s = " + s + "  tem = " + tem);
				n = Integer.valueOf(s);// 转换为数字
				daxiermb += num[n];// 把中文数字加上
				if (0 != num[n].compareTo("零"))
					daxiermb += qq[l];// 把位加上
//				System.out.println(num[n] + "  " + qq[l] + " zhengshu = "
//						+ daxiermb);
				l--;
			}
			daxiermb += unit[u];// 加上单位
//			System.out.println("tem :" + tem);
			rmb[0] = rmb[0].replaceFirst(tem, "");// 把已经转换的数字替换掉
//			System.out.println("rmb[0] =" + rmb[0]);
			tem = "";
			len = rmb[0].length();
//			System.out.println("zhengshu = " + daxiermb + " len :" + len
//					+ " rmb[1].length :" + rmb[0].length());
		}

		daxiermb += "圆";
		// 处理小数部分
		s = String.valueOf(rmb[1].charAt(0));// 从头开始取出字符串的值
		n = Integer.valueOf(s);// 转换为数字
		daxiermb += num[n];// 把中文数字加上
		daxiermb += "角";
		s = String.valueOf(rmb[1].charAt(1));// 从头开始取出字符串的值
		n = Integer.valueOf(s);// 转换为数字
		daxiermb += num[n];// 把中文数字加上
		daxiermb += "分";

		daxiermb = daxiermb.replaceAll("零亿", "亿");
		daxiermb = daxiermb.replaceAll("零万", "万");
		daxiermb = daxiermb.replaceAll("零千", "千");
		return daxiermb;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String rmb = new String("51020145.12");
		String st = formatRMB(rmb);
//		System.out.println(st);
	}

}
