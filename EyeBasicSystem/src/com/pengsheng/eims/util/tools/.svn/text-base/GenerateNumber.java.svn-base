package com.pengsheng.eims.util.tools;

import java.util.*;

/**
 * <p>
 * Title: 文件操作的类
 * </p>
 * <p>
 * Description: 用于产生随机的并且是唯一的数字串
 * </p>
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @version 1.0
 */

public class GenerateNumber {
	private static int objectNum = 0; // How many create object!
	private String generateNumber;
	private int temp;
	private int count = 0; // recording method times;

	GenerateNumber() {
		objectNum = objectNum + 1;
		this.generateNumber = "";
	}

	public static GenerateNumber getInstance() {
		return new GenerateNumber();
	}

	public String getGenerageNumber() {
		generateNumber = "";
		count = count + 1;
		Calendar datatime = Calendar.getInstance();
		temp = datatime.get(datatime.YEAR);
		generateNumber = generateNumber + temp;
		temp = datatime.get(datatime.MONTH) + 1;
		temp(temp);
		temp = datatime.get(datatime.DAY_OF_MONTH);
		temp(temp);
		temp = datatime.get(datatime.HOUR_OF_DAY);
		temp(temp);
		temp = datatime.get(datatime.MINUTE);
		temp(temp);
		temp = datatime.get(datatime.SECOND);
		temp(temp);
		// Random random = new Random();
		// temp = random.nextInt(9999);
		temp = objectNum + count;
			
		if (temp >= 100 && temp <= 999)
			generateNumber = generateNumber + "0" + temp;
		if (temp >= 10 && temp <= 99)
			generateNumber = generateNumber + "00" + temp;
		if (temp >= 0 && temp <= 9)
			generateNumber = generateNumber + "000" + temp;
		if (temp >= 1000 && temp <= 9999)
			generateNumber = generateNumber + temp;
		if(temp > 9999){
			generateNumber = generateNumber + (temp+"").substring((temp+"").length()-4, (temp+"").length());
		}
		return generateNumber;
	}

	private void temp(int temp) {
		if (temp < 10)
			generateNumber = generateNumber + "0" + temp;
		else
			generateNumber = generateNumber + temp;
	}

	public static void main(String[] args) {
		System.out.println(GenerateNumber.getInstance()
				.getGenerageNumber());
	}
}
