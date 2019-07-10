package com.wsmhz.design.pattern.creational.simplefactory;

/**
 * create by tangbj on 2019/7/4
 */
public class Test {

    public static void main(String[] args) throws Exception {
        BookFactory bookFactory = new BookFactory();
        Book book = bookFactory.getBook("java");
        book.produce();
    }
}
