package spring.boot.com.staticsC.staticBase;

/**
 * @author: yiqq
 * @date: 2019/2/22
 * @description:
 */
public class StaticShunXuB extends StaticShunXu{
    public static void test(){
        System.out.println("子类--静态方法");
    }
    static {
        System.out.println("子类--静态代码块");
    }

    {
        System.out.println("子类--非静态代码块");
    }

    public StaticShunXuB() {
        System.out.println("子类--构造函数");
    }
}
