package eu.kudljo.oop.bank.administration;

public class Bank {
    private final String name = "CSOB";
    private static Double vault = 150000.0;

    protected Double getVault() {
        return vault;
    }

    protected void setVault(Double vault) {
        this.vault = vault;
    }
}
