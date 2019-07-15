package com.wsmhz.design.pattern.structural.bridge;

/**
 * Created By tangbj On 2019/7/15
 * Description:
 */
public class ABCBank extends Bank {

    private Account account;

    public ABCBank(Account account) {
        this.account = account;
    }

    public Account openAccount() {
        System.out.println("操作农业银行的账号");
        account.openAccount();
        return account;
    }
}
