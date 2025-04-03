package me.einundneunzig.songquizapi;

import me.einundneunzig.songquizapi.entities.Song;
import me.einundneunzig.songquizapi.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.Set;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin
@RequestMapping("/songquizapi")
public class RestController {
    private final SongRepository songRepository;

    @Autowired
    public RestController(SongRepository songRepository){
        this.songRepository = songRepository;
    }

    @GetMapping("/getRandomSongByGenres")
    public ResponseEntity<Song> getRandomSongByGenres(@Param("genres") Set<String> genres) {
        Optional<Song> opt = songRepository.findRandomSongByGenres(genres);
        return opt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/getAllGenres") ResponseEntity<Set<String>> getAllGenres() {
        Set<String> set = songRepository.findAllGenres();
        return new ResponseEntity<>(set, HttpStatus.OK);
    }

}
