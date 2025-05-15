package me.einundneunzig.songquizapi.repositories;

import me.einundneunzig.songquizapi.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.Set;
import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {

    @Query(value = """
    SELECT s.* FROM song s
    JOIN song_genres sg ON s.id = sg.song_id
    WHERE s.language IN (:languages)
      AND sg.genres IN (:genres)
      AND s.popularity >= :popularity
    ORDER BY RANDOM() LIMIT 1
""", nativeQuery = true)
    Optional<Song> findRandomSongByLanguagesGenresAndPopularity(@Param("languages") Set<String> languages, @Param("genres") Set<String> genres, @Param("popularity") int popularity);


    @Query(value = """
    SELECT s.* FROM song s
    JOIN song_genres sg ON s.id = sg.song_id
    WHERE s.language IN (:languages)
      AND sg.genres IN (:genres)
    ORDER BY RANDOM() LIMIT 1
""", nativeQuery = true)
    Optional<Song> findRandomSongByLanguagesAndGenres(@Param("languages") Set<String> languages, @Param("genres") Set<String> genres);


    @Query(value = """
    SELECT * FROM song
    WHERE language IN (:languages)
    ORDER BY RANDOM() LIMIT 1
""", nativeQuery = true)
    Optional<Song> findRandomSongByLanguages(@Param("languages") Set<String> languages);


    @Query(value = """
    SELECT s.* FROM song s
    JOIN song_genres sg ON s.id = sg.song_id
    WHERE sg.genres IN (:genres)
    ORDER BY RANDOM() LIMIT 1
""", nativeQuery = true)
    Optional<Song> findRandomSongByGenres(@Param("genres") Set<String> genres);


    @Query(value = """
    SELECT * FROM song
    ORDER BY RANDOM() LIMIT 1
""", nativeQuery = true)
    Optional<Song> findRandomSong();


    @Query(value = """
    SELECT DISTINCT genres FROM song_genres
""", nativeQuery = true)
    Optional<Set<String>> findAllGenres();

    

    @Query(value = """
    SELECT genres AS genre_count
    FROM song_genres
    GROUP BY genres
    ORDER BY COUNT(song_id) DESC;
    """, nativeQuery = true)
    Optional<List<String>> findAllGenresOrderedByGenreCount();
    
    @Query(value = """
    SELECT DISTINCT language FROM song
""", nativeQuery = true)
    Optional<Set<String>> findAllLanguages();

    @Query(value = """
    SELECT s.* FROM song s
    JOIN song_genres sg ON s.id = sg.song_id
    WHERE s.popularity >= :popularity
      AND sg.genres IN (:genres)
    ORDER BY RANDOM() LIMIT 1
""", nativeQuery = true)
    Optional<Song> findRandomSongByGenreAndPopularity(@Param("genres") Set<String> genres, @Param("popularity") Integer popularity);


    @Query(value = """
    SELECT * FROM song
    WHERE language IN (:languages)
      AND popularity >= :popularity
    ORDER BY RANDOM() LIMIT 1
""", nativeQuery = true)
    Optional<Song> findRandomSongByLanguagesAndPopularity(@Param("languages") Set<String> languages, @Param("popularity") Integer popularity);


    @Query(value = """
    SELECT * FROM song
    WHERE popularity >= :popularity
    ORDER BY RANDOM() LIMIT 1
""", nativeQuery = true)
    Optional<Song> findRandomSongByPopularity(@Param("popularity") Integer popularity);

}
