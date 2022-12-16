
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.*;
import java.sql.*;
public class Department extends JFrame implements ActionListener{
    JTable table;
    JButton back_btn;
    Department(){
        getContentPane().setBackground(Color.WHITE);
        setBounds(300,200,700,600);
        setVisible(true);
        setLayout(null);
               
    table = new JTable();
    table.setBounds(0,40,700,350);
    add(table);
    
    JLabel lbl1 = new JLabel("Department");
    lbl1.setBounds(70,10,100,20);
    add(lbl1);
    
    JLabel lbl2 = new JLabel("Budget");
    lbl2.setBounds(420,10,100,20);
    add(lbl2);
    
    back_btn = new JButton("Back");
    back_btn.setBackground(Color.BLACK);
    back_btn.setForeground(Color.WHITE);
    back_btn.addActionListener(this);
    back_btn.setBounds(280,400,120,35);
    add(back_btn);
    

    try{
        Conn conn = new Conn();
        ResultSet rs = conn.s.executeQuery("select * from department");
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
        new Department();
    }
}
