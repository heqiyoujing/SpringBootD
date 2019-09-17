package spring.boot.com.javaEight.defaultInterface;

import spring.boot.com.javaEight.defaultInterface.April;
import spring.boot.com.javaEight.defaultInterface.March;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: yiqq
 * @date: 2019/4/15
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        list.add(0.0001);
        list.add(0.0001);
        list.add(0.001);
        list.add(0.005);
        list.add(0.03);
        list.add(0.5);
        list.add(0.2);
        list.add(0.2638);
//        April april = new April(){ };
        April april = new March();
        int num = april.draw(list);
        System.out.println("hello world: " + num);
    }
}
