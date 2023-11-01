package eu.kudljo.oop.bank;

import eu.kudljo.oop.bank.administration.Bank;
import eu.kudljo.oop.bank.administration.BankManager;

public class Play {
    public static void main(String[] args) {
        Bank bank = new Bank();
        BankManager managerBob = new BankManager(bank);

        Customer me = new Customer("John", "Silver", 1500.0);
        me.setBankManager(managerBob);
        me.setBank(bank);

        System.out.println(managerBob.giveVault());
    }
}
