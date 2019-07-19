package com.wsmhz.design.pattern.behavioral.iterator;

/**
 * Created By tangbj On 2019/7/19
 * Description:
 */
public interface BookOperator {

    void addBook(Book book);

    void removeBook(Book book);

    BookIterator getBookIterator();
}
