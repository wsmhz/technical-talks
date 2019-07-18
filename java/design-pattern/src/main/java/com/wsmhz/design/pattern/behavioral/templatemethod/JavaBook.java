package com.wsmhz.design.pattern.behavioral.templatemethod;

/**
 * Created By tangbj On 2019/7/18
 * Description:
 */
public class JavaBook extends BookTemplate {

    private boolean needPackageBook;

    public JavaBook(boolean needPackageBook) {
        this.needPackageBook = needPackageBook;
    }

    @Override
    protected void code() {
        System.out.println("书写java书籍");
    }

    @Override
    protected boolean needPackageBook() {
        return needPackageBook;
    }
}
