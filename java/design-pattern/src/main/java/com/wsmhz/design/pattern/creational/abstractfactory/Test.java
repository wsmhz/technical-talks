package com.wsmhz.design.pattern.creational.abstractfactory;

/**
 * Created By tangbj On 2019/7/9
 * Description:
 *      抽象工厂在jdk中的实现：
 *              jdbc 中的 Connection， Statement
 *              mysql.jdbc中分别体现了该实现
 */
public class Test {
    public static void main(String[] args) {
        CourseFactory courseFactory = new JavaCourseFactory();
        Book book = courseFactory.produceBook();
        Teacher teacher = courseFactory.produceTeacher();
        book.produce();
        teacher.teach();

        CourseFactory courseFactory2 = new PythonCourseFactory();
        Book book2 = courseFactory2.produceBook();
        Teacher teacher2 = courseFactory2.produceTeacher();
        book2.produce();
        teacher2.teach();
    }
}
