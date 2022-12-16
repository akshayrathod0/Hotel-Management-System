
package hotel.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Dashboard extends JFrame implements ActionListener{
    Dashboard(){
        setLayout(null);
        setBounds(0,0,1550,1000);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(""));
        Image i2 = i1.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);
        
        JLabel text  = new JLabel("THE TAJ GROUP WELCOME YOU");
        text.setBounds(400,80,1000,50);
        text.setBackground(Color.white);
        text.setForeground(Color.GREEN);
        text.setFont(new Font("arial",Font.PLAIN,46));
        image.add(text);
        
        JMenuBar mb = new JMenuBar();
        
        mb.setBounds(0,0,1550,30);
        image.add(mb);

        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setBounds(0,0,80,50);
        hotel.setBackground(Color.red);
        hotel.setForeground(Color.BLUE);
        mb.add(hotel);
        
        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);
        
        JMenu admin = new JMenu("ADMIN");
        admin.setBounds(100,0,1550,50);
        admin.setForeground(Color.BLACK);
        mb.add(admin);
        
        JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
        addemployee.addActionListener(this);
        admin.add(addemployee);  

        JMenuItem adddrivers = new JMenuItem("ADD DRIVERS");
        adddrivers.addActionListener(this);
        admin.add(adddrivers);
        
        JMenuItem addroom = new JMenuItem("ADD ROOMS");
        addroom.addActionListener(this);
        admin.add(addroom);
        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("ADD EMPLOYEE")){
            new AddEmployee();
        }else if(ae.getActionCommand().equals("ADD ROOMS")){
            new AddRoom();
        }else if(ae.getActionCommand().equals("ADD DRIVERS")){
            new AddDrivers();
        }else if(ae.getActionCommand().equals("RECEPTION")){
            new Reception();
        }
    }
    public static void main(String[] args){
        new Dashboard();
    }
}
