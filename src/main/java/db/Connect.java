package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connect {

    private static final Connect ourInstance = new Connect();
    private static Connection con = null;
    private final static String USERNAME = "sa";
    private final static String PASSWORD = "";
    private final static String URL = " jdbc:h2:/D:/dev/java/Cards/src/main/resources/localDB/core";

    public static Connect getInstance() {
        return ourInstance;
    }

    private Connect() {
        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void clossConnect(){
         
    }
}
