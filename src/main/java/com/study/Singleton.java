package com.study;

import java.io.Serializable;

/**
 * @program: study
 * @description: 单例 - 登记式(静态内部类)
 * @author: jinlu
 * @create: 2020-03-09 17:19
 **/
public class Singleton implements Serializable {

    /**
     * 私有化构造器
     * 提供静态内部类 内部类中创建静态的单例属性
     * 提供公有方法获取单例对象
     * 优点：只有在调用获取类的方法才会去创建对象 通过修改可以做到 对反射 线程 跟序列化是安全的
     * 加强版的饿汉式
     * **/

    private Singleton() {
        System.out.println("创建对象成功！");
        // 在调用该对象构造器的时候判断内部类对象是否存在 防止反射破坏单例
        if (SingletonHolder.singleton != null){
            throw new IllegalStateException("对象已被创建！");
        }
    }

    private static class SingletonHolder{
        private static Singleton singleton = new Singleton();
    }

    public static Singleton getSingleton(){
        return SingletonHolder.singleton;
    }

    // 因为静态的变量在序列化的时候是不会被保存的 在反序列化时会创建实例 从而破坏单例
    // 提供readResolve在方法在反序列化的时候返回当前的对象 从而解决序列化不安全的问题
    private Object readResolve(){
        return SingletonHolder.singleton;
    }
}
