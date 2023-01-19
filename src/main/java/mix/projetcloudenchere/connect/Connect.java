package mix.projetcloudenchere.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connect {
    static String url="jdbc:postgresql://localhost:5432/encherecloud";
    static String user="postgres";
    static String password="root";
    public static Connection connectToDatabase(){
        try{
            Connection c = null;
            Statement stmt ;
            c = DriverManager.getConnection(url,user,password);
            return c;
        }catch(Exception e){
            return null;
        }
    }
}
