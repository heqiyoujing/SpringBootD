package spring.boot.com.comparator;

import java.util.Comparator;
import java.util.List;

/**
 * @author: yiqq
 * @date: 2019/4/29
 * @description:
 * https://mp.weixin.qq.com/s?__biz=MzAxODcyNjEzNQ==&mid=2247487247&idx=1&sn=55dc46cdde683b79864997a183c258df&chksm=9bd0a297aca72b8106cb40bedade4a69d539dbdbb579bed6238a54cf30bb270b8b4a8e45ec04&scene=0&xtrack=1#rd
 */
public class CompareDemo {
    public static void main(String[] args) {
        List<Student> list = Student.getStudentList();
        System.out.println("--- Sort Students by age ---");
//        Comparator<Student> ageComp = (s1, s2) -> s1.getAge() - s2.getAge();
        Comparator<Student> ageComp = Comparator.comparingInt(Student::getAge);
        list.sort(ageComp);
        list.forEach(s -> System.out.println(s));
        System.out.println("--- Sort Students by name ---");
//        Comparator<Student> nameComp = (s1, s2) -> s1.getName().compareTo(s2.getName());
        Comparator<Student> nameComp = Comparator.comparing(Student::getName);
        list.sort(nameComp);
        list.forEach(s -> System.out.println(s));
    }
}
