package com.study.operation;

import java.io.UnsupportedEncodingException;

/**
 * @program: study
 * @description: 运算题1
 * @author: jinlu
 * @create: 2020-03-10 17:00
 **/
public class OperationDeom {

   /* 1.编程实现大数的加法
    例如：
    String a = "123415646431..." a.size 大于1000位
    String b = "316461131313..." b.size 大于1000位     */
    // 题中可见长度大于1000位可能会溢出所以不能直接使用数据类型进行运算 转换成数组进行计算
   public static void main(String[] args) {
       String a = "123";
       String b = "7";
       // 两个数相加的长度 结果要么是最大数的长度要么是最大数的长度加1 定义一个结果的数组
       int[] reuslt = new int[a.length() + 1];
       char[] bigNum = null;
       char[] smallNum = null;
       // 先判断出大小的数组
       if (a.length() >= b.length()){
           bigNum = a.toCharArray();
           smallNum = b.toCharArray();
       }else {
           bigNum = b.toCharArray();
           smallNum = a.toCharArray();
       }
       // 先将大的数组按照个位填充进结果的数组中
       for (int i = 0; i < bigNum.length; i++) {
           reuslt[i] = bigNum[bigNum.length - i - 1] - '0';
       }

       for (int i = 0; i < smallNum.length; i++) {
            reuslt[i] += smallNum[smallNum.length - i - 1] - '0';
       }

       for (int i = 0; i < reuslt.length; i++) {
           if (reuslt[i] > 9){
               reuslt[i + 1] += reuslt[i] / 10;
               reuslt[i] %= 10;
           }
       }
       StringBuilder builder = new StringBuilder();
       for (int i = reuslt.length -1; i >= 0; i--) {
           builder.append(reuslt[i]);
       }
       String numder = builder.toString();
       if (numder.startsWith("0")){
           numder = numder.substring(1);
       }
       System.out.println(numder);
   }

}