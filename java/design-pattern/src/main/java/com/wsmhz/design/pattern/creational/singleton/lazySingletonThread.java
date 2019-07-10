package com.wsmhz.design.pattern.creational.singleton;

/**
 * Created By tangbj On 2019/7/9
 * Description:
 */
public class lazySingletonThread implements Runnable {
    public void run() {
        LazySingleton lazySingleton = LazySingleton.getInstance();
        System.out.println(lazySingleton);
    }
}
