package com.Springpro.Springpro.Service;

import com.Springpro.Springpro.Entity.Song;
import com.Springpro.Springpro.Observer.ProfileObserver;
import com.Springpro.Springpro.Observer.SongObserver;
import com.Springpro.Springpro.Repository.SongRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The SongServiceImpl class implements the SongService interface.
 * It provides methods to manage Song entities.
 */
@Service
@AllArgsConstructor
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;
    private List<SongObserver> observers = new ArrayList<>();

    /**
     * Creates a new song.
     *
     * @param song The song to be created.
     * @return The created song.
     */
    @Override
    public Song createSong(Song song) {
        return songRepository.save(song);
    }

    /**
     * Retrieves a song by its ID.
     *
     * @param songId The ID of the song to retrieve.
     * @return The song with the specified ID, or null if not found.
     */
    @Override
    public Song getSongById(int songId) {
        Optional<Song> optionalSong = songRepository.findById(songId);
        return optionalSong.orElse(null);
    }

    /**
     * Retrieves all songs.
     *
     * @return A list of all songs.
     */
    @Override
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    /**
     * Updates an existing song.
     *
     * @param song The song to be updated.
     * @return The updated song.
     */
    @Override
    public Song updateSong(Song song) {
        Song existingSong = songRepository.findById(song.getSongId()).orElse(null);
        if (existingSong != null) {
            existingSong.setAlbumId(song.getAlbumId());
            existingSong.setTitle(song.getTitle());
            existingSong.setArtist(song.getArtist());
            existingSong.setGenre(song.getGenre());
            existingSong.setReleaseDate(song.getReleaseDate());
            notifyObservers(song);
            return songRepository.save(existingSong);
        }
        return null;
    }

    /**
     * Deletes a song by its ID.
     *
     * @param songId The ID of the song to delete.
     */
    @Override
    public void deleteSong(int songId) {
        songRepository.deleteById(songId);
    }

    /**
     * Adds an observer to the list of observers.
     *
     * @param observer The observer to be added.
     */
    @Override
    public void addObserver(SongObserver observer) {
        observers.add(observer);
    }

    /**
     * Removes an observer from the list of observers.
     *
     * @param observer The observer to be removed.
     */
    @Override
    public void removeObserver(SongObserver observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all observers with the updated song.
     *
     * @param song The song that has been updated.
     */
    @Override
    public void notifyObservers(Song song) {
        for (SongObserver observer : observers) {
            observer.update(song);
        }
    }
}
