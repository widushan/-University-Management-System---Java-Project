package universitymanagementsystem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ResultSheet extends JFrame {

    public ResultSheet(String rollno) {
        setSize(600, 750);
        setLocation(300, 50);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Result Sheet");
        heading.setBounds(200, 20, 200, 30);
        heading.setFont(new Font("serif", Font.BOLD, 24));
        add(heading);

        JTextArea resultArea = new JTextArea();
        resultArea.setBounds(50, 70, 500, 550);
        resultArea.setFont(new Font("monospaced", Font.PLAIN, 14));
        resultArea.setEditable(false);
        add(resultArea);

        JButton printButton = new JButton("Print");
        printButton.setBounds(250, 650, 100, 30);
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    resultArea.print(); // Print the content of the JTextArea
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error occurred while printing.");
                }
            }
        });
        add(printButton);

        try {
            Conn c = new Conn();

            // Fetch student details from the 'student' table
            String studentQuery = "SELECT * FROM student WHERE rollno = '" + rollno + "'";
            ResultSet studentRs = c.s.executeQuery(studentQuery);

            StringBuilder resultText = new StringBuilder();
            if (studentRs.next()) {
                resultText.append("Student Name: ").append(studentRs.getString("name")).append("\n");
                resultText.append("Roll Number: ").append(studentRs.getString("rollno")).append("\n");
                resultText.append("Faculty: ").append(studentRs.getString("faculty")).append("\n");
                resultText.append("Degree: ").append(studentRs.getString("degree")).append("\n");
                resultText.append("Batch: ").append(studentRs.getString("batch")).append("\n\n");
            } else {
                JOptionPane.showMessageDialog(null, "No student found with Roll Number: " + rollno);
                return;
            }

            // Fetch student marks from the 'studentmarks' table
            String marksQuery = "SELECT * FROM studentmarks WHERE rollno = '" + rollno + "'";
            ResultSet marksRs = c.s.executeQuery(marksQuery);

            if (marksRs.isBeforeFirst()) {
                resultText.append("Semester-wise Marks:\n");
                resultText.append(String.format("%-15s %-30s %-10s\n", "Semester", "Subject", "Marks"));
                resultText.append("------------------------------------------------------------\n");

                while (marksRs.next()) {
                    resultText.append(String.format("%-15s %-30s %-10s\n",
                            marksRs.getString("semester"),
                            marksRs.getString("subject"),
                            marksRs.getString("mark")));
                }
            } else {
                resultText.append("No marks found for the student.\n");
            }

            resultArea.setText(resultText.toString());
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred while generating result sheet.");
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        String rollno = JOptionPane.showInputDialog("Enter Roll Number:");
        if (rollno != null && !rollno.trim().isEmpty()) {
            new ResultSheet(rollno);
        } else {
            JOptionPane.showMessageDialog(null, "Roll Number cannot be empty.");
        }
    }

    public ResultSheet() {
    
}

}
