package me.einundneunzig.songquizapi.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

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

    @ElementCollection
    private Set<String> genres;

    @Column(unique = true)
    private String spotifyId;

    private String songText;
    private String instrumentalVersion;

    private long spotifyViews;

    private int likes;
    private int dislikes;

    @ManyToOne
    private Song originalSong;

    private boolean explicit;
    private int popularity;
    private String isrc;
    private boolean falseInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Set<String> getGenres() {
        return genres;
    }

    public void setGenres(Set<String> genres) {
        this.genres = genres;
    }

    public String getSpotifyId() {
        return spotifyId;
    }

    public void setSpotifyId(String spotifyId) {
        this.spotifyId = spotifyId;
    }

    public String getSongText() {
        return songText;
    }

    public void setSongText(String songText) {
        this.songText = songText;
    }

    public String getInstrumentalVersion() {
        return instrumentalVersion;
    }

    public void setInstrumentalVersion(String instrumentalVersion) {
        this.instrumentalVersion = instrumentalVersion;
    }

    public long getSpotifyViews() {
        return spotifyViews;
    }

    public void setSpotifyViews(long spotifyViews) {
        this.spotifyViews = spotifyViews;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public Song getOriginalSong() {
        return originalSong;
    }

    public void setOriginalSong(Song originalSong) {
        this.originalSong = originalSong;
    }

    public boolean isExplicit() {
        return explicit;
    }

    public void setExplicit(boolean explicit) {
        this.explicit = explicit;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public String getIsrc() {
        return isrc;
    }

    public void setIsrc(String isrc) {
        this.isrc = isrc;
    }

    public boolean isFalseInfo() {
        return falseInfo;
    }

    public void setFalseInfo(boolean falseInfo) {
        this.falseInfo = falseInfo;
    }
}
