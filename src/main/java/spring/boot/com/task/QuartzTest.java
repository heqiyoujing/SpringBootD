package spring.boot.com.task;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @author: yiqq
 * @date: 2019/4/26
 * @description:
 */
public class QuartzTest extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("quartz ---> hello "+new Date().toLocaleString());
    }
}
