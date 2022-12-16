
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class UpdateCheck  extends JFrame implements ActionListener{
    JButton  check_btn, update_btn, back_btn;
    Choice customer;
    JTextField room_txt,checkin_time_txt, name_txt, amount_deposit_txt, amount_pending_txt;
    UpdateCheck(){
        setLayout(null);  
        setBounds(300,200,900,500);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel heading_lbl = new JLabel("Update Status");
        heading_lbl.setBounds(90,20,200,20);
        heading_lbl.setFont(new Font("Tahoma",Font.PLAIN,20));
        heading_lbl.setForeground(Color.BLUE);
        add(heading_lbl);
        
        JLabel id_lbl = new JLabel("Customer id");
        id_lbl.setBounds(30,80,100,20);
        add(id_lbl);
        
        customer = new Choice();
        customer.setBounds(200,80,150,20);
        add(customer);

        try{
            Conn conn = new Conn();
             ResultSet rs = conn.s.executeQuery("select * from customer");
             while(rs.next()){
                 customer.add(rs.getString("number"));     
             }
        }catch(Exception e){
            e.printStackTrace();
        }
         JLabel room_no_lbl = new JLabel("Room Number");
        room_no_lbl.setBounds(30,120,100,20);
        add(room_no_lbl);
        room_txt = new JTextField();
        room_txt.setBounds(200,120,150,25);
        add(room_txt);
        
        JLabel name_lbl = new JLabel("Name");
        name_lbl.setBounds(30,160,100,20);
        add(name_lbl);
        name_txt = new JTextField();
        name_txt.setBounds(200,160,150,25);
        add(name_txt);
        
        JLabel checkin_time_lbl = new JLabel("Checkin Time");
        checkin_time_lbl.setBounds(30,200,100,20);
        add(checkin_time_lbl);       
        checkin_time_txt = new JTextField();
        checkin_time_txt.setBounds(200,200,150,25);
        add(checkin_time_txt);
        
        
         JLabel amount_lbl = new JLabel("Amount Paid");
        amount_lbl.setBounds(30,240,100,20);
        add(amount_lbl);
        
        amount_deposit_txt = new JTextField();
        amount_deposit_txt.setBounds(200,240,150,25);
        add(amount_deposit_txt);
        
         JLabel amount_pending_lbl = new JLabel("Pending Amount");
        amount_pending_lbl.setBounds(30,280,100,20);
        add(amount_pending_lbl);
        
        amount_pending_txt = new JTextField();
        amount_pending_txt.setBounds(200,280,150,25);
        add(amount_pending_txt);
        
        check_btn = new JButton("Check");
        check_btn.setBounds(30,340,90,30);
        check_btn.setBackground(Color.BLACK);
        check_btn.setForeground(Color.WHITE);
        check_btn.addActionListener(this);
        add(check_btn);
        
        update_btn = new JButton("Update");
        update_btn.setBounds(140,340,90,30);
        update_btn.setBackground(Color.BLACK);
        update_btn.setForeground(Color.WHITE);
        update_btn.addActionListener(this);
        add(update_btn);
        
        back_btn = new JButton("Back");
        back_btn.setBounds(260,340,90,30);
        back_btn.setBackground(Color.BLACK);
        back_btn.setForeground(Color.WHITE);
        back_btn.addActionListener(this);
        add(back_btn);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,20,500,400);
        add(image);  
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==check_btn){
            String id = customer.getSelectedItem();
            String query = "select * from customer where number='"+id+"'";
            try{
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery(query);
                while(rs.next()){
                    room_txt.setText(rs.getString("room"));
                    name_txt.setText(rs.getString("name"));
                    checkin_time_txt.setText(rs.getString("check_in_date"));
                    amount_deposit_txt.setText(rs.getString("deposit"));
                }
                ResultSet rs2 = conn.s.executeQuery("select * from customer where number='"+room_txt.getText()+"'");
                while(rs2.next()){
                    String price=rs2.getString("price");
                    int amount_paid=Integer.parseInt(price)- Integer.parseInt(amount_deposit_txt.getText());
                    amount_pending_txt.setText(""+amount_paid);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==update_btn){
            String number = customer.getSelectedItem();
            String room = room_txt.getText();
            String name = name_txt.getText();
            String checkin_time = checkin_time_txt.getText();
            String deposit = amount_deposit_txt.getText();
            
            try{
                Conn conn = new Conn();
                conn.s.executeUpdate("update customer set room='"+room+"',name='"+name+"', check_in_date='"+checkin_time+"', deposit='"+deposit+"' where number='"+number+"'");
                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                
                setVisible(false);
                new Reception();
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
        }else{
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args){
        new UpdateCheck();
    }
}
