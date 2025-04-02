package me.einundneunzig.songquizapi.repositories;

import me.einundneunzig.songquizapi.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
