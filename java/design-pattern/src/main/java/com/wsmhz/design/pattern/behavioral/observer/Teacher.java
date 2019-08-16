package com.wsmhz.design.pattern.behavioral.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created By tangbj On 2019/8/16
 * Description:
 */
public class Teacher implements Observer {

    private String teacherName;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Teacher(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public void update(Observable o, Object arg) {
        Course course = (Course) o;
        Question question = (Question)arg;
        System.out.println(teacherName + "老师收到" + question.getUserName() + "在" + course.getCourseName() + "课程上提的一个问题：内容为：" + question.getContext());
    }
}
