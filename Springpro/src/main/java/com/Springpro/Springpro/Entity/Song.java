package com.Springpro.Springpro.Entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * The Song class represents a song entity in the application.
 * This class is mapped to the "song" table in the database.
 */
@Getter
@Setter
@AllArgsConstructor
@Entity
@Data
@Table(name="song")
@NoArgsConstructor
public class Song {

    /**
     * The unique identifier for the song.
     */
    @Id
    @Column(name="songId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int songId;

    /**
     * The ID of the album the song belongs to.
     */
    @Column(name="AlbumId")
    private int albumId;

    /**
     * The title of the song.
     */
    @Column(name="Title", nullable = false)
    private String title;

    /**
     * The artist of the song.
     */
    @Column(name="Artist", nullable = false)
    private String artist;

    /**
     * The genre of the song.
     */
    @Column(name="Genre")
    private String genre;

    /**
     * The release date of the song.
     */
    @Column(name="ReleaseDate")
    private String releaseDate;
}
