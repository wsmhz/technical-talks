package com.wsmhz.design.pattern.structural.flyweight;

/**
 * Created By tangbj On 2019/7/13
 * Description: 享元模式
 *      特点：缓存处理
 *      注意：线程安全问题
 */
public class Test {

    public static void main(String[] args) {
        String[] departments = {"A", "B", "C", "D"};
        EmployeeFactory employeeFactory = new EmployeeFactory();
        for (int i = 0; i < 10; i++) {
            Manage manage = employeeFactory.getManage(departments[(int) (Math.random() * departments.length)]);
            manage.report();
        }
    }
}
