package com.wsmhz.design.pattern.creational.factorymethod;

/**
 * create by tangbj on 2019/7/4
 */
public class JavaBookFactory implements BookFactory {

    public Book produceBook() {
        return new JavaBook();
    }
}
