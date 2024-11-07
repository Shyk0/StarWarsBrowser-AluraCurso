import java.util.List;

public record Pelicula(String title,
                       int episode_id,
                       String opening_crawl,
                       String director,
                       String producer,
                       String release_date,
                       List<String> characters

                       ) {
}
