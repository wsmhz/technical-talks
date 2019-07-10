package com.wsmhz.design.pattern.creational.abstractfactory;

/**
 * Created By tangbj On 2019/7/9
 * Description:  同一产品族，不同产品
 */
public class JavaCourseFactory implements CourseFactory {
    public Book produceBook() {
        return new JavaBook();
    }

    public Teacher produceTeacher() {
        return new JavaTeacher();
    }
}
