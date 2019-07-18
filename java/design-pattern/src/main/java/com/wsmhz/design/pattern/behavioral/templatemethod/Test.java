package com.wsmhz.design.pattern.behavioral.templatemethod;

/**
 * Created By tangbj On 2019/7/18
 * Description:
 */
public class Test {

    public static void main(String[] args) {

        BookTemplate bookTemplate = new JavaBook(true);
        bookTemplate.makeBook();

        BookTemplate bookTemplate2 = new PythonBook();
        bookTemplate2.makeBook();
    }
}
