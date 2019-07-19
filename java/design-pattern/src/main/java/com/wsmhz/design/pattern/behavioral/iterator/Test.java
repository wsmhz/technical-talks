package com.wsmhz.design.pattern.behavioral.iterator;

/**
 * Created By tangbj On 2019/7/19
 * Description: 迭代器模式
 */
public class Test {

    public static void main(String[] args) {
        Book book1 = new Book("Java设计模式");
        Book book2 = new Book("Python");
        Book book3 = new Book("算法");
        Book book4 = new Book("前端");


        BookOperator bookOperator = new BookOperatorImpl();

        bookOperator.addBook(book1);
        bookOperator.addBook(book2);
        bookOperator.addBook(book3);
        bookOperator.addBook(book4);

        System.out.println("-----书本列表-----");
        printBooks(bookOperator);

        bookOperator.removeBook(book3);
        bookOperator.removeBook(book4);

        System.out.println("-----删除操作之后的书本列表-----");
        printBooks(bookOperator);
    }


    public static void printBooks(BookOperator bookOperator){
        BookIterator bookIterator= bookOperator.getBookIterator();
        while(!bookIterator.isLastBook()){
            Book book=bookIterator.nextBook();
            System.out.println(book.getName());
        }
    }
}
