
import javax.swing.*;
import java.awt.*;
import java.sql.*;



public class StudentLeave extends JFrame {

    StudentLeave(){

        setSize(500,550);
        setLocation(550,100);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Apply Leave Student");
        heading.setBounds(40, 50, 300, 30);
        add(heading);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));


        JLabel lblrollno = new JLabel("Search by Reg No");
        lblrollno.setBounds(20, 20, 150, 20);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));

        add(lblrollno);

        JTextField tfrollno = new JTextField(); // Create a JTextField
        tfrollno.setBounds(180, 20, 150, 20);
        add(tfrollno);



        JTable table = new JTable();



        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 1000, 600);
        add(jsp);

        
        try {
            Conn c = new Conn();
            String query = "SELECT * FROM student";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                tfrollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        setVisible(true);



    }

    public static void main(String[] args){

        new StudentLeave();
        
    }
    
}
