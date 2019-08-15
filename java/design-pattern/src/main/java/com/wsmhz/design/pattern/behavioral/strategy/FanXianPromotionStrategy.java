package com.wsmhz.design.pattern.behavioral.strategy;

/**
 * Created By tangbj On 2019/8/15
 * Description:
 */
public class FanXianPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("返现促销");
    }
}
