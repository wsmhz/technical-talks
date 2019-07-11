package com.wsmhz.design.pattern.structural.decorator;

/**
 * Created By tangbj On 2019/7/11
 * Description:
 */
public abstract class AbstractCakeDecorator extends AbstractCake{

    private AbstractCake abstractCake;

    public AbstractCakeDecorator(AbstractCake abstractCake) {
        this.abstractCake = abstractCake;
    }

    protected void doSomething(){}

    protected String getDesc() {
        return abstractCake.getDesc();
    }

    protected int getPrice() {
        return abstractCake.getPrice();
    }

}
