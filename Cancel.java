package airlinemanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
//import com.toedter.calendar.JDateChooser;
import java.util.*;

public class Cancel extends JFrame implements ActionListener{
    
    JTextField tfpnr ;
    JLabel tfname, tfntn, tfadd, cnc, fcode, dt;
    JButton fetchButton, Cbttn;
    //Choice source, destination;
    //JDateChooser dcdate;
    
    public Cancel(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        Random random = new Random();
        
        
        JLabel heading = new JLabel("Cancellation");
        heading.setBounds(180, 20, 250 , 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/cancel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(470, 150, 250, 250);
        add(image);
        
        
        
        JLabel lblpnr = new JLabel("Enter PNR");
        lblpnr.setBounds(60, 80, 150 , 25);
        lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblpnr.setForeground(Color.BLACK);
        add(lblpnr);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(220, 80, 150, 25);
        add(tfpnr);
        
        fetchButton = new JButton("Show Details");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 80, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 130, 150 , 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblname.setForeground(Color.BLACK);
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(220, 130, 150, 25);
        add(tfname);
        
        
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60, 180, 150 , 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblnationality.setForeground(Color.BLACK);
        add(lblnationality);
        
        tfntn = new JLabel();
        tfntn.setBounds(230, 180, 150, 25);
        add(tfntn);
        
        
        
        JLabel lbladd = new JLabel("Address");
        lbladd.setBounds(60, 230, 150 , 25);
        lbladd.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbladd.setForeground(Color.BLACK);
        add(lbladd);
        
        tfadd = new JLabel();
        tfadd.setBounds(230, 230, 150, 25);
        add(tfadd);
 
        JLabel lblcnc = new JLabel("Cacellation Number");
        lblcnc.setBounds(60, 280, 150 , 25);
        lblcnc.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblcnc.setForeground(Color.BLACK);
        add(lblcnc);
        
        cnc = new JLabel("" + random.nextInt(1000000));
        cnc.setBounds(230, 280, 150, 25);
        add(cnc);
        
        JLabel labelfcode = new JLabel("Flight Code");
        labelfcode.setBounds(60, 330, 150 , 25);
        labelfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelfcode.setForeground(Color.BLACK);
        add(labelfcode);
        
        fcode = new JLabel();
        fcode.setBounds(230, 330, 150, 25);
        add(fcode);
        
        JLabel lbldt = new JLabel("Date of Travel");
        lbldt.setBounds(60, 380 , 150 , 25);
        lbldt.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbldt.setForeground(Color.BLACK);
        add(lbldt);
        
        dt = new JLabel();
        dt.setBounds(230, 380, 150, 25);
        //src.add("Asansol");
        add(dt);
             
        Cbttn = new JButton("Cancel");
        Cbttn.setBackground(Color.black);
        Cbttn.setForeground(Color.white);
        Cbttn.setBounds(220, 480, 120, 25 );
        Cbttn.addActionListener(this);
        add(Cbttn);
   
        setSize(800, 600);
        setLocation(350, 100);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {//lbGen
        if(ae.getSource() == fetchButton){
            String PNR = tfpnr.getText();
            
            try {
                Conn c = new Conn();
                String query = "select * from reservation where PNR = '" + PNR +"'";
           
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()){
                    tfname.setText(rs.getString("name"));
                    tfntn.setText(rs.getString("nationality"));
                    tfadd.setText(rs.getString("address"));
                    fcode.setText(rs.getString("flight_code"));
                    dt.setText(rs.getString("Date"));
                    //tfMail.setText(rs.getString("mail"));
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Please Enter Correct PNR");
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }   
        }else if(ae.getSource() == Cbttn){
            String name = tfname.getText();
            String pnr = tfpnr.getText();
            String cancelno = cnc.getText();
            String fcd = fcode.getText();
            String date = dt.getText();
            
            try {
                Conn c = new Conn();
                String query = "insert into cancel values('"+pnr+"', '"+name+"', '"+cancelno+"', '"+ fcd +"', '"+date+"')";
               // String query = "insert into cancel values('"+pnr+"', '"+name+"', '"+cancelno+"', '"+fcode+"', '"+date+"')";
                
                c.s.executeUpdate(query);
                c.s.executeUpdate("delete from reservation where PNR = '"+pnr+"'");
                
                JOptionPane.showMessageDialog(null, "Ticket Cancelled");
                setVisible(false);    
            }catch(Exception e){
                e.printStackTrace();
            }   
        }
    }
    public static void main(String args[]){
        new Cancel();
    }
    
}
