package com.wsmhz.design.pattern.behavioral.chainofresponsibility;

/**
 * Created By tangbj On 2019/8/27
 * Description:
 */
public class ImageApprover extends Approver{
    @Override
    protected void deploy(Project project) {
        if(project.getImage() != null){
            System.out.println("存在镜像，审核通过，开始发布镜像到镜像仓库，运行，发布完成");
            if(approver != null){
                approver.deploy(project);
            }
        }else {
            System.out.println("镜像为空，审核不通过，结束流程");
        }
    }
}
