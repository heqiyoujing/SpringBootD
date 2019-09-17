package spring.boot.com.threadLocal;

/**
 * @author: yiqq
 * @date: 2019/4/12
 * @description: 没有先set，直接get的话,先重写了initialValue方法：
 */
public class Test {
    ThreadLocal<Long> longLocal = ThreadLocal.withInitial(() -> Thread.currentThread().getId());
    ThreadLocal<String> stringLocal = ThreadLocal.withInitial(() -> Thread.currentThread().getName());


    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final Test test = new Test();

//        test.set();
        System.out.println(test.getLong());
        System.out.println(test.getString());
        System.out.println("------------------------------>");

        Thread thread1 = new Thread(() -> {
//            test.set();
            System.out.println(test.getLong());
            System.out.println(test.getString());
        });
        thread1.start();
        thread1.join();
        System.out.println("------------------------------>");
        System.out.println(test.getLong());
        System.out.println(test.getString());
    }
}
