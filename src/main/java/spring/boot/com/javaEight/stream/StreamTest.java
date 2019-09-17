package spring.boot.com.javaEight.stream;

import spring.boot.com.entity.GsonFormatModel;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: yiqq
 * @date: 2019/4/15
 * @description: Java 8 Stream
 * https://blog.csdn.net/yitian_66/article/details/81010434
 */
public class StreamTest {
    public static void main(String[] args) {
        createStream();
        getForEach();
        getMap();
        getFilter();
        getLimit();
        getSorted();
        getParallel();
        getCollectors();
        getStatistics();
        getSumAll();
    }

    /**
     * 1.生成Stream
     */
    public static void createStream(){
        System.out.println("-------------------->>>>>>>>>>生成Stream");
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        filtered.forEach(System.out::println);
    }

    /**
     * 2.forEach
     */
    public static void getForEach(){
        System.out.println("-------------------->>>>>>>>>>forEach");
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
    }

    /**
     * 3.map
     */
    public static void getMap(){
        System.out.println("-------------------->>>>>>>>>>map");
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        squaresList.forEach(System.out::println);
    }

    /**
     * 4.filter
     */
    public static void getFilter(){
        System.out.println("-------------------->>>>>>>>>>filter");
        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        // 获取空字符串的数量
        int count = (int) strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println("空字符串的数量: "+count);
    }

    /**
     * 5.limit
     */
    public static void getLimit(){
        System.out.println("-------------------->>>>>>>>>>limit");
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
    }

    /**
     * 6.sorted
     */
    public static void getSorted(){
        System.out.println("-------------------->>>>>>>>>>sorted");
        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);
    }

    /**
     * 7.并行（parallel）程序
     */
    public static void getParallel(){
        System.out.println("-------------------->>>>>>>>>>parallel");
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        // 获取空字符串的数量
        int count = (int) strings.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println("parallel: " + count);
    }

    /**
     * 8.Collectors
     */
    public static void getCollectors(){
        System.out.println("-------------------->>>>>>>>>>Collectors");
        List<String> list = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = list.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("筛选列表: " + filtered);
        String mergedString = list.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);
    }

    /**
     * 9.统计Statistics
     */
    public static void getStatistics(){
        System.out.println("-------------------->>>>>>>>>>Statistics");
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
    }

    /**
     * 10.求和集合某个属性
     */
    public static void getSumAll(){
        System.out.println("-------------------->>>>>>>>>>Statistics");
        List<GsonFormatModel> numbers = new ArrayList<>();
        GsonFormatModel gsonFormatModel = new GsonFormatModel();
        gsonFormatModel.setFrom(111);
        numbers.add(gsonFormatModel);
        GsonFormatModel gsonFormatModel1 = new GsonFormatModel();
        gsonFormatModel1.setFrom(999);
        numbers.add(gsonFormatModel1);
        int  stats = numbers.stream().mapToInt(GsonFormatModel::getFrom).sum();
        System.out.println("所有数之和 : " + stats);
    }



}
