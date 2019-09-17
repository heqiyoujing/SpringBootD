package spring.boot.com.staticsC.staticBase;

/**
 * @author: yiqq
 * @date: 2019/2/22
 * @description:
 */
public class StaticShunXu {
    public static void test(){
        System.out.println("父类--静态方法"); //被子类的相同方法覆盖
    }
    static {
        System.out.println("父类--静态代码块");
    }

    public StaticShunXu() {
        System.out.println("父类--构造函数");
    }


    {
        System.out.println("父类--非静态代码块");
    }

}
