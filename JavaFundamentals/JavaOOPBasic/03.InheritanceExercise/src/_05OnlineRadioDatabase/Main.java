package _05OnlineRadioDatabase;

import _05OnlineRadioDatabase.exceptions.InvalidSongException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfSongs = Integer.parseInt(reader.readLine());

        PlayList playList = new PlayList();
        for (int i = 0; i < numberOfSongs; i++) {
            String[] input = reader.readLine().split(";");
            String[] time = input[2].split(":");
            try {
                int minutes = Integer.parseInt(time[0]);
                int seconds = Integer.parseInt(time[1]);
                Song song = new Song(input[0], input[1], minutes, seconds);
                System.out.println(playList.addSong(song));
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid song length.");
            } catch (InvalidSongException ise) {
                System.out.println(ise.getMessage());
            }
        }

        System.out.printf("Songs added: %d\n", playList.getNumberOfSongs());
        System.out.println(playList.getPlayListDuration());

    }
}
