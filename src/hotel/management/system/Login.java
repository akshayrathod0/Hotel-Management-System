package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
  JTextField username_txt = new JTextField();
  JPasswordField password_txt = new JPasswordField();
  JButton login_btn = new JButton("login");
  JButton cancel_btn = new JButton("cancel");
 Login(){
     getContentPane().setBackground(Color.white);
     setLayout(null);
     
     JLabel user_lbl  = new JLabel("Username");
     user_lbl.setBounds(40,20,100,30);
     add(user_lbl);
     
     username_txt.setBounds(150,20,130,30);
     add(username_txt);
     
     JLabel password_lbl = new JLabel("Password");
     password_lbl.setBounds(40,70,100,30);
     add(password_lbl);
     
     password_txt.setBounds(150, 70, 130, 30);
     add(password_txt);
     
     login_btn.setBounds(40,150,120,30);
     login_btn.setBackground(Color.BLACK);
     login_btn.setForeground(Color.WHITE);
     login_btn.addActionListener(this);
     add(login_btn);
     
     cancel_btn.setBounds(180,150,120,30);
     cancel_btn.setBackground(Color.BLACK);
     cancel_btn.setForeground(Color.WHITE);
     cancel_btn.addActionListener(this);
     add(cancel_btn);
     setBounds(500,200,600,300);
     setVisible(true);
     
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(""));
     JLabel image1 = new JLabel(i1);
     image1.setBounds(350,10,200,200);
     add(image1);
 }
 public void actionPerformed(ActionEvent ae){
     if (ae.getSource()==login_btn){
         String user = username_txt.getText();
         String password  = password_txt.getText();
         try{
             Conn c = new Conn();
             
             String query = "select * from login where username = '" +user+ "'"
                     + " and password = '" +password+ "'";
             ResultSet rs = c.s.executeQuery(query);
             
             if(rs.next()){
                 setVisible(false);
                 new Dashboard();
             }else{
                JOptionPane.showMessageDialog(null, "Invalid username or Password");
             }
             
         }catch(Exception e){
             e.printStackTrace();
         }
     }else if(ae.getSource()==cancel_btn){
         setVisible(false);
     }
 }

 public static void main(String[] args){
     new Login();
 }
}

