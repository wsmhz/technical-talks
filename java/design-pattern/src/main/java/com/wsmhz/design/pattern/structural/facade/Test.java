package com.wsmhz.design.pattern.structural.facade;

/**
 * Created By tangbj On 2019/7/11
 * Description: 外观者（门面者）模式 调用方无需关心子系统逻辑，只跟外观者交互
 */
public class Test {
    public static void main(String[] args) {
        PointsGift pointsGift = new PointsGift("衣服");
        GiftExchangeService giftExchangeService = new GiftExchangeService();
        giftExchangeService.giftExchange(pointsGift);
    }
}
