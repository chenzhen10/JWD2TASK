package by.tc.task01.util.impl;

import by.tc.task01.util.IDataReadable;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class DataReader implements IDataReadable {

    private File file;

    {
        try {
            file = new File(getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }//should handle this moment
    }


    private BufferedReader br = new BufferedReader(new FileReader(file));




    public DataReader() throws FileNotFoundException {
    }



    public String getFullApplianceData() throws IOException {

        List data = new ArrayList();
        String lines = br.readLine();

        while(lines != null  ){

            data.add(lines);
            data.add("\n");

            lines = br.readLine();
        }
        data.removeAll(Collections.singleton(""));

        return String.valueOf(data);
    }

    public String getPath() throws IOException {
        String sourceName;

        Properties dbProperties = new Properties();
        InputStream inputStream = new FileInputStream("db.properties");

        dbProperties.load(inputStream);
        sourceName = dbProperties.getProperty("path");

        inputStream.close();

        return sourceName;
    }

}
