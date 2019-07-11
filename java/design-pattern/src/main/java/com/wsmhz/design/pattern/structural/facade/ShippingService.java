package com.wsmhz.design.pattern.structural.facade;

/**
 * Created By tangbj On 2019/7/11
 * Description:
 */
public class ShippingService {
    public String shipGift(PointsGift pointsGift){
        System.out.println(pointsGift.getName()+"进入物流系统");
        String shippingOrderNo = "132456";
        return shippingOrderNo;
    }
}
