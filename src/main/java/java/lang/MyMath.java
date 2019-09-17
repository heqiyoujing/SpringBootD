package java.lang;

/**
 * @author: yiqq
 * @date: 2019/4/15
 * @description:
 * https://blog.csdn.net/tang9140/article/details/42738433
 */
public class MyMath {
    /**
     * 我们自定义的类加载器必须继承自ClassLoader，其loadClass()方法里调用了父类的defineClass()方法，并最终调到preDefineClass()
     * 方法，因此我们自定义的类加载器也是不能加载以“java.”开头的java类的。
     * 如果加载的类全名称以“java.”开头时，将会抛出SecurityException，这也是为什么直接执行MyMath类会出现SecurityException。
     */
    public static void main(String[] args) {
        System.out.println("hello world");
    }
}
