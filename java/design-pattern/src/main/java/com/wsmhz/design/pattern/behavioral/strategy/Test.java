package com.wsmhz.design.pattern.behavioral.strategy;

/**
 * Created By tangbj On 2019/8/15
 * Description: 策略模式
 */
public class Test {

    /**
     * 单纯只使用策略模式，调用层还是会存在if else条件判断，并且存在重复新建对象的问题
     */
//    public static void main(String[] args) {
//        String key ="manjian";
//        PromotionActivity promotionActivity = null;
//        if(key.equals("lijian")){
//            promotionActivity = new PromotionActivity(new LiJianPromotionStrategy());
//        } else if(key.equals("manjian")){
//            promotionActivity = new PromotionActivity(new ManJianPromotionStrategy());
//        }
//        //......
//        promotionActivity.execute();
//    }

    /**
     * 策略模式 + 工厂模式 消除条件判断
     */
    public static void main(String[] args) {
        String key ="fanxian";
        PromotionStrategyFactory promotionStrategyFactory = new PromotionStrategyFactory();
        PromotionStrategy promotionStrategy = promotionStrategyFactory.getPromotionStrategy(key);
        promotionStrategy.doPromotion();
    }
}
