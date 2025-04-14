package me.einundneunzig.songquizapi;

import me.einundneunzig.songquizapi.entities.Song;
import me.einundneunzig.songquizapi.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/getRandomSongByLanguageGenresAndPopularity")
    public ResponseEntity<Song> getRandomSongByLanguageGenresAndPopularity(@RequestParam("language") String language, @RequestParam("genres") Set<String> genres, @RequestParam("popularity") int popularity) {
        Optional<Song> opt = songRepository.findRandomSongByLanguageGenresAndPopularity(language, genres, popularity);
        return opt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/getRandomSongByLanguageAndGenres")
    public ResponseEntity<Song> getRandomSongByLanguageAndGenres(@RequestParam("language") String language, @RequestParam("genres") Set<String> genres) {
        Optional<Song> opt = songRepository.findRandomSongByLanguageAndGenres(language, genres);
        return opt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/getRandomSongByLanguage")
    public ResponseEntity<Song> getRandomSongByLanguage(@RequestParam("language") String language) {
        Optional<Song> opt = songRepository.findRandomSongByLanguage(language);
        return opt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/getRandomSongByGenres")
    public ResponseEntity<Song> getRandomSongByGenres(@RequestParam("genres") Set<String> genres) {
        Optional<Song> opt = songRepository.findRandomSongByGenres(genres);
        return opt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("getRandomSong")
    public ResponseEntity<Song> getRandomSong() {
        Optional<Song> opt = songRepository.findRandomSong();
        return opt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/getAllGenres") ResponseEntity<Set<String>> getAllGenres() {
        Set<String> set = songRepository.findAllGenres();
        return new ResponseEntity<>(set, HttpStatus.OK);
    }

}
