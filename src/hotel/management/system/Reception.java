package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener {

    JButton newCustomer_btn, rooms_btn, department_btn, all_employee_btn, customer_info_btn, search_room_btn;
    JButton manager_info_btn, checkout_btn, update_status_btn, update_room_status_btn, pickup_ser_btn, logout_btn;

    Reception() {
        setBounds(350, 200, 800, 570);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

        newCustomer_btn = new JButton("New Customer Form");
        newCustomer_btn.setBounds(10, 30, 200, 30);
        newCustomer_btn.setBackground(Color.BLACK);
        newCustomer_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        newCustomer_btn.setForeground(Color.WHITE);
        newCustomer_btn.addActionListener(this);
        add(newCustomer_btn);

        all_employee_btn = new JButton("All Employee");
        all_employee_btn.setBounds(10, 70, 200, 30);
        all_employee_btn.setBackground(Color.BLACK);
        all_employee_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        all_employee_btn.setForeground(Color.WHITE);
        all_employee_btn.addActionListener(this);
        add(all_employee_btn);

        rooms_btn = new JButton("Rooms");
        rooms_btn.setBounds(10, 110, 200, 30);
        rooms_btn.setBackground(Color.BLACK);
        rooms_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        rooms_btn.setForeground(Color.WHITE);
        rooms_btn.addActionListener(this);
        add(rooms_btn);

        department_btn = new JButton("Department");
        department_btn.setBounds(10, 150, 200, 30);
        department_btn.setBackground(Color.BLACK);
        department_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        department_btn.setForeground(Color.WHITE);
        department_btn.addActionListener(this);
        add(department_btn);

        customer_info_btn = new JButton("Customer Info");
        customer_info_btn.setBounds(10, 190, 200, 30);
        customer_info_btn.setBackground(Color.BLACK);
        customer_info_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        customer_info_btn.setForeground(Color.WHITE);
        customer_info_btn.addActionListener(this);
        add(customer_info_btn);

        manager_info_btn = new JButton("Manager Info");
        manager_info_btn.setBounds(10, 230, 200, 30);
        manager_info_btn.setBackground(Color.BLACK);
        manager_info_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        manager_info_btn.setForeground(Color.WHITE);
        manager_info_btn.addActionListener(this);
        add(manager_info_btn);

        checkout_btn = new JButton("Checkout");
        checkout_btn.setBounds(10, 270, 200, 30);
        checkout_btn.setBackground(Color.BLACK);
        checkout_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        checkout_btn.setForeground(Color.WHITE);
        checkout_btn.addActionListener(this);
        add(checkout_btn);

        update_status_btn = new JButton("Update Status");
        update_status_btn.setBounds(10, 310, 200, 30);
        update_status_btn.setBackground(Color.BLACK);
        update_status_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        update_status_btn.setForeground(Color.WHITE);
        update_status_btn.addActionListener(this);
        add(update_status_btn);

        update_room_status_btn = new JButton("Update Room Status");
        update_room_status_btn.setBounds(10, 350, 200, 30);
        update_room_status_btn.setBackground(Color.BLACK);
        update_room_status_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        update_room_status_btn.setForeground(Color.WHITE);
        update_room_status_btn.addActionListener(this);
        add(update_room_status_btn);

        pickup_ser_btn = new JButton("Pickup Service");
        pickup_ser_btn.setBounds(10, 390, 200, 30);
        pickup_ser_btn.setBackground(Color.BLACK);
        pickup_ser_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        pickup_ser_btn.setForeground(Color.WHITE);
        pickup_ser_btn.addActionListener(this);
        add(pickup_ser_btn);

        search_room_btn = new JButton("Search Room");
        search_room_btn.setBounds(10, 430, 200, 30);
        search_room_btn.setBackground(Color.BLACK);
        search_room_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        search_room_btn.setForeground(Color.WHITE);
        search_room_btn.addActionListener(this);
        add(search_room_btn);

        logout_btn = new JButton("Logout");
        logout_btn.setBounds(10, 470, 200, 30);
        logout_btn.setBackground(Color.BLACK);
        logout_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        logout_btn.setForeground(Color.WHITE);
        logout_btn.addActionListener(this);
        add(logout_btn);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(530, 470, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(230, 20, 530, 470);
        add(image);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == newCustomer_btn) {
            setVisible(false);
            new AddCustomer();
        } else if (ae.getSource() == rooms_btn) {
            setVisible(false);
            new Rooms();
        } else if (ae.getSource() == department_btn) {
            setVisible(false);
            new Department();
        } else if (ae.getSource() == all_employee_btn) {
            setVisible(false);
            new AllEmployee();
        }else if (ae.getSource() == customer_info_btn) {
            setVisible(false);
            new CustomerInfo();
        } else if (ae.getSource() == search_room_btn) {
            setVisible(false);
            new SearchRoom();
        } else if (ae.getSource() == update_status_btn) {
            setVisible(false);
            new UpdateCheck();
        } else if (ae.getSource() == update_room_status_btn) {
            setVisible(false);
            new UpdateRoom();
        } else if (ae.getSource() == pickup_ser_btn) {
            setVisible(false);
            new PickUpService();
        } else if (ae.getSource() == manager_info_btn) {
            setVisible(false);
            new ManagerInfo();
        } else if(ae.getSource() == checkout_btn ){
            setVisible(false);
            new CheckOut();
        }else if(ae.getSource() == logout_btn){
            setVisible(false);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Reception();
    }
}
