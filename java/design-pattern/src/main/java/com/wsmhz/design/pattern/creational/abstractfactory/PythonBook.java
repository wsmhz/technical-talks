package com.wsmhz.design.pattern.creational.abstractfactory;

/**
 * create by tangbj on 2019/7/4
 */
public class PythonBook extends Book {

    @Override
    public void produce() {
        System.out.println("---produce PythonBook");
    }
}
