package studentInfo;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;

public class StudentInformationApp extends JFrame {
    JTextField fnameField, lnameField, ageField, addrField, USNField;
    JTextField[] SGPAFields;
    JComboBox<String> categorySelect;
    JTextArea addedStudents;
    ArrayList<Student> students;

    StudentInformationApp() {
        this.setTitle("Student Information System");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.students = new ArrayList<Student>();

        JPanel panel = new JPanel(new GridLayout(12, 2));
        this.add(panel, BorderLayout.CENTER);
        
        panel.setBorder(new EmptyBorder(10,10,10,10));
        
        panel.add(new JLabel("First Name: "));
        this.fnameField = new JTextField();
        panel.add(fnameField);

        panel.add(new JLabel("Last Name: "));
        this.lnameField = new JTextField();
        panel.add(lnameField);

        panel.add(new JLabel("USN: "));
        this.USNField = new JTextField();
        panel.add(USNField);

        panel.add(new JLabel("Age: "));
        this.ageField = new JTextField();
        panel.add(ageField);

        this.SGPAFields = new JTextField[4];
        for (int i = 0; i < 4; i++) {
            panel.add(new JLabel("Semester " + (i + 1) + " SGPA: "));
            SGPAFields[i] = new JTextField();
            panel.add(SGPAFields[i]);
        }

        panel.add(new JLabel("Category: "));
        this.categorySelect = new JComboBox<>(new String[]{"General", "SC", "ST", "OBC", "Minority"});
        panel.add(categorySelect);

        panel.add(new JLabel("Address: "));
        this.addrField = new JTextField();
        panel.add(addrField);

        JButton computeButton = new JButton("Compute");
        computeButton.addActionListener(new ComputeButtonListener());
        panel.add(computeButton);

        JButton doneButton = new JButton("Done");
        doneButton.addActionListener(new DoneButtonListener());
        panel.add(doneButton);

        addedStudents = new JTextArea();
        addedStudents.setEditable(false);
        this.add(new JScrollPane(addedStudents), BorderLayout.SOUTH);

        this.setVisible(true);
    }

    private class ComputeButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double totalSgpa = 0.0;
                for (JTextField sgpaField : SGPAFields) {
                    double sgpa = Double.parseDouble(sgpaField.getText());
                    if (sgpa < 0 || sgpa > 10) {
                        throw new NumberFormatException();
                    }
                    totalSgpa += sgpa;
                }
                double cgpa = totalSgpa / SGPAFields.length;
                JOptionPane.showMessageDialog(StudentInformationApp.this, "CGPA: " + cgpa);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(StudentInformationApp.this, "Please enter valid SGPA values (0-10)", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class DoneButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String fname = fnameField.getText().trim();
            String lname = lnameField.getText().trim();
            String usn = USNField.getText();
            String age = ageField.getText();
            String addr = addrField.getText();
            String category = (String) categorySelect.getSelectedItem();

            try {
                double totalSgpa = 0.0;
                for (JTextField sgpaField : SGPAFields) {
                    double sgpa = Double.parseDouble(sgpaField.getText());
                    if (sgpa < 0 || sgpa > 10) {
                        throw new NumberFormatException();
                    }
                    totalSgpa += sgpa;
                }
                double cgpa = totalSgpa / SGPAFields.length;
                
                if (usn.length() != 10) {
                    throw new IllegalArgumentException("USN must be exactly 10 characters long");
                }

                if (fname.isEmpty() || lname.isEmpty() || usn.isEmpty() || age.isEmpty() || addr.isEmpty()) {
                    throw new IllegalArgumentException("All fields must be filled");
                }
                int ageInt = Integer.parseInt(age);
                Student newStudent = new Student(fname, lname, usn, category, addr, ageInt, cgpa);
                students.add(newStudent);
                JOptionPane.showMessageDialog(StudentInformationApp.this, "Student details added");
                addedStudents.append(newStudent.toString() + "\n");
                clearFields();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(StudentInformationApp.this, "Please enter valid numerical values for SGPA and Age", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(StudentInformationApp.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    private void clearFields() {
        fnameField.setText("");
        lnameField.setText("");
        USNField.setText("");
        ageField.setText("");
        addrField.setText("");
        for (JTextField sgpaField : SGPAFields) {
            sgpaField.setText("");
        }
        categorySelect.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        new StudentInformationApp();
    }
}