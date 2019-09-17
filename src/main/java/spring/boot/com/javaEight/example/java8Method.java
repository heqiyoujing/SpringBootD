package spring.boot.com.javaEight.example;

import java.util.Arrays;
import java.util.List;

/**
 * @author: yiqq
 * @date: 2019/4/15
 * @description: Java 8 方法引用
 */
public class java8Method {

    @FunctionalInterface
    public interface Supplier<T> {
        T get();
    }

    public static java8Method create(final Supplier<java8Method> supplier) {
        return supplier.get();
    }

    public static void collide(final java8Method car){
        System.out.println("Collided " + car.toString());
    }

    public void follow(final java8Method another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }
    public static void main(String[] args) {
        //构造器引用：它的语法是Class::new，或者更一般的Class< T >::new实例如下：
        java8Method car  = java8Method.create(java8Method::new);
        java8Method car1  = java8Method.create(java8Method::new);
        java8Method car2  = java8Method.create(java8Method::new);
        java8Method car3  = java8Method.create(java8Method::new);
        List<java8Method> cars = Arrays.asList(car,car1,car2,car3);
        System.out.println("===================构造器引用========================");
        //静态方法引用：它的语法是Class::static_method，实例如下：
        cars.forEach(java8Method::collide);
        System.out.println("===================静态方法引用========================");
        //特定类的任意对象的方法引用：它的语法是Class::method实例如下：
        cars.forEach(java8Method::repair);
        System.out.println("==============特定类的任意对象的方法引用================");
        //特定对象的方法引用：它的语法是instance::method实例如下：
        final java8Method police = java8Method.create(java8Method::new);
        cars.forEach(police::follow);
        System.out.println("===================特定对象的方法引用===================");

    }

    @Override
    public String toString() {
        return "I am Override";
    }
}
