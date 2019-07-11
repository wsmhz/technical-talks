package com.wsmhz.design.pattern.creational.singleton;

/**
 * Created By tangbj On 2019/7/10
 * Description: 静态内部类单例模式
 *      优点是：外部类加载时并不需要立即加载内部类，内部类不被加载则不去初始化INSTANCE，故而不占内存
 *
 *          当getInstance()方法被调用时，SSingletonHolder才在StaticInnerClassLazySingleton的运行时常量池里，
 *          把符号引用替换为直接引用，这时静态对象instance也真正被创建
 *
 *          instance在创建过程中虚拟机会保证一个类的<clinit>()方法在多线程环境中被正确地加锁、同步，如果多个线程同时去初始化一个类，
 *          那么只会有一个线程去执行这个类的<clinit>()方法，其他线程都需要阻塞等待，直到活动线程执行<clinit>()方法完毕
 */
public class StaticInnerClassLazySingleton {

    private StaticInnerClassLazySingleton(){
        // 这种判断只对于饿汉式下适用，懒汉式中并没有作用，因为能通过反射攻击构建实例
        if(SingletonHolder.instance != null){
            throw new RuntimeException("禁止反射构造");
        }
    }

    private static class SingletonHolder{
        private static StaticInnerClassLazySingleton instance = new StaticInnerClassLazySingleton();
    }

    public static StaticInnerClassLazySingleton getInstance(){
        return SingletonHolder.instance;
    }
}
