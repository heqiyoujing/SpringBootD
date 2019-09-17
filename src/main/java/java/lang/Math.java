package java.lang;

/**
 * @author: yiqq
 * @date: 2019/4/15
 * @description:
 * https://blog.csdn.net/tang9140/article/details/42738433
 */
//public class Math {
//    /**
//     * 当类首次主动使用时，必须进行类的加载，这部分工作是由类加载器来完成的。根据双亲委托原则，Math类首先由启动类加载器
//     * 去尝试加载，很显然，它找到rt.jar中的java.lang.Math类并加载进内存（并不会加载我们自定义的Math类），然后执行main
//     * 方法时，发现不存在该方法，所以报方法不存在错误。也就是说，默认情况下JVM不会加载我们自定义的Math类。
//     */
//    public static void main(String[] args) {
//        System.out.println("hello world");
//    }
//}
