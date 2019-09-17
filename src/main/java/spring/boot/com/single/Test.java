package spring.boot.com.single;

/**
 * @author: yiqq
 * @date: 2019/5/7
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        SingletonLazy singletonLazy = SingletonLazy.getInstance();
        SingletonLazy singletonLazy1 = SingletonLazy.getInstance();//不会再次执行静态代码块
    }
}
