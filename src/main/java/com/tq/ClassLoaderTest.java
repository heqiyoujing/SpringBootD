package com.tq;

/**
 * @author: yiqq
 * @date: 2019/4/15
 * @description:
 * https://blog.csdn.net/tang9140/article/details/42738433
 */
public class ClassLoaderTest {
    /**
     * Prohibited package name: java.lang
     * java.lang.ClassNotFoundException
     * 在preDefineClass方法中抛出的SecurityException。
     * 对于自定义的类加载器，强行用defineClass()方法去加载一个以"java."开头的类也是会抛出异常的
     *
     * 不能自己写以"java."开头的类，其要么不能加载进内存，要么即使你用自定义的类加载器去强行加载，也会收到一个SecurityException。
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        ClassLoader myLoader = new MyClassLoader();
        Object obj = myLoader.loadClass("java.lang.Math").newInstance();
        System.out.println(obj);
    }

}
