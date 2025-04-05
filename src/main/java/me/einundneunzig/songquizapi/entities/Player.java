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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatistics() {
        return statistics;
    }

    public void setStatistics(String statistics) {
        this.statistics = statistics;
    }

    public List<Song> getHeardSongs() {
        return heardSongs;
    }

    public void setHeardSongs(List<Song> heardSongs) {
        this.heardSongs = heardSongs;
    }

    public List<Song> getRightSongs() {
        return rightSongs;
    }

    public void setRightSongs(List<Song> rightSongs) {
        this.rightSongs = rightSongs;
    }

    public List<Song> getWrongSongs() {
        return wrongSongs;
    }

    public void setWrongSongs(List<Song> wrongSongs) {
        this.wrongSongs = wrongSongs;
    }
}
