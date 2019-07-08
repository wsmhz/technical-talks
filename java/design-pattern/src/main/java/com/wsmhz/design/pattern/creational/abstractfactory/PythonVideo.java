package com.wsmhz.design.pattern.creational.abstractfactory;

import com.wsmhz.design.pattern.creational.simplefactory.Video;

/**
 * create by tangbj on 2019/7/4
 */
public class PythonVideo extends Video {

    @Override
    public void produce() {
        System.out.println("---produce PythonVideo");
    }
}
