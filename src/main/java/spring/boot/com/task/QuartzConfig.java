package spring.boot.com.task;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: yiqq
 * @date: 2019/4/26
 * @description:
 */
@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail teatQuartzDetail(){

        return JobBuilder.newJob(QuartzTest.class).withIdentity("testQuartz").storeDurably().build();

    }

    @Bean
    public Trigger testQuartzTrigger(){

        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(3)  //设置时间周期单位秒
                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(teatQuartzDetail())

                .withIdentity("testQuartz")
                .withSchedule(scheduleBuilder)
                .build();

    }
}
