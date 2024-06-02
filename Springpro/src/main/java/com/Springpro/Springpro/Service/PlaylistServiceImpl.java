package com.Springpro.Springpro.Service;

import com.Springpro.Springpro.Entity.Playlist;
import com.Springpro.Springpro.Entity.Profile;
import com.Springpro.Springpro.Repository.PlaylistRepository;
import com.Springpro.Springpro.Repository.ProfileRepository;
import lombok.AllArgsConstructor;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlaylistServiceImpl {
    private final PlaylistRepository playlistRepository;
    private final ProfileRepository profileRepository;

    public Playlist createPlaylist(Playlist playlist) {
        Profile profile = profileRepository.findById(playlist.getProfile().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));
        playlist.setProfile(profile);
        return playlistRepository.save(playlist);
    }

    public Playlist getPlaylistById(int playlistId) {
        return playlistRepository.findById(playlistId).orElse(null);
    }

    public List<Playlist> getPlaylistsByProfileId(int profileId) {
        return playlistRepository.findByProfileId(profileId);
    }

    public Playlist updatePlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    public void deletePlaylist(int playlistId) {
        playlistRepository.deleteById(playlistId);
    }
}

