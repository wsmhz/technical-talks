package com.wsmhz.design.pattern.behavioral.templatemethod;

/**
 * Created By tangbj On 2019/7/18
 * Description:
 */
public abstract class BookTemplate {

    protected final void makeBook(){
        code();
        print();
        if(needPackageBook()){
            packageBook();
        }
        outBound();
    }

    protected abstract void code();

    final void print(){
        System.out.println("印刷书本");
    }

    final void packageBook(){
        System.out.println("包装书本书皮");
    }

    protected boolean needPackageBook(){
        return false;
    }

    protected final void outBound(){
        System.out.println("书本出库");
    }
}
