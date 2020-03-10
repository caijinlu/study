package single;

import com.study.single.Singleton;
import com.study.single.SingletonLazy;
import com.util.SerializableUtil;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Constructor;

/**
 * @program: study
 * @description: 懒汉式 Test
 * @author: jinlu
 * @create: 2020-03-10 14:43
 **/
public class SingletonLazyTest {

    @Test
    public void test(){
        // 单线程中测试
        SingletonLazy singletonLazy = SingletonLazy.getSingletonLazy();
        SingletonLazy singletonLazy2 = SingletonLazy.getSingletonLazy();
        System.out.println(singletonLazy==singletonLazy2);
    }

    @Test
    public void test2(){                        // 线程测试
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(SingletonLazy.getSingletonLazy());
                }
            }).start();
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test1() throws Exception {      // 反射测试
        Class clazz = SingletonLazy.class;
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingletonLazy s1 = SingletonLazy.getSingletonLazy();
        SingletonLazy singleton2 = (SingletonLazy) constructor.newInstance();
        System.out.println(s1 == singleton2);
    }

    @Test
    public void test3(){                       // 序列化测试
       //SerializableUtil.serialize(SingletonLazy.getSingletonLazy());
        SingletonLazy s1 = (SingletonLazy) SerializableUtil.unserialize();
        SingletonLazy singleton = SingletonLazy.getSingletonLazy();
        System.out.println(s1 == singleton);
    }
}