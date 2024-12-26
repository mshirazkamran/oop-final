package logic.subjects;


import Utils.CommandBuilder;


public class CodingSubject extends Subject implements Codeable {

    public CodingSubject(String name) {
        super(name);
    }

    @Override
    public void openAllFiles() {
        super.openAllFiles();
        
        System.out.println("opened all files now openeing code");
        openCodeEditor();
        System.out.println("opened code");
    }

    @Override
    public void openFilesInRange(int  start, int end) {
        super.openFilesInRange(start, end);
        System.out.println("opened all files now openeing code");
        openCodeEditor();
        System.out.println("opened code");

    }


    @Override
    public void openCodeEditor() {
        CommandBuilder.runCommand(Codeable.command);
    }
}
