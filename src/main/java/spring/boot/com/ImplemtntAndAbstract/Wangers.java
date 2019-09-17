package spring.boot.com.ImplemtntAndAbstract;

/**
 * @author: yiqq
 * @date: 2019/5/8
 * @description: 类 继承抽象接口，并且实现多接口
 * https://mp.weixin.qq.com/s?__biz=MzU3NzczMTAzMg==&mid=2247483998&idx=1&sn=e8ffea18d12f2eec1e681b6c29279e23&chksm=fd0162e9ca76ebffb885edd6bb685f27668af8a4837e38ff2200445c1b6964392ad2a4192652&mpshare=1&scene=24&srcid=0502pMYkmtZKlESRPq1bSBzy#rd
 */
public class Wangers extends Author implements ContractBeihang,Contract51{

    /**
     1.抽象类中的方法可以有方法体，能实现方法具体要实现的功能，但是接口中的方法不行，没有方法体。
     2.抽象类中的成员变量可以是各种类型的，而接口中的成员变量只能是 public static final 类型的，并且是隐式的，缺省的。
     3.接口中不能含有静态代码块以及静态方法(用 static 修饰的方法)，而抽象类是可以有静态代码块和静态方法的。
     4.一个类只能继承一个抽象类，而一个类却可以实现多个接口。

     究竟什么时候使用接口，什么时候使用抽象类呢？
     1、抽象类表示了一种“is-a”的关系，而接口表示的是“like-a”的关系。也就是说，如果 B 类是 A（沉默王二是一个作者），
        则 A 应该用抽象类。如果 B 类只是和 A 有某种关系，则 A 应该用接口。
     2、 如果要拥有自己的成员变量和非抽象方法，则用抽象类。接口只能存在静态的不可变的成员变量（不过一般都不在接口中定义成员变量）。
     3、为接口添加任何方法（抽象的），相应的所有实现了这个接口的类，也必须实现新增的方法，否则会出现编译错误。对于抽象类，
        如果添加了非抽象方法，其子类却可以坐享其成，完全不必担心编译会出问题。
     4、抽象类和接口有很大的相似性，请谨慎判断。Java 从1.8版本开始，尝试向接口中引入了默认方法和静态方法，以此来减少抽象
        类和接口之间的差异。换句话说，两者之间越来越难区分了。
     */

    @Override
    void write() {
        System.out.println("作品《Web 全栈开发进阶之路》，读起来轻松惬意的技术书");
    }

    @Override
    public void scriptBeihang() {
        System.out.println("一年内完成书稿啊，不然要交违约金的哦。");
    }

    @Override
    public void script51() {
        System.out.println("王老师，先把 Java 云盘的大纲整理出来。");
    }
}
