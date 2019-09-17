package spring.boot.com.single;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: yiqq
 * @date: 2019/5/7
 * @description: 使用CAS实现单例
 * 这种方式实现的单例优缺点：
 * 1.优点：不需要使用传统的锁机制来保证线程安全，没有线程切换和阻塞的额外消耗,可以支持较大的并行度。
 * 2.缺点：如果忙等待一直执行不成功(一直在死循环中),会对CPU造成较大的执行开销；
 *         如果N个线程同时执行到singleton = new Singleton();的时候，会有大量对象创建，很可能导致内存溢出。
 */
public class SingletonCAS {
    private static final AtomicReference<SingletonCAS> INSTANCE = new AtomicReference<SingletonCAS>();

    private SingletonCAS(){}

    public static SingletonCAS getInstance(){
        for (;;) {
            SingletonCAS singletonCAS = INSTANCE.get();
            if (null != singletonCAS) {
                return singletonCAS;
            }

            singletonCAS = new SingletonCAS();
            if (INSTANCE.compareAndSet(null, singletonCAS)) {
                return singletonCAS;
            }
        }
    }
}
