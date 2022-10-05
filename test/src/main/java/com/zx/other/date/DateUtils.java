package com.zx.other.date;

import org.apache.http.util.TextUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @desc:时间处理工具类
 * @Author:chenssy
 * @date:2014年8月4日
 */
public class DateUtils {
    private static final String[] weeks = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};

    private static final String[] weeksNum = {"7", "1", "2", "3", "4", "5", "6"};
    /**
     * 转换格式为yyyy-MM-dd HH:mm:ss:SSS。
     */
    public final static String yyyy_MM_dd_HH_mm_ss_SSS = "yyyy-MM-dd HH:mm:ss:SSS";

    /**
     * 转换格式为yyyy-MM-dd HH:mm:ss。
     */
    public final static String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";

    /**
     * 转换格式为yyyy/MM/dd/HH/mm/ss。
     */
    public final static String yyyy_MM_dd_HH_mm_ss_2 = "yyyy-MM-dd-HH-mm-ss";

    /**
     * 转换格式为yyyy-MM-dd HH:mm。
     */
    public final static String yyyy_MM_dd_HH_mm = "yyyy-MM-dd HH:mm";

    /**
     * 转换格式为yyyy-MM-dd。
     */
    public final static String yyyy_MM_dd = "yyyy-MM-dd";

    /**
     * 转换格式为yyyy-M-d H:m:s:S
     */
    public final static String yyyy_M_d_H_m_s_S = "yyyy-M-d H:m:s:S";

    /**
     * 转换格式为yyyy-M-d H:m:s
     */
    public final static String yyyy_M_d_H_m_s = "yyyy-M-d H:m:s";

    /**
     * 转换格式为yyyy-M-d H:m
     */
    public final static String yyyy_M_d_H_m = "yyyy-M-d H:m";

    /**
     * 转换成格式为yyyy-M-d
     */
    public final static String yyyy_M_d = "yyyy-M-d";

    /**
     * 转换格式为yyyyMMdd HH:mm:ss:SSS。
     */
    public final static String yyyyMMdd_HH_mm_ss_SSS = "yyyyMMdd HH:mm:ss:SSS";

    /**
     * 转换格式为yyyyMMdd HH:mm:ss。
     */
    public final static String yyyyMMdd_HH_mm_ss = "yyyyMMdd HH:mm:ss";

    /**
     * 转换格式为yyyyMMdd HH:mm。
     */
    public final static String yyyyMMdd_HH_mm = "yyyyMMdd HH:mm";

    /**
     * 转换格式为yyyyMMdd。
     */
    public final static String yyyyMMdd = "yyyyMMdd";

    /**
     * 转换格式为yyyyMMddHH。
     */
    public final static String yyyyMMddHH = "yyyyMMddHH";

    /**
     * 转换格式为yyyyMMddHHmmssSSS。
     */
    public final static String yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";

    /**
     * 转换格式为yyyyMMddHHmmss。
     */
    public final static String yyyyMMddHHmmss = "yyyyMMddHHmmss";

    /**
     * 转换格式为yyyyMMddHHmm。
     */
    public final static String yyyyMMddHHmm = "yyyyMMddHHmm";

    /**
     * 转换格式为yyyyMMddHHmm。
     */
    public final static String yyyyMMddHHmmSSS = "yyyyMMddHHmmSSS";

    /**
     * 转换格式为yyyyMM。
     */
    public final static String yyyyMM = "yyyyMM";

    /**
     * 转换格式为yyyy_MM。
     */
    public final static String yyyy_MM = "yyyy-MM";

    /**
     * 转换格式为yyyy。
     */
    public final static String yyyy = "yyyy";

    /**
     * 转换格式为MM。
     */
    public final static String MM = "MM";

    /**
     * 转换格式为yyyy年M月d日H点m分。
     */
    public final static String yyyyMdHm_zh = "yyyy年M月d日H点m分";

    /**
     * 转换格式为HHmmss。
     */
    public final static String HHmmss = "HHmmss";
    /**
     * 将String类型的日期转换为Date对象。
     *
     * @param dateString
     *          代表日期的字符串。
     * @param style
     *          转换格式。
     * @return 日期对象。
     */
    public static Date stringToDate(String dateString, String style) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(style, Locale.CHINESE);
            return format.parse(dateString);
        }
        catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将Date转换成为指定格式的String。
     *
     * @param date
     *          日期对象。
     * @param style
     *          转换格式。
     * @return 代表日期的字符串。
     */
    public static String dateToString(Date date, String style) {
        SimpleDateFormat format = new SimpleDateFormat(style, Locale.CHINESE);
        return format.format(date);
    }



    /**
     * 获取指定月份的最后一天
     *
     * @param date
     * @return
     */
    public static String getLastDayOfMonth(String date) {
        int year = Integer.parseInt(date.substring(0, 4));  //年
        int month = Integer.parseInt(date.substring(4, 6)); //月
        Calendar cal = Calendar.getInstance();
        // 设置年份
        cal.set(Calendar.YEAR, year);
        // 设置月份
        cal.set(Calendar.MONTH, month - 1);
        // 获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DATE);
        // 设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        // 格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat(DateFormatUtils.DATE_FORMAT1);
        return sdf.format(cal.getTime());
    }

    /**
     * 获取指定月份的最后一天  仅返回天
     *
     * @param date
     * @return
     */
    public static int getLastDayOfMonth(Date date) {
        String yyyyMMddStr = DateUtils.dateToString(date,yyyyMMdd);
        int year = Integer.parseInt(yyyyMMddStr.substring(0, 4));  //年
        int month = Integer.parseInt(yyyyMMddStr.substring(4, 6)); //月
        Calendar cal = Calendar.getInstance();
        // 设置年份
        cal.set(Calendar.YEAR, year);
        // 设置月份
        cal.set(Calendar.MONTH, month - 1);
        // 获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        return lastDay;
    }

    /**
     * 根据周获取日期（不包括今天）
     *
     * @param weekList ['1','2'...]
     * @return
     */
    public static List<String> weekToDate2(List<String> weekList) {
        List<String> weeks = new ArrayList<>();
        Integer week = getWeek(DateUtils.getCurrentDayTime());   //明天是周几
        Date date = getWeektLastDate(new Date());//本周最后一天
        for (String wl : weekList) {
            int w = Integer.parseInt(wl);
            if (week >= w) {  //不是本周
                String newDate = DateUtils.addDayToDate(w, date, "yyyy-MM-dd");
                weeks.add(newDate);
            } else {
                String newDate = DateUtils.addDayToDate(w - week, DateUtils.getCurrentDayTime(), "yyyy-MM-dd");
                weeks.add(newDate);
            }
        }
        return weeks;
    }

    /**
     * 根据指定格式获取当前时间
     *
     * @param format
     * @return String
     * @author chenssy
     * @date Dec 27, 2013
     */
    public static String getCurrentTime(String format) {
        SimpleDateFormat sdf = DateFormatUtils.getFormat(format);
        Date date = new Date();
        return sdf.format(date);
    }

    /**
     * 获取当前时间，格式为：yyyy-MM-dd HH:mm:ss
     *
     * @return String
     * @author chenssy
     * @date Dec 27, 2013
     */
    public static String getCurrentTime() {
        return getCurrentTime(DateFormatUtils.DATE_FORMAT2);
    }

    /**
     * 获取指定格式的当前时间：为空时格式为yyyy-mm-dd HH:mm:ss
     *
     * @param format
     * @return Date
     * @author chenssy
     * @date Dec 30, 2013
     */
    public static Date getCurrentDate(String format) {
        SimpleDateFormat sdf = DateFormatUtils.getFormat(format);
        String dateS = getCurrentTime(format);
        Date date = null;
        try {
            date = sdf.parse(dateS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取当前时间，格式为yyyy-MM-dd HH:mm:ss
     *
     * @return Date
     * @author chenssy
     * @date Dec 30, 2013
     */
    public static Date getCurrentDate() {
        return getCurrentDate(DateFormatUtils.DATE_FORMAT2);
    }

    /**
     * 给指定日期加入年份，为空时默认当前时间
     *
     * @param year   年份  正数相加、负数相减
     * @param date   为空时，默认为当前时间
     * @param format 默认格式为：yyyy-MM-dd HH:mm:ss
     * @return String
     * @author chenssy
     * @date Dec 30, 2013
     */
    public static String addYearToDate(int year, Date date, String format) {
        Calendar calender = getCalendar(date, format);
        SimpleDateFormat sdf = DateFormatUtils.getFormat(format);

        calender.add(Calendar.YEAR, year);

        return sdf.format(calender.getTime());
    }

    /**
     * 给指定日期加入年份，为空时默认当前时间
     *
     * @param year   年份  正数相加、负数相减
     * @param date   为空时，默认为当前时间
     * @param format 默认格式为：yyyy-MM-dd HH:mm:ss
     * @return String
     * @author chenssy
     * @date Dec 30, 2013
     */
    public static String addYearToDate(int year, String date, String format) {
        Date newDate = new Date();
        if (null != date && !"".equals(date)) {
            newDate = string2Date(date, format);
        }

        return addYearToDate(year, newDate, format);
    }

    /**
     * 给指定日期增加月份 为空时默认当前时间
     *
     * @param month  增加月份  正数相加、负数相减
     * @param date   指定时间
     * @param format 指定格式 为空默认 yyyy-mm-dd HH:mm:ss
     * @return String
     * @author chenssy
     * @date Dec 30, 2013
     */
    public static String addMothToDate(int month, Date date, String format) {
        Calendar calender = getCalendar(date, format);
        SimpleDateFormat sdf = DateFormatUtils.getFormat(format);

        calender.add(Calendar.MONTH, month);

        return sdf.format(calender.getTime());
    }

    /**
     * 给指定日期增加月份 为空时默认当前时间
     *
     * @param month  增加月份  正数相加、负数相减
     * @param date   指定时间
     * @param format 指定格式 为空默认 yyyy-mm-dd HH:mm:ss
     * @return String
     * @author chenssy
     * @date Dec 30, 2013
     */
    public static String addMothToDate(int month, String date, String format) {
        Date newDate = new Date();
        if (null != date && !"".equals(date)) {
            newDate = string2Date(date, format);
        }

        return addMothToDate(month, newDate, format);
    }

    /**
     * 给指定日期增加天数，为空时默认当前时间
     *
     * @param day    增加天数 正数相加、负数相减
     * @param date   指定日期
     * @param format 日期格式 为空默认 yyyy-mm-dd HH:mm:ss
     * @return String
     * @author chenssy
     * @date Dec 31, 2013
     */
    public static String addDayToDate(int day, Date date, String format) {
        Calendar calendar = getCalendar(date, format);
        SimpleDateFormat sdf = DateFormatUtils.getFormat(format);

        calendar.add(Calendar.DATE, day);

        return sdf.format(calendar.getTime());
    }

    /**
     * 给指定日期增加天数，为空时默认当前时间
     *
     * @param day    增加天数 正数相加、负数相减
     * @param date   指定日期
     * @param format 日期格式 为空默认 yyyy-mm-dd HH:mm:ss
     * @return String
     * @author chenssy
     * @date Dec 31, 2013
     */
    public static String addDayToDate(int day, String date, String format) {
        Date newDate = new Date();
        if (null != date && !"".equals(date)) {
            newDate = string2Date(date, format);
        }

        return addDayToDate(day, newDate, format);
    }

    /**
     * 给指定日期增加小时，为空时默认当前时间
     *
     * @param hour   增加小时  正数相加、负数相减
     * @param date   指定日期
     * @param format 日期格式 为空默认 yyyy-mm-dd HH:mm:ss
     * @return String
     * @author chenssy
     * @date Dec 31, 2013
     */
    public static String addHourToDate(int hour, Date date, String format) {
        Calendar calendar = getCalendar(date, format);
        SimpleDateFormat sdf = DateFormatUtils.getFormat(format);

        calendar.add(Calendar.HOUR, hour);

        return sdf.format(calendar.getTime());
    }

    /**
     * 给指定日期增加小时，为空时默认当前时间
     *
     * @param hour   增加小时  正数相加、负数相减
     * @param date   指定日期
     * @param format 日期格式 为空默认 yyyy-mm-dd HH:mm:ss
     * @return String
     * @author chenssy
     * @date Dec 31, 2013
     */
    public static String addHourToDate(int hour, String date, String format) {
        Date newDate = new Date();
        if (null != date && !"".equals(date)) {
            newDate = string2Date(date, format);
        }

        return addHourToDate(hour, newDate, format);
    }

    /**
     * 给指定的日期增加分钟，为空时默认当前时间
     *
     * @param minute 增加分钟  正数相加、负数相减
     * @param date   指定日期
     * @param format 日期格式 为空默认 yyyy-mm-dd HH:mm:ss
     * @return String
     * @author chenssy
     * @date Dec 31, 2013
     */
    public static String addMinuteToDate(int minute, Date date, String format) {
        Calendar calendar = getCalendar(date, format);
        SimpleDateFormat sdf = DateFormatUtils.getFormat(format);

        calendar.add(Calendar.MINUTE, minute);

        return sdf.format(calendar.getTime());
    }

    /**
     * 给指定的日期增加分钟，为空时默认当前时间
     *
     * @param minute 增加分钟  正数相加、负数相减
     * @param date   指定日期
     * @param format 日期格式 为空默认 yyyy-mm-dd HH:mm:ss
     * @return String
     * @author chenssy
     * @date Dec 31, 2013
     */
    public static String addMinuteToDate(int minute, String date, String format) {
        Date newDate = new Date();
        if (null != date && !"".equals(date)) {
            newDate = string2Date(date, format);
        }

        return addMinuteToDate(minute, newDate, format);
    }

    /**
     * 给指定日期增加秒，为空时默认当前时间
     *
     * @param second 增加秒 正数相加、负数相减
     * @param date   指定日期
     * @param format 日期格式 为空默认 yyyy-mm-dd HH:mm:ss
     * @return String
     * @author chenssy
     * @date Dec 31, 2013
     */
    public static String addSecondToDate(int second, Date date, String format) {
        Calendar calendar = getCalendar(date, format);
        SimpleDateFormat sdf = DateFormatUtils.getFormat(format);

        calendar.add(Calendar.SECOND, second);

        return sdf.format(calendar.getTime());
    }

    /**
     * 给指定日期增加秒，为空时默认当前时间
     *
     * @param second 增加秒 正数相加、负数相减
     * @param date   指定日期
     * @param format 日期格式 为空默认 yyyy-mm-dd HH:mm:ss
     * @return String
     * @throws Exception
     * @author chenssy
     * @date Dec 31, 2013
     */
    public static String addSecondToDate(int second, String date, String format) {
        Date newDate = new Date();
        if (null != date && !"".equals(date)) {
            newDate = string2Date(date, format);
        }

        return addSecondToDate(second, newDate, format);
    }

    /**
     * 获取指定格式指定时间的日历
     *
     * @param date   时间
     * @param format 格式
     * @return Calendar
     * @author chenssy
     * @date Dec 30, 2013
     */
    public static Calendar getCalendar(Date date, String format) {
        if (date == null) {
            date = getCurrentDate(format);
        }

        Calendar calender = Calendar.getInstance();
        calender.setTime(date);

        return calender;
    }

    /**
     * 字符串转换为日期，日期格式为
     *
     * @param value
     * @return
     * @author : chenssy
     * @date : 2016年5月31日 下午5:20:22
     */
    public static Date string2Date(String value) {
        if (value == null || "".equals(value)) {
            return null;
        }

        SimpleDateFormat sdf = DateFormatUtils.getFormat(DateFormatUtils.DATE_FORMAT2);
        Date date = null;

        try {
            value = DateFormatUtils.formatDate(value, DateFormatUtils.DATE_FORMAT2);
            date = sdf.parse(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 将字符串(格式符合规范)转换成Date
     *
     * @param value  需要转换的字符串
     * @param format 日期格式
     * @return Date
     * @author chenssy
     * @date Dec 31, 2013
     */
    public static Date string2Date(String value, String format) {
        if (value == null || "".equals(value)) {
            return null;
        }

        SimpleDateFormat sdf = DateFormatUtils.getFormat(format);
        Date date = null;

        try {
            value = DateFormatUtils.formatDate(value, format);
            date = sdf.parse(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 将日期格式转换成String
     *
     * @param value  需要转换的日期
     * @param format 日期格式
     * @return String
     * @author chenssy
     * @date Dec 31, 2013
     */
    public static String date2String(Date value, String format) {
        if (value == null) {
            return null;
        }

        SimpleDateFormat sdf = DateFormatUtils.getFormat(format);
        return sdf.format(value);
    }

    /**
     * 日期转换为字符串
     *
     * @param value
     * @return
     * @author : chenssy
     * @date : 2016年5月31日 下午5:21:38
     */
    public static String date2String(Date value) {
        if (value == null) {
            return null;
        }

        SimpleDateFormat sdf = DateFormatUtils.getFormat(DateFormatUtils.DATE_FORMAT2);
        return sdf.format(value);
    }

    /**
     * 获取指定日期的年份
     *
     * @param value 日期
     * @return int
     * @author chenssy
     * @date Dec 31, 2013
     */
    public static int getCurrentYear(Date value) {
        String date = date2String(value, DateFormatUtils.DATE_YEAR);
        return Integer.valueOf(date);
    }

    /**
     * 获取指定日期的年份
     *
     * @param value 日期
     * @return int
     * @author chenssy
     * @date Dec 31, 2013
     */
    public static int getCurrentYear(String value) {
        Date date = string2Date(value, DateFormatUtils.DATE_YEAR);
        Calendar calendar = getCalendar(date, DateFormatUtils.DATE_YEAR);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取指定日期的月份
     *
     * @param value 日期
     * @return int
     * @author chenssy
     * @date Dec 31, 2013
     */
    public static int getCurrentMonth(Date value) {
        String date = date2String(value, DateFormatUtils.DATE_MONTH);
        return Integer.valueOf(date);
    }

    /**
     * 获取指定日期的月份
     *
     * @param value 日期
     * @return int
     * @author chenssy
     * @date Dec 31, 2013
     */
    public static int getCurrentMonth(String value) {
        Date date = string2Date(value, DateFormatUtils.DATE_MONTH);
        Calendar calendar = getCalendar(date, DateFormatUtils.DATE_MONTH);

        return calendar.get(Calendar.MONTH);
    }

    /**
     * 获取指定日期的天份
     *
     * @param value 日期
     * @return int
     * @author chenssy
     * @date Dec 31, 2013
     */
    public static int getCurrentDay(Date value) {
        String date = date2String(value, DateFormatUtils.DATE_DAY);
        return Integer.valueOf(date);
    }

    /**
     * 获取指定日期的天份
     *
     * @param value 日期
     * @return int
     * @author chenssy
     * @date Dec 31, 2013
     */
    public static int getCurrentDay(String value) {
        Date date = string2Date(value, DateFormatUtils.DATE_DAY);
        Calendar calendar = getCalendar(date, DateFormatUtils.DATE_DAY);

        return calendar.get(Calendar.DATE);
    }

    /**
     * 获取当前日期为星期几
     *
     * @param value 日期
     * @return String
     * @author chenssy
     * @date Dec 31, 2013
     */
    public static String getCurrentWeek(Date value) {
        Calendar calendar = getCalendar(value, DateFormatUtils.DATE_FORMAT1);
        int weekIndex = calendar.get(Calendar.DAY_OF_WEEK) - 1 < 0 ? 0 : calendar.get(Calendar.DAY_OF_WEEK) - 1;

        return weeks[weekIndex];
    }

    /**
     * 获取当前日期为星期几(返回数字)
     *
     * @param value 日期
     * @return String
     * @author chenssy
     * @date Dec 31, 2013
     */
    public static String getCurrentWeekNum(String value) {
        Date date = string2Date(value, DateFormatUtils.DATE_FORMAT1);
        return getCurrentWeekNum(date);
    }

    /**
     * 获取当前日期为星期几
     *
     * @param value 日期
     * @return String
     * @author chenssy
     * @date Dec 31, 2013
     */
    public static String getCurrentWeekNum(Date value) {
        Calendar calendar = getCalendar(value, DateFormatUtils.DATE_FORMAT1);
        int weekIndex = calendar.get(Calendar.DAY_OF_WEEK) - 1 < 0 ? 0 : calendar.get(Calendar.DAY_OF_WEEK) - 1;

        return weeksNum[weekIndex];
    }

    /**
     * 获取当前日期为星期几
     *
     * @param value 日期
     * @return String
     * @author chenssy
     * @date Dec 31, 2013
     */
    public static String getCurrentWeek(String value) {
        Date date = string2Date(value, DateFormatUtils.DATE_FORMAT1);
        return getCurrentWeek(date);
    }

    /**
     * 获取指定日期的小时
     *
     * @param value 日期
     * @return int
     * @author chenssy
     * @date Dec 31, 2013
     */
    public static int getCurrentHour(Date value) {
        String date = date2String(value, DateFormatUtils.DATE_HOUR);
        return Integer.valueOf(date);
    }

    /**
     * 获取指定日期的小时
     *
     * @param value 日期
     * @return int
     * @author chenssy
     * @date Dec 31, 2013
     */
    public static int getCurrentHour(String value) {
        Date date = string2Date(value, DateFormatUtils.DATE_HOUR);
        Calendar calendar = getCalendar(date, DateFormatUtils.DATE_HOUR);

        return calendar.get(Calendar.DATE);
    }

    /**
     * 获取指定日期的分钟
     *
     * @param value 日期
     * @return int
     * @author chenssy
     * @date Dec 31, 2013
     */
    public static int getCurrentMinute(Date value) {
        String date = date2String(value, DateFormatUtils.DATE_MINUTE);
        return Integer.valueOf(date);
    }

    /**
     * 获取指定日期的分钟
     *
     * @param value 日期
     * @return int
     * @author chenssy
     * @date Dec 31, 2013
     */
    public static int getCurrentMinute(String value) {
        Date date = string2Date(value, DateFormatUtils.DATE_MINUTE);
        Calendar calendar = getCalendar(date, DateFormatUtils.DATE_MINUTE);

        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 比较两个日期相隔多少天(月、年) <br>
     * 例：<br>
     * &nbsp;compareDate("2009-09-12", null, 0);//比较天 <br>
     * &nbsp;compareDate("2009-09-12", null, 1);//比较月 <br>
     * &nbsp;compareDate("2009-09-12", null, 2);//比较年 <br>
     *
     * @param startDay 需要比较的时间 不能为空(null),需要正确的日期格式 ,如：2009-09-12
     * @param endDay   被比较的时间  为空(null)则为当前时间
     * @param stype    返回值类型   0为多少天，1为多少个月，2为多少年
     * @return int
     * @author chenssy
     * @date Dec 31, 2013
     */
    public static int compareDate(String startDay, String endDay, int stype) {
        int n = 0;
        startDay = DateFormatUtils.formatDate(startDay, "yyyy-MM-dd");
        endDay = DateFormatUtils.formatDate(endDay, "yyyy-MM-dd");

        String formatStyle = "yyyy-MM-dd";
        if (1 == stype) {
            formatStyle = "yyyy-MM";
        } else if (2 == stype) {
            formatStyle = "yyyy";
        }

        endDay = endDay == null ? getCurrentTime("yyyy-MM-dd") : endDay;

        DateFormat df = new SimpleDateFormat(formatStyle);
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try {
            c1.setTime(df.parse(startDay));
            c2.setTime(df.parse(endDay));
        } catch (Exception e) {
            e.printStackTrace();
        }
        while (!c1.after(c2)) {                   // 循环对比，直到相等，n 就是所要的结果     
            n++;
            if (stype == 1) {
                c1.add(Calendar.MONTH, 1);          // 比较月份，月份+1     
            } else {
                c1.add(Calendar.DATE, 1);           // 比较天数，日期+1     
            }
        }
        n = n - 1;
        if (stype == 2) {
            n = (int) n / 365;
        }
        return n;
    }

    /**
     * 比较两个时间相差多少小时(分钟、秒)
     *
     * @param startTime 需要比较的时间 不能为空，且必须符合正确格式：2012-12-12 12:12:
     * @param endTime   需要被比较的时间 若为空则默认当前时间
     * @param type      1：小时   2：分钟   3：秒
     * @return int
     * @author chenssy
     * @date Jan 2, 2014
     */
    public static int compareTime(String startTime, String endTime, int type) {
        //endTime是否为空，为空默认当前时间
        if (endTime == null || "".equals(endTime)) {
            endTime = getCurrentTime();
        }

        SimpleDateFormat sdf = DateFormatUtils.getFormat("");
        int value = 0;
        try {
            Date begin = sdf.parse(startTime);
            Date end = sdf.parse(endTime);
            long between = (end.getTime() - begin.getTime()) / 1000;  //除以1000转换成豪秒
            if (type == 1) {   //小时
                value = (int) (between % (24 * 36000) / 3600);
            } else if (type == 2) {
                value = (int) (between % 3600 / 60);
            } else if (type == 3) {
                value = (int) (between % 60 / 60);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * 比较两个日期的大小。<br>
     * 若date1 > date2 则返回 1<br>
     * 若date1 = date2 则返回 0<br>
     * 若date1 < date2 则返回-1
     *
     * @param date1
     * @param date2
     * @param format 待转换的格式
     * @return 比较结果
     * @autor:chenssy
     * @date:2014年9月9日
     */
    public static int compare(String date1, String date2, String format) {
        DateFormat df = DateFormatUtils.getFormat(format);
        try {
            Date dt1 = df.parse(date1);
            Date dt2 = df.parse(date2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    /**
     * 获取指定月份的第一天
     *
     * @param date
     * @return
     * @author : chenssy
     * @date : 2016年5月31日 下午5:31:10
     */
    public static String getMonthFirstDate(String date) {
        date = DateFormatUtils.formatDate(date);
        return DateFormatUtils.formatDate(date, "yyyy-MM") + "-01";
    }

    /**
     * 获取指定月份的最后一天
     *
     * @param date
     * @return
     * @author : chenssy
     * @date : 2016年5月31日 下午5:32:09
     */
    public static String getMonthLastDate(String date) {
        Date strDate = DateUtils.string2Date(getMonthFirstDate(date));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(strDate);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        return DateFormatUtils.formatDate(calendar.getTime());
    }

    /**
     * 获取所在星期的第一天
     * 周一时第一天
     *
     * @param date
     * @return
     * @date : 2016年6月1日 下午12:38:53
     */
    public static Date getFirstDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
        return c.getTime();
    }

    /**
     * 获取所在星期的第一天
     * 周日时第一天
     *
     * @param date
     * @return
     * @date : 2016年6月1日 下午12:38:53
     */
    public static Date getFirstDayOfWeekS(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.SUNDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
        return c.getTime();
    }

    /**
     * 获取所在星期的最后一天
     *
     * @param date
     * @return
     * @author : chenssy
     * @date : 2016年6月1日 下午12:40:31
     */
    @SuppressWarnings("static-access")
    public static Date getWeektLastDate(Date date) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        int today = now.get(Calendar.DAY_OF_WEEK);
        int first_day_of_week = now.get(Calendar.DATE) + 2 - today; // 星期一
        int last_day_of_week = first_day_of_week + 6; // 星期日
        now.set(Calendar.DATE, last_day_of_week);
        return now.getTime();
    }

    /**
     * 获取所在星期的最后一天
     *
     * @param date
     * @return
     * @date : 2016年6月1日 下午12:40:31
     */
    public static Date getLastDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
        return c.getTime();
    }

    /**
     * 获取所在星期的最后一天
     *
     * @param date
     * @return
     * @date : 2016年6月1日 下午12:40:31
     */
    public static Date getLastDayOfWeekS(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.SUNDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
        return c.getTime();
    }

    /**
     * 获取当前系统时间  yyyyMMddHHddss
     *
     * @return
     */
    public static String getCurrentDayTime() {
        return getCurrentTime(DateFormatUtils.TIME_NOFUll_FORMAT);
    }

    /**
     * 获取时间是周几
     *
     * @param value
     * @return
     */
    public static Integer getWeek(String value) {
        Date date = string2Date(value, DateFormatUtils.DATE_FORMAT1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK) - 1;
    }

    public static String toChineseDate(int date){
        return "星期"+"日一二三四五六".charAt(date-1);
    }

    public static String toWeek(String value) {
        String week = "";
        switch (value) {
            case "1":
                week = "星期一";
                break;
            case "2":
                week = "星期二";
                break;
            case "3":
                week = "星期三";
                break;
            case "4":
                week = "星期四";
                break;
            case "5":
                week = "星期五";
                break;
            case "6":
                week = "星期六";
                break;
            case "7":
                week = "星期日";
                break;
        }

        return week;
    }

    /**
     * 获取下周的时间集合
     *
     * @return
     */
    public static List<String> getNextWeek() {
        List<String> weekList = new ArrayList<>();
        Date date = getWeektLastDate(new Date());
        for (int i = 1; i <= 7; i++) {
            String week = addDayToDate(i, date, "yyyy-MM-dd");
            weekList.add(week);
        }
        return weekList;
    }


    /**
     * 根据周获取日期（包括今天）
     *
     * @param weekList ['1','2'...]
     * @return
     */
    public static List<String> getNextDate(List<String> weekList) {
        List<String> weeks = new ArrayList<>();
        Integer week = getWeek(getCurrentTime("yyyy-MM-dd"));   //当前日期是周几
        Date date = getWeektLastDate(new Date());//本周最后一天
        for (String wl : weekList) {
            int w = Integer.parseInt(wl);
            if (week > w) {  //不是本周
                String newDate = DateUtils.addDayToDate(w, date, "yyyy-MM-dd");
                weeks.add(newDate);
            } else {
                String newDate = DateUtils.addDayToDate(w - week, DateUtils.getCurrentDayTime(), "yyyy-MM-dd");
                weeks.add(newDate);
            }
        }
        return weeks;
    }

    /**
     * Unix时间戳转换为数据库时间。。秒(10位)
     *
     * @param nowtime
     */
    public static String getUnixTransferTime(String nowtime) {
        Long timestamp = Long.parseLong(nowtime) * 1000;
        String date = new SimpleDateFormat("yyyyMMddHHmmss", Locale.CHINA).format(new Date(timestamp));
        return date;
    }

    /**
     * Unix时间戳转换为数据库时间。。毫秒(13位)
     *
     * @param nowtime
     */
    public static String getUnixTransferTime2(String nowtime) {
        Long timestamp = Long.parseLong(nowtime);
        String date = new SimpleDateFormat("yyyyMMddHHmmss", Locale.CHINA).format(new Date(timestamp));
        return date;
    }

    /**
     * 获取两个时间之间的天数
     *
     * @param time1
     * @param time12
     * @return
     */
    public static int differentDaysByMillisecond(String time1, String time12) {
        time1 = DateFormatUtils.formatDate(time1, DateFormatUtils.DATE_FORMAT1);
        time12 = DateFormatUtils.formatDate(time12, DateFormatUtils.DATE_FORMAT1);

        SimpleDateFormat sdf = new SimpleDateFormat(DateFormatUtils.DATE_FORMAT1);
        int days = 0;
        try {
            Date date1 = sdf.parse(time1);
            Date date2 = sdf.parse(time12);
            days = (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days;
    }



    /**
     * 获取两个时间之间的天数
     *
     * @param time1
     * @param time12
     * @return
     */
    public static int differentDaysByMillisecond(String time1, String time12,String format) {
        time1 = DateFormatUtils.formatDate(time1, format);
        time12 = DateFormatUtils.formatDate(time12, format);

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        int days = 0;
        try {
            Date date1 = sdf.parse(time1);
            Date date2 = sdf.parse(time12);
            days = (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days;
    }

    /**
     * 获得两个日期之间的所有月份；
     *
     * @param startdate 起始日期
     * @param enddate   截止日期
     * @return 两个月份之间的所有月份
     */
    public static List<String> getAllMonth(String startdate, String enddate) {
        String startMon = startdate.substring(0, 6);
        String endMon = enddate.substring(0, 6);
        List<String> dateList = new ArrayList<String>();
        if (startMon == null || startMon.length() == 0 ||
                endMon == null || endMon.length() == 0) {
            return dateList;
        }

        try {
            SimpleDateFormat startDF = new SimpleDateFormat("yyyyMM");
            startDF.parse(startMon);
            Calendar startCal = startDF.getCalendar();
            SimpleDateFormat endDF = new SimpleDateFormat("yyyyMM");
            endDF.parse(endMon);
            Calendar endCal = endDF.getCalendar();

            while (startCal.before(endCal)) {
                dateList.add(formatMonth(startCal.getTime(), 1));
                startCal.add(Calendar.MONTH, 1);
            }
            dateList.add(endMon);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dateList;
    }

    /**
     * 获得两个日期之间的所有日期；
     *
     * @param startDay 起始日期 yyyyMMdd
     * @param endDay   截止日期 yyyyMMdd
     * @return 两个月份之间的所有日期 yyyyMMdd
     */
    public static List<String> getAllDate(String startDay, String endDay) {
        List<String> dateList = new ArrayList();
        try {
            if (ObjectUtils.isEmpty(startDay) || ObjectUtils.isEmpty(endDay)) {
                return dateList;
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            Date begin = sdf.parse(startDay);
            Date end = sdf.parse(endDay);
            double between = (end.getTime() - begin.getTime()) / 1000;//除以1000是为了转换成秒
            double day = between / (24 * 3600);
            for (int i = 0; i <= day; i++) {
                Calendar cd = Calendar.getInstance();
                cd.setTime(sdf.parse(startDay));
                cd.add(Calendar.DATE, i);//增加一天
                dateList.add(sdf.format(cd.getTime()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dateList;
    }

    /**
     * 由日期获取日期所在月份
     *
     * @param date 日期变量，如2003-3-3
     * @param type (1表示当前日期的字符串格式,如"200612" ,2表示当前日期的日期格式,如"2006-12")
     * @return 月份
     */
    public static String formatMonth(Date date, int type) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat bartDateFormat = null;
        if (type == 1) {
            bartDateFormat = new SimpleDateFormat("yyyyMM");
        }
        if (type == 2) {
            bartDateFormat = new SimpleDateFormat("yyyy-MM");
        }
        String disp = bartDateFormat.format(date);
        return disp;
    }


    /**
     * 根据输入年月获取其上一个月份(YYYYMM)
     *
     * @param yearMonth 年月
     * @return 日期(YYYYMM)
     */
    public static String getPreMonth(String yearMonth) {
        int year = Integer.parseInt(yearMonth.substring(0, 4));
        int month = Integer.parseInt(yearMonth.substring(4, 6));
        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, 1);
        c.add(Calendar.DATE, -1);
        String mon;
        if (c.get(Calendar.MONTH) + 1 < 10) {
            mon = "0" + String.valueOf(c.get(Calendar.MONTH) + 1);
        } else
            mon = String.valueOf(c.get(Calendar.MONTH) + 1);

        return String.valueOf(c.get(Calendar.YEAR)) + mon;

    }

    public static String getPreDay(String thisDay){
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        date = calendar.getTime();
        SimpleDateFormat format= new SimpleDateFormat("yyyyMMdd");
        return format.format(date);
    }

    /**
     * 格式化指定字符串格式的日期
     *
     * @param oldFormat 与传入的dateStr格式对应 如:yyyyMMddHHmmss
     * @param newFormat 转换后的格式 如:yyyyMMddHHmmss
     * @param dateStr   传入的时间字符串
     * @return 当前时间
     */
    public static String format(String oldFormat, String newFormat, String dateStr) {
        String formatString = "";
        try {
            formatString = new SimpleDateFormat(newFormat).format(new SimpleDateFormat(oldFormat).parse(dateStr));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatString;
    }

    /**
     * @param start 起始日期
     * @param end   结束日期
     * @return
     * @auth 获取两个日期之间的日期
     */
    public static List<String> getDateFromTwoDate(String start, String end) {
        start = DateFormatUtils.formatDate(start, DateFormatUtils.DATE_FORMAT1);
        end = DateFormatUtils.formatDate(end, DateFormatUtils.DATE_FORMAT1);

        SimpleDateFormat sdf = new SimpleDateFormat(DateFormatUtils.DATE_FORMAT1);
        List<String> list = new ArrayList<String>(); //保存日期集合
        try {
            Date date_start = sdf.parse(start);
            Date date_end = sdf.parse(end);
            Date date = date_start;
            Calendar cd = Calendar.getInstance();//用Calendar 进行日期比较判断
            while (date.getTime() <= date_end.getTime()) {
                list.add(sdf.format(date));
                cd.setTime(date);
                cd.add(Calendar.DATE, 1);//增加一天 放入集合
                date = cd.getTime();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * @param start 起始日期
     * @param end   结束日期
     * @return
     * @auth 获取两个日期之间的日期
     */
    public static List<String> getDateFromTwoDate(String start, String end,String format) {
        start = DateFormatUtils.formatDate(start,format);
        end = DateFormatUtils.formatDate(end,format);

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        List<String> list = new ArrayList<String>(); //保存日期集合
        try {
            Date date_start = sdf.parse(start);
            Date date_end = sdf.parse(end);
            Date date = date_start;
            Calendar cd = Calendar.getInstance();//用Calendar 进行日期比较判断
            while (date.getTime() <= date_end.getTime()) {
                list.add(sdf.format(date));
                cd.setTime(date);
                cd.add(Calendar.DATE, 1);//增加一天 放入集合
                date = cd.getTime();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 判断是否是闰年
     *
     * @param year
     * @return
     */
    public static Boolean isLeap(int year) {
        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        } else if (year % 100 == 0 && year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断日期是否合法
     *
     * @param dateTime yyyy-MM-dd
     * @return
     */
    public static Boolean isValidDate(String dateTime) {
        dateTime = DateFormatUtils.formatDate(dateTime, DateFormatUtils.DATE_NOFUll_FORMAT);
        int year = Integer.valueOf(dateTime.substring(0, 4));
        int month = Integer.valueOf(dateTime.substring(4, 6));
        int day = Integer.valueOf(dateTime.substring(6, 8));
        if (year > 0 && month > 0 && month < 13 && day > 0 && day < 32) {
            if (month == 2) {
                if (isLeap(year) && day < 30) {
                    return true;
                }
                if (!isLeap(year) && day < 29) {
                    return true;
                }
            } else if ((month == 4 || month == 6 || month == 9 || month == 11) && day < 31) {
                return true;
            } else if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10
                    || month == 12)) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    /**
     * 验证是否是合法的时间
     * @param time
     * @return
     */
    public static boolean isValidTime(String time) {
        String yyyyMMddHHmmss = "^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})([-\\/\\._]{0,1})(((0[13578]|1[02])([-\\/\\._]{0,1})(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)([-\\/\\._]{0,1})(0[1-9]|[12][0-9]|30))|(02([-\\/\\._]{0,1})(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))([-\\/\\._]{0,1})02([-\\/\\._]{0,1})29))\\s{0,1}(([01][0-9]|2[0-3])\\:{0,1}([0-5][0-9])\\:{0,1}([0-5][0-9]))$";
        return Pattern.compile(yyyyMMddHHmmss).matcher(time).find();
    }
    /**
     * 获得两个时间段之内的所有日期小时：例如传参数："2019112901"和"2019112903",
     * 返回结果：[2019112901,2019112902,2019112903]
     * @param beginDate 开始时间
     * @param endDate 结束时间
     */
    public static List<String> getHoursBetweenTwoDate(String beginDate,String endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
        List<String> lDate = new ArrayList<String>();
        lDate.add(beginDate);// 把开始时间加入集合
        Calendar cal = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        try {
            cal.setTime(sdf.parse(beginDate));
            boolean bContinue = true;
            while (bContinue) {
                // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
                cal.add(Calendar.HOUR, 1);
                // 测试此日期是否在指定日期之后
                if (sdf.parse(endDate).after(cal.getTime())) {
                    lDate.add(sdf.format(cal.getTime()));
                } else {
                    break;
                }
            }
            lDate.add(endDate);// 把结束时间加入集合
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lDate;
    }

    /**
     * 判断当前时间在某个时间段内
     * @param nowTime 当前时间
     * @param beginTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    public static boolean belongCalendar(Date nowTime, Date beginTime,
                                         Date endTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);
        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);
        Calendar end = Calendar.getInstance();
        end.setTime(endTime);
        //配置时段类似于  beginTime：07：00   endTime：00：30  时，结束时段天数加一天
        if (endTime.getHours() < beginTime.getHours()) {
            end.add(Calendar.DATE, 1);
        } else if (endTime.getHours() == beginTime.getHours()) {
            if (endTime.getMinutes() < beginTime.getMinutes()) {
                end.add(Calendar.DATE, 1);
            }
        }
        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取指点时间段的小时列表   比如给定  timeBegin：2019122600  timeEnd:2019122623   返回的是  2019122600  2019122601 。。。。 2019122623 等时间列表，该列表的样式可以指定
     * @param resultTimeStyle 返回的时间日期格式
     * @param interval   间隔单位  一般取1
     * @return
     */
    public static List<String> getHourRangeList(Date begin,Date end,String resultTimeStyle,int interval){
        Calendar beginCalendar = Calendar.getInstance();
        beginCalendar.setTime(begin);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(end);
        List<String> timeList = new ArrayList<>();
        // 计算小时
        while(beginCalendar.compareTo(endCalendar)<=0){// beginCalendar < endCalendar
            String hourStr = dateToString(beginCalendar.getTime(),resultTimeStyle);
            timeList.add(hourStr);
            beginCalendar.add(Calendar.HOUR, interval);
        }
        return timeList;
    }

    /**
     * 获取指点时间段的天列表   比如给定  timeBegin：2019122600  timeEnd:2019122923   返回的是  20191226  20191227 。。。。 20191229 等时间列表，该列表的样式可以指定
     * @param resultTimeStyle 返回的时间日期格式
     * @param interval   间隔单位  一般取1
     * @return
     */
    public static List<String> getDayRangeList(Date begin,Date end,String resultTimeStyle,int interval){
        Calendar beginCalendar = Calendar.getInstance();
        beginCalendar.setTime(begin);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(end);
        List<String> timeList = new ArrayList<>();
        // 计算天
        while(beginCalendar.compareTo(endCalendar)<=0){// beginCalendar < endCalendar
            String hourStr = dateToString(beginCalendar.getTime(),resultTimeStyle);
            timeList.add(hourStr);
            beginCalendar.add(Calendar.HOUR, 24*interval);
        }
        return timeList;
    }

    /**
     * 获取指点时间段的天列表   比如给定  timeBegin：2019122600  timeEnd:2019122923   返回的是  20191226  20191227 。。。。 20191229 等时间列表，该列表的样式可以指定
     * @param resultTimeStyle 返回的时间日期格式
     * @param interval   间隔单位  一般取1
     * @return
     */
    public static List<String> getMonthRangeList(Date begin,Date end,String resultTimeStyle,int interval){
        Calendar beginCalendar = Calendar.getInstance();
        beginCalendar.setTime(begin);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(end);
        List<String> timeList = new ArrayList<>();
        // 计算天
        while(beginCalendar.compareTo(endCalendar)<=0){// beginCalendar < endCalendar
            String hourStr = dateToString(beginCalendar.getTime(),resultTimeStyle);
            timeList.add(hourStr);
            beginCalendar.add(Calendar.MONTH, interval);
        }
        return timeList;
    }

    /**
     * 比较两个时间字符串，是否相差时间内
     * @param src 源时间 YyyyMMddhhmmss
     * @param dst 目的时间 YyyyMMddhhmmss
     * @param call 相差时间单位 y-年，M-月，d-日 ,h-时，m-分，s-秒
     * @param value 相差时间值
     * @return  0-相差value，小于0-小于相差值，大于0-大于相差值
     */
    public static int compareTo_Date(String src,String dst,char call,int value)
    {
        int year = Integer.parseInt(dst.substring(0, 4));
        int month = Integer.parseInt(dst.substring(4, 6));
        int day = Integer.parseInt(dst.substring(6, 8));
        int hour = Integer.parseInt(dst.substring(8, 10));
        int minute = Integer.parseInt(dst.substring(10, 12));
        int second = Integer.parseInt(dst.substring(12, 14));
        Calendar cal = Calendar.getInstance();
        cal.set(year,month-1,day,hour,minute,second);
        switch (call) {
            case 'y':
                cal.add(Calendar.YEAR, value);
                break;
            case 'M':
                cal.add(Calendar.MONTH, value);
                break;
            case 'd':
                cal.add(Calendar.DAY_OF_MONTH, value);
                break;
            case 'h':
                cal.add(Calendar.HOUR_OF_DAY, value);
                break;
            case 'm':
                cal.add(Calendar.MINUTE, value);
                break;
            case 's':
                cal.add(Calendar.SECOND, value);
                break;
            default:
                break;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String strDate = dateFormat.format(cal.getTime());
        return src.compareTo(strDate);
    }

    /**
     * 获取上个月的日期
     * @return
     */
    public static String getLastMonth() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -1);
        Date m = c.getTime();
        String mon = format.format(m);
        //System.out.println("过去一个月："+mon);
        return mon;
    }

    /**
     * 根据日期获取当天起始时间
     *
     * @param date
     * @return
     */
    public static Date getStartDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取当前时间是周几  1：周一  2：周二   等等
     * @return
     */
    public static String getDayOfWeek(Date date) {
        String[] weekNames = {"7","1","2","3","4","5","6"};
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int week = c.get(Calendar.DAY_OF_WEEK);
        return weekNames[week-1];
    }

    /**
     * 获取当前时间是周几  1：周一  2：周二   等等
     * @return
     */
    public static String getDayOfWeek(String yyyyMMddHHmmssDateStr) {
        Date date = DateUtils.stringToDate(yyyyMMddHHmmssDateStr,DateUtils.yyyyMMddHHmmss);
        return getDayOfWeek(date);
    }

    /**
     * 根据周几 和某个时间日期字符串，得到该周几的时间日期字符串
     * @return
     */
    public static String getDateFromDayOfWeek(String yyyyMMddHHmmssDateStr,String weekName,String dateFormat) {
        String[] weekNames = {"7","1","2","3","4","5","6"};
        int weekIndex = -1;
        for(int i=0;i<weekNames.length;i++){
            if(weekNames[i].equalsIgnoreCase(weekName)){
                weekIndex = i;
                break;
            }
        }
        if(weekIndex>-1){
            Date date = DateUtils.stringToDate(yyyyMMddHHmmssDateStr,DateUtils.yyyyMMddHHmmss);
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.set(Calendar.DAY_OF_WEEK,weekIndex+1);
            return DateUtils.dateToString(c.getTime(),dateFormat);
        }
        return null;
    }

    /**
     * 获取给定时间，现在的小时
     * @return
     */
    public static int getHour(Date date) {
        String format = "HH";
        return Integer.parseInt(dateToString(date,format));
    }


    /**
     * 获取某个月的所有日期
     * @param date
     * @return
     */
    public static List<String> getMonthFullDay(String date) {
        List<String> fullDayList = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(4, 6));
        int day = 1;// 所有月份从1号开始
        Calendar cal = Calendar.getInstance();// 获得当前日期对象
        cal.clear();// 清除信息
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);// 1月从0开始
        cal.set(Calendar.DAY_OF_MONTH, day);
        int count = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int j = 0; j <= (count - 1); ) {
            if (sdf.format(cal.getTime()).equals(getLastDay(year,month)))
                break;
            cal.add(Calendar.DAY_OF_MONTH, j == 0 ? +0 : +1);
            j++;
            fullDayList.add(sdf.format(cal.getTime()));
        }
        return fullDayList;
    }

    /**
     * 获取月的最后一天
     * @param year
     * @param month
     * @return
     */
    public static String getLastDay(int year, int month) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, 0);
        return sdf.format(cal.getTime());
    }

    public static void main(String[] args) {
        System.out.println(getLastDay(Integer.valueOf(getCurrentTime("yyyy")),Integer.valueOf(getCurrentTime("MM"))));
        System.out.println(toChineseDate(4));
    }

    public static String dealDateFormat(String oldDate) {
        Date date1 = null;
        DateFormat df2 = null;
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date = df.parse(oldDate);
            SimpleDateFormat df1 = new SimpleDateFormat ("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
            date1 = df1.parse(date.toString());
            df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        } catch (ParseException e) {

            e.printStackTrace();
        }
        return df2.format(date1);
    }

    /**
     * 获取时间是本月的第几周
     * @param dateString 日期
     * @return
     */
    public static Integer getWeekOfMonth(String dateString){
        int weekOfMonth = 0;
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(dateString);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);
        }catch (Exception e){
            e.printStackTrace();
        }
        return weekOfMonth;
    }

    /**
     * 获取两个时间之间的周
     *
     * @param startDay 开始日期
     * @param endDay   结束日期
     * @param type     类型 0:第一天从周日开始  1:第一天从周一开始
     * @return
     */
    public static int getWeekNum(String startDay, String endDay, int type, String format) {
        String newFormart = DateFormatUtils.DATE_NOFUll_FORMAT;
        startDay = format(format, newFormart, startDay);
        endDay = format(format, newFormart, endDay);

        int week = 0;
        String s = "";
        if (type == 0) {  //第一天从周日开始
            s = DateUtils.date2String(DateUtils.getLastDayOfWeekS(DateUtils.string2Date(startDay, newFormart)), newFormart);
        } else {
            s = DateUtils.date2String(DateUtils.getLastDayOfWeek(DateUtils.string2Date(startDay, newFormart)), newFormart);
        }
        //本周最后一天 大于等于  结束时间
        if (DateUtils.compare(s, endDay, newFormart) >= 0) {
            week = 1;
        } else {
            //第二周第一天
            String s2 = DateUtils.addDayToDate(1, s, newFormart);

            //结束时间的所在周的第一天
            String s1 = "";
            if (type == 0) {  //第一天从周日开始
                s1 = DateUtils.date2String(DateUtils.getFirstDayOfWeekS(DateUtils.string2Date(endDay, newFormart)), newFormart);
            } else {
                s1 = DateUtils.date2String(DateUtils.getFirstDayOfWeek(DateUtils.string2Date(endDay, newFormart)), newFormart);
            }
            //第二周的第一天  大于等于  最后一周的第一天
            if (DateUtils.compare(s2, s1, newFormart) == 0) {
                week = 2;
            } else if (DateUtils.compare(s2, s1, newFormart) < 0) {
                List<String> allDate = DateUtils.getAllDate(s2, s1);
                int a = (allDate.size() - 1) / 7;
                week = a + 2;
            } else {
                week = 1;
            }

        }
        return week;
    }

    /**
     * unix时间戳 转为日期
     * @param timestampString 时间戳
     * @param formats   格式
     * @return
     */
    public static String TimeStamp2Date(String timestampString, String formats) {
        if (TextUtils.isEmpty(formats))
            formats = "yyyy-MM-dd HH:mm:ss";
        Long timestamp = Long.parseLong(timestampString) * 1000;
        String date = new SimpleDateFormat(formats, Locale.CHINA).format(new Date(timestamp));
        return date;
    }


    /**
     * 传入Data类型日期，返回字符串类型时间（ISO8601标准时间）
     * @param date
     * @return
     */
    public static String getISO8601Timestamp(Date date){
        TimeZone tz = TimeZone.getTimeZone("Asia/Shanghai");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        df.setTimeZone(tz);
        String nowAsISO = df.format(date);
        return nowAsISO;
    }

    public static long getCurrentMonthRemainingTime (LocalDateTime now) {
        LocalDateTime target = now.withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0).withNano(0).plusMonths(1);
        Duration duration = Duration.between(now, target);
        return duration.getSeconds();
    }
    
}

