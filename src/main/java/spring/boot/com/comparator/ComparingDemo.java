package spring.boot.com.comparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: yiqq
 * @date: 2019/4/29
 * @description:
 */
public class ComparingDemo {
    public static void main(String[] args) {
        List<StudentTwo> list = StudentTwo.getStudentList();

        Comparator<StudentTwo> schoolComparator1 = Comparator.comparing(StudentTwo::getSchoolTwo);
        Collections.sort(list, schoolComparator1);
        list.forEach(s->System.out.print(s.getName() + "-" + s.getSchoolTwo().getSname() + " | "));
        System.out.println("-------------------");

        Comparator<StudentTwo> schoolComparator2 =
                Comparator.comparing(StudentTwo::getSchoolTwo, (sch1, sch2) -> sch1.getCode() - sch2.getCode());
        Collections.sort(list, schoolComparator2);
        list.forEach(s->System.out.print(s.getName() + "-" + s.getSchoolTwo().getCode() + " | "));
        System.out.println("-------------------");

        Comparator<StudentTwo> nameComparator1 = Comparator.comparing(StudentTwo::getName);
        Collections.sort(list, nameComparator1);
        list.forEach(s->System.out.print(s.getName() + " "));
        System.out.println("-------------------");

        Comparator<StudentTwo> nameComparator2 = Comparator.comparing(StudentTwo::getName, (s1, s2) -> s2.compareTo(s1));
        Collections.sort(list, nameComparator2);
        list.forEach(s->System.out.print(s.getName() + " "));
    }
}
