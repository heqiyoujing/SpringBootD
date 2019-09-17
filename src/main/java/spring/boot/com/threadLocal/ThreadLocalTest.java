package spring.boot.com.threadLocal;

/**
 * @author: yiqq
 * @date: 2019/4/12
 * @description: 深入解析ThreadLocal类
 * https://www.cnblogs.com/dolphin0520/p/3920407.html
 *  首先，在每个线程Thread内部有一个ThreadLocal.ThreadLocalMap类型的成员变量threadLocals，这个threadLocals就是用来存储实际
  的变量副本的，键值为当前ThreadLocal变量，value为变量副本（即T类型的变量）。
　   初始时，在Thread里面，threadLocals为空，当通过ThreadLocal变量调用get()方法或者set()方法，就会对Thread类中的threadLocals
  进行初始化，并且以当前ThreadLocal变量为键值，以ThreadLocal要保存的副本变量为value，存到threadLocals。
　   然后在当前线程里面，如果要使用副本变量，就可以通过get方法在threadLocals里面查找。
 */
public class ThreadLocalTest {
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();
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
        final ThreadLocalTest test = new ThreadLocalTest();


        test.set();
        System.out.println(test.getLong());
        System.out.println(test.getString());

        System.out.println("------------------------------>");
        Thread thread1 = new Thread(() -> {
            test.set();
            System.out.println(test.getLong());
            System.out.println(test.getString());
        });
        thread1.start();
        thread1.join();
        System.out.println("------------------------------>");
        System.out.println(test.getLong());
        System.out.println(test.getString());
    }
    /**
     *
     总结一下：
     　　1）实际的通过ThreadLocal创建的副本是存储在每个线程自己的threadLocals中的；
     　　2）为何threadLocals的类型ThreadLocalMap的键值为ThreadLocal对象，因为每个线程中可有多个threadLocal变量，就像上面
            代码中的longLocal和stringLocal；
     　　3）在进行get之前，必须先set，否则会报空指针异常；
     　　   如果想在get之前不需要调用set就能正常访问的话，必须重写initialValue()方法。
     　　　 因为在上面的代码分析过程中，我们发现如果没有先set的话，即在map中查找不到对应的存储，则会通过调用setInitialValue
                方法返回i，而在setInitialValue方法中，有一个语句是T value = initialValue()， 而默认情况下，initialValue方法返回的是null。

     三.ThreadLocal的应用场景
     最常见的ThreadLocal使用场景为 用来解决 数据库连接、Session管理等。
     */
}
