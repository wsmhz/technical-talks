package com.wsmhz.design.pattern.behavioral.templatemethod;

/**
 * Created By tangbj On 2019/7/18
 * Description:
 */
public class PythonBook extends BookTemplate {

    @Override
    protected void code() {
        System.out.println("书写python书籍");
    }
}
