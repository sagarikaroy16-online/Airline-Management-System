package airlinemanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    JTextField tfname, tfntn, tfadhr, tfadd, tfPh, tfMail;
    JRadioButton rbMale, rbFmale, rbOth;
    
    
    public AddCustomer(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel heading = new JLabel("CUSTOMER DETAILS");
        heading.setBounds(295, 20, 500 , 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 80, 150 , 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblname.setForeground(Color.BLACK);
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(230, 80, 200, 25);
        add(tfname);
        
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60, 130, 150 , 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblnationality.setForeground(Color.BLACK);
        add(lblnationality);
        
        tfntn = new JTextField();
        tfntn.setBounds(230, 130, 200, 25);
        add(tfntn);
        
        JLabel lbladhr = new JLabel("Aadhar Number");
        lbladhr.setBounds(60, 180, 150 , 25);
        lbladhr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbladhr.setForeground(Color.BLACK);
        add(lbladhr);
        
        tfadhr = new JTextField();
        tfadhr.setBounds(230, 180, 200, 25);
        add(tfadhr);
        
        JLabel lbladd = new JLabel("Address");
        lbladd.setBounds(60, 230, 150 , 25);
        lbladd.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbladd.setForeground(Color.BLACK);
        add(lbladd);
        
        tfadd = new JTextField();
        tfadd.setBounds(230, 230, 200, 25);
        add(tfadd);
        
        JLabel lblgen = new JLabel("Gender");
        lblgen.setBounds(60, 280, 150 , 25);
        lblgen.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblgen.setForeground(Color.BLACK);
        add(lblgen);
        
        ButtonGroup genderGrp = new ButtonGroup();// for selecting only one
        
        rbMale = new JRadioButton("Male");
        rbMale.setBounds(230, 280, 70, 25);
        rbMale.setBackground(Color.white);
        add(rbMale);
        
        rbFmale = new JRadioButton("Female");
        rbFmale.setBounds(300, 280, 70, 25);
        rbFmale.setBackground(Color.white);
        add(rbFmale);
        
        rbOth = new JRadioButton("Other");
        rbOth.setBounds(370, 280, 70, 25);
        rbOth.setBackground(Color.white);
        add(rbOth);
        
        genderGrp.add(rbMale);
        genderGrp.add(rbFmale);
        genderGrp.add(rbOth);
        
        JLabel lblPh = new JLabel("Phone Number");
        lblPh.setBounds(60, 330, 150 , 25);
        lblPh.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPh.setForeground(Color.BLACK);
        add(lblPh);
        
        tfPh = new JTextField();
        tfPh.setBounds(230, 330, 200, 25);
        add(tfPh);
        
        JLabel lblMail = new JLabel("Mail Id");
        lblMail.setBounds(60, 380, 150 , 25);
        lblMail.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblMail.setForeground(Color.BLACK);
        add(lblMail);
        
        tfMail = new JTextField();
        tfMail.setBounds(230, 380, 200, 25);
        add(tfMail);
        
        JButton save = new JButton("SAVE");
        save.setBackground(Color.black);
        save.setForeground(Color.white);
        save.setBounds(230, 430, 150, 30 );
        save.addActionListener(this);
        add(save);
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/emp.png"));
        JLabel lblImage = new JLabel(img);
        lblImage.setBounds(500, 80, 280, 400);
        add(lblImage);
 
        setSize(900, 600);
        setLocation(300, 150);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String nationality = tfntn.getText();
        String phone = tfPh.getText();
        String add = tfadd.getText();
        String adhr = tfadhr.getText();
        String mail = tfMail.getText();
            
        String gender = null;
        if(rbMale.isSelected()){
            gender = "Male";
        }else if(rbFmale.isSelected()){
            gender = "Female";  
        }else{
            gender = "Other"; 
        }
            
        
        try {
           Conn c = new Conn();
           String query = "insert into passenger values('"+name+"', '"+nationality+"', '"+phone+"', '"+add+"', '"+adhr+"', '"+mail+"', '"+gender+"')";
           
           c.s.executeUpdate(query);
           JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
           setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public static void main(String args[]){
        new AddCustomer();
    }
    
}
