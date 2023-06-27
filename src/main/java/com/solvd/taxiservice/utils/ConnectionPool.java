package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {


    public Connection getConnection()
    {
        Properties propperties = DBProperties.get();

        String dbuser = propperties.getProperty("db.user");
        String dbpass = propperties.getProperty("db.password");
        String dburl  = propperties.getProperty("db.url");
        String jdbcdriver = propperties.getProperty("db.driver");
  
        Connection con=null;
          try
                   {
                    Class.forName(jdbcdriver);
                    con= DriverManager.getConnection(dburl,dbuser,dbpass);
                   }
          catch(Exception ex){
          
        	  System.out.println(ex.getMessage());
          }
        return con;
    
    }
//    public static void main(String[] args) {
//        
//        try {
//            Connection con = new DBConnection().getConnection();
//            
//            System.out.println(con.getCatalog());
//        } catch (SQLException ex) {
//            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}