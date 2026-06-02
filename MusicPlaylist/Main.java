import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Music {
    private String title;
    private String artist;
    private int duration;

    public Music(String title, String artist, int duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Song: " + title +
               ", Artist: " + artist +
               ", Duration: " + duration + " sec";
    }
}

class MusicPlayer {

    private List<Music> playlist;
    private int currentIndex;

    public MusicPlayer() {
        playlist = new LinkedList<>();
        currentIndex = -1;
    }

    public void addMusic(Music music) {
        playlist.add(music);

        if (currentIndex == -1) {
            currentIndex = 0;
        }

        System.out.println("Song added successfully.");
    }

    public void addMusic(int position, Music music) {
        if (position >= 0 && position <= playlist.size()) {
            playlist.add(position, music);
            System.out.println("Song inserted successfully.");
        } else {
            System.out.println("Invalid position.");
        }
    }

    public void removeSong(int position) {
        if (position >= 0 && position < playlist.size()) {
            Music removed = playlist.remove(position);
            System.out.println("Removed: " + removed);

            if (playlist.isEmpty()) {
                currentIndex = -1;
            } else if (currentIndex >= playlist.size()) {
                currentIndex = playlist.size() - 1;
            }

        } else {
            System.out.println("Invalid position.");
        }
    }

    public void displayPlaylist() {

        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }

        System.out.println("\n----- Playlist -----");

        for (int i = 0; i < playlist.size(); i++) {
            System.out.println(i + ". " + playlist.get(i));
        }
    }

    public void playCurrent() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }

        System.out.println("Now Playing:");
        System.out.println(playlist.get(currentIndex));
    }

    public void playNext() {

        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }

        currentIndex = (currentIndex + 1) % playlist.size();

        System.out.println("Playing Next:");
        System.out.println(playlist.get(currentIndex));
    }

    public void playPrevious() {

        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }

        currentIndex = (currentIndex - 1 + playlist.size()) % playlist.size();

        System.out.println("Playing Previous:");
        System.out.println(playlist.get(currentIndex));
    }

    public void searchSong(String title) {

        boolean found = false;

        for (Music song : playlist) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Song Found:");
                System.out.println(song);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Song not found.");
        }
    }

    public void shufflePlaylist() {

        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }

        Collections.shuffle(playlist);
        currentIndex = 0;

        System.out.println("Playlist shuffled successfully.");
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MusicPlayer player = new MusicPlayer();

        while (true) {

            System.out.println("\n===== MUSIC PLAYLIST MENU =====");
            System.out.println("1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. Display Playlist");
            System.out.println("4. Play Current Song");
            System.out.println("5. Play Next Song");
            System.out.println("6. Play Previous Song");
            System.out.println("7. Search Song");
            System.out.println("8. Shuffle Playlist");
            System.out.println("9. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter artist: ");
                    String artist = sc.nextLine();

                    System.out.print("Enter duration (seconds): ");
                    int duration = sc.nextInt();

                    player.addMusic(new Music(title, artist, duration));
                    break;

                case 2:
                    System.out.print("Enter position to remove: ");
                    int pos = sc.nextInt();

                    player.removeSong(pos);
                    break;

                case 3:
                    player.displayPlaylist();
                    break;

                case 4:
                    player.playCurrent();
                    break;

                case 5:
                    player.playNext();
                    break;

                case 6:
                    player.playPrevious();
                    break;

                case 7:
                    System.out.print("Enter song title: ");
                    String searchTitle = sc.nextLine();

                    player.searchSong(searchTitle);
                    break;

                case 8:
                    player.shufflePlaylist();
                    break;

                case 9:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

// ------------------------------------------------------------
// Music Playlist System code structure
// │
// ├── Song Class
// │     ├── title
// │     ├── artist
// │     └── duration
// │
// ├── Playlist Class
// │     ├── LinkedList<Song>
// │     ├── addSong()
// │     ├── removeSong()
// │     ├── displayPlaylist()
// │     ├── playNext()
// │     ├── playPrevious()
// │     ├── searchSong()
// │     └── shufflePlaylist()
// │
// └── Main Class
//       ├── Menu
//       ├── User Input
//       └── Calls Playlist Methods
// // ------------------------------------------------------------