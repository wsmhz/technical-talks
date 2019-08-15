package com.wsmhz.design.pattern.behavioral.strategy;

/**
 * Created By tangbj On 2019/8/15
 * Description:
 */
public class ManJianPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("满减促销");
    }
}
