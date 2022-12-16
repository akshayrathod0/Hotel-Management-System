
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.*;
import java.sql.*;
public class SearchRoom extends JFrame implements ActionListener{
    JTable table;
    JButton submit_btn, back_btn;
    JComboBox bed_type_chbox; 
    JCheckBox  available;
    SearchRoom(){
        getContentPane().setBackground(Color.WHITE);
        setBounds(300,200,1050,600);
        setVisible(true);
        setLayout(null);
               
    JLabel search_lbl = new JLabel("Search for Rooms");
    search_lbl.setBounds(4000,30,200,30);
    add(search_lbl);
    
      JLabel bed_type_lbl = new JLabel("Bed Type");
    bed_type_lbl.setBounds(50,100,100,20);
    add(bed_type_lbl);
   
    String bed_type[] = {"single Bed", "Double Bed"};
   bed_type_chbox = new JComboBox(bed_type);
   bed_type_chbox.setBackground(Color.WHITE);
   bed_type_chbox.setBounds(150,100,150,20);
   add(bed_type_chbox);
   
   available = new JCheckBox("Only Display available");
   available.setBounds(700, 100, 150, 25);
   available.setBackground(Color.WHITE);
   add(available);
   
   
    
        
    table = new JTable();
    table.setBounds(0,200,1000,300);
    add(table);
    
    JLabel lbl1 = new JLabel("Room Number");
    lbl1.setBounds(50,180,100,20);
    add(lbl1);
    
    JLabel lbl2 = new JLabel("Availability");
    lbl2.setBounds(270,180,100,20);
    add(lbl2);
    
    JLabel lbl3 = new JLabel("Cleaning Status");
    lbl3.setBounds(470,180,100,20);
    add(lbl3);
    
    JLabel lbl4 = new JLabel("Price");
    lbl4.setBounds(670,180,100,20);
    add(lbl4);
    
    JLabel lbl5 = new JLabel("Bed Type");
    lbl5.setBounds(870,180,100,20);
    add(lbl5);
    
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
        ResultSet rs = conn.s.executeQuery("select * from room");
        table.setModel(DbUtils.resultSetToTableModel(rs));
        
    }catch(Exception e){
        e.printStackTrace();
    }
}
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit_btn){
            try{
                String query1 = "select * from room where bed_type='"+bed_type_chbox.getSelectedItem()+"'";
                String query2 = "select * from room where availability='Available' AND bed_type='"+bed_type_chbox.getSelectedItem()+"'";
                 ResultSet rs; 
                Conn conn = new Conn();
                if(available.isSelected()){
                    rs = conn.s.executeQuery(query2);
                  
                }else{
                    rs = conn.s.executeQuery(query1);
                }
                
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
        new SearchRoom();
    }
}
