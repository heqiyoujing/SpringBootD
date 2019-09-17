package spring.boot.com.comparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: yiqq
 * @date: 2019/4/29
 * @description:
 */
public class ThenComparingIntDemo {
    public static void main(String[] args) {
        List<StudentThree> list = StudentThree.getStudentList();

        Comparator<StudentThree> comparator = Comparator.comparing(StudentThree::getName, (s1, s2) -> s1.charAt(0) - s2.charAt(0))
                .thenComparingInt(StudentThree::getAge);

        Collections.sort(list, comparator);
        list.forEach(s->System.out.println(s.getName() + "-" + s.getAge()));
    }
}
