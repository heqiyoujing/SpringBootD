package spring.boot.com.single;

/**
 * @author: yiqq
 * @date: 2019/5/7
 * @description: 饿汉模式单例
 * https://mp.weixin.qq.com/s?__biz=MzI5NTYwNDQxNA==&mid=2247484916&idx=1&sn=6cee93e39c38aa137696a7e995ed6b61&chksm=ec505c25db27d533c7d7b78d3c4393837caeefec084ae290dfc3081ecfed4ffc3524f038fe61&scene=0&xtrack=1#rd
 */
public class Singleton {

    private static Singleton instance = new Singleton();

    private Singleton() { }

    public static Singleton getInstance() {
        return instance;
    }
}
