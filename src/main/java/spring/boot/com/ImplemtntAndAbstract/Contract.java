package spring.boot.com.ImplemtntAndAbstract;

/**
 * http://www.cnblogs.com/cornucopia2015/p/4806697.html
 * 接口继承多个接口：
 * 接口可以继承多个接口是因为接口里面的定义的方法都是未实现的，不会增加复杂性。
 * 接口不是类，而是对类的一组需求的描述。接口绝不能含有实例域，也不能在接口中实现方法。接口可以实现多继承不会增加代码的复杂性。
 * 多继承是发生在执行期间的，而不是在编译期间，所以可以编译通过，并且不违背Java是单继承的。
 *
 * 因为接口定义的都是抽象的方法，而且不能在接口中实现方法。所以，接口继承多个接口，并不会使接口的结构变得很复杂。
 * 相反，这样做，还能给一个团队在开发的过程中，提供很多便利。

 单继承指的是class，而不是interface. interface是可以多继承的。
 */
public interface Contract extends Contract51,ContractBeihang{
    void contract();
}
