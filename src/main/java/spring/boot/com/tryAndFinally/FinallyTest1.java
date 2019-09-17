package spring.boot.com.tryAndFinally;

/**
 * @author: yiqq
 * @date: 2019/5/8
 * @description:  finally语句到底是在return之前还是之后执行
 * https://mp.weixin.qq.com/s?__biz=MzAxNjk4ODE4OQ==&mid=2247485349&idx=2&sn=bdea7a3215758d229373526b89703968&chksm=9bed26d7ac9aafc1938efd5d5e53c5c7c0625aece2d6d57c4eea6e41d11c88e9aeaca59b3454&scene=0&xtrack=1#rd
 */
public class FinallyTest1 {
    public static void main(String[] args) {
        System.out.println(test1());
        /**
         执行结果：
         try block
         finally block
         b>25, b = 100
         100
         说明return语句已经执行了再去执行finally语句，不过并没有直接返回，而是等finally语句执行完了再返回结果。
         如果觉得这个例子还不足以说明这个情况的话，看FinallyTest2加强证明结论。
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
        }
        return b;
    }
}
