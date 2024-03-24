package com.Springpro.Springpro.Service;

import com.Springpro.Springpro.Entity.Song;

import java.util.List;

public interface SongService {

    Song creatSong(Song song);
    Song getSongById(int songId);
    List<Song> getAllSongs();
    Song updateProfile(Song song);
    void deleteSong(int songId);
}
