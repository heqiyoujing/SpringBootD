package spring.boot.com.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: yiqq
 * @date: 2019/4/29
 * @description:
 */
public class NullsLastDemo {
    public static void main(String[] args) {
        Student s1 = new Student("Ram", 18);
        Student s2 = new Student("Shyam", 22);
        Student s3 = new Student("Mohan", 17);

        System.out.println("-------Case1: One null----------");

        List<Student> list = Arrays.asList(s1, s2, null, s3);
        Collections.sort(list, Comparator.nullsLast(Comparator.comparing(Student::getName)));
        list.forEach(s -> System.out.println(s));

        System.out.println("--------Case2: More than one null---------");

        list = Arrays.asList(s1, null, s2, null, s3);
        Collections.sort(list, Comparator.nullsLast(Comparator.comparing(Student::getName)));
        list.forEach(s -> System.out.println(s));

        System.out.println("--------Case3: Reverse specified Comparator to nullsLast---------");

        list = Arrays.asList(s1, null, s2, null, s3);
        Collections.sort(list, Comparator.nullsLast(Comparator.comparing(Student::getName).reversed()));
        list.forEach(s -> System.out.println(s));

        System.out.println("--------Case4: Reverse Comparator returned by nullsLast---------");

        list = Arrays.asList(s1, null, s2, null, s3);
        Collections.sort(list, Comparator.nullsLast(Comparator.comparing(Student::getName)).reversed());
        list.forEach(s -> System.out.println(s));

        System.out.println("--------Case5: Specify natural order Comparator to nullsLast---------");

        list = Arrays.asList(s1, null, s2, null, s3);
        Collections.sort(list, Comparator.nullsLast(Comparator.naturalOrder()));
        list.forEach(s -> System.out.println(s));

        System.out.println("--------Case6: Specify null to nullsLast---------");

        list = Arrays.asList(s1, null, s2, null, s3);
        Collections.sort(list, Comparator.nullsLast(null));
        list.forEach(s -> System.out.println(s));
    }
}
