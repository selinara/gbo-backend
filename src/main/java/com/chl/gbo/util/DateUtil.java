package com.chl.gbo.util;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class DateUtil {

    private static final Log logger = LogFactory.getLog(DateUtil.class);

    private static final DateTimeFormatter df = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 当前时间
     * yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String now(){
        return DateTime.now().toString(df);
    }

    /**
     * 当前日期剩余的毫秒数
     * @return
     */
    public static Long todayLessTime(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return (cal.getTimeInMillis() - new Date().getTime()) / 1000;
    }

    /**
     * 判断日期是否过期
     * 未过期返回true
     * 过期返回false
     * @param date
     * @return
     */
    public static Boolean dateNotExpired(String date){
        try {
            return new Date().before(DateTime.parse(date, df).toDate());
        } catch (Exception e){
            logger.error(String.format("dateIsOverdue date %s error", date), e);
            return false;
        }
    }

    /**
     * 返回当前时间之后固定时长时间
     * @param time
     * @return
     */
    public static String after(Long time){
        return new DateTime(new DateTime().getMillis() + time).toString(df);
    }


    /**
     * 判断日期是否过期
     * @param originDate 源日期
     * @param days 有效期
     * @return
     */
    public static Boolean dateNotExpired(Date originDate, Integer days){
        try {
            return DateTime.now().minusDays(days).toDate().after(originDate);
        } catch (Exception e){
            logger.error(String.format("dateNotExpired date %s error", originDate.getTime()), e);
            return false;
        }
    }

    /**
     * 年转毫秒值
     * @param year
     * @return
     */
    public static Long yearToMillisecond(int year){
        DateTime now = DateTime.now();
        return now.plusYears(year).toDate().getTime()-now.toDate().getTime();
    }

}
