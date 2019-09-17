package spring.boot.com.comparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: yiqq
 * @date: 2019/4/29
 * @description:
 */
public class ComparingLongDemo {
    public static void main(String[] args) {
        List<StudentTwo> list = StudentTwo.getStudentList();

        Collections.sort(list, Comparator.comparingLong(StudentTwo::getHomeDistance));
        list.forEach(s->System.out.print(s.getHomeDistance() + " "));
    }
}
