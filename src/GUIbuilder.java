import javax.swing.*;

import org.w3c.dom.events.MouseEvent;

import logic.Student;
import logic.subjects.CodingSubject;
import logic.subjects.InvalidInputException;
import logic.subjects.Subject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Map;

public class GUIbuilder {

    private static final Map<String, Integer> indexes = Map.of(
        "OOP", 0,
        "DSA", 1,
        "IE", 2,
        "CALC",3,
        "PK", 4,
        "SEC", 5
        
    );


    public static void buildGUI(Student student) {

        JFrame frame = new JFrame("GUI with Buttons");
        frame.setSize(400, 280); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setName(student.getName());
        frame.setLocationRelativeTo(null);

        // Set the layout manager to FlowLayout
        frame.setLayout(new FlowLayout());

        // Create buttons based on the subjects
        for (Subject subject : student.getSubjects()) {
            
            JButton button = new JButton(subject.getName());

            //font setup and button size
            button.setFont(new Font("Consolas", Font.BOLD, 24));
            button.setPreferredSize(new Dimension(100, 100));


            // anonymous class is made here to override the 
            // action event method which helps us get the
            // user performed action
            button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    String clickedSubject = ((JButton) e.getSource()).getText();
                    System.out.println(clickedSubject);

                    // Get the max lectures for the clicked subject
                    ArrayList<Subject> subs = (ArrayList<Subject>) student.getSubjects();
                    final Subject chosenSubject = subs.get(indexes.get(clickedSubject));

                    // prints subject or coding subject to the terminal
                    System.out.println("USer clicked on a " + chosenSubject.getClass().getSimpleName());

                    // retrieving max lectures to limit the user selection to maxlectures
                    int maxLectures = chosenSubject.getFiles().size();
                    
                    // if more lectures so we need to open files that only user sepcifies
                    if (!(maxLectures < 8)) {

                        // Set up the range for the combo boxes
                        int lowerBound = 1;
                        int upperBound = maxLectures;

                        // Create the combo boxes for user input
                        JComboBox<Integer> comboBox1 = new JComboBox<>();
                        JComboBox<Integer> comboBox2 = new JComboBox<>();
                        

                        for (int i = lowerBound; i <= upperBound; i++) {
                            comboBox1.addItem(i);
                            comboBox2.addItem(i);
                        }

                        // Create a JPanel to hold the combo boxes and the OK button
                        JPanel panel = new JPanel();
                        panel.add(new JLabel("Select number of files you want to read: "));
                        panel.add(comboBox1);
                        panel.add(comboBox2);

                        JButton okButton = new JButton("Confirm");

                        // anonymous class is made here to override the 
                        // action event method which helps us get the
                        // user performed action
                        okButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // get the selected numbers and open the files
                                int selectedNumber1 = (Integer) comboBox1.getSelectedItem();
                                int selectedNumber2 = (Integer) comboBox2.getSelectedItem();

                                // custom exception thrown here. note that the method
                                // openFilesInRange(int, int) throws it
                                try {
                                    chosenSubject.openFilesInRange(selectedNumber1, selectedNumber2);
                                } catch (InvalidInputException e1) {
                                    e1.getLocalizedMessage();
                                }
                            }
                        });

                        panel.add(okButton);


                        // Main JDialog box to show the combo boxes and the OK button
                        // JComboBoxes are in a JPanel and Jpanel is inside a JDialog
                        JDialog dialog = new JDialog(frame, "Choose File Numbers", true);
                        dialog.setLayout(new BorderLayout());
                        dialog.add(panel, BorderLayout.CENTER);
                        dialog.setSize(400, 150);
                        dialog.setLocationRelativeTo(frame); // Center the dialog
                        dialog.setVisible(true);  // Show the dialog

                    } else {
                        //lesss files need to opened so we open them all
                        chosenSubject.openAllFiles();
                    }
                }    
            });

            // MAin frame
            frame.add(button);
        }

        frame.setVisible(true);
    }
}
