package spring.boot.com.threadLocal.DaYinShu;


/**
 * @author: yiqq
 * @date: 2019/5/8
 * @description: 用程序实现两个线程交替打印 0~100 的奇偶数
 * https://mp.weixin.qq.com/s?__biz=MzIzMzgxOTQ5NA==&mid=2247486942&idx=1&sn=2a41d7f38d682bf46f8e3a2d45de8b46&chksm=e8fe91d7df8918c1303c455b86e0acabebf66880ab12ef51263d226c4a9a652e26ab3cb77ad7&scene=0&xtrack=1#rd
 */
public class Print {

    private static int count = 0;
    private final static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
//        turning();
//        turningOne();
        turningTwo();
    }

    public static void turningTwo() throws InterruptedException {
        new Thread(new TurningRunner(), "偶数").start();
        // 确保偶数线程线先获取到锁
        Thread.sleep(1);
        new Thread(new TurningRunner(), "奇数").start();
    }

   static class TurningRunner implements Runnable {
       @Override
       public void run() {
           while (count <= 100) {
               // 获取锁
               synchronized (lock) {
                   // 拿到锁就打印
                   System.out.println(Thread.currentThread().getName() + ": " + count++);
                   // 唤醒其他线程
                   lock.notifyAll();
                   try {
                       if (count <= 100) {
                           // 如果任务还没有结束，则让出当前的锁并休眠
                           lock.wait();
                       }
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }
       }
   }

    /**
     * 交替获取锁的方案
     */
    public static void turningOne() throws InterruptedException {
        Thread even = new Thread(() -> {
            while (count <= 100) {
                synchronized (lock) {
                    System.out.println("偶数: " + count++);
                    lock.notifyAll();
                    try {
                        // 如果还没有结束，则让出当前的锁并休眠
                        if (count <= 100) {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread odd = new Thread(() -> {
            while (count <= 100) {
                synchronized (lock) {
                    System.out.println("奇数: " + count++);
                    lock.notifyAll();
                    try {
                        // 如果还没有结束，则让出当前的锁并休眠
                        if (count <= 100) {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        even.start();
        // 确保偶数线程线先获取到锁
        Thread.sleep(1);
        odd.start();
    }

    /**
     * 讨巧的方案: ，要输出的时候判断一下当前需要输出的数是不是自己要负责打印的值
     * 缺点：如果同一个线程一直抢到锁，而另一个线程一直没有拿到，就会导致线程做很多无谓的空转。
     */
    public static void turning() {
        Thread even = new Thread(() -> {
            while (count < 100) {
                synchronized (lock) {
                    // 只处理偶数
                    if ((count & 1) == 0) {
                        System.out.println(Thread.currentThread().getName() + ": " + count++);
                    }
                }
            }
        }, "偶数");
        Thread odd = new Thread(() -> {
            while (count < 100) {
                synchronized (lock) {
                    // 只处理奇数
                    if ((count & 1) == 1) {
                        System.out.println(Thread.currentThread().getName() + ": " + count++);
                    }
                }
            }
        }, "奇数");
        even.start();
        odd.start();
    }
}
