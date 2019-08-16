package com.wsmhz.design.pattern.behavioral.observer;

/**
 * Created By tangbj On 2019/8/16
 * Description:
 */
public class Question {

    private String userName;

    private String context;

    public Question(String userName, String context) {
        this.userName = userName;
        this.context = context;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
