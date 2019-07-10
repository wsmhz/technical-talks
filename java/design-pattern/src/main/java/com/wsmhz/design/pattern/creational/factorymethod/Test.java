package com.wsmhz.design.pattern.creational.factorymethod;

/**
 * Created By tangbj On 2019/7/9
 * Description:
 *      工厂方法在jdk中的实现：
 *              ArrayList中的iterator()中 return new Itr() ，Itr具体实现了Iterator接口
 *              URLStreamHandler、URLStreamHandlerFactory
 */
public class Test {
    public static void main(String[] args) {
        BookFactory bookFactory = new JavaBookFactory();
        Book book = bookFactory.produceBook();
        book.produce();

        BookFactory bookFactory2 = new PythonBookFactory();
        Book book2 = bookFactory2.produceBook();
        book2.produce();
    }
}
