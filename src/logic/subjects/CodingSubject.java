package logic.subjects;


import Utils.CommandBuilder;


public class CodingSubject extends Subject implements Codeable {

    public CodingSubject(String name) {
        super(name);
    }

    @Override
    public void openCodeEditor() {
        CommandBuilder.runCommand(Codeable.command);
    }
}
