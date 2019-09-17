package spring.boot.com.comparator;

import java.util.Arrays;
import java.util.List;

/**
 * @author: yiqq
 * @date: 2019/4/29
 * @description:
 */
public class StudentThree {
    private String name;
    private int age;
    private long homeDistance;
    private double weight;
    private SchoolThree schoolThree;

    public StudentThree(String name, int age, long homeDistance, double weight, SchoolThree schoolThree) {
        this.name = name;
        this.age = age;
        this.homeDistance = homeDistance;
        this.weight = weight;
        this.schoolThree = schoolThree;
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
    public SchoolThree getSchool() {
        return schoolThree;
    }
    public static List<StudentThree> getStudentList() {
        StudentThree s1 = new StudentThree("Ram", 18, 3455, 60.75, new SchoolThree("AB College", "Noida"));
        StudentThree s2 = new StudentThree("Shyam", 22, 3252, 65.80, new SchoolThree("RS College", "Gurugram"));
        StudentThree s3 = new StudentThree("Mohan", 18, 1459, 65.20, new SchoolThree("AB College", "Noida"));
        StudentThree s4 = new StudentThree("Mahesh", 22, 4450, 70.25, new SchoolThree("RS College", "Gurugram"));
        List<StudentThree> list = Arrays.asList(s1, s2, s3, s4);
        return list;
    }
}
