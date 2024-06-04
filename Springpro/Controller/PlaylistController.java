package com.Springpro.Springpro.Controller;

import com.Springpro.Springpro.Entity.Playlist;
import com.Springpro.Springpro.Service.PlaylistService;
import com.Springpro.Springpro.Service.PlaylistServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("api/playlists")
public class PlaylistController {
    private final PlaylistServiceImpl playlistService;

    @PostMapping
    public ResponseEntity<Playlist> createPlaylist(@RequestBody Playlist playlist){
        Playlist savedPlaylist = playlistService.createPlaylist(playlist);
        return new ResponseEntity<>(savedPlaylist, HttpStatus.CREATED);
    }


    @GetMapping("{id}")
    public ResponseEntity<Playlist> getPlaylistById(@PathVariable("id") int playlistId){
        Playlist playlist = playlistService.getPlaylistById(playlistId);
        return new ResponseEntity<>(playlist, HttpStatus.OK);
    }

    @GetMapping("profile/{profileId}")
    public ResponseEntity<List<Playlist>> getPlaylistsByProfileId(@PathVariable("profileId") int profileId){
        List<Playlist> playlists = playlistService.getPlaylistsByProfileId(profileId);
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Playlist> updatePlaylist(@PathVariable("id") int playlistId, @RequestBody Playlist playlist){
        playlist.setId(playlistId);
        Playlist updatedPlaylist = playlistService.updatePlaylist(playlist);
        return new ResponseEntity<>(updatedPlaylist, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePlaylist(@PathVariable("id") int playlistId){
        playlistService.deletePlaylist(playlistId);
        return new ResponseEntity<>("Playlist successfully deleted!", HttpStatus.OK);
    }
}
