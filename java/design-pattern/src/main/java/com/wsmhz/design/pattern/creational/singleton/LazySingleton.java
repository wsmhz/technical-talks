package com.wsmhz.design.pattern.creational.singleton;

/**
 * Created By tangbj On 2019/7/9
 * Description: 懒汉式单例
 *      注意线程安全问题
 */
public class LazySingleton {

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
}
