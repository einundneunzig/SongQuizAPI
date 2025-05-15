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

    
    @GetMapping("/getAllGenres")
    public ResponseEntity<Set<String>> getAllGenres(){
        Optional<Set<String>> opt;
        opt = songRepository.findAllGenres();
        return opt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/getAllGenresOrdered")
    public ResponseEntity<List<String>> getAllGenresOrdered(){
        Optional<List<String>> opt;
        opt = songRepository.findAllGenresOrderedByGenreCount();
        return opt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping("/getAllLanguages")
    public ResponseEntity<Set<String>> getAllLanguages(){
        Optional<Set<String>> opt;
        opt = songRepository.findAllLanguages();
        return opt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
        
    @GetMapping("/getRandomSong")
    public ResponseEntity<Song> getRandomSong(
            @RequestParam(value = "languages", required = false) Set<String> languages,
            @RequestParam(value = "genres", required = false) Set<String> genres,
            @RequestParam(value = "popularity", required = false) Integer popularity) {

        Optional<Song> opt;

        if (genres != null && popularity != null && languages != null) {
            opt = songRepository.findRandomSongByLanguagesGenresAndPopularity(languages, genres, popularity);
        } else if(genres != null && popularity != null) {
            opt = songRepository.findRandomSongByGenreAndPopularity(genres, popularity);
        } else if (genres != null && languages != null) {
            opt = songRepository.findRandomSongByLanguagesAndGenres(languages, genres);
        } else if(popularity != null &&  languages!= null) {
            opt = songRepository.findRandomSongByLanguagesAndPopularity(languages, popularity);
        }else if(genres != null){
            opt = songRepository.findRandomSongByGenres(genres);
        }else if(popularity != null){
            opt = songRepository.findRandomSongByPopularity(popularity);
        } else if (languages != null) {
            opt = songRepository.findRandomSongByLanguages(languages);
        }else{
            opt = songRepository.findRandomSong();
        }

        return opt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
