package com.Springpro.Springpro.Service;

import com.Springpro.Springpro.Entity.Profile;
import com.Springpro.Springpro.Observer.ProfileObserver;
import com.Springpro.Springpro.Repository.ProfileRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Unit tests for the ProfileServiceImpl class.
 */
public class ProfileServiceImplTests {

    @Mock
    private ProfileRepository profileRepository;

    @Mock
    private List<ProfileObserver> observers;

    private ProfileServiceImpl profileService;

    /**
     * Sets up the test environment before each test method.
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        profileService = new ProfileServiceImpl(profileRepository, observers);
    }

    /**
     * Tests the createProfile method.
     */
    @Test
    public void createProfileTest() {
        Profile profile = new Profile(1, "username", "mail@test.com", "password");
        profileService.createProfile(profile);
        verify(profileRepository).save(profile);
    }

    /**
     * Tests the getProfileById method.
     */
    @Test
    public void getProfileTest() {
        Profile profile = new Profile(1, "username", "mail@test.com", "password");
        when(profileRepository.findById(1)).thenReturn(Optional.of(profile));

        Profile retrievedProfile = profileService.getProfileById(1);

        verify(profileRepository).findById(1);
        assertEquals(profile, retrievedProfile);
    }

    /**
     * Tests the updateProfile method.
     */
    @Test
    public void updateProfileTest() {
        Profile profile = new Profile(1, "user", "mail", "pass");
        profileService.createProfile(profile);
        profileService.updateProfile(profile);
        verify(profileRepository).save(profile);
        verify(profileRepository).findById(profile.getId());
    }

    /**
     * Tests the deleteProfile method.
     */
    @Test
    public void deleteProfileTest() {
        Profile profile = new Profile(1, "username", "mail@test.com", "password");
        when(profileRepository.findById(1)).thenReturn(Optional.of(profile));

        profileService.deleteProfile(1);

        verify(profileRepository).deleteById(1);
    }

    /**
     * Cleans up the test environment after each test method.
     */
    @After
    public void tearDown() {
        Mockito.reset(profileRepository);
    }
}
