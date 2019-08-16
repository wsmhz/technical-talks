package com.wsmhz.design.pattern.behavioral.observer;

import java.util.Observable;

/**
 * Created By tangbj On 2019/8/16
 * Description:
 */
public class Course extends Observable {

    private String courseName;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void produceQuestion(Question question){
        System.out.println(question.getUserName() + "在" + courseName + "课程中提了一个问题");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setChanged();
        notifyObservers(question);
    }
}
