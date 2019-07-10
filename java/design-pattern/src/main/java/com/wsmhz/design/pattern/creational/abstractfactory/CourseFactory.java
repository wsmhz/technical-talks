package com.wsmhz.design.pattern.creational.abstractfactory;

/**
 * Created By tangbj On 2019/7/9
 * Description:  抽象工厂
 */
public interface CourseFactory {

    Book produceBook();

    Teacher produceTeacher();
}
