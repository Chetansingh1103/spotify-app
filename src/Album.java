import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Album {

    private String albumName;
    private String artist;
    private List<Song> songs;

    public Album(String albumName, String artist) {
        this.albumName = albumName;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public boolean findSong(String title){
        for(Song s : songs){
            if(s.getTitle().equals(title)) return true;
        }
        return false;
    }

    public void addSongToAlbum(String title,double duration){
        Song s = new Song(title,duration);
        if(findSong(s.getTitle())){
            System.out.println("song already present in album");
        }
        else{
            songs.add(s);
            System.out.println("new song has been added");
        }
    }

    //polymorphism
    public void addTOPlayListFromAlbum(String title, LinkedList<Song> playList){
        if(findSong(title)){
            for(Song song : songs){
                if(song.getTitle().equals(title)){
                    playList.add(song);
                    System.out.println("song has been added to your playlist");
                    break;
                }
            }
        }
        else{
            System.out.println("song is not present in the album");
        }
    }

    public void addTOPlayListFromAlbum(int trackNo,LinkedList<Song> playList){
        int index = trackNo - 1;
        if(index >=0 && index < songs.size()){
            playList.add(songs.get(index));
            System.out.println("song has been added to playlist");
        }
        else{
            System.out.println("invalid track number");
        }
    }
}
