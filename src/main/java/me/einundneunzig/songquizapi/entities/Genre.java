package me.einundneunzig.songquizapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Genre {
    @Id
    private String name;
}
