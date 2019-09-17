package spring.boot.com.comparator;

import java.util.Comparator;
import java.util.List;

/**
 * @author: yiqq
 * @date: 2019/4/29
 * @description:
 */
public class CompareDemoStreamSorted {
    public static void main(String[] args) {
        List<Student> list = Student.getStudentList();
        System.out.println("--- Sort Students by age ---");
//        Comparator<Student> ageComp = (s1, s2) -> s1.getAge() - s2.getAge();
        Comparator<Student> ageComp = Comparator.comparingInt(Student::getAge);
        list.stream().sorted(ageComp).forEach(s -> System.out.println(s));
        System.out.println("--- Sort Students by name ---");
        Comparator<Student> nameComp = (s1, s2) -> s1.getName().compareTo(s2.getName());
//        Comparator<Student> nameComp = Comparator.comparing(Student::getName);
        list.stream().sorted(nameComp).forEach(s -> System.out.println(s));
    }
}
