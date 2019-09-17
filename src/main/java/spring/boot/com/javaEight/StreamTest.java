package spring.boot.com.javaEight;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: yiqq
 * @date: 2019/4/25
 * @description: Java8 Stream流操作学习总结
 * https://mp.weixin.qq.com/s/nf9W_NINnZxXfwV_K7C-Gg
 */
public class StreamTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(StreamTest.class);

    private static User user = new User();

    /**
     * 对用户按年龄进行排序
     */
    @Test
    public void testSort1() {

        // 传统方式排序
        LOGGER.info("===============传统方式排序===============");
        List<User> userList1 = user.createUserDatas();
        long time1 = System.currentTimeMillis();
        Collections.sort(userList1, user.getAgeComparator());
        LOGGER.info("传统方式排序耗时 ==> {} (ms)", System.currentTimeMillis() - time1);
        userList1.stream().forEach(user -> {
            LOGGER.info(user.toString());
        });
        // Java8的方式排序
        LOGGER.info("==============Java8的方式排序=============");
        List<User> userList2 = user.createUserDatas();
        long time2 = System.currentTimeMillis();
        List<User> sortedUsers = userList2.stream().sorted(user.getAgeComparator()).collect(Collectors.toList());
        LOGGER.info("Java8的方式排序耗时 ==> {} (ms)", System.currentTimeMillis() - time2);
        sortedUsers.stream().forEach(user -> {
            LOGGER.info(user.toString());
        });
    }

    /**
     * 选出年龄最小的三个人
     */
    @Test
    public void testSort2() {

        // 传统方式排序
        LOGGER.info("===============传统方式排序===============");
        List<User> userList1 = user.createUserDatas();
        long time1 = System.currentTimeMillis();
        Collections.sort(userList1, user.getAgeComparator());
        // 切割出0,1,2这三个子元素
        List<User> userListTopThree1 = userList1.subList(0, 3);
        LOGGER.info("传统方式排序耗时 ==> {} (ms)", System.currentTimeMillis() - time1);
        userListTopThree1.stream().forEach(user -> {
            LOGGER.info(user.toString());
        });
        // Java8的方式排序
        LOGGER.info("==============Java8的方式排序=============");
        List<User> userList2 = user.createUserDatas();
        long time2 = System.currentTimeMillis();
        List<User> userListTopThree2 = userList2.stream().sorted(user.getAgeComparator()).limit(3)
                .collect(Collectors.toList());
        LOGGER.info("Java8的方式排序耗时 ==> {} (ms)", System.currentTimeMillis() - time2);
        userListTopThree2.stream().forEach(user -> {
            LOGGER.info(user.toString());
        });
    }

    /**
     * 去除重复数据
     */
    @Test
    public void testDisdinct() {

        // 传统方式去重
        LOGGER.info("===============传统方式去重===============");
        List<User> userList1 = user.createUserDatas();
        long time1 = System.currentTimeMillis();
        int length = userList1.size();
        for (int i = 1; i < length; i++) {
            if (userList1.get(i).equals(userList1.get(i - 1))) {
                userList1.remove(i);
                i--;
                length--;
            }
        }
        LOGGER.info("传统方式去重耗时 ==> {} (ms)", System.currentTimeMillis() - time1);
        userList1.stream().forEach(user -> {
            LOGGER.info(user.toString());
        });
        // Java8的方式去重
        LOGGER.info("==============Java8的方式去重=============");
        List<User> userList2 = user.createUserDatas();
        long time2 = System.currentTimeMillis();
        List<User> distinctUserList = userList2.stream().sorted().distinct().collect(Collectors.toList());
        LOGGER.info("Java8的方式去重耗时 ==> {} (ms)", System.currentTimeMillis() - time2);
        distinctUserList.stream().forEach(user -> {
            LOGGER.info(user.toString());
        });
    }

    /**
     * 按条件筛选
     */
    @Test
    public void testFilter() {

        // 传统方式按条件筛选
        LOGGER.info("===============传统方式按条件筛选===============");
        List<User> userList1 = user.createUserDatas();
        long time1 = System.currentTimeMillis();
        ArrayList<User> result1 = new ArrayList<>();
        for (User user : userList1) {
            if (user.getName().startsWith("韩"))
                result1.add(user);
        }
        LOGGER.info("传统方式按条件筛选耗时 ==> {} (ms)", System.currentTimeMillis() - time1);
        result1.stream().forEach(user -> {
            LOGGER.info(user.toString());
        });
        // Java8的方式按条件筛选
        LOGGER.info("==============Java8的方式按条件筛选=============");
        List<User> userList2 = user.createUserDatas();
        long time2 = System.currentTimeMillis();
        List<User> result2 = userList2.stream().filter(user -> user.getName().startsWith("韩"))
                .collect(Collectors.toList());
        LOGGER.info("Java8的方式按条件筛选耗时 ==> {} (ms)", System.currentTimeMillis() - time2);
        result2.stream().forEach(user -> {
            LOGGER.info(user.toString());
        });
        List<User> result3 = userList2.stream().filter(user -> user.getName().startsWith("韩") && user.getGendar() == 2)
                .collect(Collectors.toList());
        List<User> result4 = userList2.stream().filter(user -> user.getName().startsWith("韩"))
                .filter(user -> user.getGendar() == 2).collect(Collectors.toList());
        List<User> result5 = userList2.stream().filter(user -> user.getGendar() == 2)
                .filter(user -> user.getName().startsWith("韩")).collect(Collectors.toList());
        LOGGER.info("result3 ==> {}", JSON.toJSONString(result3, true));
        LOGGER.info("result4 ==> {}", JSON.toJSONString(result4, true));
        LOGGER.info("result5 ==> {}", JSON.toJSONString(result5, true));
    }

    /**
     * 只列出所有人的名字和婚姻状况
     */
    @Test
    public void testMap() {

        // 传统方式
        LOGGER.info("===============传统方式===============");
        List<User> userList1 = user.createUserDatas();
        long time1 = System.currentTimeMillis();
        ArrayList<String> result1 = new ArrayList<String>();
        for (User user : userList1) {
            result1.add(user.getName() + ":".concat(user.isHasMarried() ? "已婚" : "未婚"));
        }
        LOGGER.info("传统方式耗时 ==> {} (ms)", System.currentTimeMillis() - time1);
        result1.stream().forEach(user -> {
            LOGGER.info(user.toString());
        });
        // Java8的方式
        LOGGER.info("==============Java8的方式序=============");
        List<User> userList2 = user.createUserDatas();
        long time2 = System.currentTimeMillis();
        List<String> result2 = userList2.stream()
                .map(user -> user.getName() + ":".concat(user.isHasMarried() ? "已婚" : "未婚"))
                .collect(Collectors.toList());
        LOGGER.info("Java8的方式耗时 ==> {} (ms)", System.currentTimeMillis() - time2);
        result2.stream().forEach(user -> {
            LOGGER.info(user.toString());
        });
    }

    /**
     * 判断当前数组是否包含某些特定元素
     */
    @Test
    public void testAnyMatch() {

        // 传统方式
        LOGGER.info("===============传统方式===============");
        List<User> userList1 = user.createUserDatas();
        long time1 = System.currentTimeMillis();
        boolean isChild1 = false;
        for (User user : userList1) {
            if (user.getAge() < 18) {
                isChild1 = true;
                break;
            }
        }
        LOGGER.info("传统方式耗时 ==> {} (ms)", System.currentTimeMillis() - time1);
        LOGGER.info("isChild1 ==> {}", isChild1);
        // Java8的方式
        LOGGER.info("==============Java8的方式序=============");
        List<User> userList2 = user.createUserDatas();
        long time2 = System.currentTimeMillis();
        boolean isChild2 = userList2.stream().anyMatch(user -> user.getAge() < 18);
        LOGGER.info("Java8的方式耗时 ==> {} (ms)", System.currentTimeMillis() - time2);
        LOGGER.info("isChild2 ==> {}", isChild2);
    }

    /**
     * 确认所有元素均满足某一条件
     */
    @Test
    public void testAllMatch() {

        // 传统方式
        LOGGER.info("===============传统方式===============");
        List<User> userList1 = user.createUserDatas();
        long time1 = System.currentTimeMillis();
        boolean allMarried1 = true;
        for (User user : userList1) {
            if (!user.isHasMarried()) {
                allMarried1 = false;
                break;
            }
        }
        LOGGER.info("传统方式耗时 ==> {} (ms)", System.currentTimeMillis() - time1);
        LOGGER.info("allMarried1 ==> {}", allMarried1);
        // Java8的方式
        LOGGER.info("==============Java8的方式序=============");
        List<User> userList2 = user.createUserDatas();
        long time2 = System.currentTimeMillis();
        boolean allMarried2 = userList2.stream().allMatch(user -> user.isHasMarried());
        LOGGER.info("Java8的方式耗时 ==> {} (ms)", System.currentTimeMillis() - time2);
        LOGGER.info("allMarried2 ==> {}", allMarried2);
    }

    /**
     * 求和求平均值
     */
    @Test
    public void testSum() {

        // 传统方式
        LOGGER.info("===============传统方式===============");
        List<User> userList1 = user.createUserDatas();
        long time1 = System.currentTimeMillis();
        int sum1 = 0;
        for (User user : userList1) {
            sum1 += user.getAge();
        }
        LOGGER.info("传统方式耗时 ==> {} (ms)", System.currentTimeMillis() - time1);
        LOGGER.info("sum ==> {}", sum1);
        // Java8的方式
        LOGGER.info("==============Java8的方式序=============");
        List<User> userList2 = user.createUserDatas();
        long time2 = System.currentTimeMillis();
        int sum2 = userList2.stream().mapToInt(user -> user.getAge()).sum();
        LOGGER.info("Java8的方式耗时 ==> {} (ms)", System.currentTimeMillis() - time2);
        LOGGER.info("sum2 ==> {}", sum2);
    }

    /**
     * 分组
     */
    @Test
    public void testGroupingBy() {

        // 传统方式
        LOGGER.info("===============传统方式===============");
        List<User> userList1 = user.createUserDatas();
        long time1 = System.currentTimeMillis();
        Map<Integer, List<User>> group1 = new HashMap<>();
        for (User user : userList1) {
            List<User> list = group1.get(user.getAge());
            if (list == null) {
                list = new ArrayList<User>();
                group1.put(user.getAge(), list);
            }
            list.add(user);
        }
        LOGGER.info("传统方式耗时 ==> {} (ms)", System.currentTimeMillis() - time1);
        LOGGER.info("group1 ==> {}", JSON.toJSONString(group1), true);
        // Java8的方式
        LOGGER.info("==============Java8的方式序=============");
        List<User> userList2 = user.createUserDatas();
        long time2 = System.currentTimeMillis();
        Map<Integer, List<User>> group2 = userList2.stream().collect(Collectors.groupingBy(t -> t.getAge()));
        // 如果想按是否结婚分组，也就是key变成bool，那就应该这么写
        // Map<Boolean,List<User>> group =
        // users.stream().collect(Collectors.partitioningBy(t->t.hasMarried));
        LOGGER.info("Java8的方式耗时 ==> {} (ms)", System.currentTimeMillis() - time2);
        LOGGER.info("group2 ==> {}", JSON.toJSONString(group2), true);
    }

    /**
     * 链式操作
     */
    @Test
    public void testLinkOperation() {

        LOGGER.info("==============Java8链式操作=============");
        List<User> userList = user.createUserDatas();
        long time = System.currentTimeMillis();
        userList.stream().filter(t -> t.getGendar() == 2).map(t -> t.getName()).forEach(System.out::println);
        LOGGER.info("Java8链式操作耗时 ==> {} (ms)", System.currentTimeMillis() - time);
    }

}
