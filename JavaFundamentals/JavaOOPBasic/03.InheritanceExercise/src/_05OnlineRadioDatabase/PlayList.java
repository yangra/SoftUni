package _05OnlineRadioDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PlayList {
    private List<Song> songs;

    public PlayList() {
        this.songs = new ArrayList<>();
    }

    public String addSong(Song song){
        this.songs.add(song);
        return "Song added.";
    }

    public String getPlayListDuration(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(0, 0, 0, 0, 0, 0);
        for (Song song : songs) {
            calendar.add(Calendar.MINUTE, song.getMinutes());
            calendar.add(Calendar.SECOND, song.getSeconds());
        }

        return String.format("Playlist length: %sh %sm %ss", calendar.get(Calendar.HOUR),
                calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));
    }

    public int getNumberOfSongs(){
        return this.songs.size();
    }
}
