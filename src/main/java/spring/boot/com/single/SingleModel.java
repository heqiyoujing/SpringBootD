package spring.boot.com.single;

/**
 * @author: yiqq
 * @date: 2019/5/7
 * @description: 静态内部类实现单例
 */
public class SingleModel {

    private static class SingleHandle{
        private static final SingleModel SINGLE_MODEL = new SingleModel();
    }
    private SingleModel (){}
    public static final SingleModel getInstance(){
        return SingleHandle.SINGLE_MODEL;
    }
}
