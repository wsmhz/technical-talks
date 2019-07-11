package com.wsmhz.design.pattern.structural.facade;

/**
 * Created By tangbj On 2019/7/11
 * Description:
 */
public class QualifyService {
    public boolean isAvailable(PointsGift pointsGift){
        System.out.println("校验"+pointsGift.getName()+" 积分资格通过,库存通过");
        return true;
    }
}
