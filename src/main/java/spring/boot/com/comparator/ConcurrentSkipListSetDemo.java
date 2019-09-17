package spring.boot.com.comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @author: yiqq
 * @date: 2019/4/29
 * @description:
 */
public class ConcurrentSkipListSetDemo {
    public static void main(String[] args) {
        Student s1 = new Student("Shyam", 18);
        Student s2 = new Student("Mohan", 20);
        Student s3 = new Student("Ram", 22);

        System.out.println("---ConcurrentSkipListSet Order With Comparator---");

        Comparator<Student> ageComparator = Comparator.comparing(Student::getAge);
        ConcurrentSkipListSet<Student> myConcurrentSkipList = new ConcurrentSkipListSet<>(ageComparator);
        myConcurrentSkipList.addAll(Arrays.asList(s1, s2, s3));
        myConcurrentSkipList.forEach(s -> System.out.println(s));
        //System.out.println("Comparator: "+ myConcurrentSkipList.comparator());

        System.out.println("---ConcurrentSkipListSet Natural Order (With Comparable)---");

        myConcurrentSkipList = new ConcurrentSkipListSet<>();
        myConcurrentSkipList.addAll(Arrays.asList(s1, s2, s3));
        myConcurrentSkipList.forEach(s -> System.out.println(s));
    }
}
