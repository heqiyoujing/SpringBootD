package spring.boot.com.clone;

import javax.swing.*;

/**
 * @author: yiqq
 * @date: 2019/5/6
 * @description:
 */
public class Person implements Cloneable{

    private int age ;
    private String name;

    public Person(int age, String name){
        this.age=age;
        this.name = name;
    }
    public Person(){}

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Override
//    public String toString() {
//        return "Person{" +
//                "age=" + age +
//                ", name='" + name + '\'' +
//                '}';
//    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Person)super.clone();
    }
}
