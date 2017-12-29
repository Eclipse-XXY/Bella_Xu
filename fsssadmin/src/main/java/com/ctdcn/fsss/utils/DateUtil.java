package com.ctdcn.fsss.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * 时间转换工具
 */
public class DateUtil {
	public final static SimpleDateFormat g_SimpleDateFormat = new SimpleDateFormat(
			"yyyyMMdd");
	/**
	 * yyyy-MM-dd
	 */
	public final static SimpleDateFormat g_SimpleDateFormat_I = new SimpleDateFormat(
			"yyyy-MM-dd");
	/**
	 * yyyyMM
	 */
	public final static SimpleDateFormat g_SimpleDateFormat_II = new SimpleDateFormat(
			"yyyyMM");
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public final static SimpleDateFormat sdfDateTimeFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	public final static SimpleDateFormat sdfDateTimeFormat_I = new SimpleDateFormat(
			"yyyyMMddHHmmss");

	/**
	 * HH:mm:ss
	 */
	public final static SimpleDateFormat sdfDateTimeFormat_IIII = new SimpleDateFormat(
			"HH:mm:ss");
	public final static SimpleDateFormat sdfDateTimeFormat_YYYY = new SimpleDateFormat(
			"yyyy");

	/**
	 * 获取系统当前日期
	 * 
	 * @return
	 */
	public static Date getCurrentDate() {
		return new Date();
	}

	/**
	 * 返回日期格式(yyyy-MM-dd HH:mm:ss)
	 * 
	 * @param date
	 * @return
	 */
	public static String toDateTimeStr(Date date) {
		if (date == null) {
			return "";
		}
		return sdfDateTimeFormat.format(date);
	}

	/**
	 * 返回日期格式(yyyyMMddHHmmss)
	 * 
	 * @param date
	 * @return
	 */
	public static String toDateTimeStr2(Date date) {
		if (date == null) {
			return "";
		}
		return sdfDateTimeFormat_I.format(date);
	}

	/**
	 * 返回日期格式(yyyy-MM-dd)
	 * 
	 * @param date
	 * @return
	 */
	public static String toDateStr(Date date) {
		if (date == null) {
			return "";
		}
		return g_SimpleDateFormat_I.format(date);
	}

	/**
	 * 返回时间格式(HH:mm:ss)
	 * 
	 * @param date
	 * @return
	 */
	public static String toTimeStr(Date date) {
		if (date == null) {
			return "";
		}
		return sdfDateTimeFormat_IIII.format(date);
	}

	/**
	 * 返回日期格式(yyyyMMdd)
	 * 
	 * @param date
	 * @return
	 */
	public static String toDateStr2(Date date) {
		if (date == null) {
			return "";
		}
		return g_SimpleDateFormat.format(date);
	}

	/**
	 * 返回日期格式(yyyyMM)
	 * 
	 * @param date
	 * @return
	 */
	public static String toDateStr3(Date date) {
		if (date == null) {
			return "";
		}
		return g_SimpleDateFormat_II.format(date);
	}

	/**
	 * <p>
	 * 得到xxxx年xx月xx日 日期格式。
	 * </p>
	 * 
	 * @param date
	 * @return
	 */
	public static String toChinaDateStr(Date date) {
		if (date == null) {
			return "";
		}
		// 得到yyyy-mm-dd格式日期格式
		String dateStr = toDateStr(date);
		StringBuffer sb = new StringBuffer();
		if (dateStr != null && dateStr.length() > 0) {
			String[] newStr = dateStr.split("-");
			// 得到月
			int month = Integer.valueOf(newStr[1]);
			// 得到日
			int day = Integer.valueOf(newStr[2]);
			sb.append(newStr[0]).append("年");
			sb.append(month).append("月").append(day).append("日");
		}
		return sb.toString();
	}

	/**
	 * <p>
	 * 获取当前系统时间的小时数
	 * </p>
	 * 
	 * @return
	 */
	public static int getCurrentHour() {
		Calendar calendar = new GregorianCalendar();
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * <p>
	 * 获取当前系统时间的分钟数
	 * </p>
	 * 
	 * @return
	 */
	public static int getCurrentMinutes() {
		Calendar calendar = new GregorianCalendar();
		return calendar.get(Calendar.MINUTE);
	}

	/**
	 * <p>
	 * 获取本月第一天日期（格式如YYYYMMDD）,如果当前日为当月1日,则返回上月第一日
	 * </p>
	 * 
	 * @return
	 */
	public static String getMonthFirstDay() {
		Calendar calendar = new GregorianCalendar();
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int month = 0;
		if (day == 1) {
			calendar.add(Calendar.MONTH, -1);
		}
		month = calendar.get(Calendar.MONTH);
		if (month < 10) {
			return "" + calendar.get(Calendar.YEAR) + "0" + (month + 1) + "01";
		} else {
			return "" + calendar.get(Calendar.YEAR) + month + "01";
		}
	}

	public static Date getFristDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		return calendar.getTime();
	}

