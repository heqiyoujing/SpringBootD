package spring.boot.com.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: yiqq
 * @date: 2019/4/26
 * @description:
 */
@Component
public class ScheduledService {
    @Scheduled(cron = "0/3 * * * * *")
    public void aTask(){
        try {
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(sdf.format(new Date())+"*********A任务每3秒执行一次进入测试");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
