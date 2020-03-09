import com.study.InterviewDom;
import com.study.Singleton;
import com.util.SerializableUtil;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @program: study
 * @description: 登记式
 * @author: jinlu
 * @create: 2020-03-09 17:24
 **/
public class SingletonTest {

    @Test
    public void test(){
        // 对比两个对象是否是同一个对象
       /* Singleton s1 = Singleton.getSingleton();
        Singleton s2 = Singleton.getSingleton();
        System.out.println(s1 == s2);*/
        try {
            Class.forName("com.study.Singleton");   // 类加载去创建类
            Singleton.getSingleton();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void test1() throws Exception {      // 反射测试
        Class clazz = Singleton.class;
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton s1 = Singleton.getSingleton();
        Singleton singleton2 = (Singleton) constructor.newInstance();
        System.out.println(s1 == singleton2);
    }

    @Test
    public void test2(){                        // 线程测试
        for (int i = 0; i < 20; i++) {
             new Thread(new Runnable() {
                 @Override
                 public void run() {
                     System.out.println(Singleton.getSingleton());
                 }
             }).start();

        }
    }

    @Test
    public void test3(){                       // 序列化测试
        // SerializableUtil.serialize(Singleton.getSingleton());
        Singleton s1 = (Singleton) SerializableUtil.unserialize();
        Singleton singleton = Singleton.getSingleton();
        System.out.println(s1 == singleton);
    }
}