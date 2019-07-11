package com.wsmhz.design.pattern.structural.facade;

/**
 * Created By tangbj On 2019/7/11
 * Description:
 */
public class GiftExchangeService {
    private QualifyService qualifyService = new QualifyService();
    private PointsPaymentService pointsPaymentService = new PointsPaymentService();
    private ShippingService shippingService = new ShippingService();

    public void giftExchange(PointsGift pointsGift){
        if(qualifyService.isAvailable(pointsGift)){
            if(pointsPaymentService.pay(pointsGift)){
                String shippingOrderNo = shippingService.shipGift(pointsGift);
                System.out.println("下单成功,订单号是:"+shippingOrderNo);
            }
        }
    }

}
