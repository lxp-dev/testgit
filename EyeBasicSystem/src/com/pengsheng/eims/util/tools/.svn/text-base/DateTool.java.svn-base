package com.pengsheng.eims.util.tools;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * <p>
 * Title: 工具类
 * </p>
 * <p>
 * Description: 用来处理时间日期字符串等
 * </p>
 */
public class DateTool {

	public DateTool() {
		super();
	}

	/**
	 * 将指定的日期字符串转化为日期对象
	 * 
	 * @param dateStr
	 *            日期字符串
	 * @param format
	 *            日期格式
	 * 
	 * @return java.util.Date
	 */
	public static Date getDate(String dateStr, String format) throws Exception {

		if (dateStr == null || format == null) {
			throw new Exception("DataType Exception " + dateStr + "|" + format);
		}

		SimpleDateFormat df = new SimpleDateFormat(format);

		try {
			Date date = df.parse(dateStr);
			return date;
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * 将日期转换为yyyy-MM-dd HH:mm:ss的字符串格式
	 * 
	 * @param date
	 *            日期
	 * 
	 */
	public static String getDateStr(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			String dateStr = df.format(date);

			return dateStr;
		} catch (Exception ex) {
			return null;
		}

	}

	/**
	 * 将日期转换为指定的字符串格式
	 * 
	 * @param date
	 *            日期
	 * @param fromat
	 *            日期格式
	 * 
	 */
	public static String getDateStr(Date date, String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);

		try {
			String dateStr = df.format(date);

			return dateStr;
		} catch (Exception ex) {
			return null;
		}

	}

	/**
	 * 自动拼接日期
	 * 
	 * @param date
	 *            日期
	 * @param fromat
	 *            日期格式
	 * 
	 */
	public static String getDateAndTimeStr(String hourAndminute) {
		return DateTool.getDateStr(new Date(), "yyyyMMdd") + " "
				+ hourAndminute;
	}

