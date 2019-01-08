package by.tc.task01.entity;

import java.util.Objects;

public class Refrigerator extends Appliance{
    private double freezeCapacity;
    private double overallCapacity;

    public Refrigerator() {
    }

    public Refrigerator(int powerConsumption,double weight,double freezeCapacity,double overallCapacity, double height,  double width  ) {
        super(powerConsumption, height, weight, width);
        this.freezeCapacity = freezeCapacity;
        this.overallCapacity = overallCapacity;
    }

    public double getFreezeCapacity() {
        return freezeCapacity;
    }

    public void setFreezeCapacity(double freezeCapacity) {
        this.freezeCapacity = freezeCapacity;
    }

    public double getOverallCapacity() {
        return overallCapacity;
    }

    public void setOverallCapacity(double overallCapacity) {
        this.overallCapacity = overallCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Refrigerator that = (Refrigerator) o;
        return Double.compare(that.freezeCapacity, freezeCapacity) == 0 &&
                Double.compare(that.overallCapacity, overallCapacity) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), freezeCapacity, overallCapacity);
    }

    @Override
    public String toString() {
        return "Refrigerator{" +
                "freezeCapacity=" + freezeCapacity +
                ", overallCapacity=" + overallCapacity +
                '}';
    }

    // you may add your own code here
}
