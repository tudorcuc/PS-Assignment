package com.Springpro.Springpro.Service;

import com.Springpro.Springpro.Entity.Song;
import com.Springpro.Springpro.Observer.SongObserver;
import com.Springpro.Springpro.Repository.SongRepository;
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
 * Unit tests for the SongServiceImpl class.
 */
public class SongServiceImplTests {

    @Mock
    private SongRepository songRepository;

    @Mock
    private List<SongObserver> observers;

    private SongServiceImpl songService;

    /**
     * Sets up the test environment before each test method.
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        songService = new SongServiceImpl(songRepository, observers);
    }

    /**
     * Tests the createSong method.
     */
    @Test
    public void createSongTest() {
        Song song = new Song(1, 1, "Title", "Artist", "Genre", "20.01.2009");
        songService.createSong(song);
        verify(songRepository).save(song);
    }

    /**
     * Tests the getSongById method.
     */
    @Test
    public void getSongTest() {
        Song song = new Song(1, 1, "Title", "Artist", "Genre", "20.01.2009");
        when(songRepository.findById(1)).thenReturn(Optional.of(song));

        Song retrievedSong = songService.getSongById(1);

        verify(songRepository).findById(1);
        assertEquals(song, retrievedSong);
    }

    /**
     * Tests the updateSong method.
     */
    @Test
    public void updateSongTest() {
        Song song = new Song(1, 1, "Title", "Artist", "Genre", "20.01.2009");
        songService.createSong(song);
        songService.updateSong(song);
        verify(songRepository).save(song);
        verify(songRepository).findById(song.getSongId());
    }

    /**
     * Tests the deleteSong method.
     */
    @Test
    public void deleteSongTest() {
        Song song = new Song(1, 1, "Title", "Artist", "Genre", "20.01.2009");
        when(songRepository.findById(1)).thenReturn(Optional.of(song));

        songService.deleteSong(1);

        verify(songRepository).deleteById(1);
    }

    /**
     * Cleans up the test environment after each test method.
     */
    @After
    public void tearDown() {
        Mockito.reset(songRepository);
    }
}
