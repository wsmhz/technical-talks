package com.wsmhz.design.pattern.creational.singleton;

/**
 * Created By tangbj On 2019/7/10
 * Description:
 */
public enum EnumSingleton {

    INSTANCE;

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}
