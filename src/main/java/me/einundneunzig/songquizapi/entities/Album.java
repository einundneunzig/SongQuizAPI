package me.einundneunzig.songquizapi.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "album")
    private List<Song> songs;

    @ManyToMany
    private List<Artist> artists;

    private String spotifyId;
}
