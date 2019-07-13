package com.wsmhz.design.pattern.structural.composite;

/**
 * Created By tangbj On 2019/7/13
 * Description:
 */
public abstract class CatalogComponent {

    public void add(CatalogComponent catalogComponent){
        throw new RuntimeException("不支持的操作");
    };

    public void remove(CatalogComponent catalogComponent){
        throw new RuntimeException("不支持的操作");
    };

    public void getCode(CatalogComponent catalogComponent){
        throw new RuntimeException("不支持的操作");
    };

    public void getName(CatalogComponent catalogComponent){
        throw new RuntimeException("不支持的操作");
    };

    public void print(){
        throw new RuntimeException("不支持的操作");
    };
}
