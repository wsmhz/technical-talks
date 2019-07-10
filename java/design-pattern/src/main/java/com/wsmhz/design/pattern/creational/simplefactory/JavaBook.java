package com.wsmhz.design.pattern.creational.simplefactory;

/**
 * create by tangbj on 2019/7/4
 */
public class JavaBook extends Book {

    @Override
    public void produce() {
        System.out.println("------produce JavaBook");
    }
}
