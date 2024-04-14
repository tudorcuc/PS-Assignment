/**
 * Configures observers for profile service.
 */
package com.Springpro.Springpro.Observer;

import com.Springpro.Springpro.Service.ProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObserverConfig {

    /**
     * Configures observers for profile service.
     *
     * @param profileService          The profile service to observe.
     * @param loggingProfileObserver The observer for logging profile updates.
     */
    @Autowired
    public void configureObservers(ProfileServiceImpl profileService, LoggingProfileObserver loggingProfileObserver) {
        profileService.addObserver(loggingProfileObserver);
    }
}
