package com.wsmhz.design.pattern.creational.singleton;

/**
 * Created By tangbj On 2019/7/9
 * Description:
 */
public class Test {

    public static void main(String[] args) {

//        Thread thread1 = new Thread(new lazySingletonThread());
//        Thread thread2 = new Thread(new lazySingletonThread());

        Thread thread1 = new Thread(new lazyDoubleCheckThread());
        Thread thread2 = new Thread(new lazyDoubleCheckThread());

        thread1.start();
        thread2.start();
        System.out.println("end");
    }
}
