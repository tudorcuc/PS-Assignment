package com.Springpro.Springpro.Service;

import com.Springpro.Springpro.Entity.Profile;
import com.Springpro.Springpro.Observer.ProfileObserver;
import com.Springpro.Springpro.Repository.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class ProfileServiceImpl implements ProfileService{
    private ProfileRepository profileRepository;
    private List<ProfileObserver> observers = new ArrayList<>();
    @Override
    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile getProfileById(int profileId) {
        Optional<Profile> optionalProfile = profileRepository.findById(profileId);
        return optionalProfile.orElse(null);
    }

    @Override
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    @Override
    public Profile updateProfile(Profile profile) {
        Profile existingProfile = profileRepository.findById(profile.getId()).orElse(null);
        if (existingProfile != null) {
            existingProfile.setUsername(profile.getUsername());
            existingProfile.setEmail(profile.getEmail());
            existingProfile.setPassword(profile.getPassword());
            notifyObservers(profile);
            return profileRepository.save(existingProfile);
        }
        return null;
    }

    @Override
    public void deleteProfile(int profileId) {
        profileRepository.deleteById(profileId);
    }

    @Override
    public void addObserver(ProfileObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ProfileObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Profile profile) {
        for (ProfileObserver observer : observers) {
            observer.update(profile);
        }
    }
}
