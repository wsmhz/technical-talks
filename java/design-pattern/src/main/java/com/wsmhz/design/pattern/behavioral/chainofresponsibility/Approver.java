package com.wsmhz.design.pattern.behavioral.chainofresponsibility;

/**
 * Created By tangbj On 2019/8/27
 * Description:
 */
public abstract class Approver {

    protected Approver approver;

    public Approver nextApprover(Approver approver){
        this.approver = approver;
        return approver;
    }

    protected abstract void deploy(Project project);

}
