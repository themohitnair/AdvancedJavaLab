package stuInfo;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class StudentInformationApp extends JFrame{
	StudentInformationApp() {
		this.setSize(500, 500);
		this.setTitle("Student Information App");		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel panel = new JPanel(new GridLayout(11, 2, 3, 3));
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		JLabel nameLabel = new JLabel("Name");
		JLabel usnLabel = new JLabel("USN");
		JLabel ageLabel = new JLabel("Age");
		JLabel addrLabel = new JLabel("Address");
		JLabel catLabel = new JLabel("Category");
		JLabel oneLabel = new JLabel("SGPA in the First Semester");
		JLabel twoLabel = new JLabel("SGPA in the Second Semester");
		JLabel threeLabel = new JLabel("SGPA in the Third Semester");
		JLabel fourLabel = new JLabel("SGPA in the Fourth Semester");
		
		JTextField name = new JTextField();
		JTextField usn = new JTextField();
		JTextField age = new JTextField();
		JTextField addr = new JTextField();
		JComboBox<String> cat = new JComboBox<String>(new String[] {"General", "SC", "ST", "OBC", "Minority"});
		JTextField sgpa1 = new JTextField();
		JTextField sgpa2 = new JTextField();
		JTextField sgpa3 = new JTextField();
		JTextField sgpa4 = new JTextField();
		
		JButton compute = new JButton("Compute");
		JButton submit = new JButton("Submit");
		
		JTextArea results = new JTextArea();
		results.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(results);
		scrollPane.setPreferredSize(new Dimension(450, 100));
		JPanel resultPanel = new JPanel(new BorderLayout());
		resultPanel.add(scrollPane, BorderLayout.CENTER);
		
		panel.add(nameLabel);
		panel.add(name);
		panel.add(usnLabel);
		panel.add(usn);
		panel.add(ageLabel);
		panel.add(age);
		panel.add(addrLabel);
		panel.add(addr);
		panel.add(catLabel);
		panel.add(cat);
		panel.add(oneLabel);
		panel.add(sgpa1);
		panel.add(twoLabel);
		panel.add(sgpa2);
		panel.add(threeLabel);
		panel.add(sgpa3);
		panel.add(fourLabel);
		panel.add(sgpa4);
		panel.add(compute);
		panel.add(submit);
		
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String studentName = name.getText();
					int studentUSN = Integer.parseInt(usn.getText());
					int studentAge = Integer.parseInt(age.getText());
					String studentAddr = addr.getText();
					String studentCat = cat.getSelectedItem().toString();
					double studentSGPA1 = Double.parseDouble(sgpa1.getText());
					double studentSGPA2 = Double.parseDouble(sgpa2.getText());
					double studentSGPA3 = Double.parseDouble(sgpa3.getText());
					double studentSGPA4 = Double.parseDouble(sgpa4.getText());
					Student st = new Student(studentName, studentUSN, studentAge, studentAddr, studentCat, studentSGPA1, studentSGPA2, studentSGPA3, studentSGPA4);
					results.append(st.toString() + "\n");						
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Please enter only numeric values for USN, Age and SGPA Fields");
				}							
			}
		});
		
		compute.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					double studentSGPA1 = Double.parseDouble(sgpa1.getText());
					double studentSGPA2 = Double.parseDouble(sgpa2.getText());
					double studentSGPA3 = Double.parseDouble(sgpa3.getText());
					double studentSGPA4 = Double.parseDouble(sgpa4.getText());
					JOptionPane.showMessageDialog(null, "Calculated CGPA: " + (studentSGPA1 + studentSGPA2 + studentSGPA3 + studentSGPA4) / 4);
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Please enter only numeric values for SGPA Fields");
				}	
			}
		});
		
		mainPanel.add(panel, BorderLayout.NORTH);
		mainPanel.add(resultPanel, BorderLayout.CENTER);
		this.add(mainPanel);		
		this.setVisible(true);		
	}
	
	public static void main(String args[]) {
		StudentInformationApp app = new StudentInformationApp();	
	}
			
}
