package com.Springpro.Springpro.Service;

import com.Springpro.Springpro.Entity.Playlist;
import java.util.List;

public interface PlaylistService {
    Playlist createPlaylist(Playlist playlist);
    Playlist addSongToPlaylist(int playlistId, int songId);
    Playlist removeSongFromPlaylist(int playlistId, int songId);
    List<Playlist> getPlaylistsByUser(int userId);
    void deletePlaylist(int playlistId);
}
