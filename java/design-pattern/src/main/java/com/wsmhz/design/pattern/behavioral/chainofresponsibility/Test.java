package com.wsmhz.design.pattern.behavioral.chainofresponsibility;

/**
 * Created By tangbj On 2019/8/27
 * Description: 责任链模式
 */
public class Test {

    public static void main(String[] args) {
        CodeApprover codeApprover = new CodeApprover();
        DockerFileApprover dockerFileApprover = new DockerFileApprover();
        ImageApprover imageApprover = new ImageApprover();

        Project project = new Project();
        project.setCode("设计模式相关代码");
        project.setDockerFile("设计模式dockerFile");
        project.setImage("设计模式镜像文件");

        codeApprover.nextApprover(dockerFileApprover).nextApprover(imageApprover);
        codeApprover.deploy(project);
    }
}
