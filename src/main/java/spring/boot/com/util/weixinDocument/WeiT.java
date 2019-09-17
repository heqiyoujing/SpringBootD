package spring.boot.com.util.weixinDocument;

/**
 * @author: yiqq
 * @date: 2019/4/17
 * @description: 位运算
 * http://mp.weixin.qq.com/s?__biz=MzIzMzgxOTQ5NA==&mid=2247486909&idx=1&sn=9f6176528e88814fbcfc5cb800872e29&chksm=e8fe91b4df8918a23f3b35455959e618442342087798369e47b8ac375b093797643f5cd13237&scene=0&xtrack=1#rd
 */
public class WeiT {

    public static void main(String[] args) {
        isOdd(-1);
    }

    /**
     * 判断一个数是否基数
     * @param i 要判断的数
     * @return 返回结果 true或者false
     */
    public static boolean isOdd(int i) {
        //&:只有两个位都是1，结果才是1 。|:两个位只要有一个为1，那么结果就是1
        return (i & 1) == 1;
    }
}
