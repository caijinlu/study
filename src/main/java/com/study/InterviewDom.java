package com.study;

import java.io.Serializable;

/**
 * @program: study
 * @description: 单例 -饿汉式
 * @author: jinlu
 * @create: 2020-03-09 16:12
 **/
public class InterviewDom implements Serializable {
    /**
     *  私有化构造器
     *  提供静态的实例对象
     *  公开外部调用实例的方法
     *  优点：类加载的时候就已经开始创建对象 执行效率高 线程是安全的
     *  缺点：当前类创建需要很多资源时会浪费很多内存，对于反射和发序列化是不安全的
     * */

    private static InterviewDom interviewDom = new InterviewDom();  // 静态属性是全局的 永远共享同一个属性

    private InterviewDom() {
    }

    public static InterviewDom getInterviewDom(){
        return interviewDom;
    }

    // 因为静态的变量在序列化的时候是不会被保存的 在反序列化时会创建实例 从而破坏单例
    // 提供readResolve在方法在反序列化的时候返回当前的对象 从而解决序列化不安全的问题
    private Object readResolve(){
        return interviewDom;
    }
}