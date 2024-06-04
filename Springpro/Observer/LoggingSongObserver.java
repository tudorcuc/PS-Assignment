package com.Springpro.Springpro.Observer;

import com.Springpro.Springpro.Entity.Song;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Provides an observer implementation that logs song updates.
 */
@Component
public class LoggingSongObserver implements SongObserver {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingSongObserver.class);

    /**
     * Logs the update of a song.
     *
     * @param song The updated song.
     */
    @Override
    public void update(Song song) {
        LOGGER.info("A modification has been made for a Song!");
    }
}
