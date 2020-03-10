package single;

import com.study.single.InterviewDom;
import com.util.SerializableUtil;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @program: study
 * @description:
 * @author: jinlu
 * @create: 2020-03-09 16:38
 **/
public class InterviewDomTest {

    @Test
    public void test(){
        // 对比两个对象是否是同一个对象
        InterviewDom interviewDom = InterviewDom.getInterviewDom();
        InterviewDom interviewDom2 = InterviewDom.getInterviewDom();
        System.out.println(interviewDom == interviewDom2);
    }

    @Test
    public void test2(){
        // 线程测试对象地址是否一致
        for (int i = 0; i < 20; i++) {
             new Thread(new Runnable() {
                 @Override
                 public void run() {
                     System.out.println(InterviewDom.getInterviewDom());
                 }
             }).start();
        }
    }

    @Test
    public void test3() throws Exception {
        Class clazz = InterviewDom.class;                           // 反射获取类文件
        Constructor constructor = clazz.getDeclaredConstructor();   // 获取类的构造方法
        constructor.setAccessible(true);                            // 打开类的私有化权限
        InterviewDom s1 = InterviewDom.getInterviewDom();
        InterviewDom s2 = (InterviewDom) constructor.newInstance();
        System.out.println(s1 == s2);
    }

    @Test
    public void test4() throws Exception {
        //InterviewDom s1 = InterviewDom.getInterviewDom();
        //SerializableUtil.serialize(s1);
        InterviewDom s1 = (InterviewDom) SerializableUtil.unserialize();
        InterviewDom s2 = (InterviewDom) SerializableUtil.unserialize();
        System.out.println(s1 == s2);
    }
}