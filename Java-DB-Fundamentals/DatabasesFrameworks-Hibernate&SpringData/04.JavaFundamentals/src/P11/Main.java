package P11;


import P11.exceptions.InvalidSongException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Playlist songs = new Playlist();

        int numberOfSongs = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfSongs; i++) {
            String[] songData = reader.readLine().split(";");
            if (songData.length == 3) {
                String artistName = songData[0];
                String songName = songData[1];
                String[] time = songData[2].split(":");
                String minutes = time[0];
                String seconds = time[1];
                try {
                    Song song = new Song(artistName, songName, minutes, seconds);
                    songs.addSong(song);
                    System.out.println("Song added.");
                } catch (InvalidSongException ise) {
                    System.out.println(ise.getMessage());
                }
            } else {
                System.out.println("Invalid song.");
            }
        }
        System.out.printf("Songs added: %d\n", songs.count());
        System.out.println(songs.length());
    }
}
