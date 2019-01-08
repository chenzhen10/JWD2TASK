package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Map;

public class Validator {

    public static <E> boolean criteriaValidator(Criteria<E> criteria) throws IllegalArgumentException {

        boolean criteriaNameValid = false;
        String applianceType = criteria.getApplianceType();

        CriteriaValidationManager criteriaManager = new CriteriaValidationManager();
        Object[] allowedCriteriaNames = criteriaManager.getAllowedCriteriaNames(applianceType);

        for (Map.Entry entry : criteria.getCriteria().entrySet()) {
            for (Object allowedCriteriaName : allowedCriteriaNames) {
                if (entry.getKey().equals(allowedCriteriaName)) {
                    criteriaNameValid = true;
                    break;
                }
            }
            if (!criteriaNameValid || !criteriaManager.criteriaValueValid(entry.getValue())) {
                return false;
            }
            criteriaNameValid = false;
        }
        return true;
    }
}

class CriteriaValidationManager {

    Object[] getAllowedCriteriaNames(String applianceType) throws IllegalArgumentException {
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

    boolean criteriaValueValid(Object criteriaValue) {
        return (criteriaValue instanceof Number || criteriaValue.getClass() == String.class);
    }
}
