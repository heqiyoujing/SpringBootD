package spring.boot.com.javaEight.defaultInterface;

import java.time.DateTimeException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 函数式接口(FunctionalInterface)就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。
 * https://www.cnblogs.com/JohnTsai/p/5598036.html
 */
public interface April {

    /**
     * java8接口默认方法
     */
    default int draw(List<Double> list) {
        List<Double> sortRateList = new ArrayList<Double>();
        double sumRate = 0d;
        // 计算概率总和
        sumRate = list.stream().mapToDouble(Double::doubleValue).sum();
        // 随机生成一个随机数
        double random = new java.security.SecureRandom().nextDouble();
        if (sumRate != 0) {
            double rate = 0d;
            for (int i = 0; i < list.size(); i++) {
                double prob = list.get(i);
                rate += prob;
                sortRateList.add(rate / sumRate); //计算区间
            }
            sortRateList.add(random);
            Collections.sort(sortRateList);
            return sortRateList.indexOf(random);
        }
        return -1;
    }

    /**
     * java8接口静态方法
     */
    static ZoneId getZoneId (String zoneString) {
        try {
            return ZoneId.of(zoneString);
        } catch (DateTimeException e) {
            System.err.println("Invalid time zone: " + zoneString +
                    "; using default time zone instead.");
            return ZoneId.systemDefault();
        }
    }


    /**
     * 继承含有默认方法的接口:
     * 1.不去管默认方法，继承的接口直接继承默认方法
     * 2.重新声明默认方法，这样会使得这个方法变成抽象方法
     * 3.重新定义默认方法，这样会使得方法被重写
     */

}
