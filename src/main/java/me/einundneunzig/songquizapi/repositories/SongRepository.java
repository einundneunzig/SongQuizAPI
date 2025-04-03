package me.einundneunzig.songquizapi.repositories;

import me.einundneunzig.songquizapi.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.Set;

public interface SongRepository extends JpaRepository<Song, Long> {

    @Query(value = "SELECT * FROM song WHERE genres @> :genres ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Optional<Song> findRandomSongByGenres(@Param("genres") Set<String> genres);

    @Query(value = "SELECT DISTINCT unnest(genres) FROM song", nativeQuery = true)
    Set<String> findAllGenres();
}
