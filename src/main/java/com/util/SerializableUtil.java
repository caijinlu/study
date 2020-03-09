package com.util;

import java.io.*;

/**
 * @program: study
 * @description: 原生序列化工具类
 * @author: jinlu
 * @create: 2020-03-09 16:54
 **/
public class SerializableUtil {

    public static void serialize(Object obj){
        ObjectOutputStream outPut = null;
        try {
            File file = new File("obj");
            outPut = new ObjectOutputStream(new FileOutputStream(file));
            outPut.writeObject(obj);
            outPut.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                outPut.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static Object unserialize(){
        ObjectInputStream input = null;
        try {
            File file = new File("obj");
            input = new ObjectInputStream(new FileInputStream(file));
            Object object = input.readObject();
            return object;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                input.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
}