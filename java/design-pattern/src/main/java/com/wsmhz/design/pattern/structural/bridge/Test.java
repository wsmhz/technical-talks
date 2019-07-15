package com.wsmhz.design.pattern.structural.bridge;

/**
 * Created By tangbj On 2019/7/15
 * Description:
 */
public class Test {
    public static void main(String[] args) {
        Bank icbcBank = new ICBCBank(new DepositAccount());
        Account account = icbcBank.openAccount();
        account.showAccountType();

        Bank icbcBank2 = new ICBCBank(new SavingAccount());
        Account account2 = icbcBank2.openAccount();
        account2.showAccountType();

        Bank abcBank = new ABCBank(new DepositAccount());
        Account abcBankAccount = abcBank.openAccount();
        abcBankAccount.showAccountType();
    }
}
