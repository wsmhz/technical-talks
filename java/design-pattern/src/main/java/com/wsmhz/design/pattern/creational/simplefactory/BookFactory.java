package com.wsmhz.design.pattern.creational.simplefactory;

/**
 * create by tangbj on 2019/7/4
 */
public class BookFactory {

    public Book getBook(Class clazz) throws Exception {
        return (Book)Class.forName(clazz.getName()).newInstance();
    }

    public Book getBook(String type) throws Exception {
        if(type.equalsIgnoreCase("java")){
            return new JavaBook();
        } else if(type.equalsIgnoreCase("python")){
            return new PythonBook();
        }
        return null;
    }
}
