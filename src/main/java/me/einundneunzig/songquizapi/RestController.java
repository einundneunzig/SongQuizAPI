package me.einundneunzig.songquizapi;

import me.einundneunzig.songquizapi.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin
public class RestController {
    private final SongRepository songRepository;

    @Autowired
    public RestController(SongRepository songRepository){
        this.songRepository = songRepository;
    }


}
