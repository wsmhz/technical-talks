package com.wsmhz.design.pattern.creational.prototype;

/**
 * Created By tangbj On 2019/7/10
 * Description: 原型模式
 *      注意深拷贝与浅拷贝问题
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Mail mail = new Mail();
        mail.setContent("初始化模板");
        System.out.println("初始化mail:"+mail);
        for(int i = 0;i < 5;i++){
            Mail mailTemp = (Mail) mail.clone();
            mailTemp.setName("姓名"+i);
            mailTemp.setEmailAddress(i+"@qq.com");
            mailTemp.setContent("邮件内容");
            MailUtil.sendMail(mailTemp);
            System.out.println("克隆的mailTemp:"+mailTemp);
        }
        MailUtil.saveOriginMailRecord(mail);
    }
}
