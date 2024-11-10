package core.persistence;

import java.sql.Connection;
import java.sql.DriverManager;


public class SQLiteHelper {
    private static Connection c = null;
    public static Connection getConnection() throws Exception {
        if(c == null){
//            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:./jdeployments_data/jdeployments.db");
        }
        return c;
    }
}