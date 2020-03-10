package com.study.single;

/**
* @Description: 单例 -枚举式
* @Param:
* @return:
* @Author: jinlu
* @Date:
*/
public enum SingletonEnum {

    /**
     * 定义一个对象属性
     * 提供一个抽象方法
     * 属性中实现抽象
     *
     * 枚举没有构造器
     * 枚举支持序列化
     * 缺点 无法被其他类继承
     * **/

    INSTANCE{
        @Override
        protected void getInstance() {
            System.out.println("创建对象！");
        }
    };

    protected abstract void getInstance();
}
