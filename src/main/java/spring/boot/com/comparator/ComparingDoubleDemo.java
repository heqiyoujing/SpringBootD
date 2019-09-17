package spring.boot.com.comparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: yiqq
 * @date: 2019/4/29
 * @description:
 */
public class ComparingDoubleDemo {
    public static void main(String[] args) {
        List<StudentTwo> list = StudentTwo.getStudentList();

        Collections.sort(list, Comparator.comparingDouble(StudentTwo::getWeight));
        list.forEach(s->System.out.print(s.getWeight() + " "));
    }
}
