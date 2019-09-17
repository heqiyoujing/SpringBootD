package spring.boot.com.staticsC;

/**
 * @author: yiqq
 * @date: 2019/5/8
 * @description: 你真以为你会做这道JVM面试题？
 * https://mp.weixin.qq.com/s?__biz=MzAxNjk4ODE4OQ==&mid=2247485364&idx=1&sn=35008ece0f86749c82a65bef70ff2811&chksm=9bed26c6ac9aafd0dcc191af3ecf73b4f8ae2a4aa71e4fa23c54f43e69e8b38a6fc41505f677&scene=0&xtrack=1#rd
 */
public class StaticTest {

    /**静态语句块只能访问到定义在它之前的类变量，定义在它之后的类变量只能赋值，不能访问。*/
    /*static {
        i = 0;                // 给变量赋值可以正常编译通过
        System.out.print(i);  // 这句编译器会提示“非法向前引用”
    }
    static int i = 1;*/
    /**
     * 加载：1.通过一个类的全限定名来获取定义此类的二进制字节流。
     *       2.将这个字节流所代表的静态存储结构转化为方法区的运行时存储结构。
     *       3.在内存中生成一个代表这个类的 Class 对象，作为方法区这个类的各种数据的访问入口。
     * 验证：确保 Class 文件的字节流中包含的信息符合当前虚拟机的要求，并且不会危害虚拟机自身的安全。
     * 准备：类变量是被 static 修饰的变量，准备阶段为类变量分配内存并设置初始值，使用的是方法区的内存。
     *       实例变量不会在这阶段分配内存，它将会在对象实例化时随着对象一起分配在 Java 堆中。
     *       初始值一般为 0 值，例如下面的类变量 value 被初始化为 0 而不是 123。
     *       public static int value = 123;
     *       如果类变量是常量，那么会按照表达式来进行初始化，而不是赋值为 0。
     *       public static final int value = 123;
     * 解析：将常量池的符号引用替换为直接引用的过程。
     * 初始化：初始化阶段才真正开始执行类中的定义的 Java 程序代码。初始化阶段即虚拟机执行类构造器 <clinit>() 方法的过程。
     *          public static void main(String[] args) {
                    System.out.println(Sub.B);  // 输出结果是父类中的静态变量 A 的值 ，也就是 2。如果静态代码块放前面，结果就是1。
                }
     *
     * */
    static class Parent {
        public static int A = 1;
        static {
            A = 2;
        }
    }
    static class Sub extends Parent {
        public static int B = A;
    }

    /**
     这里主要的点之一：实例初始化不一定要在类初始化结束之后才开始初始化。
     1.类的生命周期是：加载->验证->准备->解析->初始化->使用->卸载。
     2.只有在准备阶段和初始化阶段才会涉及类变量的初始化和赋值，因此只针对这两个阶段进行分析；
     3.类的准备阶段需要做是为类变量分配内存并设置默认值，因此类变量st为null、b为0；
     4.需要注意的是如果类变量是final，编译时javac将会为value生成ConstantValue属性，
        在准备阶段虚拟机就会根据ConstantValue的设置将变量设置为指定的值。
        如果这里这么定义：static final int b=112，那么在准备阶段b的值就是112，而不再是0了。
     5.类的初始化阶段需要做的是执行类构造器。
        类构造器是编译器收集所有静态语句块和类变量的赋值语句，按语句在源码中的顺序合并生成类构造器，
        对象的构造方法是()，类的构造方法是()，可以在堆栈信息中看到。
        1)因此，先执行第一条静态变量的赋值语句，即st = new StaticTest ()，此时会进行对象的初始化。
        2)对象的初始化是先初始化成员变量，再执行构造方法。因此打印2->设置a为110->执行构造方法
            (打印3,此时a已经赋值为110，但是b只是设置了默认值0，并未完成赋值动作)。
        3)等对象的初始化完成后，继续执行之前的类构造器的语句。接下来就不详细说了，按照语句在源码中的顺序执行即可。
     */
    public static void main(String[] args) {
        staticFunction();
        /**
         一.打印结果：
         2
         3
         a=110,b=0
         1
         4

         二.若注释掉static StaticTest st = new StaticTest();
         则打印结果为：
         1
         4
         因此在实例化st变量时，实际上是把实例初始化嵌入到了静态初始化流程中，并且在楼主的问题中，嵌入到了静态初始化的
         起始位置。这就导致了实例初始化完全至于静态初始化之前。这也是导致a有值b没值的原因。

         三.结论：static StaticTest st = new StaticTest();导致先实例初始化，后面再静态初始化。
         实例初始化：先打印非静态代码块，输出2；然后设置a=110,再执行构造函数，输出3 和a=110,b=0
                    （此时a已经赋值为110，b静态初始化为开始，所以是0）
         静态初始化：先执行静态代码块，输出 1 ，再执行要执行的静态方法，输出4。
         因此最后输出结果是：
         2
         3
         a=110,b=0
         1
         4

         */
    }

    static StaticTest st = new StaticTest();/**静态类变量和静态语句按代码顺序执行*/

    static {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    public StaticTest() {
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void staticFunction() {
        System.out.println("4");
    }

    int a = 110;
    static int b = 112;
}
