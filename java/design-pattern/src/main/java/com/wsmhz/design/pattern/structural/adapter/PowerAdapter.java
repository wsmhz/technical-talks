package com.wsmhz.design.pattern.structural.adapter;

/**
 * Created By tangbj On 2019/7/12
 * Description:
 */
public class PowerAdapter implements DC50 {

    private AC220 ac220 = new AC220();

    public int outputDc() {
        int inputAc = ac220.inputAc();
        int outputDc = inputAc/44;
        System.out.println("输入交流电" + inputAc + "V，电源适配输出直流电" + outputDc + "V");
        return outputDc;
    }
}
