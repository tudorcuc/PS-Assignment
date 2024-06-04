package com.Springpro.Springpro.Observer;

import com.Springpro.Springpro.Entity.Profile;

/**
 * Defines an interface for objects that observe profile updates.
 */
public interface ProfileObserver {
    /**
     * Updates the observer with the latest profile information.
     *
     * @param profile The updated profile.
     */
    void update(Profile profile);
}
