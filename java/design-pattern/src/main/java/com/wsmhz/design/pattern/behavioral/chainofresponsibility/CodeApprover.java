package com.wsmhz.design.pattern.behavioral.chainofresponsibility;

/**
 * Created By tangbj On 2019/8/27
 * Description:
 */
public class CodeApprover extends Approver{
    @Override
    protected void deploy(Project project) {
        if(project.getCode() != null){
            System.out.println("存在代码，审核通过，开始更新代码，编译代码");
            if(approver != null){
                approver.deploy(project);
            }
        }else {
            System.out.println("代码为空，审核不通过，结束流程");
        }
    }
}
