import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongServiceProxy implements SongService {

    private SongService realSongService;

    private Map<Integer, Song> idCache = new HashMap<>();

    private Map<String, List<Song>> titleCache = new HashMap<>();

    private Map<String, List<Song>> albumCache = new HashMap<>();

    public SongServiceProxy(SongService realSongService) {
        this.realSongService = realSongService;
    }

    @Override
    public Song searchById(Integer songID) {
        if (!idCache.containsKey(songID)) {

            Song song =realSongService.searchById(songID);

            idCache.put(songID, song);
        }

        return idCache.get(songID);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        String key = title.toLowerCase();

        if (!titleCache.containsKey(key)) {

            List<Song> songs = realSongService.searchByTitle(title);

            titleCache.put(key, songs);
        }

        return titleCache.get(key);
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        String key = album.toLowerCase();

        if (!albumCache.containsKey(key)) {
            
            List<Song> songs = realSongService.searchByAlbum(album);

            albumCache.put(key, songs);
        }

        return albumCache.get(key);
    }
}