
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.*;
import java.sql.*;
public class PickUpService extends JFrame implements ActionListener{
    JTable table;
    JButton submit_btn, back_btn;
    Choice typeof_car; 
    JCheckBox  available;
    PickUpService(){
        getContentPane().setBackground(Color.WHITE);
        setBounds(300,200,1050,600);
        setVisible(true);
        setLayout(null);
               
    JLabel search_lbl = new JLabel("Pickup Service");
    search_lbl.setBounds(400,30,200,30);
    add(search_lbl);
    
      JLabel bed_type_lbl = new JLabel("Type of Car");
    bed_type_lbl.setBounds(50,100,100,20);
    add(bed_type_lbl);

     typeof_car = new Choice();
     typeof_car.setBounds(150,100,200,25);
     add(typeof_car);
     
     try{
         Conn conn = new Conn();
         ResultSet rs = conn.s.executeQuery("select * from driver");
         while(rs.next()){
             typeof_car.add(rs.getString("brand"));
         }
     }catch(Exception e){
         e.printStackTrace();
     }

   available = new JCheckBox("Only Display available");
   available.setBounds(700, 100, 150, 25);
   available.setBackground(Color.WHITE);
   add(available);
   
   
    
        
    table = new JTable();
    table.setBounds(0,200,1050,300);
    add(table);
    
    JLabel lbl1 = new JLabel("Name");
    lbl1.setBounds(50,180,100,20);
    add(lbl1);
    
    JLabel lbl2 = new JLabel("Age");
    lbl2.setBounds(200,180,100,20);
    add(lbl2);
    
    JLabel lbl3 = new JLabel("Gender");
    lbl3.setBounds(350,180,100,20);
    add(lbl3);
    
    JLabel lbl4 = new JLabel("Company");
    lbl4.setBounds(500,180,100,20);
    add(lbl4);
    
    JLabel lbl5 = new JLabel("Brand");
    lbl5.setBounds(650,180,100,20);
    add(lbl5);
    
    JLabel lbl6 = new JLabel("Available");
    lbl6.setBounds(800,180,100,20);
    add(lbl6);
    
      JLabel lbl7 = new JLabel("Location");
    lbl7.setBounds(950,180,100,20);
    add(lbl7);
    
    
    
    try{
        Conn conn = new Conn();
        ResultSet rs = conn.s.executeQuery("select * from driver");
        table.setModel(DbUtils.resultSetToTableModel(rs));
    }catch(Exception e){
        e.printStackTrace();
    }
    submit_btn = new JButton("Submit");
    submit_btn.setBackground(Color.BLACK);
    submit_btn.setForeground(Color.WHITE);
    submit_btn.addActionListener(this);
    submit_btn.setBounds(200,500,80,35);
    add(submit_btn);
    
    back_btn = new JButton("Back");
    back_btn.setBackground(Color.BLACK);
    back_btn.setForeground(Color.WHITE);
    back_btn.addActionListener(this);
    back_btn.setBounds(350,500,80,35);
    add(back_btn);
   
    try{
        Conn conn = new Conn();
        ResultSet rs = conn.s.executeQuery("select * from driver");
        table.setModel(DbUtils.resultSetToTableModel(rs));
        
    }catch(Exception e){
        e.printStackTrace();
    }
}
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit_btn){
            try{
                String query1 = "select * from driver where brand='"+typeof_car.getSelectedItem()+"'";
                 ResultSet rs; 
                Conn conn = new Conn();
                 rs = conn.s.executeQuery(query1);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Reception();  
        } 
    }
    public static void main(String[] args){
        new PickUpService();
    }
}
