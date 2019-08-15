package com.wsmhz.design.pattern.behavioral.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created By tangbj On 2019/8/15
 * Description:
 */
public class PromotionStrategyFactory {
    private static Map<String, PromotionStrategy> PROMOTION_STRATEGY_MAP = new HashMap<>();

    static {
        PROMOTION_STRATEGY_MAP.put(StrategyKey.LI_JIAN, new LiJianPromotionStrategy());
        PROMOTION_STRATEGY_MAP.put(StrategyKey.MAN_JIAN, new ManJianPromotionStrategy());
        PROMOTION_STRATEGY_MAP.put(StrategyKey.FAN_XIAN, new FanXianPromotionStrategy());
    }

    private PromotionStrategy empty = new EmptyPromotionStrategy();

    public PromotionStrategy getPromotionStrategy(String strategyKey){
        return PROMOTION_STRATEGY_MAP.getOrDefault(strategyKey, empty);
    }

    public interface StrategyKey{
        String LI_JIAN = "lijian";
        String MAN_JIAN = "manjian";
        String FAN_XIAN = "fanxian";
    }
}
