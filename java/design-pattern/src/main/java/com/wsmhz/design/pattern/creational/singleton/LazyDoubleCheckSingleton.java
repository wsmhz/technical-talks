package com.wsmhz.design.pattern.creational.singleton;

/**
 * Created By tangbj On 2019/7/9
 * Description: 懒汉式单例
 *      注意指令重排序问题
 */
public class LazyDoubleCheckSingleton {

//    private static LazyDoubleCheckSingleton instance = null;
    private static volatile LazyDoubleCheckSingleton instance = null;

    private LazyDoubleCheckSingleton(){}

    public static LazyDoubleCheckSingleton getInstance(){
        if(instance == null){
            synchronized (LazyDoubleCheckSingleton.class){
                if(instance == null){
                    instance = new LazyDoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
