package spring.boot.com.tryAndFinally;

/**
 * @author: yiqq
 * @date: 2019/5/8
 * @description:
 *
 */
public class FinallyTest5 {
    public static void main(String[] args) {
        System.out.println(test1());
        /**
         执行结果：
         try block
         catch block
         finally block
         b>25, b = 35
         85

         在return之前发生了除0异常，所以try中的return不会被执行到，而是接着执行捕获异常的catch 语句和最终的finally语句，
         此时两者对b的修改都影响了最终的返回值，这时return b;就起到作用了。

         这里大家可能又有疑问：如果catch中有return语句呢？当然只有在异常的情况下才有可能会执行，那么是在finally之前就返回吗？
         看FinallyTest6。
         */
    }

    public static int test1(){
        int b = 20;
        try {
            System.out.println("try block");
            b = b / 0;
            return b += 80;
        } catch (Exception e) {
            b += 15;
            System.out.println("catch block");
        } finally {
            System.out.println("finally block");
            if (b > 25) {
                System.out.println("b>25, b = " + b);
            }
            b += 50;
        }
        return b;
    }
}
