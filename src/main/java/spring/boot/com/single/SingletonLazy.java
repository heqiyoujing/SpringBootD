package spring.boot.com.single;

/**
 * @author: yiqq
 * @date: 2019/5/7
 * @description:
 */
public class SingletonLazy {

    private static SingletonLazy instance = null;

    static {
        System.out.println("初始化......");
        instance = new SingletonLazy();
    }

    public static SingletonLazy getInstance(){
        return instance;
    }
}
