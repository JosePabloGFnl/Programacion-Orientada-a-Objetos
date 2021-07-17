
package interfaces;
import java.sql.*;
public class conexion {
    static String bd="basetienda";
    static String login="root";
    static String password="xboxONE.5";
    static String url="jdbc:mysql://localhost:3306/basetienda";
Connection enlazar= null;
public Connection conectar() {
    try {
        Class.forName("com.mysql.jdbc.Driver");
        enlazar = DriverManager.getConnection(url,login,password);
        
        if(enlazar!=null) {
            System.out.println("conectando base ("+enlazar+")OK");
        }
    } catch(SQLException e) {
    System.out.println("exception conexion:"+e.getMessage());
    }catch(ClassNotFoundException e) {
        System.out.println("exception driver: "+e.getMessage());
    }
    return enlazar;
}
}
