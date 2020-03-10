package com.study.single;

/**
 * @program: study
 * @description: 单例 -ThreadLocal
 * @author: jinlu
 * @create: 2020-03-10 15:15
 **/
public class SingletonThread {

    private static SingletonThread singletonThread = null;

    private SingletonThread(){}

    private static final ThreadLocal<SingletonThread> threadSingleton = new ThreadLocal<SingletonThread>(){
        @Override
        protected SingletonThread initialValue(){       // 重写初始化的方法
            return new SingletonThread();
        }
    };

    public static SingletonThread getSingletonThread(){
        return threadSingleton.get();
    }
}