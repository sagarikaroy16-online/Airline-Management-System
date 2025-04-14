package airlinemanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class BookFlight extends JFrame implements ActionListener{
    
    JTextField tfadhr ;
    JLabel tfname, tfntn, tfadd, tfPh, tfMail, lbGen, labelfname, labelfcode;
    JButton fetchButton, fbttn, bkflight;
    Choice source, destination;
    JDateChooser dcdate;
    
    public BookFlight(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel heading = new JLabel("Book Flight");
        heading.setBounds(480, 10, 500 , 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel lbladhr = new JLabel("Aadhar Number");
        lbladhr.setBounds(60, 80, 150 , 25);
        lbladhr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbladhr.setForeground(Color.BLACK);
        add(lbladhr);
        
        tfadhr = new JTextField();
        tfadhr.setBounds(220, 80, 150, 25);
        add(tfadhr);
        
        fetchButton = new JButton("Fetch User");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(390, 80, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 120, 150 , 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblname.setForeground(Color.BLACK);
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(230, 120, 200, 25);
        add(tfname);
        
        
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60, 160, 150 , 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblnationality.setForeground(Color.BLACK);
        add(lblnationality);
        
        tfntn = new JLabel();
        tfntn.setBounds(230, 160, 200, 25);
        add(tfntn);
        
        
        
        JLabel lbladd = new JLabel("Address");
        lbladd.setBounds(60, 200, 150 , 25);
        lbladd.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbladd.setForeground(Color.BLACK);
        add(lbladd);
        
        tfadd = new JLabel();
        tfadd.setBounds(230, 200, 200, 25);
        add(tfadd);
        
        JLabel lblgen = new JLabel("Gender");
        lblgen.setBounds(60, 240, 150 , 25);
        lblgen.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblgen.setForeground(Color.BLACK);
        add(lblgen);
        
        lbGen = new JLabel();
        lbGen.setBounds(230, 240, 150 , 25);
        add(lbGen);
 
        JLabel lblPh = new JLabel("Phone Number");
        lblPh.setBounds(60, 280, 150 , 25);
        lblPh.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPh.setForeground(Color.BLACK);
        add(lblPh);
        
        tfPh = new JLabel();
        tfPh.setBounds(230, 280, 200, 25);
        add(tfPh);
        
        JLabel lblMail = new JLabel("Mail Id");
        lblMail.setBounds(60, 320, 150 , 25);
        lblMail.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblMail.setForeground(Color.BLACK);
        add(lblMail);
        
        tfMail = new JLabel();
        tfMail.setBounds(230, 320, 200, 25);
        add(tfMail);
        
        JLabel lblsrc = new JLabel("Source");
        lblsrc.setBounds(60, 360 , 150 , 25);
        lblsrc.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblsrc.setForeground(Color.BLACK);
        add(lblsrc);
        
        source = new Choice();
        source.setBounds(230, 360, 150, 25);
        //src.add("Asansol");
        add(source);
        
        JLabel lbldst = new JLabel("Destination");
        lbldst.setBounds(60, 400, 150 , 25);
        lbldst.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbldst.setForeground(Color.BLACK);
        add(lbldst);
        
        destination = new Choice();
        destination.setBounds(230, 400, 150, 25);
        add(destination);
        
        try {
            Conn c = new Conn();
            String query = "select * from flight";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()) {
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        fbttn = new JButton("Fetch Flights");
        fbttn.setBackground(Color.black);
        fbttn.setForeground(Color.white);
        fbttn.setBounds(390, 400, 120, 25 );
        fbttn.addActionListener(this);
        add(fbttn);
        
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60, 440, 150 , 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblfname.setForeground(Color.BLACK);
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(230, 440, 150, 25);
        add(labelfname);
        
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(60, 480, 150 , 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblfcode.setForeground(Color.BLACK);
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(230, 480, 150, 25);
        add(labelfcode);
        
        JLabel lbldt = new JLabel("Date of Travel");
        lbldt.setBounds(60, 520, 150 , 25);
        lbldt.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbldt.setForeground(Color.BLACK);
        add(lbldt);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(230, 520, 150, 25);
        add(dcdate);
        
        
        bkflight = new JButton("Book Flight");
        bkflight.setBackground(Color.black);
        bkflight.setForeground(Color.white);
        bkflight.setBounds(480, 580, 150, 30 );
        bkflight.addActionListener(this);
        add(bkflight);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/details.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
        ImageIcon img = new ImageIcon(i2);
        JLabel lblImage = new JLabel(img);
        lblImage.setBounds(550, 80, 500, 410);
        add(lblImage);
 
        setSize(1100, 700);
        setLocation(200, 20);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {//lbGen
        if(ae.getSource() == fetchButton){
            String adhr = tfadhr.getText();
            
            try {
                Conn c = new Conn();
                String query = "select * from passenger where aadhar = '" + adhr +"'";
           
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()){
                    tfname.setText(rs.getString("name"));
                    tfntn.setText(rs.getString("nationality"));
                    tfadd.setText(rs.getString("address"));
                    lbGen.setText(rs.getString("gender"));
                    tfPh.setText(rs.getString("phone"));
                    tfMail.setText(rs.getString("mail"));
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Please Enter Correct Aadhar Number");
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }   
        }else if(ae.getSource() == fbttn){
            String src = source.getSelectedItem();
            String dest = destination.getSelectedItem();
            
            try {
                Conn c = new Conn();
                String query = "select * from flight where source = '" + src +"' and destination = '" + dest + "'";
           
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()){
                    labelfname.setText(rs.getString("f_name"));
                    labelfcode.setText(rs.getString("f_code"));
                    
                    
                }else{
                    JOptionPane.showMessageDialog(null, "No Flights Available");
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }   
        }else {
            Random random = new Random();
            String aadhar = tfadhr.getText();
            String name = tfname.getText();
            String ntn = tfntn.getText();
            String add = tfadd.getText();
            String gen = lbGen.getText();
            String ph = tfPh.getText();
            String mail = tfMail.getText();
            
            String fname = labelfname.getText();
            String fcode = labelfcode.getText();
            String src = source.getSelectedItem();
            String dst = destination.getSelectedItem();
            
            String dt = ((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
            
            try {
                Conn c = new Conn();
                String query = "insert into reservation values('PNR-" + random.nextInt(1000000)+"', 'TIC-"+random.nextInt(10000)+"', '"+ aadhar+"', '" +name + "', '" +ntn +"', '" +add +"', '" +gen +"', '" +ph +"', '" +mail +"', '" +fname +"', '" +fcode +"', '" +src +"', '" +dst +"', '" +dt +"')";
                //String query = "insert into reservation values('PNR-"+random.nextInt(1000000)+"', 'TIC-"+random.nextInt(10000)+"', '"+aadhar+"', '"+name+"', '"+ntn+"', '"+add+"', '"+gen+"', '"+ph+"', '"+mail+"', '"+fname+"', '"+fcode+"', '"+dt+"')";
                
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Booking Successful");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }   
        }
    }
    public static void main(String args[]){
        new BookFlight();
    }
    
}
