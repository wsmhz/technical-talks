package com.wsmhz.design.pattern.structural.decorator;

/**
 * Created By tangbj On 2019/7/11
 * Description:
 */
public class MilkDecorator extends AbstractCakeDecorator {

    public MilkDecorator(AbstractCake abstractCake) {
        super(abstractCake);
    }

    protected String getDesc() {
        return super.getDesc() + " 加点牛奶";
    }

    protected int getPrice() {
        return super.getPrice() + 10;
    }
}
