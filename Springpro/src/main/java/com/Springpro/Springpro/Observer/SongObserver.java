package com.Springpro.Springpro.Observer;

import com.Springpro.Springpro.Entity.Song;

/**
 * Defines an interface for objects that observe song updates.
 */
public interface SongObserver {
    /**
     * Updates the observer with the latest song information.
     *
     * @param song The updated song.
     */
    void update(Song song);
}
