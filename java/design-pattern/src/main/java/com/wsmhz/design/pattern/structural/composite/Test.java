package com.wsmhz.design.pattern.structural.composite;

/**
 * Created By tangbj On 2019/7/13
 * Description: 组合模式
 *      特点：需要有统一的接口实现或者抽象父类
 */
public class Test {

    public static void main(String[] args) {

        CodeCatalog codeCatalog = new CodeCatalog("代码主目录", 1);

        Code code1 = new Code("示例代码1", "hello world");
        Code code2 = new Code("示例代码2", "hi world");

        CodeCatalog designCodeCatalog = new CodeCatalog("设计模式代码目录", 2);

        Code adapter = new Code("适配器模式", "adapter code");
        Code singleton = new Code("单例模式", "singleton code");

        codeCatalog.add(code1);
        codeCatalog.add(code2);

        designCodeCatalog.add(adapter);
        designCodeCatalog.add(singleton);
        codeCatalog.add(designCodeCatalog);

        codeCatalog.print();
    }
}
