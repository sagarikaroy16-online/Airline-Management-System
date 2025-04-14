package airlinemanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class BoardingPass extends JFrame implements ActionListener{
    
    JTextField tfpnr ;
    JLabel tfname, tfntn, tfsrc, tfPh, tfdst, lbGen, labelfname, labelfcode, dcdate;
    JButton fetchButton;
    
    
    public BoardingPass(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel heading = new JLabel("AIR INDIA");
        heading.setBounds(380, 10, 450 , 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLACK);
        add(heading);
        
        JLabel subHeading = new JLabel("Boarding Pass");
        subHeading.setBounds(380, 50, 300 , 30);
        subHeading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        subHeading.setForeground(Color.BLUE);
        add(subHeading);
        
        JLabel lblpnr = new JLabel(" Enter the PNR");
        lblpnr.setBounds(60, 100, 150 , 25);
        lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblpnr.setForeground(Color.BLACK);
        add(lblpnr);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(220, 100, 150, 25);
        add(tfpnr);
        
        fetchButton = new JButton("Fetch Details");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(390, 100, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        JLabel lblname = new JLabel("NAME:");
        lblname.setBounds(60, 140, 150 , 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblname.setForeground(Color.BLACK);
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(220, 140, 150, 25);
        add(tfname);
        
        JLabel lblgen = new JLabel("GENDER:");
        lblgen.setBounds(60, 180, 150 , 25);
        lblgen.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblgen.setForeground(Color.BLACK);
        add(lblgen);
        
        lbGen = new JLabel();
        lbGen.setBounds(220, 180, 150 , 25);
        add(lbGen);
        
        JLabel lblnationality = new JLabel("NATIONALITY:");
        lblnationality.setBounds(60, 220, 150 , 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblnationality.setForeground(Color.BLACK);
        add(lblnationality);
        
        tfntn = new JLabel();
        tfntn.setBounds(220, 220, 150, 25);
        add(tfntn);
        
        JLabel lblPh = new JLabel("CONTACT NO.:");
        lblPh.setBounds(60, 260, 150 , 25);
        lblPh.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPh.setForeground(Color.BLACK);
        add(lblPh);
        
        tfPh = new JLabel();
        tfPh.setBounds(220, 260, 200, 25);
        add(tfPh);
        
        JLabel lblsrc = new JLabel("SOURCE:");
        lblsrc.setBounds(60, 300, 150 , 25);
        lblsrc.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblsrc.setForeground(Color.BLACK);
        add(lblsrc);
        
        tfsrc = new JLabel();
        tfsrc.setBounds(220, 300, 150, 25);
        add(tfsrc);
        
        JLabel lbldst = new JLabel("DESTINATION:");
        lbldst.setBounds(400, 300, 150 , 25);
        lbldst.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbldst.setForeground(Color.BLACK);
        add(lbldst);
        
        tfdst = new JLabel();
        tfdst.setBounds(560, 300, 150, 25);
        add(tfdst);
        
        JLabel lblfname = new JLabel("FLIGHT NAME:");
        lblfname.setBounds(60, 340, 150 , 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblfname.setForeground(Color.BLACK);
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(220, 340, 150, 25);
        add(labelfname);
        
        JLabel lblfcode = new JLabel("FLIGHT CODE:");
        lblfcode.setBounds(400, 340, 150 , 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblfcode.setForeground(Color.BLACK);
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(560, 340, 150, 25);
        add(labelfcode);
        
        JLabel lbldt = new JLabel("DATE OF TRAVEL:");
        lbldt.setBounds(650, 340, 150 , 25);
        lbldt.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbldt.setForeground(Color.BLACK);
        add(lbldt);
        
        dcdate = new JLabel();
        dcdate.setBounds(810, 340, 150, 25);
        add(dcdate);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/airindia.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(600, 0, 300, 300);
        add(lblimage);
 
        setSize(1000, 450);
        setLocation(300, 150);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {//lbGen
        String pnr = tfpnr.getText();

        try {
            Conn conn = new Conn();

            String query = "select * from reservation where PNR = '"+pnr+"'";

            ResultSet rs = conn.s.executeQuery(query);

            if (rs.next()) {
                tfname.setText(rs.getString("name")); 
                tfntn.setText(rs.getString("nationality"));
                lbGen.setText(rs.getString("gender"));
                tfPh.setText(rs.getString("contact")); 
                tfsrc.setText(rs.getString("source"));
                tfdst.setText(rs.getString("destination"));
                labelfname.setText(rs.getString("flight_name"));  
                labelfcode.setText(rs.getString("flight_code"));  
                dcdate.setText(rs.getString("Date")); 
            } else {
                JOptionPane.showMessageDialog(null, "Please enter correct PNR");                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]){
        new BoardingPass();
    }
    
}
