package com.wsmhz.design.pattern.structural.flyweight;

/**
 * Created By tangbj On 2019/7/13
 * Description:
 */
public class Manage implements Employee {

    private String department;

    private String reportContent;

    public Manage(String department) {
        this.department = department;
    }

    public void report() {
        System.out.println(reportContent);
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }
}
