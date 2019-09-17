package spring.boot.com.comparator;

import java.util.Comparator;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author: yiqq
 * @date: 2019/4/29
 * @description:
 */
public class ConcurrentSkipListMapDemo {
    public static void main(String[] args) {
        Student s1 = new Student("Shyam", 18);
        Student s2 = new Student("Mohan", 20);
        Student s3 = new Student("Ram", 22);

        System.out.println("---ConcurrentSkipListMap Order With Comparator---");

        Comparator<Student> ageComparator = Comparator.comparing(Student::getAge);
        ConcurrentSkipListMap<Student, String> myConcurrentSkipListMap = new ConcurrentSkipListMap<>(ageComparator);
        myConcurrentSkipListMap.put(s1, "Varanasi");
        myConcurrentSkipListMap.put(s2, "Mathura");
        myConcurrentSkipListMap.put(s3, "Kashi");
        myConcurrentSkipListMap.forEach((k, v) -> System.out.println(k + " - " + v));
//System.out.println("Comparator: "+ myConcurrentSkipListMap.comparator());

        System.out.println("---ConcurrentSkipListMap Natural Order (With Comparable)---");

        myConcurrentSkipListMap = new ConcurrentSkipListMap<>();
        myConcurrentSkipListMap.put(s1, "Varanasi");
        myConcurrentSkipListMap.put(s2, "Mathura");
        myConcurrentSkipListMap.put(s3, "Kashi");
        myConcurrentSkipListMap.forEach((k, v) -> System.out.println(k + " - " + v));
    }
}
