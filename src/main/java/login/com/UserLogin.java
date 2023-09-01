package login.com;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static song.com.JukeBoxImpl.displayMenu;

public class UserLogin
{
    public static void createTable() throws SQLException, ClassNotFoundException {
        Statement statement = ConnectionData.connection();
        boolean booleanRes = statement.execute("create table if not exists userDetails(name varchar(20),emailId varchar(20),password varchar(20),gender varchar(20), age int  )");
    }

    public static void insertIntoTable(String name, String emailId, String password, String gender, int age) throws SQLException, ClassNotFoundException {
        Statement statement = ConnectionData.connection();
        statement.executeUpdate("insert into userDetails values('" + name + "','" + emailId + "','" + password + "','" + gender + "'," + age + ")");
    }

    public static void displayTable() throws SQLException, ClassNotFoundException {
        Statement statement = ConnectionData.connection();
        ResultSet s = statement.executeQuery("select * from userDetails");
        while (s.next())
        {
            System.out.format("%s,%s,%s,%s,%d", s.getString(1), s.getString(2), s.getString(3), s.getString(4), s.getInt(5));
            System.out.println();
        }
    }
    public static void getUserDetailsToLogin(String name, String password) throws SQLException, UnsupportedAudioFileException, LineUnavailableException, IOException, ClassNotFoundException {
        Statement st = ConnectionData.connection();
        ResultSet res = st.executeQuery("select * from userDetails where name='"+name+"' && password='"+password+"'");
        int flag=1;
        while(flag == 1)
        {
            if (res.next())
            {
                System.out.println("+--------------------------------------------------+");
                System.out.println("                   Logged in                        ");
                System.out.println("+--------------------------------------------------+");
                System.out.println("                   Hiiiiii " + name + "             ");
                System.out.println("+--------------------------------------------------+");
                System.out.println("                   Main Menu                        ");
                System.out.println("+--------------------------------------------------+");
                displayMenu();
                break;
            }

            else
            {
                System.out.println("+--------------------------------------------------+");
                System.out.println("          Invalid Password or UserName              ");
                System.out.println("+--------------------------------------------------+");
                System.out.println("         Please check your given details            ");
                System.out.println("+--------------------------------------------------+");
                flag=0;
                break;
            }
        }
    }
}
