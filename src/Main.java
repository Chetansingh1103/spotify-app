import java.util.*;

public class Main {

   public static List<Album> albumList = new ArrayList<>();
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
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
        album1.addTOPlayListFromAlbum("295",myPlayList);
        album2.addTOPlayListFromAlbum(3,myPlayList);
        album1.addTOPlayListFromAlbum("LastRide",myPlayList);
        album2.addTOPlayListFromAlbum("kesariya",myPlayList);

        play(myPlayList);
    }

    public static void play(LinkedList<Song> playList){
      Scanner sc = new Scanner(System.in);
      ListIterator<Song> itr = playList.listIterator();

      boolean forward = false;

      if(playList.size() > 0){
        System.out.println("currently playing");
        System.out.println(itr.next());
        forward = true;
      }
      else{
        System.out.println("playlist is empty");
      }

      System.out.println("enter your choice");
      printMenu();

      boolean quit = false;
      while(!quit){
        int choice = sc.nextInt();
        switch (choice){
          case 1:
            if(!forward){
              itr.next();
              forward = true;
            }
            if(itr.hasNext())
              System.out.println(itr.next());
            else
              System.out.println("you have reached the end of the playlist");
            break;
          case 2:
            if(forward){
              itr.previous();
              forward = false;
            }
            if(itr.hasPrevious())
              System.out.println(itr.previous());
            else
              System.out.println("you are at the start at your playlist");
            break;
          case 3:
            if(forward) {
              if (itr.hasPrevious()) {
                System.out.println(itr.previous());
                forward = false;
              }
              else {
                System.out.println("Song doesn't exist");
              }
            }
            else{
              if(itr.hasNext()){
                System.out.println(itr.next());
                forward = true;
              }
            }
            break;
          case 4:
            printMenu();
            break;
          case 5:
            break;
          case 6:
            printSongs(playList);
            break;
          case 7:
            quit = true;
            break;
        }
      }
    }

    public static void printSongs(LinkedList<Song> playList){
      for(Song song : playList) System.out.println(song);
    }

    public static void printMenu(){
      System.out.println("1 - play next song");
      System.out.println("2 - play previous song");
      System.out.println("3 - repeat the current song");
      System.out.println("4 - show menu again");
      System.out.println("5 - delete the current song");
      System.out.println("6 - print all the songs in playlist");
      System.out.println("7 - exit");
    }
}