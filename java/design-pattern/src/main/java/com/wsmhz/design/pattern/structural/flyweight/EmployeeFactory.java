package com.wsmhz.design.pattern.structural.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created By tangbj On 2019/7/13
 * Description:
 */
public class EmployeeFactory {

    private static Map<String, Employee> EMPLOYEE_MAP = new ConcurrentHashMap<String, Employee>();

    public Manage getManage(String department){
        Manage manage = (Manage) EMPLOYEE_MAP.get(department);
        if(manage == null){
            manage = new Manage(department);
            System.out.println("创建部门经理,部门为：" + department);
            String reportContent = department+"部门汇报:此次报告的汇报内容为......";
            System.out.println("创建汇报内容：" + reportContent);
            manage.setReportContent(reportContent);
            EMPLOYEE_MAP.put(department, manage);
        }
        return manage;
    }
}
