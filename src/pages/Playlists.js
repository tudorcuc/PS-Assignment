import React, { useState, useEffect } from 'react';
import './Playlists.css';
import { useNavigate, useLocation } from 'react-router-dom';

const Playlists = ({ profileId }) => {
    const [name, setName] = useState('');
    const [songs, setSongs] = useState([]);
    const [availableSongs, setAvailableSongs] = useState([]);
    const [playlists, setPlaylists] = useState([]);
    const navigate = useNavigate();
    const [profile, setProfile] = useState(null);
    const location = useLocation();

    useEffect(() => {
        const fetchPlaylists = async () => {
            try {
                const response = await fetch(`http://localhost:8080/api/playlists/profile/${profileId}`);
                if (response.ok) {
                    const data = await response.json();
                    setPlaylists(data);
                } else {
                    console.error('Failed to fetch playlists');
                }
            } catch (error) {
                console.error('Error:', error);
            }
        };

        fetchPlaylists();
    }, [profileId]);

    useEffect(() => {
        const fetchSongs = async () => {
            try {
                const response = await fetch('http://localhost:8080/api/songs');
                if (response.ok) {
                    const data = await response.json();
                    setAvailableSongs(data);
                } else {
                    console.error('Failed to fetch songs');
                }
            } catch (error) {
                console.error('Error:', error);
            }
        };

        fetchSongs();
    }, []);

    useEffect(() => {
        const storedProfile = JSON.parse(localStorage.getItem("profile"));
        if (!storedProfile) {
          navigate(`/login?redirectedFromPlaylists=true`);
        } else {
          setProfile(storedProfile);
        }
      }, [navigate]);
    
      if (!profile) {
        return <div>Loading...</div>;
      }

    const handleAddPlaylist = async () => {
        const playlist = {
            name,
            profile: { id: profileId },
            songs: songs.map(songId => ({ id: songId }))
        };

        try {
            const response = await fetch('http://localhost:8080/api/playlists', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(playlist)
            });
            if (response.ok) {
                const newPlaylist = await response.json();
                setPlaylists([...playlists, newPlaylist]);
                setName('');
                setSongs([]);
            } else {
                console.error('Failed to create playlist');
            }
        } catch (error) {
            console.error('Error:', error);
        }
    };

    const handleSongSelection = (songId) => {
        if (songs.includes(songId)) {
            setSongs(songs.filter(id => id !== songId));
        } else {
            setSongs([...songs, songId]);
        }
    };

    return (
        <div className="playlists-container">
            <h2 className="playlists-title">Your Playlists</h2>
            <div className="playlist-form">
                <input
                    type="text"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                    placeholder="Playlist Name"
                />
                <div className="song-list">
                    {availableSongs.map(song => (
                        <div key={song.id} className="song-item">
                            <input
                                type="checkbox"
                                checked={songs.includes(song.id)}
                                onChange={() => handleSongSelection(song.id)}
                            />
                            <span>{song.title}</span>
                        </div>
                    ))}
                </div>
                <button onClick={handleAddPlaylist}>Add Playlist</button>
            </div>
            <div className="playlist-list">
                {playlists.map(playlist => (
                    <div key={playlist.id} className="playlist-item">
                        {playlist.name}
                    </div>
                ))}
            </div>
        </div>
    );
};

export default Playlists;
