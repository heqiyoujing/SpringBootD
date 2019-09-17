package spring.boot.com.comparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: yiqq
 * @date: 2019/4/29
 * @description:
 */
public class ComparingIntDemo {
    public static void main(String[] args) {
        List<StudentTwo> list = StudentTwo.getStudentList();

        Collections.sort(list, Comparator.comparingInt(StudentTwo::getAge));
        list.forEach(s->System.out.print(s.getAge() + " "));
    }
}
