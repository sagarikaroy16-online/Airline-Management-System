package airlinemanagementsystem;
import java.sql.*; 

public class Conn{
    
    Connection c;
    Statement s;
    
    public Conn() {
        try {
            //JDBC CONNECTIVITY
            //Step 1: register the driver for the connection 
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Step 2: create the connection string -- connection and  statement
            c = DriverManager.getConnection("jdbc:mysql:///airlinemanagementsystem", "root", "S@ga4232");
            s = c.createStatement();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
