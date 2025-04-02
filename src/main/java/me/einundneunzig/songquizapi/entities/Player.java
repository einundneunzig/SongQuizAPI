package me.einundneunzig.songquizapi.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private String statistics;

    @ManyToMany
    private List<Song> heardSongs;

    @ManyToMany
    private List<Song> rightSongs;

    @ManyToMany
    private List<Song> wrongSongs;
}
