package com.Springpro.Springpro.Observer;

import com.Springpro.Springpro.Entity.Profile;

/**
 * Defines an interface for an observable profile service.
 */
public interface ObservableProfileService {
    /**
     * Adds an observer to the list of observers.
     *
     * @param observer The observer to be added.
     */
    void addObserver(ProfileObserver observer);

    /**
     * Removes an observer from the list of observers.
     *
     * @param observer The observer to be removed.
     */
    void removeObserver(ProfileObserver observer);

    /**
     * Notifies all observers with the updated profile.
     *
     * @param profile The profile that has been updated.
     */
    void notifyObservers(Profile profile);
}
