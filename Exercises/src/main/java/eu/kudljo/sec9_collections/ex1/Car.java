package eu.kudljo.sec9_collections.ex1;

import java.time.LocalDate;
import java.util.Objects;

public class Car implements Comparable<Car> {
    private String make;
    private String model;
    private LocalDate creationDate;

    public Car(String make, String model, LocalDate creationDate) {
        this.make = make;
        this.model = model;
        this.creationDate = creationDate;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return creationDate.getYear();
    }

    @Override
    public String toString() {
        return String.format("Car[make=%s, model=%s, year=%d]", make, model, creationDate.getYear());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(make, car.make) && Objects.equals(model, car.model) && Objects.equals(creationDate, car.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, model, creationDate);
    }

    @Override
    public int compareTo(Car car) {
        int compareMake = this.make.compareTo(car.make);
        if (compareMake != 0) return compareMake;
        int compareModel = this.model.compareTo(car.model);
        if (compareModel != 0) return compareModel;
        int compareYear = Integer.compare(this.creationDate.getYear(), car.getYear());
        return compareYear;
    }
}
