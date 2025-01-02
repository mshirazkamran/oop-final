package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import logic.filetypes.Files;


public class PopulateLists {

    private static final Map<String,String> map = Map.of(
        "OOP", "./src/txtfiles/OOPlocations.txt",
        "DSA", "./src/txtfiles/DSAlocations.txt",
        "IE", "./src/txtfiles/IElocations.txt",
        "PK", "./src/txtfiles/PKlocations.txt",
        "SEC", "./src/txtfiles/SEClocations.txt",
        "CALC", "./src/txtfiles/CALClocations.txt"
    );
    
    public static List<Files> readFiles(String subjectName) {

        subjectName = subjectName.toUpperCase();
        List<Files> list = new ArrayList<Files>();
        String filepath = map.get(subjectName);


        //file exists
        // System.out.println(filepath);
        // File file = new File(filepath);
        // System.out.println(file.exists());


        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(new Files(line));
            }
        } catch (Exception e) {
            System.err.println("error reading files: " + e.getMessage() + "\n" + e.getLocalizedMessage());
        }

        return list;
    }
}
