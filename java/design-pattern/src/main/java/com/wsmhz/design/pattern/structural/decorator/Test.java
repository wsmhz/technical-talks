package com.wsmhz.design.pattern.structural.decorator;

/**
 * Created By tangbj On 2019/7/11
 * Description: 装饰者模式
 */
public class Test {

    public static void main(String[] args) {
        AbstractCake cake = new Cake();
        cake = new AppleDecorator(cake);
        cake = new MilkDecorator(cake);
        System.out.println(cake.getDesc() + " " + cake.getPrice());
    }
}
