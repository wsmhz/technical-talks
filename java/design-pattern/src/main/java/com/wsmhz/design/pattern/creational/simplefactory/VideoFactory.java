package com.wsmhz.design.pattern.creational.simplefactory;

/**
 * create by tangbj on 2019/7/4
 */
public class VideoFactory {

    public Video getVideo(Class clazz) throws Exception {
        return (Video)Class.forName(clazz.getName()).newInstance();
    }

    public Video getVideo(String type) throws Exception {
        if(type.equalsIgnoreCase("java")){
            return new JavaVideo();
        } else if(type.equalsIgnoreCase("python")){
            return new PythonVideo();
        }
        return null;
    }
}
