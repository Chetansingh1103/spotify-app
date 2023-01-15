import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

   public static List<Album> albumList = new ArrayList<>();
    public static void main(String[] args) {
      Album  album1 = new Album("moosa","sidhu moosewala");
      album1.addSongToAlbum("295",4.05);
      album1.addSongToAlbum("LastRide",5.5);
      album1.addSongToAlbum("so high",3.05);

      Album album2 = new Album("Arijit's Songs","Arijit Singh");
      album2.addSongToAlbum("kesariya",5);
      album2.addSongToAlbum("jeena jeena",4.05);
      album2.addSongToAlbum("gerua",6);

      albumList.add(album1);
      albumList.add(album2);

        System.out.println(album1.findSong("gerua"));

        LinkedList<Song> myPlayList = new LinkedList<>();
        album1.addTOPlayListFromAlbum("295,",myPlayList);
        album2.addTOPlayListFromAlbum(2,myPlayList);
    }
}