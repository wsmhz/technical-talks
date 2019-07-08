package com.wsmhz.design.pattern.creational.simplefactory;

/**
 * create by tangbj on 2019/7/4
 */
public class Test {

    public static void main(String[] args) throws Exception {
        VideoFactory videoFactory = new VideoFactory();
        Video video = videoFactory.getVideo("java");
        video.produce();
    }
}
