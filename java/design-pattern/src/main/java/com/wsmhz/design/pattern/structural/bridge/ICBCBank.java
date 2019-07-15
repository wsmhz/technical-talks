package com.wsmhz.design.pattern.structural.bridge;

/**
 * Created By tangbj On 2019/7/15
 * Description:
 */
public class ICBCBank extends Bank {

    private Account account;

    public ICBCBank(Account account) {
        this.account = account;
    }

    public Account openAccount() {
        System.out.println("操作工商银行账号");
        account.openAccount();
        return account;
    }
}
