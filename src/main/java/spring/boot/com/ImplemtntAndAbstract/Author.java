package spring.boot.com.ImplemtntAndAbstract;

/**
 * @author: yiqq
 * @date: 2019/5/8
 * @description: 抽象接口
 */
public abstract class Author {
    abstract void write ();

    public void sleep () {
        System.out.println("吃饭睡觉打豆豆");
    }
}
