package com.wsmhz.design.pattern.structural.bridge;

/**
 * Created By tangbj On 2019/7/15
 * Description:
 */
public class DepositAccount implements Account {
    public Account openAccount() {
        System.out.println("打开定期账号");
        return new DepositAccount();
    }

    public void showAccountType() {
        System.out.println("这是个定期账号");
    }
}
