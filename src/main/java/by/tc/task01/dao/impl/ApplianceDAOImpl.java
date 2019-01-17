package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.util.impl.DataReader;
import by.tc.task01.util.impl.DataValidator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ApplianceDAOImpl implements ApplianceDAO {
    private static final int SIX_ARGUMENT = 6;
    private static final int FIVE_ARGUMENT = 5;
    private static final int FOUR_ARGUMENT = 4;
    private static final int THREE_ARGUMENT = 3;
    private static final int TWO_ARGUMENT = 2;
    private static final int ONE_ARGUMENT = 1;
    private static final int ZERO_ARGUMENT = 0;

    private static final String REG_EXP_FOR_CORRECT_GETTING_DATA = "[^A-z,0-9.0-9=\\-A-z0-9]";
    private static final String REG_EXP_FOR_SEPARATE_BY_COMMA = ",";
    private static final String REG_EXP_FOR_SEPARATE_BY_SPACE = "\\s";
    private static final String REPLACE_EMPTY_STRING = "";
    private static final String REPLACE_SPACE_STRING = " ";




    public <E> List find(Criteria<E> criteria) throws FileNotFoundException {

        DataReader readData = new DataReader();




        DataValidator validateData = new DataValidator();
        List<String> finded = new ArrayList<>();

        String extractedKeys = String.valueOf(criteria.getCriteria())
                .replaceAll(REG_EXP_FOR_CORRECT_GETTING_DATA, REPLACE_EMPTY_STRING)
                .replace(REG_EXP_FOR_SEPARATE_BY_COMMA, REPLACE_SPACE_STRING);

        String[] spliterator = extractedKeys.split(REG_EXP_FOR_SEPARATE_BY_SPACE);

        try {
            List<String> appliances = validateData.validateApplianceData(readData.getFullApplianceData());
            for (String appliance : appliances) {
                differentCountOfCriteria(spliterator, appliance, finded);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return finded;
    }


    private void differentCountOfCriteria(String[] appliances, String appliance, List finded) {

        if (appliances.length == SIX_ARGUMENT) {
            if (appliance.contains(appliances[ZERO_ARGUMENT]) &&
                    appliance.contains(appliances[ONE_ARGUMENT]) &&
                    appliance.contains(appliances[TWO_ARGUMENT]) &&
                    appliance.contains(appliances[THREE_ARGUMENT]) &&
                    appliance.contains(appliances[FOUR_ARGUMENT]) &&
                    appliance.contains(appliances[FIVE_ARGUMENT])) {
                finded.add(appliance);
            }
        } else if (appliances.length == FIVE_ARGUMENT) {
            if (appliance.contains(appliances[ZERO_ARGUMENT]) &&
                    appliance.contains(appliances[ONE_ARGUMENT]) &&
                    appliance.contains(appliances[TWO_ARGUMENT]) &&
                    appliance.contains(appliances[THREE_ARGUMENT]) &&
                    appliance.contains(appliances[FOUR_ARGUMENT])){
                finded.add(appliance);
            }
        } else if (appliances.length == FOUR_ARGUMENT) {
            if (appliance.contains(appliances[ZERO_ARGUMENT]) &&
                    appliance.contains(appliances[ONE_ARGUMENT]) &&
                    appliance.contains(appliances[TWO_ARGUMENT]) &&
                    appliance.contains(appliances[THREE_ARGUMENT])) {
                finded.add(appliance);
            }
        } else if (appliances.length == THREE_ARGUMENT) {
            if (appliance.contains(appliances[ZERO_ARGUMENT]) &&
                    appliance.contains(appliances[ONE_ARGUMENT]) &&
                    appliance.contains(appliances[TWO_ARGUMENT])) {
                finded.add(appliance);
            }
        } else if (appliances.length == TWO_ARGUMENT) {
            if (appliance.contains(appliances[ZERO_ARGUMENT]) &&
                    appliance.contains(appliances[ONE_ARGUMENT])) {
                finded.add(appliance);
            }
        } else if (appliances.length == ONE_ARGUMENT) {
            if (appliance.contains(appliances[ZERO_ARGUMENT])) {
                finded.add(appliance);
            }
        }

    }


}


