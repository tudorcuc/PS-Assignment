package com.Springpro.Springpro.Entity;
import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@Entity
@Data
@Table(name="Profile_DB")
@NoArgsConstructor
public class Song {
    @Id
    @Column(name="ID")
    @GeneratedValue
    private int id;

    @Column(name="ALBUM_ID", nullable = false)
    private String albumID;

    @Column(name="TITLE",nullable = false)
    private String title;

    @Column(name="ARTIST",nullable = false)
    private String artist;


    @Column(name="GENRE",nullable = false)
    private String genre;

    @Column(name="RELEASE_DATE",nullable = false)
    private String releaseDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlbumID() {
        return albumID;
    }

    public void setAlbumID(String albumID) {
        this.albumID = albumID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
