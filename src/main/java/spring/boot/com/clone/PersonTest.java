package spring.boot.com.clone;

/**
 * @author: yiqq
 * @date: 2019/5/6
 * @description:
 */
public class PersonTest {
    public static void main(String[] args) throws CloneNotSupportedException {
//        Person p = new Person(23, "zhang");
//        Person p1 = (Person) p.clone();//Person对象必须继承Cloneable
//        System.out.println(p);
//        System.out.println(p1);

        /**
         * 浅拷贝 和 深拷贝
         * ①直接将源对象中的name的引用值拷贝给新对象的name字段；
         * ②根据原Person对象中的name指向的字符串对象创建一个新的相同的字符串对象，将这个新字符串对象的引用赋给新拷贝的Person对象的name字段。
         */
        Person p = new Person(23, "zhang");
        Person p1 = (Person) p.clone();
        String result = p.getName() == p1.getName() ? "clone是浅拷贝的" : "clone是深拷贝的";
        System.out.println(result);//clone是浅拷贝的


    }
}
