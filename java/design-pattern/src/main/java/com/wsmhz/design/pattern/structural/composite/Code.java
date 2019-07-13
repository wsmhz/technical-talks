package com.wsmhz.design.pattern.structural.composite;

/**
 * Created By tangbj On 2019/7/13
 * Description:
 */
public class Code extends CatalogComponent {

    private String name;

    private String code;

    public Code(String name, String code) {
        this.name = name;
        this.code = code;
    }

    @Override
    public void getCode(CatalogComponent catalogComponent) {
        System.out.println(code);
    }

    @Override
    public void getName(CatalogComponent catalogComponent) {
        System.out.println(name);
    }

    @Override
    public void print() {
        System.out.println("名称为：" + name + "，具体代码为：" + code);
    }
}
