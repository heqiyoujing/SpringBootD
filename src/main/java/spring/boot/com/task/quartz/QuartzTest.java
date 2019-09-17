package spring.boot.com.task.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;


/**
 * @author: yiqq
 * @date: 2019/2/21
 * @description:  Quartz使用
 * https://www.cnblogs.com/drift-ice/p/3817269.html
 */
public class QuartzTest {
    public static void main(String[] args) {
        Quart(HelloQuartz.class,"*/3 * * * * ?");
    }


    private static void Quart(Class<? extends Job> clazz,String cron) {
        try {
            //创建scheduler
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            //定义一个Trigger
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1") //定义name/group
                    .startNow()//一旦加入scheduler，立即生效
//                    .withSchedule(simpleSchedule().withIntervalInSeconds(1).repeatForever()) //使用SimpleTrigger,每隔一秒执行一次,一直执行，奔腾到老不停歇
                    .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                    .build();

            //定义一个JobDetail
            JobDetail job = JobBuilder.newJob(clazz) //定义Job类为HelloQuartz类，这是真正的执行逻辑所在
                    .withIdentity("job1", "group1") //定义name/group
                    .usingJobData("name", "Quart") //定义属性
                    .build();

            //加入这个调度
            scheduler.scheduleJob(job, trigger);

            //启动之
            scheduler.start();

            //运行一段时间后关闭
            Thread.sleep(10000);
            scheduler.shutdown(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
