package by.tc.task01.entity;

import java.util.Objects;

public class Speakers extends Appliance{
    private int numberOfSpeakers;
    private String fregquencyRange;
    private int cordLength;

    public Speakers() {
    }

    public Speakers(int powerConsumption, int numberOfSpeakers, String fregquencyRange, int cordLength) {
        super(powerConsumption);
        this.numberOfSpeakers = numberOfSpeakers;
        this.fregquencyRange = fregquencyRange;
        this.cordLength = cordLength;
    }

    public int getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(int numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public String getFregquencyRange() {
        return fregquencyRange;
    }

    public void setFregquencyRange(String fregquencyRange) {
        this.fregquencyRange = fregquencyRange;
    }

    public int getCordLength() {
        return cordLength;
    }

    public void setCordLength(int cordLength) {
        this.cordLength = cordLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Speakers speakers = (Speakers) o;
        return numberOfSpeakers == speakers.numberOfSpeakers &&
                cordLength == speakers.cordLength &&
                Objects.equals(fregquencyRange, speakers.fregquencyRange);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), numberOfSpeakers, fregquencyRange, cordLength);
    }

    @Override
    public String toString() {
        return "Speakers{" +
                "numberOfSpeakers=" + numberOfSpeakers +
                ", fregquencyRange='" + fregquencyRange + '\'' +
                ", cordLength=" + cordLength +
                '}';
    }

    // you may add your own code here
}
