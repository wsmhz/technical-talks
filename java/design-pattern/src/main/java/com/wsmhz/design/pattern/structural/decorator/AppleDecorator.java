package com.wsmhz.design.pattern.structural.decorator;

/**
 * Created By tangbj On 2019/7/11
 * Description:
 */
public class AppleDecorator extends AbstractCakeDecorator {

    public AppleDecorator(AbstractCake abstractCake) {
        super(abstractCake);
    }

    protected String getDesc() {
        return super.getDesc() + " 加点苹果";
    }

    protected int getPrice() {
        return super.getPrice() + 5;
    }
}
