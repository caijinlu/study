package single;

import com.study.single.InterviewDom;
import com.study.single.Singleton;
import com.study.single.SingletonEnum;
import com.util.SerializableUtil;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @program: study
 * @description:
 * @author: jinlu
 * @create: 2020-03-10 14:06
 **/
public class SingletonEnumTest {

    @Test
    public void test(){
        SingletonEnum singletonEnum =  SingletonEnum.INSTANCE;
        SingletonEnum singletonEnum2 =  SingletonEnum.INSTANCE;
        System.out.println(singletonEnum == singletonEnum2);
    }

    @Test
    public void test2(){
        // 线程测试对象地址是否一致
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(SingletonEnum.INSTANCE);
                }
            }).start();
        }
    }

    @Test
    public void test1() throws Exception {      // 反射测试
        Class clazz = SingletonEnum.class;
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingletonEnum singletonEnum =  SingletonEnum.INSTANCE;
        SingletonEnum singleton2 = (SingletonEnum) constructor.newInstance();
        System.out.println(singletonEnum == singleton2);
    }


    @Test
    public void test3(){                       // 序列化测试
       // SerializableUtil.serialize(SingletonEnum.INSTANCE);
        SingletonEnum s1 = (SingletonEnum) SerializableUtil.unserialize();
        SingletonEnum singletonEnum =  SingletonEnum.INSTANCE;
        System.out.println(s1 == singletonEnum);
    }
}