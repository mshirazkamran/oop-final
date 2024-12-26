import javax.swing.SwingUtilities;

import Utils.CommandBuilder;
import logic.Student;
import logic.subjects.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // new CodingSubject().openCodeEditor();
        //runs
        // CommandBuilder.runCommand("start chrome G:\\IMP-FILES\\Semester-3\\Software-Engineering\\3-Lectures\\SEC-FALL-2023-Lecture#1.pdf"); // Opens Visual Studio Code

    //    Subject sub = new Subject("SEC");
    //    sub.openFilesInRange(3,7);

        SwingUtilities.invokeLater( () -> {
            GUIbuilder.buildGUI(new Student("shiraz"));
        });
        // GUIbuilder.buildGUI(new Student("shiraz"));
    }
}
