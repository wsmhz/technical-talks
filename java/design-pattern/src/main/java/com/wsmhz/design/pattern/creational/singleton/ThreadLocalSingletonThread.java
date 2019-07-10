package com.wsmhz.design.pattern.creational.singleton;

/**
 * Created By tangbj On 2019/7/10
 * Description:
 */
public class ThreadLocalSingletonThread implements Runnable {
    public void run() {
        ThreadLocalSingleton instance = ThreadLocalSingleton.getInstance();
        System.out.println(instance);
    }
}
