import java.util.ArrayList;
import java.util.List;

public class ConcreteSongService implements SongService {

    private List<Song> songs;

    public ConcreteSongService(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public Song searchById(Integer songID) {
        delay();

        for (Song song : songs) {
            if (song.getSongID().equals(songID)) {
                return song;
            }
        }

        return null;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        delay();

        List<Song> results = new ArrayList<>();

        for (Song song : songs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                results.add(song);
            }
        }

        return results;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        delay();

        List<Song> results = new ArrayList<>();

        for (Song song : songs) {
            if (song.getAlbum().equalsIgnoreCase(album)) {
                results.add(song);
            }
        }

        return results;
    }

    private void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}