	public static Date getLastDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		return calendar.getTime();
	}

	/**
	 * 时间戳转换为返回日期
	 */
	public static String getFormatDate(String timeMillis, SimpleDateFormat sdf) {
		sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		return sdf.format(new Date(new Long(timeMillis).longValue()));
	}

	/**
	 * 获取时间差
	 * 
	 * @param starttime
	 *            起始时间 yyyy-MM-dd HH:mm:ss
	 * @param endtime
	 *            结束时间yyyy-MM-dd HH:mm:ss
	 * @return 0相等，-1起始晚于结束时间1豪秒，2起始时间早于结束时间2毫秒
	 */
	public static long getTimeInterval(String starttime, String endtime)
			throws ParseException {
		return DateUtil.getTimeInterval(sdfDateTimeFormat.parse(starttime),
				sdfDateTimeFormat.parse(endtime));
	}

	/**
	 * 获取时间差
	 * 
	 * @param starttime
	 *            起始时间 Date
	 * @param endtime
	 *            结束时间 Date
	 * @return 0相等，-1起始晚于结束时间1豪秒，2起始时间早于结束时间2毫秒
	 */
	public static long getTimeInterval(Date starttime, Date endtime) {
		java.util.Calendar c1 = java.util.Calendar.getInstance();
		java.util.Calendar c2 = java.util.Calendar.getInstance();
		c1.setTime(starttime);
		c2.setTime(endtime);
		return c2.getTimeInMillis() - c1.getTimeInMillis();

	}

	/**
	 * 获得前一天
	 * 
	 * @return 日期格式yyyy-MM-dd
	 */
	public static String getPreDate() {
		Date nowDate = new Date();
		String nowdates = g_SimpleDateFormat_I.format(nowDate);
		String[] dates = nowdates.split("-");
		int year = Integer.parseInt(dates[0]);
		int month = Integer.parseInt(dates[1]);
		int day = Integer.parseInt(dates[2]) - 1;
		if (day == 0) {
			switch (month - 1) {
			case 1:
				day = 31;
				break;
			case 3:
				day = 31;
				break;
			case 5:
				day = 31;
				break;
			case 7:
				day = 31;
				break;
			case 8:
				day = 31;
				break;
			case 10:
				day = 31;
				break;
			case 0:
				month = 13;
				year = year - 1;
				day = 31;
				break;
			case 4:
				day = 30;
				break;
			case 6:
				day = 30;
				break;
			case 9:
				day = 30;
				break;
			case 11:
				day = 30;
				break;
			case 2:
				if (year % 4 == 0) {
					day = 29;
				} else {
					day = 28;
				}
				break;
			default:
				break;
			}
			month = month - 1;
		}
		String predate = Integer.toString(year) + "-"
				+ (month < 10 ? "0" + month : month) + "-"
				+ (day < 10 ? "0" + day : day);
		return predate;
	}

	/***
	 * 获得当前年份
	 * 
	 * @return 格式yyyy
	 */
	public static long getCurrentYear() {
		return Long.parseLong(sdfDateTimeFormat_YYYY.format(new Date()));
	}

	/**
	 * 将字符串类型的日期格式 转换为 符合要求的日期格式
	 * 
	 * @param date
	 * @param format
	 *            需要转换的格式
	 * @return
	 */
	public static String getStrDate4String(String date, String format) {
		if (date == null || date.trim().equals("")) {
			return "";
		} else {
			SimpleDateFormat df = new SimpleDateFormat(format);
			try {
				Date d = df.parse(date);
				return df.format(d);
			} catch (ParseException e) {
				return "";
			}
		}
	}

	/**
	 * 将Date类型的日期格式 转换为 符合要求的 String日期格式
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String toDateStr(Date date, String format) {
		if (date == null) {
			return "";
		} else {
			SimpleDateFormat df = new SimpleDateFormat(format);
			return df.format(date);
		}
	}

	/**
	 * 将字符串类型的日期格式 转换为 日期格式
	 * 
	 * @param date
	 * @return
	 */
	public static Date toDateTime(String date, String fmt) {
		if (date == null || date.trim().equals("")) {
			return null;
		} else {
			SimpleDateFormat df = new SimpleDateFormat(fmt);
			try {
				return df.parse(date);
			} catch (ParseException e) {
				return null;
			}
		}
	}

	/**
	 * 计算指定日期时间之间的时间差
	 * 
	 * @param beginStr
	 *            开始日期字符串
	 * @param endStr
	 *            结束日期字符串
	 * @param f
	 *            时间差的形式0-秒,1-分种,2-小时,3--天 日期时间字符串格式:yyyyMMddHHmmss
	 * */
	public static int getInterval(String beginStr, String endStr, int f) {
		int hours = 0;
		try {
			Date beginDate = sdfDateTimeFormat.parse(beginStr);
			Date endDate = sdfDateTimeFormat.parse(endStr);
			long millisecond = endDate.getTime() - beginDate.getTime(); // 日期相减得到日期差X(单位:毫秒)
			/**
			 * Math.abs((int)(millisecond/1000)); 绝对值 1秒 = 1000毫秒
			 * millisecond/1000 --> 秒 millisecond/1000*60 - > 分钟
			 * millisecond/(1000*60*60) -- > 小时 millisecond/(1000*60*60*24) -->
			 * 天
			 * */
			switch (f) {
			case 0: // second
				return (int) (millisecond / 1000);
			case 1: // minute
				return (int) (millisecond / (1000 * 60));
			case 2: // hour
				return (int) (millisecond / (1000 * 60 * 60));
			case 3: // day
				return (int) (millisecond / (1000 * 60 * 60 * 24));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hours;
	}

	/**
	 * 得到起始日期后的日期
	 * 
	 * @param starttime
	 *            起始日期 格式：yyyy-MM-dd HH:mm:ss
	 * @param timeinsecond
	 *            秒数
	 * @return
	 * @throws ParseException
	 */
	public static Date getStartDateInterval(String starttime, int timeinsecond) {
		// 格式化起始时间 yyyyMMdd
		Date startDate = null;
		try {
			startDate = sdfDateTimeFormat.parse(starttime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar startTime = Calendar.getInstance();
		startTime.clear();
		startTime.setTime(startDate);

		startTime.add(Calendar.SECOND, timeinsecond);
		return startTime.getTime();
	}

	/**
	 * 得到起始日期和结束日期之间的天数
	 * 
	 * @param beginStr
	 *            起始日期
	 * @param endStr
	 *            结束日期
	 * @param format
	 *            根据 日期参数的格式，传对应的SimpleDateFormat格式
	 * @return 天数
	 */
	public static int getDaysInterval(String beginStr, String endStr,
			SimpleDateFormat format) {

		try {
			Date beginDate = format.parse(beginStr);
			Date endDate = format.parse(endStr);
			long millisecond = endDate.getTime() - beginDate.getTime(); // 日期相减得到日期差X(单位:毫秒)
			return (int) (millisecond / (1000 * 60 * 60 * 24));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * @Title: getDaysInterval
	 * @Description: 得到两个日期间隔时间
	 * @param @param beginDate
	 * @param @param endDate
	 * @param @return 设定文件 天数
	 * @return int 返回类型
	 * @throws
	 */
	public static int getDaysInterval(Date beginDate, Date endDate) {
		try {
			long millisecond = endDate.getTime() - beginDate.getTime(); // 日期相减得到日期差X(单位:毫秒)
			return (int) (millisecond / (1000 * 60 * 60 * 24));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static long getYearsInterval(Date beginDate, Date endDate) {
		try {
			long millisecond = endDate.getTime() - beginDate.getTime(); // 日期相减得到日期差X(单位:毫秒)
			return (int) (millisecond / ((long) 1000 * 60 * 60 * 24 * 365));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * @Title: addDate
	 * @Description: 日期加天数得到新的日期
	 * @param @param d
	 * @param @param day
	 * @param @throws ParseException 设定文件
	 * @return Date 返回类型
	 * @throws
	 */
	public static Date addDate(Date d, long day) throws ParseException {

		long time = d.getTime();
		day = day * 24 * 60 * 60 * 1000;
		time += day;
		return new Date(time);

	}
}
