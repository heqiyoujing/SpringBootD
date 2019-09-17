package spring.boot.com.task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author: yiqq
 * @date: 2019/4/26
 * @description: Spring Boot 实现定时任务的 4 种方式
 * https://mp.weixin.qq.com/s?__biz=MzI3ODcxMzQzMw==&mid=2247488967&idx=2&sn=e67b9e652eaea199525beaeed17e0682&chksm=eb5390f1dc2419e7ac48dc52deec704c17a76a73183d8e0420f8fbd2a68b75480230ab9f5513&scene=0&xtrack=1#rd
 */
public class TimerTest {

    private static Timer timer = new Timer(false);//参数为true，改为守护线程.

    public static void main(String[] args) {
        try {
            MyTask task = new MyTask();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = "2019-02-21 18:13:55";//计划时间早于当前时间，立即执行
            Date date = sdf.parse(dateString);
            System.out.println("字符串时间："+date.toLocaleString()+"当前时间："+new Date().toLocaleString());
            timer.schedule(task,date,3000);//守护线程,计划时间晚于当前时间,TimerTask任务不再进行;1s执行一次。
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    static public class MyTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("运行了！时间为："+new Date().toLocaleString());
        }
    }
}
