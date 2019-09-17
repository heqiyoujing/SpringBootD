package spring.boot.com.comparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: yiqq
 * @date: 2019/4/29
 * @description:
 */
public class ThenComparingDemo {
    public static void main(String[] args) {
        List<StudentThree> list = StudentThree.getStudentList();

        System.out.println("--------Example-1---------");

        Comparator<StudentThree> compByStdName = Comparator.comparing(StudentThree::getName);
        Comparator<StudentThree> schoolComparator1 = Comparator.comparing(StudentThree::getAge) //sort by student age
                .thenComparing(compByStdName); //then sort by student name

        Collections.sort(list, schoolComparator1);
        list.forEach(s->System.out.println(s.getName() + "-" + s.getAge()));

        System.out.println("--------Example-2---------");

        Comparator<StudentThree> schoolComparator2 = Comparator.comparing(StudentThree::getSchool) //sort by school natural ordering i.e. city
                .thenComparing(StudentThree::getAge) //then sort by student age
                .thenComparing(StudentThree::getName); //then sort by student name

        Collections.sort(list, schoolComparator2);
        list.forEach(s->System.out.println(s.getName() + "-" + s.getAge()+ "-" + s.getSchool().getCity()));

        System.out.println("--------Example-3---------");

        Comparator<StudentThree> schoolComparator3 = Comparator.comparing(StudentThree::getSchool) //sort by school natural ordering i.e. city
                .thenComparing(StudentThree::getSchool, (school1, school2) -> school1.getSname().compareTo(school2.getSname())) //then sort by school name
                .thenComparing(StudentThree::getAge) //then sort by student age
                .thenComparing(StudentThree::getName); //then sort by student name

        Collections.sort(list, schoolComparator3);
        list.forEach(s->System.out.println(s.getName() + "-" + s.getAge()+ "-" + s.getSchool().getSname() + "-" + s.getSchool().getCity()));
    }
}
