package spring.boot.com.tryAndFinally;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yiqq
 * @date: 2019/5/8
 * @description:
 *
 */
public class FinallyTest4 {
    public static void main(String[] args) {
        System.out.println(test1());
        /**
         执行结果：
         try block
         finally block
         b>25, b = 100
         100
         */
        System.out.println(getMap().get("KEY").toString());
        /**
         执行结果：FINALLY
         为什么测试用例1中finally里的b = 150;并没有起到作用？
         测试用例2中finally的map.put("KEY", "FINALLY");起了作用而map = null;却没起作用呢？
         这就是Java到底是传值还是传址的问题了，简单来说就是：Java中只有传值没有传址，这也是为什么map = null这句不起作用。
         这同时也说明了返回语句是try中的return语句而不是 finally外面的return b;

         这里大家可能又要想：是不是每次返回的一定是try中的return语句呢？那么finally外的return b不是一点作用没吗？请看FinallyTest5
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
            b = 150;
        }
        return 2000;
    }

    public static Map<String,String> getMap(){
        Map<String, String> map = new HashMap<>();
        map.put("KYE", "INIT");

        try {
            map.put("KEY", "TRY");
            return map;
        } catch (Exception e) {
            map.put("KEY", "CATCH");
        } finally {
            map.put("KEY", "FINALLY");
            map = null;
        }
        return map;
    }
}
