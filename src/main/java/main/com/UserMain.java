package main.com;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import static login.com.UserLogin.*;
import static song.com.JukeBoxImpl.displayMenu;

public class UserMain
{
    public static void display() throws ClassNotFoundException, SQLException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        createTable();
        Scanner sc = new Scanner(System.in);
        int input = 0;
        int flag = 1;
        while (flag == 1)
        {
            System.out.println("+---------------------------------------------------------------+");
            System.out.println("+                    Welcome to JukeBox 5.2                     +");
            System.out.println("+---------------------------------------------------------------+");
            System.out.println("1.New User\n2.Existing User\n3.Exit");
            System.out.println("+---------------------------------------------------------------+");
            input = sc.nextInt();
            switch (input)
            {
                case 1:
                {
                    System.out.println("+-----------------+");
                    System.out.println("   Sign up free    ");
                    System.out.println("+-----------------+");
                    System.out.println("  What's your name ");
                    System.out.println("+-----------------+");
                    String name = sc.next();
                    System.out.println("+------------------+");
                    System.out.println("What's your Email Id");
                    System.out.println("+------------------+");
                    String emailId = sc.next();
                    System.out.println("+-----------------------------------------------+");
                    System.out.println("Create the Password\n (use at least 8 characters)");
                    System.out.println("+-----------------------------------------------+");
                    String password = sc.next();
                    System.out.println("+----------------+");
                    System.out.println("What's your gender");
                    System.out.println("+----------------+");
                    String gender = sc.next();
                    System.out.println("+-------------+");
                    System.out.println("What's your Age");
                    System.out.println("+-------------+");
                    int age = sc.nextInt();
                    System.out.println("+------------------------------------------+");
                    System.out.println("Your JukeBox Profile is created successfully");
                    System.out.println("+------------------------------------------+");
                    System.out.println("+------------------------------------------+");
                    System.out.println("                Main Menu                   ");
                    System.out.println("+------------------------------------------+");
                    //System.out.println("1.Display All Songs\n2.Search Song\n3.Create Playlist\n4.Listen to Songs\n5.Main menu\n6.Exit");
                    insertIntoTable(name, emailId, password, gender, age);
                    displayMenu();
                    break;
                }
                case 2:
                {
                    System.out.println("+-----------------+");
                    System.out.println("Enter your userName");
                    System.out.println("+-----------------+");
                    String name = sc.next();
                    System.out.println("+-----------------+");
                    System.out.println("Enter the Password");
                    System.out.println("+-----------------+");
                    String password = sc.next();
                    getUserDetailsToLogin(name,password);
                    break;
                }
                case 3:
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
