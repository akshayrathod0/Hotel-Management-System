
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddRoom extends JFrame implements ActionListener{
    JTextField room_no_txt, price_txt ;
    JComboBox available_chbox, clean_chbox, bed_type_chbox;
    JButton add_btn, cancel_btn;
    AddRoom(){
        setBounds(330,200,940,470);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
        
        
        JLabel heading_lbl = new JLabel("Add Rooms");
        heading_lbl.setFont(new Font("aboma",Font.BOLD,18));
        heading_lbl.setBounds(150,20, 200, 20);
        add(heading_lbl);
        
        JLabel room_no_lbl = new JLabel("Room Numbers");
        room_no_lbl.setFont(new Font("Tahoma",Font.PLAIN,18));
        room_no_lbl.setBounds(60,80,150,30);
        add(room_no_lbl);
        
        room_no_txt = new JTextField();
        room_no_txt.setBounds(200,80,150,30);
        add(room_no_txt);
        
        JLabel available_lbl = new JLabel("Available");
        available_lbl.setFont(new Font("Tahoma",Font.PLAIN,18));
        available_lbl.setBounds(60,130,150,30);
        add(available_lbl);
        
        String available_status[] = {"Available","Occupied"};
        available_chbox = new JComboBox(available_status);
        available_chbox.setBounds(200,130,150,30);
//        available_chbox.setForeground(Color.WHITE);
        available_chbox.setBackground(Color.WHITE);
        add(available_chbox);
        
        JLabel clean_lbl = new JLabel("Cleaning Status");
        clean_lbl.setFont(new Font("Tahoma",Font.PLAIN,18));
        clean_lbl.setBounds(60,180,150,30);
        add(clean_lbl);
        
        String clean_status[] = {"Cleaned","Durty"};
        clean_chbox = new JComboBox(clean_status);
        clean_chbox.setBounds(200,180,150,30);
//        available_chbox.setForeground(Color.WHITE);
        clean_chbox.setBackground(Color.WHITE);
        add(clean_chbox);

        JLabel price_lbl = new JLabel("Price");
        price_lbl.setFont(new Font("Tahoma",Font.PLAIN,18));
        price_lbl.setBounds(60,230,150,30);
        add(price_lbl);        

        price_txt = new JTextField();
        price_txt.setBounds(200,230,150,30);
        add(price_txt);        
       
        JLabel bed_type_lbl = new JLabel("Bed Type");
        bed_type_lbl.setFont(new Font("Tahoma",Font.PLAIN,18));
        bed_type_lbl.setBounds(60,280,150,30);
        add(bed_type_lbl);        
        
        String bed_type[] = {"Single Bed","Double Bed"};
        bed_type_chbox = new JComboBox(bed_type);
        bed_type_chbox.setBounds(200,280,150,30);
        bed_type_chbox.setBackground(Color.WHITE);
        add(bed_type_chbox);     
        
        add_btn = new JButton("Add Room");
        add_btn.setBounds(60,340,120,30);
        add_btn.setBackground(Color.BLACK);
        add_btn.setFont(new Font("Tahoma",Font.PLAIN,18));
        add_btn.setForeground(Color.WHITE);
        add_btn.addActionListener(this);
        add(add_btn);
        
        cancel_btn = new JButton("Back");
        cancel_btn.setBounds(200,340,120,30);
        cancel_btn.setFont(new Font("Tahoma",Font.PLAIN,18));
        cancel_btn.setForeground(Color.WHITE);
        cancel_btn.setBackground(Color.BLACK);
        cancel_btn.addActionListener(this);
        add(cancel_btn);
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,50,500,300);
        add(image);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add_btn){
            String roomnumber=room_no_txt.getText();
            String available=(String)available_chbox.getSelectedItem();
            String status=(String)clean_chbox.getSelectedItem();
            String price=price_txt.getText();
            String bed_type=(String)bed_type_chbox.getSelectedItem();
            
            try{
                Conn conn = new Conn();
                String query = "insert into room values('"+roomnumber+"', '"+available+"', '"+status+"', '"+price+"', '"+bed_type+"')";
                conn.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "New Room Added Successfully");
                
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new AddRoom();
    }
}
