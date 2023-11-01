package eu.kudljo.oop.bank;

import eu.kudljo.oop.bank.administration.Bank;
import eu.kudljo.oop.bank.administration.BankManager;

public class Customer {
    private String firstName;
    private String lastName;
    private Bank bank;
    private BankManager bankManager;
    private Double deposit;

    private Customer() {
    }

    public Customer(String firstName, String lastName, Double deposit) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.deposit = deposit;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public BankManager getBankManager() {
        return bankManager;
    }

    public void setBankManager(BankManager bankManager) {
        this.bankManager = bankManager;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }
}
