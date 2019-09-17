package spring.boot.com.util.bug;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author: 何其有静
 * @date: 2019/3/27
 * @description: 容易出错的地方
 */
public class BugHui {

    public static void main(String[] args) {
        asList();
    }

    /**
     * list的remove进入不同重载方法
     */
    public static void test(){
            Set<Integer> set = new TreeSet<Integer>();
            List<Integer> list = new ArrayList<Integer>();
            for(int i=-3;i<3;i++) {
                set.add(i);
                list.add(i);
            }
            for(int i=0;i<3;i++) {
                set.remove(i);
                list.remove((Integer) i);//remove(Object o)
//            list.remove(i);//remove(int index)
            }
            System.out.println(set + " : " + list);
    }

    /**
     * 精度问题，建议采用BigDecimal,然后保留2位
     */
    public static void decimal(){
            double funds = 1;
            int timesBought = 0;
            for (double price = 0.1; funds >= price; price += 0.1) {
                funds -= price;
                timesBought++;
            }
            System.out.println("timeBought: " + timesBought);
            System.out.println("change: $" + funds);
    }

    /**
     * 比较出错
     */
    public static void compare(){
        int a = comparator.compare(new Integer(42), new Integer(42));
        System.out.println(a);
    }

    static Comparator<Integer> comparator = new Comparator<Integer>() {
        public int compare(Integer first, Integer second) {
            return first < second ? -1 : (first == second ? 0 : 1);
        }
    };

    /**
     * 自动拆箱出错
     */
    static Integer i;
    public static void testInteger(){
        if (i == 42) {
            System.out.println("Unable");
        }
    }

    /**
     * 精度精度
     */
    public static void decimals(){
        System.out.println("---------->" + (1.03 - 0.42));
        System.out.println("---------->" + (1.00 - 9 * 0.10));
    }

    /**
     * 浅谈Arrays.asList()方法的使用
     　首先，该方法是将数组转化为list。有以下几点需要注意：
     　　（1）该方法不适用于基本数据类型（byte,short,int,long,float,double,boolean）
     　　（2）该方法将数组与列表链接起来，当更新其中之一时，另一个自动更新
     　　（3）不支持add和remove方法
     *
     */
    public static void asList(){
        int [] arrs = {1,2,3};
        List list = Arrays.asList(arrs);
        for(Object arr: list){
            System.out.println(arr);
        }
    }

    /**
     * transient关键字的作用是：阻止实例中那些用此关键字修饰的的变量序列化；当对象被反序列化时，被transient修饰的
     * 变量值不会被持久化和恢复。transient只能修饰变量，不能修饰类和方法。
     */


    /**
     * 改变System.out.println输出方式
     */
    public static void print(){
        int a,b;
        a = 4;
        b = 5;
        method(a,b);
        System.out.println("a="+a+", b="+b);
    }

    public static void method(int a, int b) {
        PrintStream Sys = new PrintStream(System.out){
            @Override
            public void println(String x) {
                super.println("a="+a*100+", b="+b*100);
            }
        };
        System.setOut(Sys);
    }


}
