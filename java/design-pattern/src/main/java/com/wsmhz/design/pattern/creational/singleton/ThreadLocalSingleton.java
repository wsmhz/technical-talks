package com.wsmhz.design.pattern.creational.singleton;

/**
 * Created By tangbj On 2019/7/10
 * Description: ThreadLocal方式“单例”模式，全局不唯一，但是线程唯一，线程安全
 */
public class ThreadLocalSingleton {

    private ThreadLocalSingleton(){}

    private static ThreadLocal<ThreadLocalSingleton> threadLocal = new ThreadLocal<ThreadLocalSingleton>(){
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };

    public static ThreadLocalSingleton getInstance(){
        return threadLocal.get();
    }
}
