package com.wsmhz.design.pattern.creational.singleton;

import java.io.Serializable;

/**
 * Created By tangbj On 2019/7/9
 * Description: 懒汉式单例
 *      注意线程安全问题
 */
public class LazySingleton implements Serializable {

    private static LazySingleton instance = null;

    private LazySingleton(){

    }

//    public static LazySingleton getInstance(){
//        if(instance == null){
//            instance = new LazySingleton();
//        }
//        return instance;
//    }

    public static LazySingleton getInstance(){
        synchronized (LazySingleton.class){
            if(instance == null){
                instance = new LazySingleton();
            }
        }
        return instance;
    }

    // 序列化与反序列化 造成对象不一致的
    private Object readResolve(){
        return instance;
    }
}
