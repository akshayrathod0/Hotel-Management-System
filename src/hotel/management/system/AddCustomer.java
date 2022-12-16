package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener {

    JComboBox id_chbox;
    JLabel check_in_date_lbl;
    Choice c_all_ch;
    JButton add_btn, back_btn;
    JTextField number_txt, name_txt, country_txt, deposit_txt;
    JRadioButton male_rb, female_rb;

    AddCustomer() {
        setBounds(350, 200, 800, 550);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setLayout(null);

        JLabel new_cus_lbl = new JLabel("NEW CUSTOMER FORM");
        new_cus_lbl.setBounds(100, 20, 300, 30);
        new_cus_lbl.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(new_cus_lbl);

        JLabel id_lbl = new JLabel("ID Proof");
        id_lbl.setBounds(35, 80, 100, 20);
        id_lbl.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(id_lbl);

        String options[] = {"Aadhar Card", "Password", "Driving Licence", "Voter-id card", "Rayshan card"};
        id_chbox = new JComboBox(options);
        id_chbox.setBounds(200, 80, 150, 25);
        id_chbox.setBackground(Color.WHITE);
        add(id_chbox);

        JLabel number_lbl = new JLabel("Number");
        number_lbl.setBounds(35, 120, 100, 20);
        number_lbl.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(number_lbl);

        number_txt = new JTextField();
        number_txt.setBounds(200, 120, 150, 25);
        add(number_txt);

        JLabel name_lbl = new JLabel("Name");
        name_lbl.setBounds(35, 160, 100, 20);
        name_lbl.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(name_lbl);

        name_txt = new JTextField();
        name_txt.setBounds(200, 160, 150, 25);
        add(name_txt);

        JLabel gender_lbl = new JLabel("Gender");
        gender_lbl.setBounds(35, 200, 100, 20);
        gender_lbl.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(gender_lbl);

        male_rb = new JRadioButton("Male");
        male_rb.setBounds(200, 200, 60, 25);
        male_rb.setBackground(Color.WHITE);
        add(male_rb);

        female_rb = new JRadioButton("Female");
        female_rb.setBounds(270, 200, 100, 25);
        female_rb.setBackground(Color.WHITE);
        add(female_rb);

        JLabel country_lbl = new JLabel("Country");
        country_lbl.setBounds(35, 240, 100, 20);
        country_lbl.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(country_lbl);

        country_txt = new JTextField();
        country_txt.setBounds(200, 240, 150, 25);
        add(country_txt);

        JLabel allo_room_lbl = new JLabel("Room Number");
        allo_room_lbl.setBounds(35, 280, 150, 20);
        allo_room_lbl.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(allo_room_lbl);

        c_all_ch = new Choice();
        c_all_ch.setBounds(200, 280, 150, 20);
        add(c_all_ch);

        JLabel check_in_time_lbl = new JLabel("Check In Date");
        check_in_time_lbl.setBounds(35, 320, 180, 20);
        check_in_time_lbl.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(check_in_time_lbl);

        Date date = new Date();

        check_in_date_lbl = new JLabel("" + date);
        check_in_date_lbl.setBounds(200, 320, 150, 25);
        check_in_date_lbl.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(check_in_date_lbl);

        JLabel deposit_lbl = new JLabel("Deposit");
        deposit_lbl.setBounds(35, 360, 100, 20);
        deposit_lbl.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(deposit_lbl);

        deposit_txt = new JTextField();
        deposit_txt.setBounds(200, 360, 150, 25);
        add(deposit_txt);

        add_btn = new JButton("Add");
        add_btn.setBackground(Color.BLACK);
        add_btn.setForeground(Color.WHITE);
        add_btn.setBounds(50, 410, 120, 25);
        add_btn.addActionListener(this);
        add(add_btn);

        back_btn = new JButton("Back");
        back_btn.setBackground(Color.BLACK);
        back_btn.setForeground(Color.WHITE);
        back_btn.setBounds(200, 410, 120, 25);
        back_btn.addActionListener(this);
        add(back_btn);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 300, 400);
        add(image);

        try {
            Conn conn = new Conn();
            String query = "select * from room";
            ResultSet rs = conn.s.executeQuery(query);

            while (rs.next()) {
                c_all_ch.add(rs.getString("roomnumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add_btn) {
            String document = (String) id_chbox.getSelectedItem();
            String number = number_txt.getText();
            String name = name_txt.getText();
            String gender = null;

            if (male_rb.isSelected()) {
                gender = "Male";
            } else {
                gender = "Female";
            }
            String country = country_txt.getText();
            String room = c_all_ch.getSelectedItem();
            String time = check_in_date_lbl.getText();
            String deposit = deposit_txt.getText();

            try {
                String query = "insert into customer values('" + document + "','" + number + "','" + name + "'"
                        + ",'" + gender + "','" + country + "','" + room + "','" + time + "','" + deposit + "')";

                String query1 = "update room set availability = 'Occupied' where roomnumber='" + room + "'";
                Conn conn = new Conn();
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query1);

                JOptionPane.showMessageDialog(null, "New Customer added Successfully");
                setVisible(false);
                new Reception();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back_btn) {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new AddCustomer();
    }

}
