/*****************************************************************************
 *
 * Demo program for Sentinel LDK licensing services
 *
 *
 * Copyright (C) 2014, SafeNet, Inc. All rights reserved.
 *
 *
 * Sentinel DEMOMA key required with features 1 and 42 enabled
 *
 *****************************************************************************/
package com.safenet;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.pengsheng.eims.util.tools.DateTool;
import com.pengsheng.eims.util.tools.Utility;

import Aladdin.Hasp;
import Aladdin.HaspStatus;

public class HaspApi {
	public static final int DEMO_MEMBUFFER_SIZE = 128;

	public static final String vendorCode = "8OXqdk/Nmu51esOu1dvg2UNdAwC7HM3e+CouDJJVUKpiDcTd55rLCVE78WzCDg1qMl49IYQPHsH+IIxt"
			+ "mYP1WQIZlCWcHL+ulteNgnfHM2l1iHPop9nLyrUzPUBmCvh5qeNsJuWjXic9P6s6WRCVJV1ASgLm21sD"
			+ "k9d9I/mdy/qehhCZtsNrkNlkyxt+i3RHuTGTBNCOrSxtHtf7XSVybqCsrf4yXeKXOFD5HDOAB59cFw78"
			+ "yLLlPIe9Oo4mF3mvKq4VvDDlRNtXZCcM8aaIGkX3+yFUPf3Q3twn/Xxv7v2Z9m6ZV/QC18VC4rdrSbas"
			+ "Qwe756eIbjjVqc1OLhM1B6pG+BVYD4k+UyHexiTmlURI4/WDJChUZpFEhZzig9cuXp9v8NOlxBQngFAH"
			+ "RAS9giNYxWfRCaDgOGyG1EwUJJuu1WojLXmXP+bjFdkLZfhLOjol19H3eaj9px1g8BWpAfnLhbLQQ5k0"
			+ "Rw/VTnggxBJllSN+meGDo/I2vHpGZC717cHkacYCxZShNw53V7vSn1/CmWAK2qCJ7rFodjSi+s166ttL"
			+ "tUqXgZuDJDVbKIF56i6o30bGskYKRvqHsSmai9zYwvQXa2OYoS8BZzPpfkdUXN1Lno8eoLb0qXMGqibe"
			+ "65/9jdFutQtT22N1xLY7PfMYwYiaFr1uH75bfS++MisD+RGgUYU0dX0alFhqisTRE9BDIjTebokjrC24"
			+ "0/ZBtukbCGyI/pFzweUOj8OZh9FzBRaZa3CTaOI0SzKQW2vLr+ahz/LyR1WTcUs1dvIDgSB8348LtTT7"
			+ "Bf3XtA07musChZwqlrD0fHuE1gLBUXsQwUKsED/SL0KKZy87HZjtY9HgGk4/WXeumP09uwXRgOFstzaJ"
			+ "zSjhcSTuLKKD1vvRlamiszoHC9qh+cLL5m5ZNo6mWdVP+Mz94WOgBwpTWzNwIEOPQuiRGS6rboSxetSM"
			+ "yXPbW6TFTFbLjHXB4s3CFg==";

	public static void main(String argv[]) throws java.io.IOException {
		System.out.println(HaspApi.getHaspResult());
	}

	public static String getHaspResult() {
//		long feature = Hasp.HASP_DEFAULT_FID;
//
//		Hasp hasp = new Hasp(feature);
//		hasp.login(vendorCode);
//		int status = hasp.getLastError();
//
//		if (HaspStatus.HASP_STATUS_OK != status) {
//			return "Hasp Login Error! Code=" + status;
//		} else {
//			int offset = 0;
//			byte[] data = new byte[32];
//			hasp.read(Hasp.HASP_FILEID_RW, offset, data);
//			status = hasp.getLastError();
//			if (HaspStatus.HASP_STATUS_OK != status) {
//				return "Hasp Login Error! Code=" + status;
//			} else {
//				String haspResult = new String(data);
//
//				String key = "mysflying";
//				Encrypt encrypt = new Encrypt();
//				encrypt.setKey(key);
//				encrypt.setDesString(haspResult);
//				haspResult = encrypt.getStrM();
//
//				if (haspResult.length() == 17) {
//					try {
//						int i;
//						i = Integer.parseInt(haspResult.substring(0, 6));
//					} catch (NumberFormatException e) {
//						return "Hasp Read Meory Data Error! ParseInt Error!";
//					}
//
//					if (!haspResult.substring(7, 17).trim().equals("")) {
//						try {
//							String str = haspResult.substring(7, 17);
//							SimpleDateFormat sdf = new SimpleDateFormat(
//									"yyyy-MM-dd");
//							Date date = sdf.parse(str);
//						} catch (ParseException e) {
//							return "Hasp Read Meory Data Error! ParseDate Error!";
//						}
//					}
//
//					return haspResult;
//				} else {
//					return "Hasp Read Meory Data Error! Lenght="
//							+ haspResult.length();
//				}
//			}
//		}
		return "100000 2050-09-09";
	}
}
