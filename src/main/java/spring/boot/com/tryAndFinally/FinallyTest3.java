package spring.boot.com.tryAndFinally;

/**
 * @author: yiqq
 * @date: 2019/5/8
 * @description:
 *
 */
public class FinallyTest3 {
    public static void main(String[] args) {
        System.out.println(test1());
        /**
         执行结果：
         try block
         finally block
         b>25, b = 100
         200
         这说明finally里的return直接返回了，就不管try中是否还有返回语句，这里还有个小细节需要注意，finally里加上return过后，
         finally外面的return b就变成不可到达语句了，也就是永远不能被执行到，所以需要注释掉否则编译器报错。
         这里大家可能又想：如果finally里没有return语句，但修改了b的值，那么try中return返回的是修改后的值还是原值？看FinallyTest4。
         */
    }

    public static int test1(){
        int b = 20;
        try {
            System.out.println("try block");
            return b += 80;
        } catch (Exception e) {
            System.out.println("catch block");
        } finally {
            System.out.println("finally block");
            if (b > 25) {
                System.out.println("b>25, b = " + b);
            }
            return 200;
        }
//        return b;
    }
}
