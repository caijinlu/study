package single;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: study
 * @description: 字符串算法相关
 * @author: jinlu
 * @create: 2020-03-11 15:18
 **/
public class string {

    @Test   // 算出字符串中出现次数最多的字符
    public void test1(){
        String str = "aaaaaaalllwwwrere";
        char[] a = str.toCharArray();
        char text = a[0];
        int max = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            Integer count = map.get(a[i]);
            if (count != null){
                count++;
            }else {
                count = 1;
            }
            map.put(a[i],count);
            if (count > max){
                text = a[i];
                max = count;
            }
        }
        System.out.println(text + "出现次数: " + max);
    }

    @Test // 找出字符串中第一次重复出现的字符
    public void test2(){
        String str = "afdfssfsa";
        Set<Character> set = new HashSet<>();   // 利用Set元素不能重复的特性
        for (int i = 0; i < str.length(); i++) {
            if (!set.add(str.charAt(i))){
                System.out.println("第一个重复出现的字符是 ： " + str.charAt(i));
                break;
            }
        }
    }

    @Test // 找出字符串中找出第一个只出现一次的字符
    public void test3(){
        String str = "awfdgaga";
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i))){          // 利用String的方法
                System.out.println("第一个只出现一次的字符： " + str.charAt(i));
                break;
            }
        }
    }

    @Test // 统计手机号各个数字的个数，按照升序输出
    public void test4(){
        String str = "13650096499";
        int[] chars = new int[10];
        for (int i = 0; i < str.length(); i++) {            // 通过数组的脚标进行排序 桶排序
            char c = str.charAt(i);
            chars[c - '0'] += 1;
        }
        for (int i = 0; i < chars.length; i++) {
            System.out.println(i + " : " + chars[i]);
        }
    }

    @Test // 截取字符串字符
    public void test5(){
        String str = "我昆仑决afdafa";
        Integer index = 5;
        Integer get = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int len = String.valueOf(str.charAt(i)).getBytes().length;  // 获取字符串的字节长度
            if (get + len <= index){
                get += len;
                builder.append(str.charAt(i));
            }else {
                break;
            }
        }
        System.out.println(builder.toString());
    }

    @Test // 匹配字符串中的字符
    public void test6(){
        String str = "<p id='text'>egf</p>";
        String res = ".*(egf).*";                   // 正则规则 使用正则表达式去匹配字符
        Pattern matcher = Pattern.compile(res);
        Matcher matcher1 = matcher.matcher(str);
        if (matcher1.find()){
            System.out.println(matcher1.group(1));
        }
    }

}