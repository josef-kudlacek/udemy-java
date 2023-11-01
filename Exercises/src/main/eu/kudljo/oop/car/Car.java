package eu.kudljo.oop.car;

import java.time.LocalDate;

public class Car {
    private String name = "Ford";
    private String color = "blue";
    private int price = 5000;
    private LocalDate createdDate = LocalDate.of(1995, 6, 25);

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", createdDate=" + createdDate +
                '}';
    }
}
