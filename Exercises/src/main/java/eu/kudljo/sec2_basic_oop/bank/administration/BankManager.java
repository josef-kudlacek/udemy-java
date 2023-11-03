package eu.kudljo.sec2_basic_oop.bank.administration;

public class BankManager {
    private final String firstName = "Bob";
    private final String lastName = "Tailor";
    private Bank bank;

    public BankManager(Bank bank) {
        this.bank = bank;
    }

    public void manageVault(Double vault) {
        bank.setVault(vault);
    }

    public Double giveVault() {
        return bank.getVault();
    }
}
