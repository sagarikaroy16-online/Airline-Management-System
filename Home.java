package airlinemanagementsystem;
import javax.swing.*;//to create frame
import java.awt.*;//TO TAKE COLOR
import java.awt.event.*;
//import java.sql.*;

public class Home extends JFrame implements ActionListener {//J -> swing

    //public constructor 
    public Home(){
        setLayout(null);
        
        //MAIN FRAME IMAGE
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/front.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1600, 800);
        add(image);
        
        //MAIN FRAME HEADING
        JLabel heading = new JLabel("AIR INDIA WELCOMES YOU");
        heading.setBounds(550, 70, 1000, 40);
        heading.setForeground(Color.black);
        heading.setFont(new Font("Tahoma", Font.ITALIC, 36));
        image.add(heading);
        
        //DROPDOWN MENUBAR -1
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        
        JMenu details = new JMenu("Details");
        menubar.add(details);
        
        JMenuItem flightDetails = new JMenuItem("Flight");
        flightDetails.addActionListener(this);
        details.add(flightDetails);
        
        JMenuItem customerDetails = new JMenuItem("Customer");
        customerDetails.addActionListener(this);
        details.add(customerDetails);
        
        JMenuItem bookFlight = new JMenuItem("Booking");
        bookFlight.addActionListener(this);
        details.add(bookFlight);
        
        JMenuItem jrnDetails = new JMenuItem("Journey");
        jrnDetails.addActionListener(this);
        details.add(jrnDetails);
        
        /*JMenuItem resvDetails = new JMenuItem("Reservation");
        details.add(resvDetails);*/
        
        JMenuItem tktCl = new JMenuItem("Cancel Ticket");
        tktCl.addActionListener(this);
        details.add(tktCl);
        

        //DROPDOWN MENUBAR - 2
        JMenu ticket = new JMenu("Ticket");
        
        menubar.add(ticket);
        
        JMenuItem brdPass = new JMenuItem("Boarding Pass");
        brdPass.addActionListener(this);
        ticket.add(brdPass);
        
        
        //frame specification: Full screen (length and height)
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String text = ae.getActionCommand();
        
        if(text.equals("Flight")){
            new FlightInfo();
        }else if(text.equals("Customer")){
            new AddCustomer();
        }
        else if(text.equals("Booking")){
            new BookFlight();
        }else if(text.equals("Journey")) {
            new JourneyDetails();
        }else if(text.equals("Cancel Ticket")) {
            new Cancel();
        }else if(text.equals("Boarding Pass")) {
            new BoardingPass();
        }
    }
    public static void main(String args[]){
        new Home(); //annonymous object
    }
    
}
