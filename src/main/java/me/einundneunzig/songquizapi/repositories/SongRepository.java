package me.einundneunzig.songquizapi.repositories;

import me.einundneunzig.songquizapi.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.Set;

public interface SongRepository extends JpaRepository<Song, Long> {

    @Query(value = "SELECT * FROM song WHERE language = :language AND genre_name @> :genres AND popularity >= :popularity ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Optional<Song> findRandomSongByLanguageGenresAndPopularity(@Param("language") String language, @Param("genres") Set<String> genres, @Param("popularity") int popularity);

    @Query(value = "SELECT * FROM song WHERE language = :language AND genre_name @> :genres ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Optional<Song> findRandomSongByLanguageAndGenres(@Param("language") String language, @Param("genres") Set<String> genres);

    @Query(value = "SELECT * FROM song WHERE language = :language ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Optional<Song> findRandomSongByLanguage(@Param("language") String language);
    
    @Query(value = "SELECT * FROM song WHERE genre_name @> :genres ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Optional<Song> findRandomSongByGenres(@Param("genres") Set<String> genres);
    
    @Query(value = "SELECT * FROM song ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Optional<Song> findRandomSong();

    @Query(value = "SELECT DISTINCT unnest(genre_name) FROM song", nativeQuery = true)
    Set<String> findAllGenres();
}
