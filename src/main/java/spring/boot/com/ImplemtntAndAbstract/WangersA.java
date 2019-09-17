package spring.boot.com.ImplemtntAndAbstract;

/**
 * @author: yiqq
 * @date: 2019/5/8
 * @description: 类实现一个接口(该接口继承了多个接口),必须实现所有相关接口的方法.
 *
 * 这种方法的好处在于,Contract接口相当于把它两个继承的接口里的方法放到自己的接口方法里,通过继承接口直接实现
 */
public class WangersA implements Contract{
    @Override
    public void contract() {
        System.out.println("类实现的接口Contract");
    }

    @Override
    public void script51() {
        System.out.println("接口Contract继承的接口script51");
    }

    @Override
    public void scriptBeihang() {
        System.out.println("接口Contract继承的接口ContractBeihang");
    }
}
