package by.tc.task01.entity;

import java.util.Objects;

public class Laptop extends ComputerTechnology {
    private String osName;
    private double cpu;
    private int systemMemory;

    public Laptop() {
    }

    public Laptop(double batteryCapacity, String osName, int ram, int systemMemory, double cpu, double displayInches) {
        super(batteryCapacity, displayInches, ram);
        this.osName = osName;
        this.cpu = cpu;
        this.systemMemory = systemMemory;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public double getCpu() {
        return cpu;
    }

    public void setCpu(double cpu) {
        this.cpu = cpu;
    }

    public int getSystemMemory() {
        return systemMemory;
    }

    public void setSystemMemory(int systemMemory) {
        this.systemMemory = systemMemory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Laptop laptop = (Laptop) o;
        return Double.compare(laptop.cpu, cpu) == 0 &&
                systemMemory == laptop.systemMemory &&
                Objects.equals(osName, laptop.osName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), osName, cpu, systemMemory);
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "osName='" + osName + '\'' +
                ", cpu=" + cpu +
                ", systemMemory=" + systemMemory +
                '}';
    }


    // you may add your own code here
}
