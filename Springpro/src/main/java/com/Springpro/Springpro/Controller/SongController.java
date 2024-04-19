package com.Springpro.Springpro.Controller;

import com.Springpro.Springpro.Entity.Song;
import com.Springpro.Springpro.Service.SongService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The SongController class handles HTTP requests related to song entities.
 * It defines REST endpoints for CRUD operations on songs.
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/songs")
public class SongController {
    private final SongService songService;

    /**
     * REST endpoint to create a new song.
     *
     * @param song The song data to be created.
     * @return The created song and HTTP status code 201 (Created) if successful.
     */
    @PostMapping
    public ResponseEntity<Song> createSong(@RequestBody Song song){
        Song savedSong = songService.createSong(song);
        return new ResponseEntity<>(savedSong, HttpStatus.CREATED);
    }

    /**
     * REST endpoint to retrieve a song by ID.
     *
     * @param songId The ID of the song to retrieve.
     * @return The song with the specified ID and HTTP status code 200 (OK) if found.
     */
    @GetMapping("{id}")
    public ResponseEntity<Song> getSongById(@PathVariable("id") int songId){
        Song song = songService.getSongById(songId);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }

    /**
     * REST endpoint to retrieve all songs.
     *
     * @return A list of all songs and HTTP status code 200 (OK).
     */
    @GetMapping
    public ResponseEntity<List<Song>> getAllSongs(){
        List<Song> songs = songService.getAllSongs();
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    /**
     * REST endpoint to update an existing song.
     *
     * @param songId The ID of the song to update.
     * @param song   The updated song data.
     * @return The updated song and HTTP status code 200 (OK) if successful.
     */
    @PutMapping("{id}")
    public ResponseEntity<Song> updateSong(@PathVariable("id") int songId, @RequestBody Song song){
        song.setSongId(songId);
        Song updatedSong = songService.updateSong(song);
        return new ResponseEntity<>(updatedSong, HttpStatus.OK);
    }

    /**
     * REST endpoint to delete a song by ID.
     *
     * @param songId The ID of the song to delete.
     * @return A success message and HTTP status code 200 (OK) if deletion is successful.
     */
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSong(@PathVariable("id") int songId){
        songService.deleteSong(songId);
        return new ResponseEntity<>("Song successfully deleted!", HttpStatus.OK);
    }
}
