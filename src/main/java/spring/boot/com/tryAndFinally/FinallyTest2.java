package spring.boot.com.tryAndFinally;

/**
 * @author: yiqq
 * @date: 2019/5/8
 * @description:
 */
public class FinallyTest2 {
    public static void main(String[] args) {

        System.out.println(test11());
        /**
         输出结果：
         111111
         333333
         222222
         444444
         说明try中的return语句先执行了但并没有立即返回，等到finally执行结束后再。
         这里大家可能会想：如果finally里也有return语句，那么是不是就直接返回了，try中的return就不能返回了？看FinallyTest3。
         */
    }

    public static String test11() {
        try {
            System.out.println("111111");
            return test12();
        } finally {
            System.out.println("222222");
        }
    }

    public static String test12(){
        System.out.println("333333");

        return "444444";
    }
}
