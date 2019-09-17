package spring.boot.com.comparator;

import java.util.Arrays;
import java.util.List;

/**
 * @author: yiqq
 * @date: 2019/4/29
 * @description:
 * https://mp.weixin.qq.com/s?__biz=MzAxODcyNjEzNQ==&mid=2247487247&idx=1&sn=55dc46cdde683b79864997a183c258df&chksm=9bd0a297aca72b8106cb40bedade4a69d539dbdbb579bed6238a54cf30bb270b8b4a8e45ec04&scene=0&xtrack=1#rd
 */
public class Student implements Comparable<Student> {
    private String name;
    private int age;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    @Override
    public int compareTo(Student s) {
        return name.compareTo(s.getName());
    }
    @Override
    public String toString(){
        return name + "-" + age;
    }
    public static List<Student> getStudentList(){
        Student s1 = new Student("Ram", 18);
        Student s2 = new Student("Shyam",22);
        Student s3 = new Student("Mohan",19);
        List<Student> list = Arrays.asList(s1,s2,s3);
        return list;
    }
}
