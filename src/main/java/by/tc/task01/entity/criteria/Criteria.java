package by.tc.task01.entity.criteria;

import by.tc.task01.entity.Appliance;

import java.util.*;

public class Criteria<E> {

    private String applianceType;
    private Map<E, Object> criteria = new HashMap<E, Object>();


    public void add(E searchCriteria, Object value) {
        criteria.put(searchCriteria, value);
    }


    public Map<E, Object> getCriteria() {
        return criteria;
    }


    public String getApplianceType() {
        return applianceType;
    }


    public void setApplianceType(String applianceType) {
        this.applianceType = applianceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Criteria<?> criteria1 = (Criteria<?>) o;
        return Objects.equals(applianceType, criteria1.applianceType) &&
                Objects.equals(criteria, criteria1.criteria);
    }

    @Override
    public int hashCode() {

        return Objects.hash(applianceType, criteria);
    }
}
