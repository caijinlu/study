package com.study.single;

/**
 * @program: study
 * @description: 单例 -懒汉式
 * @author: jinlu
 * @create: 2020-03-10 14:15
 **/
public class SingletonLazy {

    /**
     * 懒汉式只有调用方法时才创建对象
     * 简单的懒汉式线程是不安全的
     * 双检索的懒汉式式也不是绝对的安全的 创建对象的步骤为 1.分配对象的内存空间 2.初始化对象 3.指向1中的分配的空间
     * 在某些编译器上可能会出现指令重排 会变成 1.分配对象的内存空间 2.指向1中的分配的空间 3.初始化对象
     * 指令重排不会影响创建对象最终的结果 只是在多线程时 A线程 在指定对象的地址 但还没有初始化对象时 B线程进入读取到了A没有初始化的内存地址 B就会读走一个空的对象
     * 解决指令重排可以在静态属性上面加上 volatile 关键字保证变量不进行指令重排
     *
     * 私有化构造器
     * 提供静态的单例属性
     * 提供公有方法获取单例对象
     * **/

    private static volatile SingletonLazy singletonLazy = null;

    private SingletonLazy(){}

    public static SingletonLazy getSingletonLazy(){
        // 双检索同步代码块 只有在一开始初始化才会进入到synchronized
        if (singletonLazy == null){
            synchronized (SingletonLazy.class){
                if (singletonLazy == null){
                    singletonLazy = new SingletonLazy();
                }
            }
        }
        return singletonLazy;
    }
}