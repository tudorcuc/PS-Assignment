package com.Springpro.Springpro.Controller;

import com.Springpro.Springpro.Entity.Profile;
import com.Springpro.Springpro.Service.ProfileService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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

    /**
     * REST endpoint to retrieve available methods for a resource.
     *
     * @return The allowed methods for the resource and HTTP status code 200 (OK).
     */
    @RequestMapping(value = "{id}", method = RequestMethod.OPTIONS)
    public ResponseEntity<?> resourceOptions(){
        // You can customize the response body to include allowed methods, headers, etc.
        return ResponseEntity.ok().allow(HttpMethod.GET, HttpMethod.PUT, HttpMethod.DELETE, HttpMethod.PATCH, HttpMethod.OPTIONS).build();
    }

    /**
     * REST endpoint to retrieve headers of a resource without the body.
     *
     * @param profileId The ID of the profile to retrieve headers.
     * @return The headers of the resource and HTTP status code 200 (OK).
     */
    @RequestMapping(value = "{id}", method = RequestMethod.HEAD)
    public ResponseEntity<?> resourceHeaders(@PathVariable("id") int profileId){
        // You can customize the headers to include metadata about the resource.
        HttpHeaders headers = new HttpHeaders();
        // Add any necessary headers
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    /**
     * REST endpoint to update specific fields of an existing profile.
     *
     * @param profileId The ID of the profile to update.
     * @param profile   The partial profile data to update.
     * @return The updated profile and HTTP status code 200 (OK) if successful.
     */
    @PatchMapping("{id}")
    public ResponseEntity<Profile> updatePartialProfile(@PathVariable("id") int profileId, @RequestBody Profile profile) {
        Profile existingProfile = profileService.getProfileById(profileId);
        if (existingProfile == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        /* update fields of the profile */
        if (profile.getUsername() != null) {
            existingProfile.setUsername(profile.getUsername());
        }
        if (profile.getEmail() != null) {
            existingProfile.setEmail(profile.getEmail());
        }
        /* will continue for all columns */

        Profile updatedProfile = profileService.updateProfile(existingProfile);
        return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
    }
}
