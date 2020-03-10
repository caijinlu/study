package single;

import com.study.single.SingletonLazy;
import com.study.single.SingletonThread;
import org.junit.Test;

import java.io.IOException;

/**
 * @program: study
 * @description:
 * @author: jinlu
 * @create: 2020-03-10 15:20
 **/
public class SingletonThreadTest {

    @Test
    public void test(){
        // 单线程中测试
        SingletonThread singletonLazy = SingletonThread.getSingletonThread();
        SingletonThread singletonLazy2 = SingletonThread.getSingletonThread();
        System.out.println(singletonLazy==singletonLazy2);
    }

    @Test
    public void test1(){
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SingletonThread singletonLazy = SingletonThread.getSingletonThread();
                    SingletonThread singletonLazy2 = SingletonThread.getSingletonThread();
                    System.out.println(Thread.currentThread().getName() + " , " + (singletonLazy==singletonLazy2) + singletonLazy);
                }
            }).start();
        }
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}