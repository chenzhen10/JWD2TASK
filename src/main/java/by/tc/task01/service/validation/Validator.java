package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Map;

public class Validator<E> {

    public static <E> boolean criteriaValidator(Criteria<E> criteria)  {

        boolean criteriaNameValid = false;
        String applianceType = criteria.getApplianceType();

        Object[] allowedCriteriaNames = getAllowedCriteriaNames(applianceType);

        for (Map.Entry entry : criteria.getCriteria().entrySet()) {
            for (Object allowedCriteriaName : allowedCriteriaNames) {
                if (entry.getKey().equals(allowedCriteriaName)) {
                    criteriaNameValid = true;
                    break;
                }
            }
            if (!criteriaNameValid || !criteriaValueValid(entry.getValue())) {
                return false;
            }
            criteriaNameValid = false;
        }
        return true;
    }


    private static Object[] getAllowedCriteriaNames(String applianceType)  {
        if (applianceType == null) throw new IllegalArgumentException("Appliance type not set!");
        Object[] valuesNames = null;
        switch (applianceType) {
            case "Oven":
                valuesNames = SearchCriteria.Oven.values();
                break;
            case "Laptop":
                valuesNames = SearchCriteria.Laptop.values();
                break;
            case "Refrigerator":
                valuesNames = SearchCriteria.Refrigerator.values();
                break;
            case "Speakers":
                valuesNames = SearchCriteria.Speakers.values();
                break;
            case "TabletPC":
                valuesNames = SearchCriteria.TabletPC.values();
                break;
            case "VacuumCleaner":
                valuesNames = SearchCriteria.VacuumCleaner.values();
        }
        return valuesNames;
    }

    private static boolean criteriaValueValid(Object criteriaValue) {
        boolean flag = true;
        if (criteriaValue.getClass().getSimpleName().equalsIgnoreCase("Integer")) {
            if ((int) criteriaValue < 0) {
                flag = false;
            }
        } else if (criteriaValue.getClass().getSimpleName().equalsIgnoreCase("Double")) {
            if ((double) criteriaValue < 0) {
                flag = false;
            }
        }
        return (flag || criteriaValue.getClass() == String.class);
    }
}


