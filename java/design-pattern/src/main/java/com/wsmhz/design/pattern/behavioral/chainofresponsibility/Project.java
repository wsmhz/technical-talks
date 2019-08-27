package com.wsmhz.design.pattern.behavioral.chainofresponsibility;

/**
 * Created By tangbj On 2019/8/27
 * Description:
 */
public class Project {

    private String name;

    private String code;

    private String dockerFile;

    private String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDockerFile() {
        return dockerFile;
    }

    public void setDockerFile(String dockerFile) {
        this.dockerFile = dockerFile;
    }
}
