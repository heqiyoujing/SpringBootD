package spring.boot.com.ImplemtntAndAbstract;

/**
 * @author: yiqq
 * @date: 2019/5/8
 * @description: 类继承抽象接口
 */
public class Wanger extends Author {
    @Override
    void write() {
        System.out.println("沉默王二的作品《Web 全栈开发进阶之路》，读起来轻松惬意");
    }
}
