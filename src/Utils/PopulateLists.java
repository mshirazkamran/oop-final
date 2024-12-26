package Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import logic.filetypes.Files;


public class PopulateLists {

    private static final Map<String,String> map = Map.of(
        "OOP", "txtfiles/OOPlocations.txt",
        "DSA", "txtfiles/DSAlocations.txt",
        "IE", "txtfiles/IElocations.txt",
        "PK", "txtfiles/PKlocations.txt",
        "SEC", "txtfiles/SEClocations.txt",
        "CALC", "txtfiles/CALClocations.txt"
    );
    
    public static List<Files> readFiles(String subjectName) {

        subjectName = subjectName.toUpperCase();
        List<Files> list = new ArrayList<Files>();
        String filepath = map.get(subjectName);
        System.out.println(filepath.repeat(4));


        //file exists
        // System.out.println(filepath);
        // File file = new File(filepath);
        // System.out.println(file.exists());


        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            System.out.println(reader.markSupported());
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
