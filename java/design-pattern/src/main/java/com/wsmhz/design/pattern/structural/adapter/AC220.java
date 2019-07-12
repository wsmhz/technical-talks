package com.wsmhz.design.pattern.structural.adapter;

/**
 * Created By tangbj On 2019/7/12
 * Description: 交流电220V
 */
public class AC220 {

    public int inputAc(){
        int output = 220;
        System.out.println("输入交流电" + output + "V");
        return output;
    }
}
