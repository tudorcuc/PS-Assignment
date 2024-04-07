/**
 * Provides an observer implementation that logs profile updates.
 */
package com.Springpro.Springpro.Observer;

import com.Springpro.Springpro.Entity.Profile;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class LoggingProfileObserver implements ProfileObserver {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(LoggingProfileObserver.class);

    /**
     * Logs profile updates.
     *
     * @param profile The profile that has been updated.
     */
    @Override
    public void update(Profile profile) {
        LOGGER.info("Profile has been updated.");
    }
}

