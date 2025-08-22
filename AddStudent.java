import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;



public class AddStudent extends JFrame implements ActionListener {

    JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfnic, tfyear, tfbatch;
    JLabel labelrollno;
    JDateChooser dcdob;
    JComboBox<String> cbbatch;
    JComboBox<String> cbfaculty;
    JComboBox<String> cbdegree;
    JButton submit, cancel;

    

    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L); // Generate a random 4-digit number

    AddStudent() {
        setSize(900, 700);
        setLocation(350, 50);
        setLayout(null);
        

        JLabel heading = new JLabel("Student Details");
        heading.setBounds(350, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);


        JLabel lblname = new JLabel("Student Name");
        lblname.setBounds(40, 150, 200, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);
        tfname = new JTextField();
        tfname.setBounds(200, 150, 200, 30);
        tfname.setFont(new Font("serif", Font.PLAIN, 18));
        add(tfname);

        JLabel lblfname = new JLabel("Guardian's Name");
        lblfname.setBounds(450, 150, 200, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);
        tffname = new JTextField();
        tffname.setBounds(640, 150, 200, 30);
        tffname.setFont(new Font("serif", Font.PLAIN, 18));
        add(tffname);

        JLabel lblrollno = new JLabel("Registration No.");
        lblrollno.setBounds(40, 200, 200, 30);
        lblrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(lblrollno);
        labelrollno = new JLabel("1533" + first4);
        labelrollno.setBounds(200, 200, 200, 30);
        labelrollno.setFont(new Font("serif", Font.PLAIN, 18));
        add(labelrollno);

        JLabel lbldob = new JLabel("Date Of Birth");
        lbldob.setBounds(450, 200, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(640, 200, 200, 30);
        dcdob.setFont(new Font("serif", Font.PLAIN, 18));
        add(dcdob);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(40, 250, 200, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladdress);
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 200, 30);
        tfaddress.setFont(new Font("serif", Font.PLAIN, 18));
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone No.");
        lblphone.setBounds(450, 250, 200, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);
        tfphone = new JTextField();
        tfphone.setBounds(640, 250, 200, 30);
        tfphone.setFont(new Font("serif", Font.PLAIN, 18));
        add(tfphone);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(40, 300, 200, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 200, 30);
        tfemail.setFont(new Font("serif", Font.PLAIN, 18));
        add(tfemail);

        JLabel lblnic = new JLabel("NIC NO");
        lblnic.setBounds(450, 300, 200, 30);
        lblnic.setFont(new Font("serif", Font.BOLD, 20));
        add(lblnic);
        tfnic = new JTextField();
        tfnic.setBounds(640, 300, 200, 30);
        tfnic.setFont(new Font("serif", Font.PLAIN, 18));
        add(tfnic);

        JLabel lblyear = new JLabel("Year Of Study");
        lblyear.setBounds(40, 350, 200, 30);
        lblyear.setFont(new Font("serif", Font.BOLD, 20));
        add(lblyear);
        tfyear = new JTextField();
        tfyear.setBounds(200, 350, 200, 30);
        tfyear.setFont(new Font("serif", Font.PLAIN, 18));
        add(tfyear);

        JLabel lblbatch = new JLabel("Batch");
        lblbatch.setBounds(450, 350, 200, 30);
        lblbatch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbatch);
        String[] batch = {"2026-A", "2026-B", "2027-A", "2027-B", "2028-A", "2028-B"};
        cbbatch = new JComboBox<>(batch);
        cbbatch.setBounds(640, 350, 200, 30);
        cbbatch.setFont(new Font("serif", Font.PLAIN, 18));
        cbbatch.setBackground(Color.WHITE);
        add(cbbatch);

        JLabel lblfaculty = new JLabel("Faculty");
        lblfaculty.setBounds(40, 400, 200, 30);
        lblfaculty.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfaculty);
        String[] faculty = {"Engineering", "Computer Science", "Information Technology", "Software Engineering", "Data Science"};
        cbfaculty = new JComboBox<>(faculty);
        cbfaculty.setBounds(200, 400, 200, 30);
        cbfaculty.setFont(new Font("serif", Font.PLAIN, 18));
        cbfaculty.setBackground(Color.WHITE);
        add(cbfaculty);

        JLabel lbldegree = new JLabel("Degree");
        lbldegree.setBounds(450, 400, 200, 30);
        lbldegree.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldegree);
        String[] degree = {"B.Tech", "M.Tech", "B.Sc", "M.Sc", "Ph.D"};
        cbdegree = new JComboBox<>(degree);
        cbdegree.setBounds(640, 400, 200, 30);
        cbdegree.setFont(new Font("serif", Font.PLAIN, 18));
        cbdegree.setBackground(Color.WHITE);
        add(cbdegree);


        submit = new JButton("Submit");
        submit.setBounds(200, 500, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(500, 500, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);






        setVisible(true);
    }

    public static void main(String[] args) {
        new AddStudent();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == submit) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String rollno = labelrollno.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String nic = tfnic.getText();
            String year = tfyear.getText();
            String batch = (String) cbbatch.getSelectedItem();
            String faculty = (String) cbfaculty.getSelectedItem();
            String degree = (String) cbdegree.getSelectedItem();


            try {
                Conn c = new Conn();
                String query = "INSERT INTO student VALUES('" + name + "','" + fname + "','" + rollno + "','" + dob + "','" + address + "','" + phone + "','" + email + "','" + nic + "','" + year + "','" + batch + "','" + faculty + "','" + degree + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Student Details Added Successfully");
                setVisible(false);
                //new Home().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
        
        
    }
}

