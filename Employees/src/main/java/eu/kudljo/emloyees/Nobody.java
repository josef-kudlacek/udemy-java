package eu.kudljo.emloyees;

public class Nobody extends Employee implements IEmployee, Apple {

    public Nobody(String personText) {
        super(personText);
    }

    @Override
    public int getSalary() {
        return 0;
    }

}
