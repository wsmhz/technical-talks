package com.wsmhz.design.pattern.structural.adapter;

/**
 * Created By tangbj On 2019/7/12
 * Description: 适配器模式
 */
public class Test {

    public static void main(String[] args) {
        DC50 dc50  = new PowerAdapter();
        dc50.outputDc();
    }
}
