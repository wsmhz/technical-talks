package com.wsmhz.design.pattern.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By tangbj On 2019/7/19
 * Description:
 */
public class BookOperatorImpl implements BookOperator{

    private List<Book> bookList;

    public BookOperatorImpl() {
        this.bookList = new ArrayList<>();
    }

    @Override
    public void addBook(Book book) {
        bookList.add(book);
    }

    @Override
    public void removeBook(Book book) {
        bookList.remove(book);
    }

    @Override
    public BookIterator getBookIterator() {
        return new BookIteratorImpl(bookList);
    }
}
