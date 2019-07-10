package com.wsmhz.design.pattern.creational.singleton;

/**
 * Created By tangbj On 2019/7/9
 * Description:
 */
public class lazyDoubleCheckThread implements Runnable {
    public void run() {
        LazyDoubleCheckSingleton lazyDoubleCheckSingleton = LazyDoubleCheckSingleton.getInstance();
        System.out.println(lazyDoubleCheckSingleton);
    }
}
