package eu.kudljo.oop.shopping;

import java.util.UUID;

public class Customer {
    private String id;
    private String firstName;
    private String lastName;
    private String address;

    public Customer() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void call() {
        System.out.println("Calling customer " + firstName + " " + lastName + " ...");
    }
}
