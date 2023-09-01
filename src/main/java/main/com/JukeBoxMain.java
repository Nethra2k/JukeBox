package main.com;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.SQLException;

import static main.com.UserMain.display;

public class JukeBoxMain
{
    public static void main(String[] args) throws SQLException, UnsupportedAudioFileException, LineUnavailableException, IOException, ClassNotFoundException {
        display();
    }
}
