import javax.swing.*;
import logic.Student;
import logic.subjects.Subject;

import java.awt.*;
import java.awt.event.ActionEvent;
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
        frame.setSize(400, 400); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setName(student.getName());
        frame.setLocationRelativeTo(null);

        // Set the layout manager to FlowLayout
        frame.setLayout(new FlowLayout());

        // Create buttons based on the subjects
        for (Subject subject : student.getSubjects()) {
            JButton button = new JButton(subject.getName());
            button.setPreferredSize(new Dimension(100, 70));

            button.addActionListener((ActionEvent e) -> {

                String clickedSubject = ((JButton) e.getSource()).getText();
                System.out.println(clickedSubject);

                // Get the max lectures for the clicked subject
                var subs = student.getSubjects();
                Subject chosenSub = subs.get(indexes.get(clickedSubject));
                int maxLectures = chosenSub.getFiles().size();
                
                // Set up the range for the combo boxes
                int lowerBound = 0;
                int upperBound = maxLectures - 1;

                // Create the combo boxes for user input
                JComboBox<Integer> comboBox1 = new JComboBox<>();
                JComboBox<Integer> comboBox2 = new JComboBox<>();

                for (int i = lowerBound; i <= upperBound; i++) {
                    comboBox1.addItem(i);
                    comboBox2.addItem(i);
                }

                // Create a JPanel to hold the combo boxes and the OK button
                JPanel panel = new JPanel();
                panel.add(new JLabel("Select files you want to read: "));
                panel.add(comboBox1);
                panel.add(comboBox2);

                JButton okButton = new JButton("Confirm");
                okButton.addActionListener((ActionEvent ae) -> {
                    int selectedNumber1 = (Integer) comboBox1.getSelectedItem();
                    int selectedNumber2 = (Integer) comboBox2.getSelectedItem();
                    JOptionPane.showMessageDialog(frame, 
                        "You selected: " + selectedNumber1 + " and " + selectedNumber2);
                    chosenSub.openFilesInRange(selectedNumber1, selectedNumber2);
                });

                panel.add(okButton);

                // Create a JDialog to show the combo boxes and the OK button
                JDialog dialog = new JDialog(frame, "Choose Two Numbers", true);
                dialog.setLayout(new BorderLayout());
                dialog.add(panel, BorderLayout.CENTER);
                dialog.setSize(400, 150);
                dialog.setLocationRelativeTo(frame); // Center the dialog
                dialog.setVisible(true);  // Show the dialog
            });

            frame.add(button);
        }

        frame.setVisible(true);
    }
}
