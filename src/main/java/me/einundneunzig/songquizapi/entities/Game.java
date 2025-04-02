package me.einundneunzig.songquizapi.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<Player> players;

    @OneToMany
    private List<Song> songsInOrder;

    private String statisticsInSongOrder;
    private boolean isRight;
}
