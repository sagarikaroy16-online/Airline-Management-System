
package airlinemanagementsystem;
import javax.swing.*;//to create frame
import java.awt.*;//TO TAKE COLOR
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {//J -> swing
    JButton submit, reset, close;
    JTextField tfusername;
    JPasswordField tfpass;
    //public constructor 
    public Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //set labels - USERNAME
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(20, 20, 100, 20); //(distL, distT,length, height)
        add(lblusername);
        
        //set labels - PASSWORD
        JLabel lblpass = new JLabel("Password");
        lblpass.setBounds(20, 60, 100, 20); //(distL, distT,length, height)
        add(lblpass);
        
        //BOX FOR INPUT
        tfusername = new JTextField();
        tfusername.setBounds(130, 20, 200, 20);
        add(tfusername);
        
        tfpass = new JPasswordField();
        tfpass.setBounds(130, 60, 200, 20);
        add(tfpass);
        
        //BUTTONS
        reset = new JButton("Reset");
        reset.setBounds(50, 120, 120, 20);
        reset.addActionListener(this);
        add(reset);
        
        submit = new JButton("Submit");
        submit.setBounds(220, 120, 120, 20);
        submit.addActionListener(this);
        add(submit);
        
        close = new JButton("Close");
        close.setBounds(135, 160, 120, 20);
        close.addActionListener(this);
        add(close);
        
        
        
        
        //frame specification
        setSize(400,250);
        setLocation(600, 250);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String username = tfusername.getText();
            String password = tfpass.getText();
            try{ //JDBC CONNECTIVITY
                Conn c = new Conn();
                
                String query = "select * from login where username = '" + username +"' and password = '" + password + "'";
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()){
                    new Home();
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    setVisible(false);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == close){
            setVisible(false);
        }else if(ae.getSource() == reset){
            tfusername.setText("");
            tfpass.setText("");
        }
    }
    public static void main(String args[]){
        new Login(); //annonymous object
    }
    
}
