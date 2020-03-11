package com.study.operation;

/**
 * @program: study
 * @description: 编程实现大数的乘法
 * @author: jinlu
 * @create: 2020-03-11 13:38
 **/
public class OperationDeom1 {

    /* 1.编程实现大数的加法
    例如：
    String a = "123415646431..." a.size 大于1000位
    String b = "316461131313..." b.size 大于1000位     */

    public static void main(String[] args) {
        String a = "100";
        String b = "50";

        char[] bigStr = null;
        char[] smallStr = null;
        if (a.length() >= b.length()){
            bigStr = a.toCharArray();
            smallStr = b.toCharArray();
        }else {
            bigStr = b.toCharArray();
            smallStr = a.toCharArray();
        }

        int[] mult = new int[a.length() + b.length()];

        for (int i = bigStr.length - 1; i >= 0; i--) {
            // 个位相乘
            for (int j = smallStr.length - 1; j >= 0 ; j--) {
                int num1 =bigStr[i] - '0';
                int num2 =smallStr[j] - '0';
                mult[bigStr.length -1 - i + smallStr.length -1 - j] += num1 * num2;
            }
        }
        for (int i = 0; i < mult.length; i++) {
            if (mult[i] > 9){
                mult[i + 1] += mult[i] / 10;
                mult[i] %= 10;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = mult.length - 1; i >= 0; i--) {
            builder.append(mult[i]);
        }
        String result = builder.toString();
        if (result.startsWith("0")){
            result = result.substring(1);
        }
        System.out.println(result);
    }
}