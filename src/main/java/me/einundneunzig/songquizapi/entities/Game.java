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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Song> getSongsInOrder() {
        return songsInOrder;
    }

    public void setSongsInOrder(List<Song> songsInOrder) {
        this.songsInOrder = songsInOrder;
    }

    public String getStatisticsInSongOrder() {
        return statisticsInSongOrder;
    }

    public void setStatisticsInSongOrder(String statisticsInSongOrder) {
        this.statisticsInSongOrder = statisticsInSongOrder;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }
}
