package spring.boot.com.javaEight;

import spring.boot.com.entity.User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: yiqq
 * @date: 2019/4/15
 * @description: java8新特性
 * https://blog.csdn.net/yitian_66/article/details/81010434
 */
public class Document {

    /**
     Java 8 Lambda 表达式:
     语法：
         可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。
         可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。
         可选的大括号：如果主体包含了一个语句，就不需要使用大括号。
         可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定明表达式返回了一个数值。

     Java 8 API添加了一个新的抽象称为流Stream，可以让你以一种声明的方式处理数据。
     Stream使用一种类似用SQL语句从数据库查询数据的直观方式来提供一种对Java集合运算和表达的高阶抽象。
     这种风格将要处理的元素集合看作一种流，流在管道中传输，并且可以在管道的节点上进行处理，比如筛选，排序，聚合等。
     元素流在管道中经过中间操作（intermediate operation）的处理，最后由最终操作(terminal operation)得到前面处理的结果。

     什么是 Stream？
         Stream（流）是一个来自数据源的元素队列并支持聚合操作
         元素：是特定类型的对象，形成一个队列。Java中的Stream并不会存储元素，而是按需计算。
         数据源 ：流的来源。可以是集合，数组，I/O channel，产生器generator等。
         聚合操作： 类似SQL语句一样的操作，比如filter, map, reduce, find,match, sorted等。
         和以前的Collection操作不同，Stream操作还有两个基础的特征：
         Pipelining:：中间操作都会返回流对象本身。这样多个操作可以串联成一个管道，如同流式风格（fluent style）。
            这样做可以对操作进行优化，比如延迟执行(laziness)和短路( short-circuiting)。
         内部迭代：以前对集合遍历都是通过Iterator或者For-Each的方式,显式的在集合外部进行迭代，这叫做外部迭代。
            Stream提供了内部迭代的方式，通过访问者模式(Visitor)实现。

     面试题：Kafka、ActiveMQ、RabbitMQ、RocketMQ 有什么优缺点
     https://mp.weixin.qq.com/s?__biz=MzI0NjQ0MjMxNA==&mid=2247493833&idx=1&sn=4f372137988497582e09eedc2d0ae1b1&chksm=e9bd98ecdeca11fa856afb5d8dfb711a9549c9ace5f5158e3b659ef6071238e7265c49fe44ec&scene=0&xtrack=1#rd
     */

    public static void main(String[] args) {
        getList();
        getObject();
    }

    public static void getObject(){
        List<User> list = new ArrayList<>();
        for(int i=0;i<3;i++) {
            User user = new User();
            user.setAge(50 + i);
            user.setName("yiqq" + i);
            list.add(user);
        }
        Collections.sort(list,(g1,g2)-> g1.getAge()-g2.getAge());
        Collections.sort(list, Comparator.comparingInt(User::getAge));
        Collections.sort(list,(user1,user2)->{
            if (user1.getAge() - user2.getAge() > 0) {
                return 1;
            }else if(user1.getAge() - user2.getAge() < 0){
                return -1;
            } else {
                return 0;
            }
        });
    }

    public static void getList(){
        List<Double> list = new ArrayList<>();
        list.add(0.0001);
        list.add(0.0001);
        list.add(0.001);
        list.add(0.005);
        list.add(0.03);
        list.add(0.5);
        list.add(0.2);
        list.add(0.2638);
        Collections.sort(list, Comparator.comparingDouble(g -> g));
    }
}
