package me.einundneunzig.songquizapi.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToMany
    private List<Artist> artists;

    @ManyToOne
    private Album album;

    private LocalDate releaseDate;

    @ManyToOne
    private Genre genre;

    private String spotifyUrl;
    private String songText;
    private String instrumentalVersion;
    private int difficulty;
    private long spotifyViews;
    private int likes;
    private int dislikes;

    @ManyToOne
    private Song originalSong;

    private boolean explicit;
    private int popularity;
    private String isrc;
    private boolean falseInfo;
}
