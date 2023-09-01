package song.com;

import login.com.ConnectionData;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static song.com.Song.createPlaylist;
import static song.com.Song.searchSong;
import static song.com.SongImpl.listenSongs;

public class JukeBoxImpl
{
    public static void displayMenu() throws SQLException, UnsupportedAudioFileException, LineUnavailableException, IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        int flag = 1;
        while (flag == 1)
        {
            System.out.println("1.Display All Songs\n2.Search Song\n3.Create Playlist\n4.Listen to Songs\n5.Main menu\n6.Exit");
            input = scanner.nextInt();
            switch (input)
            {
                case 1:
                {
                    Statement statement = ConnectionData.connection();
                    ResultSet r = statement.executeQuery("select * from songList");
                    while (r.next())
                    {
                        System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------+");
                        System.out.format("%s,%s,%s,%s,%s", "Song Name :- " + r.getString(1) + "  ", "  Song Id :- " + r.getString(2) + "  ", "  Genre :- " + r.getString(3) + "  ", "  Artist :- " + r.getString(4) + "  ", "  Duration :- " + r.getString(5));
                        System.out.println();
                        System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------+");
                    }
                    break;
                }
                case 2:
                {
                    String songPath ="";
                    searchSong(songPath);
                    break;
                }
                case 3:
                {
                    System.out.println("Enter Playlist Name");
                    String playlistName = scanner.next();
                    System.out.println("Your playList is create"+"("+playlistName+")");
                    System.out.println("Enter 1 to add song");
                    int Continue= scanner.nextInt();
                    while (Continue==1)
                    {
                        System.out.println("Enter Song Id");
                        String songId = scanner.next();
                        System.out.println("Enter 1 to continue adding songs");
                        System.out.println("Enter 0 to stop adding songs");
                        createPlaylist(playlistName, songId);
                        Continue= scanner.nextInt();
                    }
                    break;
                }
                case 4:
                {
                    String filepath = null;
                    listenSongs(filepath);
                    break;
                }
                case 5:
                {
                    System.out.println("1.Display All Songs\n2.Search Song\n3.Create Playlist\n4.Listen to Songs\n5.Main menu\n6.Exit");
                    break;
                }
                case 6:
                {
                    flag=0;
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
}
