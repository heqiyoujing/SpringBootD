package spring.boot.com.tryAndFinally;

/**
 * @author: yiqq
 * @date: 2019/5/8
 * @description:
 *
 */
public class FinallyTest6 {
    public static void main(String[] args) {
        System.out.println(test1());
        /**
         执行结果：
         try block
         catch block
         finally block
         b>25, b = 35
         35

         发生异常后，catch中的return语句先执行，确定了返回值后再去执行finally块，执行完了catch再返回，finally里对b的改变
         对返回值无影响，原因同前面一样，也就是说情况与try中的return语句执行完全一样。

         最后总结：finally块的语句在try或catch中的return语句执行之后返回之前执行且finally里的修改语句可能影响也可能不影
         响try或catch中 return已经确定的返回值，若finally里也有return语句则覆盖try或catch中的return语句直接返回。
         */
    }

    public static int test1(){
        int b = 20;
        try {
            System.out.println("try block");
            b = b / 0;
            return b += 80;
        } catch (Exception e) {
            System.out.println("catch block");
            return b += 15;
        } finally {
            System.out.println("finally block");
            if (b > 25) {
                System.out.println("b>25, b = " + b);
            }
            b += 50;
        }
//        return b;
    }
}
