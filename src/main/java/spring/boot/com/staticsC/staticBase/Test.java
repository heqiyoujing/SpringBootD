package spring.boot.com.staticsC.staticBase;

/**
 * @author: yiqq
 * @date: 2019/2/22
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        StaticShunXuB shunXuB = new StaticShunXuB();
        shunXuB.test();
        /*父类--静态代码块
        子类--静态代码块
        父类--非静态代码块
        父类--构造函数
        子类--非静态代码块
        子类--构造函数
        子类--静态方法*/

        //类的加载顺序是静态成员变量-静态代码块-非静态成员变量-非静态代码块-构造方法

//        父类（静态变量、静态语句块块）
//        子类（静态变量、静态语句块）
//        父类（实例变量、普通语句块）
//        父类（构造函数）
//        子类（实例变量、普通语句块）
//        子类（构造函数）
    }
}
