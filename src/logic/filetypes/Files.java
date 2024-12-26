package logic.filetypes;

import java.util.Arrays;
import java.util.List;


public class Files {
    
    private String command;
    private String filepath;

    public Files(String filepath) {

        this.filepath = filepath;

        if (filepath.contains("ppt") || filepath.contains("pptx")) {
            command = "start powerpnt ";
        } else if (filepath.contains("pdf")) {
            command = "start chrome ";
        } else if (filepath.contains("word")) {
            command = "start winword ";  
        }
    }

    public String getCommand() {
        return command;
    }

    public String getFilepath() {
        return filepath;
    }

    

}
