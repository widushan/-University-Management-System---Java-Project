/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package universitymanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;


public class FeeStructure extends JFrame implements ActionListener{
    
    JTable table; 
    
    
    FeeStructure(){
        
        setSize(900, 350);
        setLocation(350, 50);
        setLayout(null);
        

        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(350, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);
        
        table = new JTable();



        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(150, 100, 600, 140);
        add(jsp);
        
        try {
            Conn c = new Conn();
            String query = "SELECT * FROM feestructure";
            ResultSet rs = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        setVisible(true);
        
    }
    
    
    public static void main(String[] args) {
        new FeeStructure();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
