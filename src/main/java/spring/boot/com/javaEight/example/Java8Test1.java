package spring.boot.com.javaEight.example;

/**
 * @author: yiqq
 * @date: 2019/4/15
 * @description:
 */
public class Java8Test1 {
    final static String salutation = "Hello! ";
    public static void main(String[] args) {
        GreetingService greetService1 = message ->
                System.out.println(salutation + message);
        greetService1.sayMessage("Runoob");
    }

    interface GreetingService {
        void sayMessage(String message);
    }

}
