package vasko.collections.set;

import java.util.Objects;

public class Car implements Comparable<Car> {
    @Override
    public int compareTo(Car car) {
        if (pricePerDay < car.pricePerDay) {
            return -1;
        }
        if (pricePerDay > car.pricePerDay) {
            return 1;
        }
        return 0;
    }

    private final String carBrend;
    private final String model;
    private final Integer pricePerDay;

    public Car(String carBrend, String model, int pricePerDay) {
        this.carBrend = carBrend;
        this.model = model;
        this.pricePerDay = pricePerDay;
    }

    public String getCarBrend() {
        return carBrend;
    }

    public String getModel() {
        return model;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Car car = (Car) obj;
        if (!this.carBrend.equals(car.getCarBrend())) return false;
        if (!this.model.equals(car.getModel())) return false;
        return this.pricePerDay.equals(car.getPricePerDay());
    }

    @Override
    public int hashCode() {
        return Objects.hash(carBrend, model, pricePerDay);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carBrend='" + carBrend + '\'' +
                ", model='" + model + '\'' +
                ", pricePerDay=" + pricePerDay +
                '}';
    }
}
