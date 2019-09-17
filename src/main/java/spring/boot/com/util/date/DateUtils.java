package spring.boot.com.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
    /**
     * 转换带时区的日期字符串为普通时间字符串
     * @param dateZone 参数格式：dd/MMM/yyyy:hh:mm:ss Z
     * @param pattern
     * @return
     */
    public static Date turnDateZoneToNormalDate(String dateZone, String pattern) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy:hh:mm:ss Z", Locale.ENGLISH);
        SimpleDateFormat sdfDate = new SimpleDateFormat(pattern);
        try{
            return sdfDate.parse(sdfDate.format(sdf.parse(dateZone)));
        }catch (ParseException e){
            e.printStackTrace();
            throw e;
        }
    }


    /**
     * Date 转化为字符串2019-03-27 00：00：00
     * @param date
     * @param format
     * @return
     */
    public static String date2String(Date date,String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /***
     * 获取date日期当月剩余的天数(包含当天)
     * @param date
     * @return
     */
    public static int getCurrentMonthSurplusDay(Date date){
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        int currentDayOfMonth = localDateTime.getDayOfMonth();
        int lastDayOfMonth = localDateTime.toLocalDate().with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
        return lastDayOfMonth-currentDayOfMonth+1;
    }

    /**
     * 获取历史年月的字符串
     * @param current 当前时间
     * @param num 距离当前月份的月份数
     * @return 例如：2017-08
     */
    public static String getHistoryYearMonthString(Date current,int num){
        Instant instant = current.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        if(num!=0) {
            Period monthNum = Period.ofMonths(num);
            localDateTime = localDateTime.minus(monthNum);
        }
        int year = localDateTime.getYear();
        String month = localDateTime.getMonth().getValue()<10?"0"+localDateTime.getMonth().getValue():localDateTime.getMonth().getValue()+"";

        return year+"-"+month;
    }

    //这两个方法使我们可以方便的实现将旧的日期类转换为新的日期类，具体思路都是通过Instant当中介，然后通过Instant来创建
    // LocalDateTime（这个类可以很容易获取LocalDate和LocalTime），新的日期类转旧的也是如此，将新的先转成LocalDateTime，
    // 然后获取Instant，接着转成Date，具体实现细节如下：

    public static void main(String[] args) throws Exception {
        Date date = turnDateZoneToNormalDate("24/Mar/2019:00:00:05 +0800","yyyy-MM-dd HH:mm:ss");
        String dates = date2String(date, "yyyy-MM-dd HH:mm:ss");
        System.out.println(dates);
        getCurrentMonthSurplusDay(date);
        System.out.println(getHistoryYearMonthString(date, 1));

        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println("------");

        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDate localDate1 = localDateTime.toLocalDate();
        LocalTime localTime = localDateTime.toLocalTime();

        LocalDateTime localDateTime1 = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * Date --> LocalDateTime
     */
    public static LocalDateTime dateToLocalDateTime() {
        java.util.Date date = new java.util.Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime;
    }

    /**
     * Date --> LocalDate
     */
    public static LocalDate dateToLocalDate() {
        java.util.Date date = new java.util.Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalDate localDate = localDateTime.toLocalDate();
        return localDate;
    }

    /**
     * Date --> LocalTime
     */
    public static LocalTime dateToLocalTime() {
        java.util.Date date = new java.util.Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalTime localTime = localDateTime.toLocalTime();
        return localTime;
    }

    /**
     * . java.time.LocalDateTime --> java.util.Date
     */
    public static Date localDateTimeToUdate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        Date date = Date.from(instant);
        return date;
    }

    /**
     *  java.time.LocalDate --> java.util.Date
     * @return
     */
    public static Date localDateToUdate() {
        LocalDate localDate = LocalDate.now();
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        Date date = Date.from(instant);
        return date;
    }

    /**
     * java.time.LocalTime --> java.util.Date
     */
    public static Date LocalTimeToUdate() {
        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        Date date = Date.from(instant);
        return date;
    }
}