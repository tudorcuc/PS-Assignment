package com.Springpro.Springpro.Service;

import com.Springpro.Springpro.Entity.Profile;
import com.Springpro.Springpro.Repository.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class ProfileServiceImpl implements ProfileService{
    private ProfileRepository profileRepository;
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
            return profileRepository.save(existingProfile);
        }
        return null;
    }

    @Override
    public void deleteProfile(int profileId) {
        profileRepository.deleteById(profileId);
    }
}
