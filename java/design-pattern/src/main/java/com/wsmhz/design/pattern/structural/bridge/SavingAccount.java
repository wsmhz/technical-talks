package com.wsmhz.design.pattern.structural.bridge;

/**
 * Created By tangbj On 2019/7/15
 * Description:
 */
public class SavingAccount implements Account {
    public Account openAccount() {
        System.out.println("打开活期账号");
        return new SavingAccount();
    }

    public void showAccountType() {
        System.out.println("这是个活期账号");
    }
}
