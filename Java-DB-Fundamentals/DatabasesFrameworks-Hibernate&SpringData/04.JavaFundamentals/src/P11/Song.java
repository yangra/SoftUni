package P11;


import P11.exceptions.*;

public class Song {
    private String artistName;
    private String songName;
    private int minutes;
    private int seconds;


    Song(String artistName, String songName, String minutes, String seconds) throws InvalidSongException {
        this.setArtistName(artistName);
        this.setSongName(songName);
        checkLengthValidity(minutes,seconds);
        this.setMinutes(Integer.parseInt(minutes));
        this.setSeconds(Integer.parseInt(seconds));

    }

    public String getArtistName() {
        return artistName;
    }

    private void setArtistName(String artistName) throws InvalidArtistNameException {
        if (artistName == null || artistName.length() >= 3 && artistName.length() <= 20) {
            this.artistName = artistName;
        } else {
            throw new InvalidArtistNameException("Artist name should be between 3 and 20 symbols.");
        }

    }

    public String getSongName() {
        return songName;
    }

    private void setSongName(String songName) throws InvalidSongNameExcepton {
        if (songName == null || songName.length() < 3 || songName.length() > 30) {
            throw new InvalidSongNameExcepton("Song name should be between 3 and 30 symbols.");
        }
        this.songName = songName;
    }

    public int getMinutes() {
        return minutes;
    }

    private void setMinutes(int minutes) throws InvalidSongMinutesException {
        if (minutes < 0 || minutes > 14) {
            throw new InvalidSongMinutesException("Song minutes should be between 0 and 14.");
        }
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    private void setSeconds(int seconds) throws InvalidSongSecondsException {
        if (seconds < 0 || seconds > 59) {
            throw new InvalidSongSecondsException("Song seconds should be between 0 and 59.");
        }
        this.seconds = seconds;
    }

    private void checkLengthValidity(String minutes, String seconds) throws InvalidSongLengthException {
        try{
            int currentMinutes = Integer.parseInt(minutes);
            int currentSeconds = Integer.parseInt(seconds);
        }catch(NumberFormatException ex){
            throw new InvalidSongLengthException("Invalid song length.");
        }
    }
}
