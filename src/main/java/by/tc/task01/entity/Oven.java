package by.tc.task01.entity;

import java.util.Objects;

public class Oven extends Appliance {
    private double capacity;
    private double depth;

    public Oven() {
    }

    public Oven(int powerConsumption, double weight, double capacity, double depth, double height, double width) {
        super(powerConsumption, height, weight, width);
        this.capacity = capacity;
        this.depth = depth;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Oven oven = (Oven) o;
        return Double.compare(oven.capacity, capacity) == 0 &&
                Double.compare(oven.depth, depth) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), capacity, depth);
    }

    @Override
    public String toString() {
        return "Oven{" +
                "capacity=" + capacity +
                ", depth=" + depth +
                '}';
    }

    // you may add your own code here
}
