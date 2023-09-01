package song.com;

import login.com.ConnectionData;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SongImpl
{
    public static void listenSongs(String filepath) throws IOException, LineUnavailableException, UnsupportedAudioFileException, SQLException, ClassNotFoundException {
        Statement statement = ConnectionData.connection();
        ResultSet r = statement.executeQuery("select * from playList" );
        while (r.next()) {
            System.out.println("+------------------------------------------------------------------+");
            System.out.format("%s  %s", r.getString(1),r.getString(2));
            System.out.println();
            System.out.println("+-------------------------------------------------------------------+");
        }
        ResultSet s = statement.executeQuery("select * from userList");
        while (s.next()) {
            System.out.println("+------------------------------------------------------------------+");
            System.out.format("%s  %s  %s,", "Playlist Name  "+ s.getString(1), "Song Id  "+ s.getString(2), "Song Name  "+ s.getString(3));
            System.out.println();
            System.out.println("+-------------------------------------------------------------------+");
        }
        System.out.println("select songId");
        Scanner sc = new Scanner(System.in);
        String songId= sc.next();
        ResultSet r1=statement.executeQuery("select * from playList where songId='"+songId+"'");
        while (r1.next())
        {
            filepath="C:\\Users\\ELCOT\\Desktop\\JukeBox\\src\\main\\resources\\"+r1.getString(3)+""+".wav";
            //filepath="C:\\Capstone_Project\\jukebox\\Juke_Box\\src\\main\\resources\\"+r1.getString(3)+""+".wav";
        }
        System.out.println(filepath);
        File file = new File(filepath);
        Clip clip = AudioSystem.getClip();
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        clip.open(audioStream);
        int input;
        int flag = 0;
        long clippos = 0;
        while (flag == 0)
        {
            System.out.println("+------------------------------------------------------------------+");
            System.out.println("\nEnter Your Choice\n----- ---- ------\n1.Play\n2.Pause\n3.Resume\n4.Restart\n5.Forward\n6.Backwards\n9.Exit");
            System.out.println("+------------------------------------------------------------------+");
            input = sc.nextInt();
            switch (input) {
                case 1:
                {
                    clip.start();
                    System.out.println("+------------+");
                    System.out.println("|Playing Song|");
                    System.out.println("+------------+");
                    break;
                }
                case 2: {
                    clippos = clip.getMicrosecondPosition();
                    clip.stop();
                    System.out.println("+-----------+");
                    System.out.println("|Song Paused|");
                    System.out.println("+-----------+");
                    break;
                }
                case 3: {
                    clip.setMicrosecondPosition(clippos);
                    clip.start();
                    System.out.println("+------------+");
                    System.out.println("|Song Resumed|");
                    System.out.println("+------------+");
                    break;
                }
                case 4: {
                    clip.setMicrosecondPosition(0);
                    clip.start();
                    System.out.println("+--------------+");
                    System.out.println("|Song Restarted|");
                    System.out.println("+--------------+");
                    break;
                }
                case 5: {
                    System.out.println("+-----------------+");
                    System.out.println("|Forwarding by 50s|");
                    System.out.println("+-----------------+");
                    clip.setMicrosecondPosition(clip.getMicrosecondPosition() + 5000000);
                    break;
                }
                case 6: {
                    System.out.println("+-----------------+");
                    System.out.println("|Backward by 50s|");
                    System.out.println("+-----------------+");
                    clip.setMicrosecondPosition(clip.getMicrosecondPosition() - 5000000);
                    break;
                }
                case 9: {
                    clip.close();
                    flag = 1;
                    break;
                }
                default: {
                    System.out.println("+---------------+");
                    System.out.println("Not a valid Input");
                    System.out.println("+---------------+");
                }
            }
        }
    }
}
