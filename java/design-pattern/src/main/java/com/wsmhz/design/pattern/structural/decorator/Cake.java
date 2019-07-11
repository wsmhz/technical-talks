package com.wsmhz.design.pattern.structural.decorator;

/**
 * Created By tangbj On 2019/7/11
 * Description:
 */
public class Cake extends AbstractCake {

    protected String getDesc() {
        return "蛋糕 ";
    }

    protected int getPrice() {
        return 20;
    }
}
