import java.util.List;

public class StreamingApplication{
    public static void main(String[] args){
        List<Song> songs = List.of(
                new Song(1, "Seagirl", "King Krule", "Space Heavy", 202),

                new Song(2, "The Hours", "Beach House", "Bloom", 262),

                new Song(3, "How High", "Pierre Bourne", "The Life Of Pierre 4", 249),

                new Song(4, "Riot", "Hugh Masekela", "Masekela", 120),

                new Song(5, "Carousel", "Travis Scott", "Astroworld", 180)
        );

        SongService realService = new ConcreteSongService(songs);

        SongService proxy = new SongServiceProxy(realService);

        System.out.println("Search by ID:");
        System.out.println(proxy.searchById(3));
        System.out.println(proxy.searchById(5));

        System.out.println("\nSearch by title:");
        System.out.println(proxy.searchByTitle("Seagirl"));
        System.out.println(proxy.searchByTitle("Riot"));

        System.out.println("\nSearch by album:");
        System.out.println(proxy.searchByAlbum("Bloom"));
        System.out.println(proxy.searchByAlbum("Astroworld"));
    }

}