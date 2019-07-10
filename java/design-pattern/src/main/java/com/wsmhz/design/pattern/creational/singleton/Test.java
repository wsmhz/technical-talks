package com.wsmhz.design.pattern.creational.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created By tangbj On 2019/7/9
 * Description:
 */
public class Test {

    public static void main(String[] args) throws Exception {

//        Thread thread1 = new Thread(new lazySingletonThread());
//        Thread thread2 = new Thread(new lazySingletonThread());

//        Thread thread1 = new Thread(new lazyDoubleCheckThread());
//        Thread thread2 = new Thread(new lazyDoubleCheckThread());
//
//        thread1.start();
//        thread2.start();
//        System.out.println("end");

//        LazySingleton lazySingleton = LazySingleton.getInstance();
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton_file"));
//        oos.writeObject(lazySingleton);
//
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton_file"));
//        LazySingleton newLazySingleton  = (LazySingleton) ois.readObject();
//
//        // ois.readObject() 调用了 private Object readResolve 方法 序列化与反序列化
//        System.out.println(lazySingleton);
//        System.out.println(newLazySingleton);
//        System.out.println(lazySingleton == newLazySingleton);

//        StaticInnerClassLazySingleton singleton = StaticInnerClassLazySingleton.getInstance();
//        EnumSingleton singleton = EnumSingleton.getInstance();
//        System.out.println(singleton);

        System.out.println("Main thread : " + ThreadLocalSingleton.getInstance());
        System.out.println("Main thread : " + ThreadLocalSingleton.getInstance());
        System.out.println("Main thread : " + ThreadLocalSingleton.getInstance());
        Thread thread1 = new Thread(new ThreadLocalSingletonThread());
        Thread thread2 = new Thread(new ThreadLocalSingletonThread());

        thread1.start();
        thread2.start();
        System.out.println("end");
    }
}
