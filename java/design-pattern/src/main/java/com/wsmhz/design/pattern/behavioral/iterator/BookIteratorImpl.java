package com.wsmhz.design.pattern.behavioral.iterator;

import java.util.List;

/**
 * Created By tangbj On 2019/7/19
 * Description:
 */
public class BookIteratorImpl implements BookIterator{

    private List<Book> bookList;
    private int index;
    private Book book;

    public BookIteratorImpl(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public Book nextBook() {
        System.out.println("返回书本,位置是: " + index);
        book = bookList.get(index);
        index ++;
        return book;
    }

    @Override
    public boolean isLastBook() {
        if(index < bookList.size()){
            return false;
        }
        return true;
    }
}
