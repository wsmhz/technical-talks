package com.wsmhz.design.pattern.creational.builder;

/**
 * Created By tangbj On 2019/7/9
 * Description: 建造者模式
 */
public class Test {

    public static void main(String[] args) {
        Book book = new Book.BookBuilder().builderName("bookName").builderImg("bookImg").build();
        System.out.println(book);
    }

}
