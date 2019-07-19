package com.wsmhz.design.pattern.behavioral.iterator;

/**
 * Created By tangbj On 2019/7/19
 * Description:
 */
public interface BookIterator {

    Book nextBook();

    boolean isLastBook();
}
