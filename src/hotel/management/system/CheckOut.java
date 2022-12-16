package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class CheckOut extends JFrame implements ActionListener{

    Choice cCustomer;
    JButton checkOut_btn, back_btn;
    JTextField roomNo_txt;
    JLabel checkin_time_lbl, checkout_time_lbl, roomNo_lbl;
    CheckOut() {
        setLayout(null);
        setBounds(300, 200, 800, 450);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

        JLabel text = new JLabel("CheckOut");
        text.setBounds(100, 30, 100, 30);
        text.setForeground(Color.BLUE);
        add(text);

        JLabel customerId_lbl = new JLabel("Customer Id");
        customerId_lbl.setBounds(40, 70, 100, 30);
        customerId_lbl.setForeground(Color.BLUE);
        add(customerId_lbl);

        cCustomer = new Choice();
        cCustomer.setBounds(200, 70, 150, 25);
        add(cCustomer);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 70, 20, 20);

        roomNo_lbl = new JLabel("Room Number");
        roomNo_lbl.setBounds(40, 120, 100, 30);
        roomNo_lbl.setForeground(Color.BLUE);
        add(roomNo_lbl);
        
        roomNo_txt = new JTextField();
        roomNo_txt.setBounds(200,120,150,30);
        add(roomNo_txt);
        
        JLabel checkin_lbl = new JLabel("CheckIn Time");
         checkin_lbl.setBounds(40, 170, 150, 30);
        checkin_lbl.setForeground(Color.BLUE);
        add(checkin_lbl);
        
         checkin_time_lbl = new JLabel();
         checkin_time_lbl.setBounds(200, 170, 150, 30);
        checkin_time_lbl.setForeground(Color.BLUE);
        add(checkin_time_lbl);
        
        JLabel checkout_lbl = new JLabel("CheckOut Time");
        checkout_lbl.setBounds(40, 220, 150, 30);
        checkout_lbl.setForeground(Color.BLUE);
        add(checkout_lbl);
        
        Date checkout_date = new Date();
        checkout_time_lbl = new JLabel(""+checkout_date);
        checkout_time_lbl.setBounds(200, 220, 150, 30);
        checkout_time_lbl.setForeground(Color.BLUE);
        add(checkout_time_lbl);
        
        checkOut_btn = new JButton("CheckOut");
        checkOut_btn.setBounds(30,300,120,30);
        checkOut_btn.setBackground(Color.BLACK);
        checkOut_btn.setForeground(Color.WHITE);
        checkOut_btn.addActionListener(this);
        add(checkOut_btn);
        
        back_btn = new JButton("Back");
        back_btn.setBounds(170,300,120,30);
        back_btn.setBackground(Color.BLACK);
        back_btn.setForeground(Color.WHITE);
        back_btn.addActionListener(this);
        add(back_btn);
        
         ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
    Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
    ImageIcon i6 = new ImageIcon(i5);
    JLabel image1 = new JLabel(i6);
    image1.setBounds(400,50,400,250);
    add(image1); 
     
    try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");
            while (rs.next()) {
                cCustomer.add(rs.getString("number"));
                roomNo_txt.setText(rs.getString("room"));
                checkin_time_lbl.setText(rs.getString("check_in_date"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
}
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkOut_btn){
            String query1 = "delete from customer where number='"+cCustomer.getSelectedItem()+"'";
            String query2 = "update room set availability='Available' where roomnumber='"+roomNo_lbl.getText()+"'";
            
            try{
                Conn conn = new Conn();
                ResultSet rs;
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "CheckOut Done");
                setVisible(false);
           }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args) {
        new CheckOut();
    }

}
