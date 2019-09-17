package spring.boot.com.util.weixinDocument;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: yiqq
 * @date: 2019/4/17
 * @description: 禁止在 foreach 循环里进行元素的 remove/add 操作
 * https://mp.weixin.qq.com/s/tC1S9W8njObulTP35Owd6A
 */
public class foreachT {
    public static void main(String[] args) {
        // 使用ImmutableList初始化一个List,是不可变集合，不能进行删除
        List<String> list = ImmutableList.of("Hollis", "hollis", "HollisChuang", "H");
        List<String> userNames = new ArrayList<>();
        userNames.add("Hollis");
        userNames.add("hollis");
        userNames.add("HollisChuang");
        userNames.add("H");

        System.out.println("-------------------->>>>>>>>>>>>>>>>>>>>普通for循环");
        for (int i = 0; i < userNames.size(); i++) {
            System.out.println(userNames.get(i));
            if (userNames.get(i).equals("Hollis")) {
                userNames.remove(i);
            }
        }
        System.out.println(userNames);
//        System.out.println("-------------------->>>>>>>>>>>>>>>>>>>>增强for循环");
//        //原本的增强for循环，其实是依赖了while循环和Iterator实现的
//        for (String userName : userNames) {
//            System.out.println(userName);
//            //报错
//            if (userName.equals("Hollis")) {
//                userNames.remove(userName);
//            }
//        }
//        System.out.println(userNames);
        System.out.println("-------------------->>>>>>>>>>>>>>>>>>>>Iterator");
        Iterator<String> it = userNames.iterator();
        while (it.hasNext()) {
            String name = it.next();
            if ("hollis".equals(name)) {
                it.remove();
            }
        }
        System.out.println(userNames);
        System.out.println("-------------------->>>>>>>>>>>>>>>>>>>>Lambda表达式");
        userNames = userNames.stream().filter(userName -> !userName.equals("H")).collect(Collectors.toList());
        System.out.println(userNames);
    }
}
