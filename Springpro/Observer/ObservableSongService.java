package com.Springpro.Springpro.Observer;

import com.Springpro.Springpro.Entity.Song;

/**
 * Defines an interface for an observable song service.
 */
public interface ObservableSongService {
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
