package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDrivers extends JFrame implements ActionListener {

    JTextField name_txt, age_txt,cmp_txt,brand_txt,location_txt;
    JComboBox available_chbox, gender_chbox;
    JButton add_driver_btn, cancel_btn;

    AddDrivers() {
        setBounds(300, 200, 980, 490);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);

        JLabel heading_lbl = new JLabel("Add Drivers");
        heading_lbl.setFont(new Font("aboma", Font.BOLD, 18));
        heading_lbl.setBounds(150, 20, 200, 20);
        add(heading_lbl);

        JLabel name_lbl = new JLabel("Name");
        name_lbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
        name_lbl.setBounds(60, 80, 150, 30);
        add(name_lbl);

        name_txt = new JTextField();
        name_txt.setBounds(200, 80, 150, 30);
        add(name_txt);

        JLabel age_lbl = new JLabel("Age");
        age_lbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
        age_lbl.setBounds(60, 120, 150, 30);
        add(age_lbl);
        
        age_txt = new JTextField();
        age_txt.setBounds(200, 120, 150, 30);
        add(age_txt);

        JLabel gender_lbl = new JLabel("Gender");
        gender_lbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
        gender_lbl.setBounds(60, 160, 150, 30);
        add(gender_lbl);

        String gender_status[] = {"Male", "Female"};
        gender_chbox = new JComboBox(gender_status);
        gender_chbox.setBounds(200, 160, 150, 30);
//        available_chbox.setForeground(Color.WHITE);
        gender_chbox.setBackground(Color.WHITE);
        add(gender_chbox);

        JLabel cmp_lbl = new JLabel("Company");
        cmp_lbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
        cmp_lbl.setBounds(60, 200, 150, 30);
        add(cmp_lbl);

        cmp_txt = new JTextField();
        cmp_txt.setBounds(200, 200, 150, 30);
        add(cmp_txt);

        JLabel brand_lbl = new JLabel("Brand");
        brand_lbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
        brand_lbl.setBounds(60, 240, 150, 30);
        add(brand_lbl);
       
        brand_txt = new JTextField();
        brand_txt.setBounds(200, 240, 150, 30);
        add(brand_txt);
        
        JLabel location_lbl = new JLabel("Location");
        location_lbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
        location_lbl.setBounds(60, 280, 150, 30);
        add(location_lbl);
       
        location_txt = new JTextField();
        location_txt.setBounds(200, 280, 150, 30);
        add(location_txt);
        
        JLabel available_lbl = new JLabel("Available");
        available_lbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
        available_lbl.setBounds(60, 320, 150, 30);
        add(available_lbl);
        
        String driver_status[] = {"Available", "Busy"};
        available_chbox = new JComboBox(driver_status);
        available_chbox.setBounds(200, 320, 150, 30);
        available_chbox.setBackground(Color.WHITE);
        add(available_chbox);

        add_driver_btn = new JButton("Add Driver");
        add_driver_btn.setBounds(60, 395, 120, 30);
        add_driver_btn.setBackground(Color.BLACK);
        add_driver_btn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add_driver_btn.setForeground(Color.WHITE);
        add_driver_btn.addActionListener(this);
        add(add_driver_btn);

        cancel_btn = new JButton("Cancel");
        cancel_btn.setBounds(200, 395, 120, 30);
        cancel_btn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        cancel_btn.setForeground(Color.WHITE);
        cancel_btn.setBackground(Color.BLACK);
        cancel_btn.addActionListener(this);
        add(cancel_btn);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);

        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 500, 300);
        add(image);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add_driver_btn) {
            String name = name_txt.getText();
            String age = age_txt.getText(); 
            String gender = (String) gender_chbox.getSelectedItem();
            String company = cmp_txt.getText();
            String brand = brand_txt.getName();
            String available = (String) available_chbox.getSelectedItem();
            
            String location = location_txt.getText();

            try {
                Conn conn = new Conn();
                String query = "insert into driver values('" + name+ "', '" + age + 
                        "', '" + gender + "', '" + company + "', '" + brand + "','"+available+"','"+ location+"')";
                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "New Room Added Successfully");

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddDrivers();
    }
}
