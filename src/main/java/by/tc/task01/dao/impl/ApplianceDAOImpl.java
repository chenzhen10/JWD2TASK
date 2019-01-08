package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.util.impl.ReadFromFile;
import by.tc.task01.util.impl.ValidateFromFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ApplianceDAOImpl implements ApplianceDAO {





    public <E> List find(Criteria<E> criteria) {
        ReadFromFile rf = new ReadFromFile();
        ValidateFromFile vf = new ValidateFromFile();
        List<String> finded = new ArrayList<>();

        String extracted = String.valueOf(criteria.getCriteria())
                .replaceAll("[^A-z,0-9.0-9=A-z0-9]","")
                .replace(","," ");

        String[] spliterator = extracted.split("\\s");
        try {
            List<String> l = vf.validateFromFile(rf.readFromFile());
            for (String str : l) {
                differentCountOfCriteria(spliterator,str,finded);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return finded;
    }



    private void differentCountOfCriteria(String [] arr,String str, List finded) {
        if (arr.length == 6) {
            if (str.contains(arr[0]) && str.contains(arr[1]) && str.contains(arr[2]) && str.contains(arr[3])
                    && str.contains(arr[4]) && str.contains(arr[5])) {
                finded.add(str);
            }
        } else if (arr.length == 5) {
            if (str.contains(arr[0]) && str.contains(arr[1]) && str.contains(arr[2]) && str.contains(arr[3])
                    && str.contains(arr[4])) {
                finded.add(str);
            }
        } else if (arr.length == 4) {
            if (str.contains(arr[0]) && str.contains(arr[1]) && str.contains(arr[2]) && str.contains(arr[3])) {
                finded.add(str);
            }
        } else if (arr.length == 3) {
            if (str.contains(arr[0]) && str.contains(arr[1]) && str.contains(arr[2])) {
                finded.add(str);
            }
        } else if (arr.length == 2) {
            if (str.contains(arr[0]) && str.contains(arr[1])) {
                finded.add(str);
            }
        } else if (arr.length == 1) {
            if (str.contains(arr[0])) {
                finded.add(str);
            }

        }
    }




}


