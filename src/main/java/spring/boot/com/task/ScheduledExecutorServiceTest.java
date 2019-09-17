package spring.boot.com.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: yiqq
 * @date: 2019/4/26
 * @description:
 */
public class ScheduledExecutorServiceTest {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

        // 参数：1、任务体 2、首次执行的延时时间
        //      3、任务执行间隔 4、间隔时间单位
        service.scheduleAtFixedRate(()->System.out.println("task ScheduledExecutorService "+new Date().toLocaleString()), 0, 3, TimeUnit.SECONDS);

    }
}
