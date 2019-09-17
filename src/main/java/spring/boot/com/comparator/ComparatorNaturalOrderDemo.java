package spring.boot.com.comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: yiqq
 * @date: 2019/4/29
 * @description: naturalOrder是Comparator功能接口的静态方法。
 */
public class ComparatorNaturalOrderDemo {
    /**
     * naturalOrder是Comparator功能接口的静态方法。Comparator.naturalOrder方法返回一个比较器，该比较器按自然顺序比较
     * Comparable对象。对于自然排序，类需要实现Comparable并定义compareTo方法。根据自然顺序中的compareTo方法对对象集合
     * 进行排序。诸如Integer，String和Date之类的Java类实现Comparable接口并覆盖其compareTo方法，它们按字典顺序排序。
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> numList = Arrays.asList(12, 10, 15, 8, 11);
        numList.sort(Comparator.naturalOrder());
        numList.forEach(n -> System.out.print(n + " "));
        System.out.println("-----------");

        List<String> strList = Arrays.asList("Varanasi", "Allahabad", "Kanpur", "Noida");
        strList.sort(Comparator.naturalOrder());
        strList.forEach(s -> System.out.print(s + " "));
        System.out.println("-----------");

        List<Student> stdList = Student.getStudentList();
        stdList.sort(Comparator.naturalOrder());
        stdList.forEach(s -> System.out.print(s.getName() + " "));
    }
}
