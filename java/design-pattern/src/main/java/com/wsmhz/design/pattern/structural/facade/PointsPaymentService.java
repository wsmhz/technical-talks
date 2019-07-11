package com.wsmhz.design.pattern.structural.facade;

/**
 * Created By tangbj On 2019/7/11
 * Description:
 */
public class PointsPaymentService {
    public boolean pay(PointsGift pointsGift){
        System.out.println("支付"+pointsGift.getName()+" 积分成功");
        return true;
    }

}
