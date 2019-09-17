package spring.boot.com.staticsC;

/**
 * @author: yiqq
 * @date: 2019/5/9
 * @description:
 */
public class TestStatic2 {
    public static void main(String[] args) {
        System.out.println("count的值：" + TestStatic2.count);
        System.out.println("name的值：" + TestStatic2.name);
        /***
         输出结果：
         staticInitTest的静态初始化块
         count的值：2
         name的值：变量在static块里面

         若是静态变量和静态代码库位置换一下，最后输出的是：
         staticInitTest的静态初始化块
         count的值：2
         name的值：name变量在static块里面

         结论：静态代码块和静态变量是按顺序执行的。
         */
    }

    static int count = 2;
    static String name = "name变量在static块里面";

    static {
        System.out.println("staticInitTest的静态初始化块");
        name = "变量在static块里面";
    }
//    static String name = "name变量在static块里面";
}
