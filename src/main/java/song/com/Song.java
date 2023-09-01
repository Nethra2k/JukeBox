package song.com;

import login.com.ConnectionData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Song
{
    public static void searchSong(String songPath) throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        Statement statement = ConnectionData.connection();
        int input;
        int flag = 0;
        while (flag == 0)
        {
            System.out.println("+-----------------------------------------------------+");
            System.out.println("1.Search using SongId\n2.Search using Genre\n3.Search using artist\n4.Exit");
            System.out.println("+-----------------------------------------------------+");
            input = sc.nextInt();
            switch (input)
            {
                case 1:
                {
                    System.out.println("Enter Song Id");
                    songPath = sc.next();
                    ResultSet r = statement.executeQuery("select songTitle from songList where songId='" + songPath + "'");
                    while (r.next()) {
                        System.out.println("+------------------------------------------------------------------+");
                        System.out.format("%s", r.getString(1));
                        System.out.println();
                        System.out.println("+------------------------------------------------------------------+");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Enter Song Genre");
                    songPath = sc.next();
                    ResultSet r = statement.executeQuery("select songTitle from songList where genre='" + songPath + "'");
                    while (r.next()) {
                        System.out.println("+------------------------------------------------------------------+");
                        System.out.format("%s", r.getString(1));
                        System.out.println();
                        System.out.println("+------------------------------------------------------------------+");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Enter Song Artist");
                    songPath = sc.next();
                    ResultSet r = statement.executeQuery("select songTitle from songList where artist='" + songPath + "'");
                    while (r.next()) {
                        System.out.println("+------------------------------------------------------------------+");
                        System.out.format("%s", r.getString(1));
                        System.out.println();
                        System.out.println("+------------------------------------------------------------------+");
                    }
                    break;
                }
                case 4:
                {
                    flag=1;
                    break;
                }
                default:
                {
                    System.out.println("+---------------+");
                    System.out.println("Not a valid Input");
                    System.out.println("+---------------+");
                }
            }
        }
    }

    public static void createPlaylist(String playlistName, String songId) throws SQLException, ClassNotFoundException {
        Statement statement = ConnectionData.connection();
        ResultSet r1 = statement.executeQuery("select songTitle from songList where songId='" + songId + "'");
        r1.next();
        String name=r1.getString(1);
        statement.executeUpdate("insert into userList values('" + playlistName + "','" + songId + "','"+name+"')");
    }
}
