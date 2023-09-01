package login.com;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;


public class ConnectionData
{
    public static Statement connection() throws SQLException, ClassNotFoundException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jukeboxdb","root","root@123");
        Statement st=con.createStatement();
        return st;
    }
}
