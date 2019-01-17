package by.tc.task01.util.impl;


import by.tc.task01.util.IDataValidatable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DataValidator implements IDataValidatable {

    private static final String REG_EXP_FOR_SPLITTING_BY_NEW_LINE_OR_SEMICOLON = "[\\n]|;|[\\[]";
    private static final String REPLACE_COMMA = ",";
    private static final String REPLACE_EMPTY_STRING = "";
    private static final String REPLACE_SPACE_STRING = " ";

    public List validateApplianceData(String data) {
        List appliances = new ArrayList<>();

        String[] spliterator = data.replace(REPLACE_COMMA, REPLACE_EMPTY_STRING).
                split(REG_EXP_FOR_SPLITTING_BY_NEW_LINE_OR_SEMICOLON);

        for (String iter : spliterator) {
            appliances.add(iter);
        }
        appliances.removeAll(Collections.singleton(REPLACE_SPACE_STRING));
        appliances.removeAll(Collections.singleton(REPLACE_EMPTY_STRING));


        return appliances;
    }
}
