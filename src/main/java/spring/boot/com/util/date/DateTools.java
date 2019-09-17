package spring.boot.com.util.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author: yiqq
 * @date: 2019/3/25
 * @description: Date相关操作
 */
public class DateTools {
    private static final long DAY_TIME = 86400000L;
    public static void main(String[] args) throws Exception {
        System.out.println(getDays("2018-01-01", "2018-01-10"));//获取两个日期之间的所有日期
        System.out.println(parseString2Date("2019-3-25 11:13:51","yyyy-MM-dd"));//字符串转Date
        System.out.println(turnDateZoneToNormalDate("23/Oct/2018:00:00:06 +0800", "yyyy-MM-dd HH:mm:ss"));//转换带时区的日期字符串为普通时间字符串
        System.out.println(getForm("2019-03-25"));//将yyyy-MM-dd转换成yyyyMMdd
        System.out.println(getYesterday("2019-03-25"));//获取yyyy-MM-dd的前一天，格式不变
        System.out.println(dateToString(turnDateZoneToNormalDate("23/Oct/2018:00:00:06 +0800", "yyyy-MM-dd HH:mm:ss")));//Date转yyyy-MM-dd HH:mm:ss
        System.out.println(getMonthFirstDay());//获取当月第一天的时间戳
        System.out.println(longToString(getMonthFirstDay()));//时间戳2转化为yyyy-MM-dd HH:mm:ss
        isDayFirst();
        getDays();
        getDateFormat();
    }
    /**
     * 获取两个日期之间的所有日期
     * startTime 开始日期
     * endTime 结束日期
     * */
    public static List<String> getDays(String startTime, String endTime) {

        // 返回的日期集合
        List<String> days = new ArrayList<String>();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date start = dateFormat.parse(startTime);
            Date end = dateFormat.parse(endTime);

            Calendar tempStart = Calendar.getInstance();
            tempStart.setTime(start);

            Calendar tempEnd = Calendar.getInstance();
            tempEnd.setTime(end);
            tempEnd.add(Calendar.DATE, +1);// 日期加1(包含结束)
            while (tempStart.before(tempEnd)) {
                days.add(dateFormat.format(tempStart.getTime()));
                tempStart.add(Calendar.DAY_OF_YEAR, 1);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return days;
    }

    /**
     * 字符串转date
     * @param date
     * @param p
     * @return
     */
    public static Date parseString2Date(String date,String p){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf = new SimpleDateFormat(p);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 转换带时区的日期字符串为普通时间字符串
     * @param dateZone 参数格式：dd/MMM/yyyy:hh:mm:ss Z
     * @param pattern
     * @return
     */
    public static Date turnDateZoneToNormalDate(String dateZone,String pattern) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy:hh:mm:ss Z", Locale.ENGLISH);
        SimpleDateFormat sdfDate = new SimpleDateFormat(pattern);
        try{
            return sdfDate.parse(sdfDate.format(sdf.parse(dateZone)));
        }catch (ParseException e){
            e.printStackTrace();
            throw e;
        }
    }

    /**将yyyy-MM-dd转换成yyyyMMdd*/
    public static String getForm(String str) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setLenient(false);
        Date newDate= formatter.parse(str);
        formatter = new SimpleDateFormat("yyyyMMdd");
        return formatter.format(newDate);
    }

    /**获取yyyy-MM-dd的前一天，格式不变*/
    public static String getYesterday(String str) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(str);
        date = new Date(date.getTime() - DAY_TIME);
        String message = sdf.format(date);
        return message;
    }

    /**
     * Date转yyyy-MM-dd HH:mm:ss
     * @param date
     * @return
     */
    public static String dateToString(Date date){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取当月第一天的时间戳
     * @return
     */
    public static Long getMonthFirstDay(){
        long first = 0;
        try {
            Date date = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            //设置为1号,当前日期既为本月第一天
            c.set(Calendar.DAY_OF_MONTH, 1);
            //将小时至0
            c.set(Calendar.HOUR_OF_DAY, 0);
            //将分钟至0
            c.set(Calendar.MINUTE, 0);
            //将秒至0
            c.set(Calendar.SECOND,0);
            //将毫秒至0
            c.set(Calendar.MILLISECOND, 0);
            first =c.getTimeInMillis();
        } catch (Exception e) {
            first = 0;
            System.out.println("获取当月第一天时间戳错误:"+e.getMessage());
        }
        return first;
    }

    public static String longToString(Long start){
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dateStart = new Date(Long.valueOf(start));
            String startTime = simpleDateFormat.format(dateStart);
            return startTime;
        } catch (Exception e) {
            System.out.println("参数时间戳转化为yyyy-MM-dd出错，出错信息为："+e.getMessage());
            return null;
        }

    }

    /**
     * 判断是否当月第一天
     */
    public static void isDayFirst(){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
        String dates = dateFormat.format( now );
        System.out.println("当前日期:" + dates);
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int date = c.get(Calendar.DATE);
        if(date == 1)
            System.out.println(dates + "是第一天");
        else
            System.out.println(dates + "不是第一天");
    }
    /**
     * java获取 昨天 今天 明天的日期
     */
    public static void getDays(){
        Date date=new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE,-1);//把日期往后增加一天.整数往后推,负数往前移动
        date=calendar.getTime(); //这个时间就是日期往后推一天的结果
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);
        System.out.println(dateString);
    }

    /**Instant代替 Date，LocalDateTime代替 Calendar，DateTimeFormatter 代替 SimpleDateFormat*/
    public static void getDateFormat(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.now();
        String str = formatter.format(time);
        System.out.println("---------->>>>>>>>>>" + str);
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate times = LocalDate.now();
        String str1 = formatter1.format(times);
        System.out.println("---------->>>>>>>>>>" + str1);
    }
}
