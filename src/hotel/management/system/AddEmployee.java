
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddEmployee extends JFrame implements ActionListener{
    JTextField name_txt, email_txt, phone_txt, salary_txt, age_txt,  adhar_no_txt;
    JRadioButton rbfemale, rbmale;
    JComboBox chjob;
    JButton submit_btn; 
    AddEmployee(){
        setLayout(null);
        
        JLabel name_lbl = new JLabel("NAME");
        name_lbl.setBounds(60,30,120,30);
        name_lbl.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(name_lbl);
        
        name_txt = new JTextField();
        name_txt.setBounds(180,30,150,30);
        add(name_txt);
        
        JLabel age_lbl = new JLabel("AGE");
        age_lbl.setBounds(60,80,120,30);
        age_lbl.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(age_lbl);
        
        age_txt = new JTextField();
        age_txt.setBounds(180,80,150,30);
        add(age_txt);
        
        JLabel gender = new JLabel("GENDER");
        gender.setBounds(60,130,120,30);
        gender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(gender);
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(180,130,70,30);
        rbmale.setBackground(Color.WHITE);
        rbmale.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(260,130,100,30);
        rbfemale.setBackground(Color.WHITE);
        rbfemale.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(rbfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        JLabel job_lbl = new JLabel("JOB");
        job_lbl.setBounds(60,180,120,30);
        job_lbl.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(job_lbl);
       
        String str[]={"Front Desk Clerk","Porters","Housekeeping","Kitchen Staff","Room Service","Shefe","Manager","Accountant"};
        chjob = new JComboBox(str);
        chjob.setBounds(180,180,150,30);
        chjob.setBackground(Color.WHITE);
        add(chjob);
        
        JLabel salary_lbl = new JLabel("SALARY");
        salary_lbl.setBounds(60,230,150,30);
        salary_lbl.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(salary_lbl);
        
        salary_txt = new JTextField();
        salary_txt.setBounds(180,230,150,30);
        add(salary_txt);

        JLabel phone_lbl = new JLabel("PHONE");
        phone_lbl.setBounds(60,280,150,30);
        phone_lbl.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(phone_lbl);
        
        phone_txt = new JTextField();
        phone_txt.setBounds(180,280,150,30);
        add(phone_txt);
        
        JLabel email_lbl = new JLabel("EMAIL");
        email_lbl.setBounds(60,330,150,30);
        email_lbl.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(email_lbl);
        
        email_txt = new JTextField();
        email_txt.setBounds(180,330,150,30);
        add(email_txt);

        JLabel adhar_no_lbl = new JLabel("ADHAR N0");
        adhar_no_lbl.setBounds(60,380,150,30);
        adhar_no_lbl.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(adhar_no_lbl);
        
        adhar_no_txt = new JTextField();
         adhar_no_txt.setBounds(180,380,150,30);
        add( adhar_no_txt);
        
        JButton submit_btn = new JButton("SUBMIT");
        submit_btn.setBounds(200,430,150,30);
        submit_btn.setBackground(Color.BLACK);
        submit_btn.setForeground(Color.WHITE);
        submit_btn.addActionListener(this);
        add(submit_btn);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380,60,450,370);
        add(image);
        
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(350,200,850,540);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String name = name_txt.getText();
        String age = age_txt.getText();
        String gender = null;
//        String job = chjob.getSelectedItem();
        String salary = salary_txt.getText();
        String phone = phone_txt.getText();
        String email = email_txt.getText();
       String aadhar = adhar_no_txt.getText(); 
       
       
       
       if(rbmale.isSelected()){
           gender="Male";
       }else if(rbfemale.isSelected()){
           gender="Female";
       }
       String job = (String)chjob.getSelectedItem();
       try{
           Conn conn = new Conn();
           String query = "insert into employee values('"+name+"', '"+age+"', '"+job+"', "
                   + "'"+gender+"', '"+salary+"','"+phone+"', '"+email+"', '"+aadhar+"')";
           conn.s.executeUpdate(query);
           
           JOptionPane.showMessageDialog(null, "Employee Added Successfully");
           setVisible(false);
       }catch(Exception e){
           e.printStackTrace();
       }
    }
    public static void main(String[] args){
        new AddEmployee();
    }
}
