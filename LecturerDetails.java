
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils; 



public class LecturerDetails extends JFrame implements ActionListener {

    JTextField tfrollno; 
    JTable table; 
    JButton search, print, update, add, delete, cancel;


    LecturerDetails() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Search by LEC ID");
        heading.setBounds(20, 20, 150, 20);
        add(heading);

        tfrollno = new JTextField(); // Create a JTextField
        tfrollno.setBounds(180, 20, 150, 20);
        add(tfrollno);



        table = new JTable();



        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 1000, 600);
        add(jsp);
        
        try {
            Conn c = new Conn();
            String query = "SELECT * FROM lecturer";
            ResultSet rs = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }




        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);

        add = new JButton("Add");
        add.setBounds(320, 70, 80, 20);
        add.addActionListener(this);
        add(add);

        delete = new JButton("Delete");
        delete.setBounds(420, 70, 80, 20);
        delete.addActionListener(this);
        add(delete);

        cancel = new JButton("Cancel");
        cancel.setBounds(520, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);




        setSize(1000, 700);
        setLocation(300, 100);
        setVisible(true);
    }

    public static void main(String[] args) { 
        new LecturerDetails();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String lecno = tfrollno.getText();
            try {
                Conn c = new Conn();
                String query = "SELECT * FROM lecturer WHERE lecno = '" + lecno + "'";
                System.out.println("Executing Query: " + query); // Debugging: Print the query
                ResultSet rs = c.s.executeQuery(query);

                if (rs.isBeforeFirst()) { // Check if ResultSet has any rows
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                    JOptionPane.showMessageDialog(null, "Lecturer Found!");
                } else {
                    JOptionPane.showMessageDialog(null, "No Lecturer Found with Reg No: " + lecno);
                    table.setModel(new DefaultTableModel()); // Clear the table
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                
            }
        }

        else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
        
        else if (ae.getSource() == update) {
            setVisible(false);
            //new UpdateLecturer()
        } 
        
        else if (ae.getSource() == add) {
            setVisible(false);
            new AddLecturer();
            
        } 
        
        else if (ae.getSource() == delete) {
            String lecno = tfrollno.getText();
            try {
                Conn c = new Conn();
                String query = "DELETE FROM lecturer WHERE lecno = '" + lecno + "'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Lecturer Deleted Successfully");
                table.setModel(new DefaultTableModel()); // Clear the table
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } 
        
        else if (ae.getSource() == cancel) {
            setVisible(false);
        }
        
         
        
         
        
        
    }
}





