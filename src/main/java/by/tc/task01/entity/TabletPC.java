package by.tc.task01.entity;

import java.util.Objects;

public class TabletPC extends ComputerTechnology{
    private String color;
    private int flashMemory;

    public TabletPC() {
    }

    public TabletPC(double batteryCapacity, double displayInches, int ram, int flashMemory, String color) {
        super(batteryCapacity, displayInches, ram);
        this.color = color;
        this.flashMemory = flashMemory;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getFlashMemory() {
        return flashMemory;
    }

    public void setFlashMemory(int flashMemory) {
        this.flashMemory = flashMemory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TabletPC tabletPC = (TabletPC) o;
        return flashMemory == tabletPC.flashMemory &&
                Objects.equals(color, tabletPC.color);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), color, flashMemory);
    }

    @Override
    public String toString() {
        return "TabletPC{" +
                "color='" + color + '\'' +
                ", flashMemory=" + flashMemory +
                '}';
    }

    // you may add your own code here
}
