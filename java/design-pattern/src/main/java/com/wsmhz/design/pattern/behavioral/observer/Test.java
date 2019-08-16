package com.wsmhz.design.pattern.behavioral.observer;

/**
 * Created By tangbj On 2019/8/16
 * Description: 观察者模式
 */
public class Test {

    public static void main(String[] args) {

        Course course = new Course("java设计模式");
        Teacher teacher = new Teacher("wsmhz");
        course.addObserver(teacher);

        course.produceQuestion(new Question("小明","观察者模式是怎么设计的？"));
    }
}
