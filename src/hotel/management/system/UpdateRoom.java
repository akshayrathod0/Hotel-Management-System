
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class UpdateRoom  extends JFrame implements ActionListener{
    JButton  check_btn, update_btn, back_btn;
    Choice customer;
    JTextField availability_txt, room_no_txt,clean_status_txt, name_txt, amount_deposit_txt, amount_pending_txt;
    UpdateRoom(){
        setLayout(null);  
        setBounds(300,200,980,420);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel heading_lbl = new JLabel("Update Room Status");
        heading_lbl.setBounds(30,35,250,20);
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
        room_no_lbl.setBounds(30,130,100,20);
        add(room_no_lbl);
        room_no_txt = new JTextField();
        room_no_txt.setBounds(200,130,150,25);
        add(room_no_txt);
        
        JLabel availability_lbl = new JLabel("Availabilitity");
        availability_lbl.setBounds(30,180,100,20);
        add(availability_lbl);
        availability_txt = new JTextField();
        availability_txt.setBounds(200,180,150,25);
        add(availability_txt);
        
        JLabel clean_status_lbl = new JLabel("Cleaning Status");
        clean_status_lbl.setBounds(30,230,100,20);
        add(clean_status_lbl);       
        clean_status_txt = new JTextField();
        clean_status_txt.setBounds(200,230,150,25);
        add(clean_status_txt);
        
        check_btn = new JButton("Check");
        check_btn.setBounds(30,330,90,30);
        check_btn.setBackground(Color.BLACK);
        check_btn.setForeground(Color.WHITE);
        check_btn.addActionListener(this);
        add(check_btn);
        
        update_btn = new JButton("Update");
        update_btn.setBounds(140,330,90,30);
        update_btn.setBackground(Color.BLACK);
        update_btn.setForeground(Color.WHITE);
        update_btn.addActionListener(this);
        add(update_btn);
        
        back_btn = new JButton("Back");
        back_btn.setBounds(260,330,90,30);
        back_btn.setBackground(Color.BLACK);
        back_btn.setForeground(Color.WHITE);
        back_btn.addActionListener(this);
        add(back_btn);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,10,500,400);
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
                    room_no_txt.setText(rs.getString("room"));
                }
                ResultSet rs2 = conn.s.executeQuery("select * from room where roomnumber='"+room_no_txt.getText()+"'");
                while(rs2.next()){
                    availability_txt.setText(rs2.getString("availability"));
                    clean_status_txt.setText(rs2.getString("cleaning_status"));
                    
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==update_btn){
            String id = customer.getSelectedItem();
            String  room = room_no_txt.getText();
            String available = availability_txt.getText();
            String clean_status = clean_status_txt.getText();
            
            try{
                Conn conn = new Conn();
                conn.s.executeUpdate("update room set availability='"+available+"', cleaning_status='"+clean_status+"' where roomnumber='"+room+"'");
                
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
        new UpdateRoom();
    }
}
