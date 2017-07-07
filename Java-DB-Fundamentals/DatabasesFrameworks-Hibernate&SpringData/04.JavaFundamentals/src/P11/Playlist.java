package P11;


import java.util.ArrayList;
import java.util.List;

 class Playlist {
    private List<Song> songs;

    Playlist() {
        this.songs = new ArrayList<>();
    }

    int count(){
        return this.songs.size();
    }

    void addSong(Song song) {
        this.songs.add(song);
    }

    String length() {
        int minutes = 0;
        int seconds = 0;
        for (Song song : songs) {
            minutes += song.getMinutes();
            seconds += song.getSeconds();
        }
        int totalLength = minutes * 60 + seconds;

        int totalHours = totalLength / 60 / 60;
        int totalMinutes = (totalLength  / 60) - (60 * totalHours);
        int totalSeconds = totalLength  % 60;

        return String.format("Playlist length: %dh %dm %ds",totalHours,totalMinutes,totalSeconds);
    }


}
