package universitymanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class AddPayments extends JFrame implements ActionListener {

    JTextField regrollno;
    JLabel tfname, labelrollno, cbbatch, cbfaculty, cbdegree, lblfullfee, fullfee, semfee;
    JButton search, addMore, submit, cancel, update;
    JPanel dynamicPanel; // Panel to hold dynamic fields
    JScrollPane scrollPane;
    ArrayList<SemesterPaymentRow> semesterPaymentRows = new ArrayList<>();

    AddPayments() {
        setSize(1000, 1000);
        setLocation(300, 20);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Semester Payments");
        heading.setBounds(300, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        JLabel lblrollnumber = new JLabel("Search by Reg No");
        lblrollnumber.setBounds(40, 100, 200, 30);
        add(lblrollnumber);

        regrollno = new JTextField();
        regrollno.setBounds(160, 100, 150, 20);
        add(regrollno);

        search = new JButton("Search");
        search.setBounds(350, 100, 100, 20);
        search.addActionListener(this);
        add(search);

        JLabel lblname = new JLabel("Student Name");
        lblname.setBounds(40, 150, 200, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);

        tfname = new JLabel();
        tfname.setBounds(200, 150, 200, 30);
        add(tfname);

        JLabel lblrollno = new JLabel("Registration No.");
        lblrollno.setBounds(40, 200, 200, 30);
        lblrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(lblrollno);

        labelrollno = new JLabel();
        labelrollno.setBounds(200, 200, 200, 30);
        labelrollno.setFont(new Font("serif", Font.PLAIN, 18));
        add(labelrollno);

        JLabel lblbatch = new JLabel("Batch");
        lblbatch.setBounds(40, 250, 200, 30);
        lblbatch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbatch);

        cbbatch = new JLabel();
        cbbatch.setBounds(200, 250, 200, 30);
        add(cbbatch);

        JLabel lblfaculty = new JLabel("Faculty");
        lblfaculty.setBounds(40, 300, 200, 30);
        lblfaculty.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfaculty);

        cbfaculty = new JLabel();
        cbfaculty.setBounds(200, 300, 200, 30);
        add(cbfaculty);

        JLabel lbldegree = new JLabel("Degree");
        lbldegree.setBounds(40, 350, 200, 30);
        lbldegree.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldegree);

        cbdegree = new JLabel();
        cbdegree.setBounds(200, 350, 200, 30);
        add(cbdegree); 
        
        JLabel lblfullfee = new JLabel("Degree Fee");
        lblfullfee.setBounds(40, 400, 200, 30);
        lblfullfee.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfullfee);

        fullfee = new JLabel();
        fullfee.setBounds(200, 400, 200, 30);
        add(fullfee);
        
        JLabel lblsemfee = new JLabel("Semester Fee");
        lblsemfee.setBounds(40, 450, 200, 30);
        lblfullfee.setFont(new Font("serif", Font.BOLD, 20));
        add(lblsemfee);

        semfee = new JLabel();
        semfee.setBounds(200, 450, 200, 30);
        add(semfee);
        
        JLabel lblentersubject = new JLabel("Enter Semester and Payment Status");
        lblentersubject.setBounds(60, 500, 500, 30);
        lblentersubject.setFont(new Font("serif", Font.BOLD, 20));
        add(lblentersubject);
        
        // Panel to hold dynamic fields
        dynamicPanel = new JPanel();
        dynamicPanel.setLayout(new BoxLayout(dynamicPanel, BoxLayout.Y_AXIS));
        scrollPane = new JScrollPane(dynamicPanel);
        scrollPane.setBounds(50, 550, 880, 250);
        add(scrollPane);
        
        // Add first row by default
        addSemesterPaymentRow();
        
        addMore = new JButton("Add More");
        addMore.setBounds(50, 830, 120, 30);
        addMore.addActionListener(e -> addSemesterPaymentRow());
        add(addMore);
        
        submit = new JButton("Submit");
        submit.setBounds(200, 900, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(400, 900, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        update = new JButton("Update");
        update.setBounds(600, 900, 120, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);


        setVisible(true);
    }

    public static void main(String[] args) {
        new AddPayments();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String rollno = regrollno.getText();

            try {
                Conn c = new Conn();

                // Query to fetch student details from the 'student' table
                String studentQuery = "SELECT * FROM student WHERE rollno = '" + rollno + "'";
                ResultSet studentRs = c.s.executeQuery(studentQuery);

                if (studentRs.next()) {
                    JOptionPane.showMessageDialog(null, "Student Found!");
                    tfname.setText(studentRs.getString("name"));
                    labelrollno.setText(studentRs.getString("rollno"));
                    cbbatch.setText(studentRs.getString("batch"));
                    cbfaculty.setText(studentRs.getString("faculty"));
                    cbdegree.setText(studentRs.getString("degree"));

                    // Fetch Degree Fee and Semester Fee from the 'feestructure' table
                    String degree = studentRs.getString("degree"); // Get the degree of the student
                    String feeQuery = "SELECT * FROM feestructure WHERE degree = '" + degree + "'";
                    ResultSet feeRs = c.s.executeQuery(feeQuery);

                    if (feeRs.next()) {
                        fullfee.setText(feeRs.getString("fullfee")); // Set Degree Fee
                        semfee.setText(feeRs.getString("semesterfee")); // Set Semester Fee
                    } else {
                        JOptionPane.showMessageDialog(null, "No fee structure found for the degree: " + degree);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No student found with Reg No: " + rollno);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error occurred while searching student.");
            }
        }
        else if (ae.getSource() == submit) {
            String rollno = labelrollno.getText(); // Get the roll number from the label

            if (rollno == null || rollno.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please search and select a student before submitting.");
                return;
            }

            try {
                Conn c = new Conn();

                // Iterate through the rows in the dynamic panel
                for (SemesterPaymentRow row : semesterPaymentRows) {
                    String semester = row.semesterField.getText();
                    String status = row.paymentField.getText();

                    if (!semester.isEmpty() && !status.isEmpty()) {
                        // Insert the data into the semesterpayments table
                        String query = "INSERT INTO semesterpayments (rollno, semester, status) VALUES ('" + rollno + "', '" + semester + "', '" + status + "')";
                        c.s.executeUpdate(query);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please fill out all fields for each row.");
                        return;
                    }
                }

                JOptionPane.showMessageDialog(null, "Semester Payments Submitted Successfully!");
                setVisible(false); // Close the window after submission
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error occurred while submitting payments.");
            }
        }
        else if (ae.getSource() == cancel) {
            setVisible(false);
        }
        else if (ae.getSource() == update) {
            //new UpdateSemesterPayment();
            setVisible(false);
        }
    }

    private void addSemesterPaymentRow() {
        JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField semesterField = new JTextField(20);
        JTextField paymentField = new JTextField(10);
        JButton removeBtn = new JButton("Remove");

        SemesterPaymentRow row = new SemesterPaymentRow(semesterField, paymentField, rowPanel);
        semesterPaymentRows.add(row);

        removeBtn.addActionListener(e -> {
            dynamicPanel.remove(rowPanel);
            semesterPaymentRows.remove(row);
            dynamicPanel.revalidate();
            dynamicPanel.repaint();
        });

        rowPanel.add(new JLabel("Semester:"));
        rowPanel.add(semesterField);
        rowPanel.add(Box.createHorizontalStrut(10));
        rowPanel.add(new JLabel("Status:"));
        rowPanel.add(paymentField);
        rowPanel.add(Box.createHorizontalStrut(10));
        rowPanel.add(removeBtn);

        dynamicPanel.add(rowPanel);
        dynamicPanel.revalidate();
        dynamicPanel.repaint();
    }

    static class SemesterPaymentRow {
        JTextField semesterField, paymentField;
        JPanel rowPanel;

        public SemesterPaymentRow(JTextField semesterField, JTextField paymentField, JPanel rowPanel) {
            this.semesterField = semesterField;
            this.paymentField = paymentField;
            this.rowPanel = rowPanel;
        }
    }
}
