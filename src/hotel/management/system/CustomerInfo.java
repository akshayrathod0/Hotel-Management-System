
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.*;
import java.sql.*;
public class CustomerInfo extends JFrame implements ActionListener{
    JTable table;
    JButton back_btn;
    CustomerInfo(){
        getContentPane().setBackground(Color.WHITE);
        setBounds(300,200,1000,600);
        setVisible(true);
        setLayout(null);
    
    table = new JTable();
    table.setBounds(0,40,1000,400);
    add(table);
    
    JLabel lbl1 = new JLabel("Document Type");
    lbl1.setBounds(10,10,100,20);
    add(lbl1);
    
    JLabel lbl2 = new JLabel("Doc Number");
    lbl2.setBounds(160,10,100,20);
    add(lbl2);
    
    JLabel lbl3 = new JLabel("Name");
    lbl3.setBounds(290,10,100,20);
    add(lbl3);
    
    JLabel lbl4 = new JLabel("Gender");
    lbl4.setBounds(410,10,100,20);
    add(lbl4);
    
    JLabel lbl5 = new JLabel("Country");
    lbl5.setBounds(540,10,100,20);
    add(lbl5);
    
    JLabel lbl6 = new JLabel("Room Number");
    lbl6.setBounds(660,10,100,20);
    add(lbl6);
    
    JLabel lbl7 = new JLabel("Checkin Time");
    lbl7.setBounds(770,10,100,20);
    add(lbl7);
    
    JLabel lbl8 = new JLabel("Deposit");
    lbl8.setBounds(890,10,100,20);
    add(lbl8);
    
    back_btn = new JButton("Back");
    back_btn.setBackground(Color.BLACK);
    back_btn.setForeground(Color.WHITE);
    back_btn.addActionListener(this);
    back_btn.setBounds(420,500,80,35);
    add(back_btn);
    

    try{
        Conn conn = new Conn();
        ResultSet rs = conn.s.executeQuery("select * from customer");
        table.setModel(DbUtils.resultSetToTableModel(rs));
        
    }catch(Exception e){
        e.printStackTrace();
    }
    
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
        
    }
    public static void main(String[] args){
        new CustomerInfo();
    }
}

