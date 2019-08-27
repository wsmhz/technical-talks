package com.wsmhz.design.pattern.behavioral.chainofresponsibility;

/**
 * Created By tangbj On 2019/8/27
 * Description:
 */
public class DockerFileApprover extends Approver{
    @Override
    protected void deploy(Project project) {
        if(project.getDockerFile() != null){
            System.out.println("存在dockerFile，审核通过，开始打包镜像");
            if(approver != null){
                approver.deploy(project);
            }
        }else {
            System.out.println("dockerFile为空，审核不通过，结束流程");
        }
    }
}
