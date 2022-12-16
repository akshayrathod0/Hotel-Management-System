package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelManagementSystem  extends JFrame implements ActionListener{
    HotelManagementSystem(){
//        setSize(1370,570);
//        setLocation(100,100);
        setLayout(null);
        setBounds(0,0,1370,570);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/Background_img.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1365,565);
        add(image);
        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20,430,1000,90);
        image.add(text);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("arial",Font.PLAIN,50));
        
        JButton next = new JButton("Next..");
        next.setBounds(1150,450,200,50);
        next.setBackground(Color.white);
        next.setForeground(Color.MAGENTA);
        next.addActionListener(this);
        next.setFont(new Font("arial",Font.PLAIN,24));
        image.add(next);
        setVisible(true);    
        while(true){
            text.setVisible(false);
            try {
                Thread.sleep(500);
            }catch(Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
               Thread.sleep(500);

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
     public void actionPerformed(ActionEvent ae){
     setVisible(false);
     new Login();
 }
    public static void main(String[] args) {
        new HotelManagementSystem();    
    }    
}
