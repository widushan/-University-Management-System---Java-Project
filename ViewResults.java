/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package universitymanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;



public class ViewResults extends JFrame implements ActionListener {
    
    JTextField regrollno, tfsub1 , tfsub2, tfsub3, tfsub4, tfmark1, tfmark2, tfmark3, tfmark4;
    JLabel tfname, labelrollno, cbbatch, cbfaculty, cbdegree, lblsemester, lblentersubject, lblentermarks;
    JButton search, submit, cancel, update, delete, print;
    JComboBox<String> cbsemester;
    JTable table;
    
    
    ViewResults(){
    
        setSize(1000, 1000);
        setLocation(300, 20);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("ViewResults");
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
        search.setBounds(330, 100, 100, 20);
        search.addActionListener(this);
        add(search);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 100, 100, 20);
        cancel.addActionListener(this);
        add(cancel);
        
        update = new JButton("Update");
        update.setBounds(570, 100, 100, 20);
        update.addActionListener(this);
        add(update);
        
        delete = new JButton("Delete");
        delete.setBounds(690, 100, 100, 20);
        delete.addActionListener(this);
        add(delete);
        
        print = new JButton("Print");
        print.setBounds(810, 100, 100, 20);
        print.addActionListener(this);
        add(print);
        
        
        table = new JTable();



        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(20, 150, 960, 600);
        add(jsp);
        
        try {
            Conn c = new Conn();
            String query = "SELECT * FROM studentmarks";
            ResultSet rs = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        setVisible(true);
        
    }
    
    
    public static void main(String[] args) {
        new ViewResults();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String rollno = regrollno.getText();

            try {
                Conn c = new Conn();
                String query = "SELECT * FROM studentmarks WHERE rollno = '" + rollno + "'";
                System.out.println("Executing Query: " + query); // Debugging: Print the query
                ResultSet rs = c.s.executeQuery(query);

                if (rs.isBeforeFirst()) { // Check if ResultSet has any rows
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                    JOptionPane.showMessageDialog(null, "Student Found!");
                } else {
                    JOptionPane.showMessageDialog(null, "No Student Found with Reg No: " + rollno);
                    table.setModel(new DefaultTableModel()); // Clear the table
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error occurred while searching student.");
            }
        }
        else if
            (ae.getSource() == cancel){
            try {
            Conn c = new Conn();
            String query = "SELECT * FROM studentmarks";
            ResultSet rs = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            //clear the textfield
            regrollno.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        else if (ae.getSource() == delete) {
            String rollno = regrollno.getText();
            try {
                Conn c = new Conn();
                String query = "DELETE FROM studentmarks WHERE rollno = '" + rollno + "'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Student Result Deleted Successfully");
                table.setModel(new DefaultTableModel()); // Clear the table
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else if (ae.getSource()== update){
             new UpdateResults();
        }
        else if (ae.getSource() == print) {
            String rollno = regrollno.getText(); // Get the roll number from the text field
            if (rollno != null && !rollno.trim().isEmpty()) {
                new ResultSheet(rollno); // Pass the roll number to the ResultSheet constructor
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a Roll Number to print the result sheet.");
            }
        }
        
    }
    
}
