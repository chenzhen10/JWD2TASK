package by.tc.task01.entity;


import java.util.Objects;

public abstract class ComputerTechnology  extends Appliance {
    private double displayInches;
    private double batteryCapacity;
    private int ram;


    public ComputerTechnology() {
    }


    public ComputerTechnology(double displayInches, double batteryCapacity, int ram) {
        this.displayInches = displayInches;
        this.batteryCapacity = batteryCapacity;
        this.ram = ram;
    }

    public double getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(double displayInches) {
        this.displayInches = displayInches;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }


    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComputerTechnology that = (ComputerTechnology) o;
        return Double.compare(that.displayInches, displayInches) == 0 &&
                Double.compare(that.batteryCapacity, batteryCapacity) == 0 &&
                ram == that.ram;
    }

    @Override
    public int hashCode() {

        return Objects.hash(displayInches, batteryCapacity, ram);
    }

    @Override
    public String toString() {
        return "ComputerTechnology{" +
                "displayInches=" + displayInches +
                ", ram=" + ram +
                '}';
    }
}
