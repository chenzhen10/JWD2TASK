package by.tc.task01.util.impl;


import by.tc.task01.util.IValidateFronFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ValidateFromFile implements IValidateFronFile {



    public List validateFromFile(String str){
        List appliances = new ArrayList<>();
            String[] spliterator = str.replace(",","").split("[\\n]|;" );
            for(String iter : spliterator) {
                appliances.add(iter);
                appliances.removeAll(Collections.singleton(""));
        }
        return appliances;
    }
}
