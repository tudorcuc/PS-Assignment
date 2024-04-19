package com.Springpro.Springpro.Service;

import com.Springpro.Springpro.Entity.Song;
import com.Springpro.Springpro.Observer.SongObserver;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The SongService interface defines operations for managing Song entities.
 */
@Service
public interface SongService {

    /**
     * Creates a new song.
     *
     * @param song The song to be created.
     * @return The created song.
     */
    Song createSong(Song song);

    /**
     * Retrieves a song by its ID.
     *
     * @param songId The ID of the song to retrieve.
     * @return The song with the specified ID, or null if not found.
     */
    Song getSongById(int songId);

    /**
     * Retrieves all songs.
     *
     * @return A list of all songs.
     */
    List<Song> getAllSongs();

    /**
     * Updates an existing song.
     *
     * @param song The song to be updated.
     * @return The updated song.
     */
    Song updateSong(Song song);

    /**
     * Deletes a song by its ID.
     *
     * @param songId The ID of the song to delete.
     */
    void deleteSong(int songId);

    /**
     * Adds an observer to the list of observers.
     *
     * @param observer The observer to be added.
     */
    void addObserver(SongObserver observer);

    /**
     * Removes an observer from the list of observers.
     *
     * @param observer The observer to be removed.
     */
    void removeObserver(SongObserver observer);

    /**
     * Notifies all observers with the updated song.
     *
     * @param song The song that has been updated.
     */
    void notifyObservers(Song song);
}
