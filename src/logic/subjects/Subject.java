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

    public void openFilesInRange(int start, int end) throws InvalidInputException {

        if (start > end) {
            throw new InvalidInputException("Cannot open files if start is smaller than end!");
        }
        for (int i = start; i <= end; i++) {
            // typical command looks like this "start winword file/filename.word"
            String command = files.get(i - 1).getCommand() + files.get(i - 1).getFilepath();
            CommandBuilder.runCommand(command);
        }
    }

    public String getName() {
        return name;
    }
}
