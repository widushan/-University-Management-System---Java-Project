package universitymanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

public class EnterMarks extends JFrame implements ActionListener {

    JTextField regrollno;
    JLabel tfname, labelrollno, cbbatch, cbfaculty, cbdegree;
    JButton search, submit, cancel, addMore;
    JComboBox<String> cbsemester;

    JPanel dynamicPanel; // Panel to hold dynamic fields
    JScrollPane scrollPane;
    ArrayList<SubjectMarkRow> subjectMarkRows = new ArrayList<>();

    EnterMarks() {
        setSize(1000, 800);
        setLocation(300, 20);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Enter Marks");
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

        JLabel lblsemester = new JLabel("Select Semester");
        lblsemester.setBounds(50, 400, 150, 30);
        add(lblsemester);

        String[] semester = {"1st Semester", "2nd Semester", "3rd Semester", "4th Semester"};
        cbsemester = new JComboBox<>(semester);
        cbsemester.setBounds(230, 400, 150, 20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);

        JLabel lblentersubject = new JLabel("Enter Subjects and Marks");
        lblentersubject.setBounds(60, 440, 300, 30);
        lblentersubject.setFont(new Font("serif", Font.BOLD, 20));
        add(lblentersubject);

        // Panel to hold dynamic fields
        dynamicPanel = new JPanel();
        dynamicPanel.setLayout(new BoxLayout(dynamicPanel, BoxLayout.Y_AXIS));
        scrollPane = new JScrollPane(dynamicPanel);
        scrollPane.setBounds(50, 480, 880, 150);
        add(scrollPane);

        // Add first row by default
        addSubjectMarkRow();

        addMore = new JButton("Add More");
        addMore.setBounds(50, 640, 120, 30);
        addMore.addActionListener(e -> addSubjectMarkRow());
        add(addMore);

        submit = new JButton("Submit");
        submit.setBounds(200, 700, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(500, 700, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }

    private void addSubjectMarkRow() {
        JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField subjectField = new JTextField(20);
        JTextField markField = new JTextField(5);
        JButton removeBtn = new JButton("Remove");

        SubjectMarkRow row = new SubjectMarkRow(subjectField, markField, rowPanel);
        subjectMarkRows.add(row);

        removeBtn.addActionListener(e -> {
            dynamicPanel.remove(rowPanel);
            subjectMarkRows.remove(row);
            dynamicPanel.revalidate();
            dynamicPanel.repaint();
        });

        rowPanel.add(new JLabel("Subject:"));
        rowPanel.add(subjectField);
        rowPanel.add(Box.createHorizontalStrut(10));
        rowPanel.add(new JLabel("Mark:"));
        rowPanel.add(markField);
        rowPanel.add(Box.createHorizontalStrut(10));
        rowPanel.add(removeBtn);

        dynamicPanel.add(rowPanel);
        dynamicPanel.revalidate();
        dynamicPanel.repaint();
    }

    static class SubjectMarkRow {
        JTextField subjectField, markField;
        JPanel rowPanel;

        public SubjectMarkRow(JTextField subjectField, JTextField markField, JPanel rowPanel) {
            this.subjectField = subjectField;
            this.markField = markField;
            this.rowPanel = rowPanel;
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String rollno = regrollno.getText();

            try {
                Conn c = new Conn();
                String query = "SELECT * FROM student WHERE rollno = '" + rollno + "'";
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Student Found!");
                    tfname.setText(rs.getString("name"));
                    labelrollno.setText(rs.getString("rollno"));
                    cbbatch.setText(rs.getString("batch"));
                    cbfaculty.setText(rs.getString("faculty"));
                    cbdegree.setText(rs.getString("degree"));
                } else {
                    JOptionPane.showMessageDialog(null, "No student found with Reg No: " + rollno);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error occurred while searching student.");
            }
        } else if (ae.getSource() == submit) {
            String semester = (String) cbsemester.getSelectedItem();
            String name = tfname.getText();
            String rollno = labelrollno.getText();

            try {
                Conn c = new Conn();
                for (SubjectMarkRow row : subjectMarkRows) {
                    String subject = row.subjectField.getText();
                    String mark = row.markField.getText();
                    if (!subject.isEmpty() && !mark.isEmpty()) {
                        String query = "INSERT INTO studentmarks (name, rollno, semester, subject, mark) VALUES('" + name + "','" + rollno + "','" + semester + "','" + subject + "','" + mark + "')";

                        c.s.executeUpdate(query);
                    }
                }
                JOptionPane.showMessageDialog(null, "Student Marks Inserted Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new EnterMarks();
    }
}
