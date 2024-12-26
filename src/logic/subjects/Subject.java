package logic.subjects;

import java.util.List;

import Utils.CommandBuilder;
import Utils.PopulateLists;
import logic.filetypes.*;

public class Subject {

    private List<Files> files;
    private String name;

    public Subject(String name) {
        this.name = name;
        this.files = setWordFiles();
    }

    public List<Files> getFiles() {
        return files;
    }

    public List<Files> setWordFiles() {
        return PopulateLists.readFiles(this.getName());
    }


    public void openAllFiles() {
        for (Files file : files) {
            CommandBuilder.runCommand(file.getCommand() + file.getFilepath());
        }
    }

    public void openFilesInRange(int start, int end) {
        for (int i = start; i <= end; i++) {
            String command = files.get(i).getCommand() + files.get(i-1).getFilepath();
            CommandBuilder.runCommand(command);
        }
    }

    public String getName() {
        return name;
    }

    

}
