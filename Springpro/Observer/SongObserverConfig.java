package com.Springpro.Springpro.Observer;

import com.Springpro.Springpro.Service.SongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SongObserverConfig {

    /**
     * Configures observers for song service.
     *
     * @param songService          The song service to observe.
     * @param loggingSongObserver The observer for logging song updates.
     */
    @Autowired
    public void configureObservers(SongServiceImpl songService, LoggingSongObserver loggingSongObserver) {
        songService.addObserver(loggingSongObserver);
    }
}
