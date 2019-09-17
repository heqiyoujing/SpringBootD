package spring.boot.com.javaEight.example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yiqq
 * @date: 2019/4/15
 * @description:
 */
public class java8Test2 {
    public static void main(String[] args) {
        final int num = 1;//可以不加final，但是必须不可被后面的代码修改
        Converter<Integer, String> s = (integer) -> System.out.println(String.valueOf(integer + num));
        s.convert(2);  // 输出结果为 3
        System.out.println("---------------------->>>>>>>>>>>>>>");
        List names = new ArrayList();
        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");
        names.forEach(System.out::println);
        System.out.println("---------------------->>>>>>>>>>>>>>将System.out::println 方法作为静态方法来引用");

    }
    public interface Converter<T1, T2> {
        void convert(int i);
    }
}
