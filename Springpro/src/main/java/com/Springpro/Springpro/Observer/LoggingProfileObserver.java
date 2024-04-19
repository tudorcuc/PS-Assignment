/**
 * Provides an observer implementation that logs profile updates.
 */
package com.Springpro.Springpro.Observer;

import com.Springpro.Springpro.Entity.Profile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class LoggingProfileObserver implements ProfileObserver {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingProfileObserver.class);

    @Override
    public void update(Profile profile) {
        LOGGER.info("A modification has been made for a Profile!");
    }
}

