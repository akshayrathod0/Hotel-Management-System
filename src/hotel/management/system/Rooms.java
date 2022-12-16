
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.*;
import java.sql.*;
public class Rooms extends JFrame implements ActionListener{
    JTable table;
    JButton back_btn;
    Rooms(){
        getContentPane().setBackground(Color.WHITE);
        setBounds(300,200,1050,600);
        setVisible(true);
        setLayout(null);
                
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
    Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(500,0,600,600);
    add(image);
    
    table = new JTable();
    table.setBounds(0,40,500,400);
    add(table);
    
    JLabel lbl1 = new JLabel("Room Number");
    lbl1.setBounds(10,10,100,20);
    add(lbl1);
    
    JLabel lbl2 = new JLabel("Availability");
    lbl2.setBounds(120,10,100,20);
    add(lbl2);
    
    JLabel lbl3 = new JLabel("Status");
    lbl3.setBounds(230,10,100,20);
    add(lbl3);
    
    JLabel lbl4 = new JLabel("Price");
    lbl4.setBounds(330,10,100,20);
    add(lbl4);
    
    JLabel lbl5 = new JLabel("Bed Type");
    lbl5.setBounds(410,10,100,20);
    add(lbl5);
    
    back_btn = new JButton("Back");
    back_btn.setBackground(Color.BLACK);
    back_btn.setForeground(Color.WHITE);
    back_btn.addActionListener(this);
    back_btn.setBounds(200,500,80,35);
    add(back_btn);
    

    try{
        Conn conn = new Conn();
        ResultSet rs = conn.s.executeQuery("select * from room");
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
        new Rooms();
    }
}
