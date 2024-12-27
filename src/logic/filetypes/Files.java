package logic.filetypes;



public class Files {
    
    private String command;
    private String filepath;

    public Files(String filepath) {

        this.filepath = filepath;

        if (filepath.endsWith("ppt") || filepath.endsWith("pptx")) {
            command = "start powerpnt ";
        } else if (filepath.endsWith("pdf")) {
            command = "start chrome ";
        } else if (filepath.endsWith("word")) {
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
