package logic.subjects;


import Utils.CommandBuilder;


public class CodingSubject extends Subject implements Codeable {

    public CodingSubject(String name) {
        super(name);
    }

    @Override
    public void openAllFiles() {
        super.openAllFiles();
        openCodeEditor();
    }

    @Override
    public void openFilesInRange(int start, int end) {
        super.openFilesInRange(start, end);
        openCodeEditor();
    }

    @Override
    public void openCodeEditor() {
        CommandBuilder.runCommand(Codeable.command);
    }
}
