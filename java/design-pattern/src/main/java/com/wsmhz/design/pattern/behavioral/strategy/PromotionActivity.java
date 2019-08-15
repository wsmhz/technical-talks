package com.wsmhz.design.pattern.behavioral.strategy;

/**
 * Created By tangbj On 2019/8/15
 * Description:
 */
public class PromotionActivity {

    private PromotionStrategy promotionStrategy;

    public PromotionActivity(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    public void execute(){
        promotionStrategy.doPromotion();
    }

}
