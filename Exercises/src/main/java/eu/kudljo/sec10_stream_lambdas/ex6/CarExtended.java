package eu.kudljo.sec10_stream_lambdas.ex6;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class CarExtended implements Comparable<CarExtended> {
    private String make;
    private String model;
    private LocalDate creationDate;
    private BigDecimal price;

    public CarExtended(String make, String model, LocalDate creationDate, BigDecimal price) {
        this.make = make;
        this.model = model;
        this.creationDate = creationDate;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return creationDate.getYear();
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Car[make=%s, model=%s, year=%d, price=%d]", make, model, creationDate.getYear(), price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarExtended car = (CarExtended) o;
        return Objects.equals(make, car.make)
                && Objects.equals(model, car.model)
                && Objects.equals(creationDate, car.creationDate)
                && Objects.equals(price, car.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, model, creationDate);
    }

    @Override
    public int compareTo(CarExtended car) {
        int compareMake = this.make.compareTo(car.make);
        if (compareMake != 0) return compareMake;
        int compareModel = this.model.compareTo(car.model);
        if (compareModel != 0) return compareModel;
        int compareYear = Integer.compare(this.creationDate.getYear(), car.getYear());
        if (compareYear != 0) return compareYear;
        int comparePrice = this.getPrice().compareTo(car.price);
        return comparePrice;
    }
}
