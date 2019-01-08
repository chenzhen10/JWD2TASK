package by.tc.task01.util.impl;

import by.tc.task01.util.IReadFromFile;

import java.io.*;

public class ReadFromFile implements IReadFromFile {
    private final  String path = "src/main/resources/appliances_db.txt" ;
    private File file = new File(path);
    private BufferedReader br;

    {
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String readFromFile() throws IOException {
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        while(str != null ){
            sb.append(str);
            sb.append("\n");
            str = br.readLine();
        }
        return String.valueOf(sb);
    }

}
