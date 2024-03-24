package com.Springpro.Springpro.Controller;

import com.Springpro.Springpro.Entity.Profile;
import com.Springpro.Springpro.Service.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The ProfileController class handles HTTP requests related to profile entities.
 * It defines REST endpoints for CRUD operations on profile.
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/profiles")
public class ProfileController {
    private ProfileService profileService;

    /**
     * REST endpoint to create a new profile.
     *
     * @param profile The profile data to be created.
     * @return The created profile and HTTP status code 201 (Created) if successful.
     */
    @PostMapping
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile){
        Profile savedProfile = profileService.createProfile(profile);
        return new ResponseEntity<>(savedProfile, HttpStatus.CREATED);
    }

    /**
     * REST endpoint to retrieve a profile by ID.
     *
     * @param profileId The ID of the profile to retrieve.
     * @return The profile with the specified ID and HTTP status code 200 (OK) if found.
     */
    @GetMapping("{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable("id") int profileId){
        Profile profile = profileService.getProfileById(profileId);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

    /**
     * REST endpoint to retrieve all profiles.
     *
     * @return A list of all profiles and HTTP status code 200 (OK).
     */
    @GetMapping
    public ResponseEntity<List<Profile>> getAllProfiles(){
        List<Profile> profiles = profileService.getAllProfiles();
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }

    /**
     * REST endpoint to update an existing profile.
     *
     * @param profileId The ID of the profile to update.
     * @param profile   The updated profile data.
     * @return The updated profile and HTTP status code 200 (OK) if successful.
     */
    @PutMapping("{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable("id") int profileId, @RequestBody Profile profile){
        profile.setId(profileId);
        Profile updatedProfile =profileService.updateProfile(profile);
        return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
    }

    /**
     * REST endpoint to delete a profile by ID.
     *
     * @param profileId The ID of the profile to delete.
     * @return A success message and HTTP status code 200 (OK) if deletion is successful.
     */
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProfile(@PathVariable("id") int profileId){
        profileService.deleteProfile(profileId);
        return new ResponseEntity<>("Profile successfully deleted!", HttpStatus.OK);
        }
    }
