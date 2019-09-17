package spring.boot.com.mySpike;

import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: yqq
 * @date: 2019/4/17
 * @description: 秒杀功能
 */
public class MyTest {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static Jedis jedis = MyJedis.getJedisObject();
    private static String KEY = "num_all";
    private static int threadCount = 1009;
    public static void main(String[] args) {
        jedis.set(KEY, "1000");
        TestM m = new TestM();
        ExecutorService exec = Executors.newFixedThreadPool(threadCount);
        for (int i = 0; i < threadCount; i++) {
            exec.submit(m);
        }
    }

    static class TestM extends Thread{
        @Override
        public void run() {
            String key = "testLock";
            String value = MyLock.getLockValue();
            MyLock.lock(key, value);
            try {
                int num = Integer.valueOf(jedis.get(KEY));
                if(num >0){
                    jedis.decr(KEY);
                }else {
                    System.out.println(sdf.format(new Date()) + "已售完");
                }
            } finally {
                MyLock.unlock(key, value);
            }
        }
    }
}
