package spring.boot.com.xianliu;

import com.google.common.util.concurrent.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author: yiqq
 * @date: 2019/4/12
 * @description: Guava的RateLimiter实现限流,RateLimiter控制的是速率
 * https://blog.csdn.net/fanrenxiang/article/details/80683378
 * https://mp.weixin.qq.com/s?__biz=MzAxNjk4ODE4OQ==&mid=2247485427&idx=1&sn=85b9f2a617773527fc0ed7a4746ed69a&chksm=9bed2681ac9aaf97838d47d49b3f2eb91bb242401a5d2bc08c26871d13b399cd6bef787e2e83&scene=0&xtrack=1#rd
 */
public class RateLimiterTest {
    private static Logger logger = LoggerFactory.getLogger(RateLimiterTest.class);
    public static void main(String[] args) {
//        testRateLimiter1();
//        testRateLimiter2();
//        testRateLimiter3();
//        testRateLimiter4();
        testRateLimiter5();

    }

    //限流
    private static void testRateLimiter1() {
        String start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        RateLimiter limiter = RateLimiter.create(1.0); // 这里的1表示每秒允许处理的量为1个
        for (int i = 1; i <= 10; i++) {
            limiter.acquire();// 请求RateLimiter, 超过permits会被阻塞
            logger.info("call execute.." + i);
        }
        String end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println("start time:" + start);
        System.out.println("end time:" + end);
    }

    //平滑突发限流
    private static void testRateLimiter2(){
        RateLimiter r = RateLimiter.create(5);//这里的1表示每秒允许处理的量为5个
        while (true) {
            logger.info("get 1 tokens: " + r.acquire() + "s");
        }
    }

    //RateLimiter使用令牌桶算法，会进行令牌的累积，如果获取令牌的频率比较低，则不会导致等待，直接获取令牌。
    private static void testRateLimiter3(){
        RateLimiter r = RateLimiter.create(2);//这里的1表示每秒允许处理的量为2个
        while (true) {
            logger.info("get 1 tokens: " + r.acquire(1) + "s");
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
            }
            logger.info("get 1 tokens: " + r.acquire(1) + "s");
            logger.info("get 1 tokens: " + r.acquire(1) + "s");
            logger.info("get 1 tokens: " + r.acquire(1) + "s");
            logger.info("get 1 tokens: " + r.acquire(1) + "s");
            logger.info("end");
        }
    }

    //RateLimiter在没有足够令牌发放时，采用滞后处理的方式，也就是前一个请求获取令牌所需等待的时间由
    // 下一次请求来承受，也就是代替前一个请求进行等待。
    private static void testRateLimiter4(){
        RateLimiter r = RateLimiter.create(5);//这里的1表示每秒允许处理的量为2个
        while (true) {
            logger.info("get 1 tokens: " + r.acquire(5) + "s");
            logger.info("get 1 tokens: " + r.acquire(1) + "s");
            logger.info("get 1 tokens: " + r.acquire(1) + "s");
            logger.info("get 1 tokens: " + r.acquire(1) + "s");
            logger.info("end");
        }
    }
    //平滑预热限流
    //由于设置了预热时间是3秒，令牌桶一开始并不会0.5秒发一个令牌，而是形成一个平滑线性下降的坡度，频率越来越高，在3秒钟
    // 之内达到原本设置的频率，以后就以固定的频率输出。这种功能适合系统刚启动需要一点时间来“热身”的场景。
    private static void testRateLimiter5(){
        RateLimiter r = RateLimiter.create(2,3, TimeUnit.SECONDS);//创建一个平均分发令牌速率为2，预热期为3分钟。
        while (true) {
            logger.info("get 1 tokens: " + r.acquire(1) + "s");
            logger.info("get 1 tokens: " + r.acquire(1) + "s");
            logger.info("get 1 tokens: " + r.acquire(1) + "s");
            logger.info("get 1 tokens: " + r.acquire(1) + "s");
            logger.info("end");
        }
    }
}
