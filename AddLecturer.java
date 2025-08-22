
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;



public class AddLecturer extends JFrame implements ActionListener {

    JTextField tlname, tfaddress, tfphone, tfemail, tfnic;
    JLabel labellecno;
    JDateChooser dcsd;
    JComboBox<String> cbdepartment;
    JComboBox<String> cbmodule1;
    JComboBox<String> cbmodule2;
    JComboBox<String> cbmodule3;
    JComboBox<String> cbmodule4;
    JButton submit, cancel;

    

    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L); // Generate a random 4-digit number

    AddLecturer() {
        setSize(900, 700);
        setLocation(350, 50);
        setLayout(null);
        

        JLabel heading = new JLabel("Lecturer Details");
        heading.setBounds(350, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);


        JLabel lblname = new JLabel("Lecturer Name");
        lblname.setBounds(40, 150, 200, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);
        tlname = new JTextField();
        tlname.setBounds(200, 150, 200, 30);
        tlname.setFont(new Font("serif", Font.PLAIN, 18));
        add(tlname);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(450, 150, 200, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladdress);
        tfaddress = new JTextField();
        tfaddress.setBounds(640, 150, 200, 30);
        tfaddress.setFont(new Font("serif", Font.PLAIN, 18));
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone No.");
        lblphone.setBounds(40, 200, 200, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);
        tfphone = new JTextField();
        tfphone.setBounds(200, 200, 200, 30);
        tfphone.setFont(new Font("serif", Font.PLAIN, 18));
        add(tfphone);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(450, 200, 200, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);
        tfemail = new JTextField();
        tfemail.setBounds(640, 200, 200, 30);
        tfemail.setFont(new Font("serif", Font.PLAIN, 18));
        add(tfemail);

        JLabel lblnic = new JLabel("NIC NO");
        lblnic.setBounds(40, 250, 200, 30);
        lblnic.setFont(new Font("serif", Font.BOLD, 20));
        add(lblnic);
        tfnic = new JTextField();
        tfnic.setBounds(200, 250, 200, 30);
        tfnic.setFont(new Font("serif", Font.PLAIN, 18));
        add(tfnic);

        JLabel lbllecno = new JLabel("Lecturer ID");
        lbllecno.setBounds(450, 250, 200, 30);
        lbllecno.setFont(new Font("serif", Font.BOLD, 20));
        add(lbllecno);
        labellecno = new JLabel("LEC" + first4);
        labellecno.setBounds(640, 250, 200, 30);
        labellecno.setFont(new Font("serif", Font.PLAIN, 18));
        add(labellecno);

        JLabel lblsd = new JLabel("Service Entry");
        lblsd.setBounds(40, 300, 200, 30);
        lblsd.setFont(new Font("serif", Font.BOLD, 20));
        add(lblsd);

        dcsd = new JDateChooser();
        dcsd.setBounds(200, 300, 200, 30);
        dcsd.setFont(new Font("serif", Font.PLAIN, 18));
        add(dcsd);

        JLabel lbldepartment = new JLabel("Department");
        lbldepartment.setBounds(450, 300, 200, 30);
        lbldepartment.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldepartment);
        String[] department = {"Engineering", "Medical", "Business", "IT", "Art", "Music", "Law", "Dancing", "Sports"};
        cbdepartment = new JComboBox<>(department);
        cbdepartment.setBounds(640, 300, 200, 30);
        cbdepartment.setFont(new Font("serif", Font.PLAIN, 18));
        cbdepartment.setBackground(Color.WHITE);
        add(cbdepartment);

        JLabel lblmodule1 = new JLabel("Module 1");
        lblmodule1.setBounds(40, 350, 200, 30);
        lblmodule1.setFont(new Font("serif", Font.BOLD, 20));
        add(lblmodule1);
        String[] module1 = {"S001 - Course 1", "S002 - Course 2", "S003 - Course 3", "S004 - Course 4", "S005 - Course 5"};
        cbmodule1 = new JComboBox<>(module1);
        cbmodule1.setBounds(200, 350, 200, 30);
        cbmodule1.setFont(new Font("serif", Font.PLAIN, 18));
        cbmodule1.setBackground(Color.WHITE);
        add(cbmodule1);

        JLabel lblmodule2 = new JLabel("Module 2");
        lblmodule2.setBounds(450, 350, 200, 30);
        lblmodule2.setFont(new Font("serif", Font.BOLD, 20));
        add(lblmodule2);
        String[] module2 = {"S001 - Course 1", "S002 - Course 2", "S003 - Course 3", "S004 - Course 4", "S005 - Course 5"};
        cbmodule2 = new JComboBox<>(module1);
        cbmodule2.setBounds(640, 350, 200, 30);
        cbmodule2.setFont(new Font("serif", Font.PLAIN, 18));
        cbmodule2.setBackground(Color.WHITE);
        add(cbmodule2);

        JLabel lblmodule3 = new JLabel("Module 3");
        lblmodule3.setBounds(40, 400, 200, 30);
        lblmodule3.setFont(new Font("serif", Font.BOLD, 20));
        add(lblmodule3);
        String[] module3 = {"S001 - Course 1", "S002 - Course 2", "S003 - Course 3", "S004 - Course 4", "S005 - Course 5"};
        cbmodule3 = new JComboBox<>(module1);
        cbmodule3.setBounds(200, 400, 200, 30);
        cbmodule3.setFont(new Font("serif", Font.PLAIN, 18));
        cbmodule3.setBackground(Color.WHITE);
        add(cbmodule3);

        JLabel lblmodule4 = new JLabel("Module 4");
        lblmodule4.setBounds(450, 400, 200, 30);
        lblmodule4.setFont(new Font("serif", Font.BOLD, 20));
        add(lblmodule4);
        String[] module4 = {"S001 - Course 1", "S002 - Course 2", "S003 - Course 3", "S004 - Course 4", "S005 - Course 5"};
        cbmodule4 = new JComboBox<>(module1);
        cbmodule4.setBounds(640, 400, 200, 30);
        cbmodule4.setFont(new Font("serif", Font.PLAIN, 18));
        cbmodule4.setBackground(Color.WHITE);
        add(cbmodule4);

        


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
        new AddLecturer();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == submit) {
            String name = tlname.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String nic = tfnic.getText();
            String lecno = labellecno.getText();
            String doservice = ((JTextField) dcsd.getDateEditor().getUiComponent()).getText();
            String department = (String) cbdepartment.getSelectedItem();
            String module1 = (String) cbmodule1.getSelectedItem();
            String module2 = (String) cbmodule2.getSelectedItem();
            String module3 = (String) cbmodule3.getSelectedItem();
            String module4 = (String) cbmodule4.getSelectedItem();


            try {
                Conn c = new Conn();
                String query = "INSERT INTO lecturer VALUES('" + name + "','" + address + "','" + phone + "','" + email + "','" + nic + "','" + lecno + "','" + doservice + "','" + department + "','" + module1 + "','" + module2 + "','" + module3 + "','" + module4 + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Lecturer Details Added Successfully");
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
