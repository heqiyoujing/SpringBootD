package spring.boot.com.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author: yiqq
 * @date: 2019/4/17
 * @description: SimpleDateFormat多线程异常
 * https://mp.weixin.qq.com/s?__biz=MzI1NDQ3MjQxNA==&mid=2247488579&idx=1&sn=938bf5c4060f5758d57bb38a3d273523&chksm=e9c5edf2deb264e41895a296a71db6363a7c24d1574d1262b2a74d464c73871ab3dfb65920e6&scene=0&xtrack=1#rd
 */
public class SimpleDateFormatTest {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String formatdate(Date date){
        return sdf.format(date);
    }

    public static Date parse(String date) throws ParseException {
        return sdf.parse(date);
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(100);
        for(int i=0;i<20;i++) {
            service.execute(()->{
                for(int j=0;j<10;j++) {
                    try {
//                        System.out.println(parse("2019-04-17 10:00:00"));
                        System.out.println(parse2("2019-04-17 10:00:00"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        service.shutdown();//等待上述线程执行完
        service.awaitTermination(1, TimeUnit.DAYS);
    }

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String formatDate(LocalDateTime time){
        return formatter.format(time);
    }

    public static LocalDateTime parse2(String time) {
        return LocalDateTime.parse(time,formatter);
    }
}