	/**
	 * 将指定日期转换为 Timestamp
	 * 
	 * @param date
	 *            指定日期格式为 "20030908"
	 * @return Timestamp
	 * @throws Exception
	 */
	public static Timestamp getTimestamp(String dateStr) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00.000");
		return Timestamp.valueOf(sdf.format(getDate(dateStr, "yyyyMMdd")));
	}

	/**
	 * 从指定Timestamp中得到相应的日期
	 * 
	 * @param datetime
	 *            指定的Timestamp
	 * @return 日期 "2003-09-08"
	 */
	public String getDateFromDateTime(Timestamp datetime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(datetime).toString();
	}

	/**
	 * 得到当前时间的时间戳
	 * 
	 * @return 当前时间戳
	 */
	public Timestamp getNowTimestamp() {
		long curTime = System.currentTimeMillis();
		return new Timestamp(curTime);
	}

	/**
	 * 計算某天是星期幾
	 */
	public static String getDay(Date date) {
		Calendar aCalendar = Calendar.getInstance();
		// 里面可以直接插入date类型
		aCalendar.setTime(date);
		// 计算此日期是一周中的哪一天
		int x = aCalendar.get(Calendar.DAY_OF_WEEK);
		String day = "";
		switch (x) {
		case 1:
			day = "(日)";
			break;
		case 2:
			day = "(一)";
			break;
		case 3:
			day = "(二)";
			break;
		case 4:
			day = "(三)";
			break;
		case 5:
			day = "(四)";
			break;
		case 6:
			day = "(五)";
			break;
		case 7:
			day = "(六)";
			break;

		default:
			break;
		}
		return day;
	}

	/**
	 * 得到會議時間,格式為:2007-11-2（五） 08:00~10:00
	 * 
	 * @param startTime
	 *            會議開始時間
	 * @param endTime
	 *            會議結束時間
	 */
	public static String getMeetingDate(Date startTime, Date endTime) {
		String str = "";
		str = DateTool.getDateStr(startTime, "yyyy-MM-dd") + " "
				+ getDay(startTime) + " "
				+ DateTool.getDateStr(startTime, "HH:mm") + "~"
				+ DateTool.getDateStr(endTime, "HH:mm");
		return str;
	}

	public int getDaysBetween(java.util.Calendar d1, java.util.Calendar d2) {
		if (d1.after(d2)) { // swap dates so that d1 is start and d2 is end
			java.util.Calendar swap = d1;
			d1 = d2;
			d2 = swap;
		}
		int days = d2.get(java.util.Calendar.DAY_OF_YEAR)
				- d1.get(java.util.Calendar.DAY_OF_YEAR);
		int y2 = d2.get(java.util.Calendar.YEAR);
		if (d1.get(java.util.Calendar.YEAR) != y2) {
			d1 = (java.util.Calendar) d1.clone();
			do {
				days += d1.getActualMaximum(java.util.Calendar.DAY_OF_YEAR);
				d1.add(java.util.Calendar.YEAR, 1);
			} while (d1.get(java.util.Calendar.YEAR) != y2);
		}
		return days + 1;
	}

	/**
	 * 计算2个日期之间的相隔天数
	 * 
	 * @param d1
	 * @param d2
	 * @param flag
	 *            单双休 单休： 0，双休：1
	 * @return
	 */
	public int getWorkingDay(java.util.Calendar d1, java.util.Calendar d2,
			int flag) {
		int result = -1;
		if (d1.after(d2)) { // swap dates so that d1 is start and d2 is end
			java.util.Calendar swap = d1;
			d1 = d2;
			d2 = swap;
		}

		int betweendays = getDaysBetween(d1, d2);

		int charge_date = 0;
		int charge_start_date = 0;// 开始日期的日期偏移量
		int charge_end_date = 0;// 结束日期的日期偏移量
		// 日期不在同一个日期内
		int stmp;
		int etmp;
		int weekDayStart = d1.get(Calendar.DAY_OF_WEEK);
		int weekDayEnd = d2.get(Calendar.DAY_OF_WEEK);
		stmp = 7 - weekDayStart;
		etmp = 7 - weekDayEnd;

		if (flag == 2) {
			if (!String.valueOf(weekDayStart).matches(
					"^[" + Calendar.SATURDAY + Calendar.SUNDAY + "]$")) {// 开始日期为星期六和星期日时偏移量为0
				charge_start_date = stmp;
				// System.out.println("charge_start_date=="+charge_start_date);
			}
			if (!String.valueOf(weekDayEnd).matches(
					"^[" + Calendar.SATURDAY + Calendar.SUNDAY + "]$")) {// 结束日期为星期六和星期日时偏移量为0
				charge_end_date = etmp - 1;
				// System.out.println("charge_end_date=="+charge_end_date);
			}
		} else if (flag == 1) {
			if (!String.valueOf(weekDayStart).matches(
					"^[" + Calendar.SUNDAY + "]$")) {// 开始日期为星期六和星期日时偏移量为0
				charge_start_date = stmp + 1;
				// System.out.println("charge_start_date=="+charge_start_date);
			}
			if (!String.valueOf(weekDayEnd).matches(
					"^[" + Calendar.SUNDAY + "]$")) {// 结束日期为星期六和星期日时偏移量为0
				charge_end_date = etmp;
				// System.out.println("charge_end_date=="+charge_end_date);
			}
		} else if (flag == 0) {

			if (String.valueOf(weekDayStart).matches(
					"^[" + Calendar.SUNDAY + "]$")) {
				stmp = -1;
			}

			charge_start_date = stmp + 2;
			// System.out.println("charge_start_date=="+charge_start_date);

			if (String.valueOf(weekDayEnd).matches(
					"^[" + Calendar.SUNDAY + "]$")) {
				etmp = -1;
			}
			charge_end_date = etmp + 1;
			// System.out.println("charge_end_date=="+charge_end_date);
			// }
		}
		Calendar endCal = this.getNextMonday(d2);
		endCal.add(Calendar.DATE, -1);

		if (flag == 2) {
			result = (getDaysBetween(this.getNextMonday(d1), endCal) / 7) * 5
					+ charge_start_date - charge_end_date;
		} else if (flag == 1) {
			result = (getDaysBetween(this.getNextMonday(d1), endCal) / 7) * 6
					+ charge_start_date - charge_end_date;
		} else if (flag == 0) {
			result = (getDaysBetween(this.getNextMonday(d1), endCal) / 7) * 7
					+ charge_start_date - charge_end_date;
		}
		// System.out.println("charge_start_date>" + charge_start_date);
		// System.out.println("charge_end_date>" + charge_end_date);
		// System.out.println("between day is-->" + betweendays);
		return result;
	}

	public String getChineseWeek(Calendar date) {
		final String dayNames[] = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五",
				"星期六" };

		int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);

		// System.out.println(dayNames[dayOfWeek - 1]);
		return dayNames[dayOfWeek - 1];

	}

	/**
	 * 获得日期的下一个星期一的日期
	 * 
	 * @param date
	 * @return
	 */
	public Calendar getNextMonday(Calendar date) {
		Calendar result = null;
		result = date;
		do {
			result = (Calendar) result.clone();
			result.add(Calendar.DATE, 1);
		} while (result.get(Calendar.DAY_OF_WEEK) != 2);
		return result;
	}

	/**
	 * 
	 * @param d1
	 * @param d2
	 * @param flag
	 *            单双休 单休： 0，双休：1
	 * @return
	 */
	public int getHolidays(Calendar d1, Calendar d2, int flag) {
		return this.getDaysBetween(d1, d2) - this.getWorkingDay(d1, d2, flag);

	}

	// public static void main(String[] args) {
	// System.out.println(DateTool.getDateAndTimeStr("9:30"));
	// }

	public static void main(String[] args) {
        System.out.println(new Date()); 
	}

	public static boolean compare_date(String DATE1, String DATE2) {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dt1 = df.parse(DATE1);
			Date dt2 = df.parse(DATE2);
			if (dt1.getTime() < dt2.getTime()) {
				return true;
			} else{
				return false;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return false;
	}
}
