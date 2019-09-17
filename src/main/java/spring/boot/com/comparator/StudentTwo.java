package spring.boot.com.comparator;

import java.util.Arrays;
import java.util.List;

/**
 * @author: yiqq
 * @date: 2019/4/29
 * @description:
 */
public class StudentTwo {
    private String name;
    private int age;
    private long homeDistance;
    private double weight;
    private SchoolTwo schoolTwo;
    public StudentTwo(String name, int age, long homeDistance, double weight, SchoolTwo schoolTwo) {
        this.name = name;
        this.age = age;
        this.homeDistance = homeDistance;
        this.weight = weight;
        this.schoolTwo = schoolTwo;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public long getHomeDistance() {
        return homeDistance;
    }
    public double getWeight() {
        return weight;
    }
    public SchoolTwo getSchoolTwo() {
        return schoolTwo;
    }
    public static List<StudentTwo> getStudentList() {
        StudentTwo s1 = new StudentTwo("Ram", 18, 3455, 60.75, new SchoolTwo(101, "PQ College"));
        StudentTwo s2 = new StudentTwo("Shyam", 22, 3252, 65.80, new SchoolTwo(103, "RS College"));
        StudentTwo s3 = new StudentTwo("Mohan", 19, 1459, 65.20, new SchoolTwo(102, "AB College"));
        StudentTwo s4 = new StudentTwo("Mahesh", 20, 4450, 70.25, new SchoolTwo(104, "CD College"));
        List<StudentTwo> list = Arrays.asList(s1, s2, s3, s4);
        return list;
    }
}
