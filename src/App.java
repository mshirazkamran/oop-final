import javax.swing.SwingUtilities;

import Utils.CommandBuilder;
import logic.Student;
import logic.subjects.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        GUIbuilder.buildGUI(new Student("shiraz"));
    }
}
