import React, { useState, useEffect } from 'react';

const Playlists = ({ profileId }) => {
    const [name, setName] = useState('');
    const [songs, setSongs] = useState([]);
    const [availableSongs, setAvailableSongs] = useState([]);
    const [playlists, setPlaylists] = useState([]);

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
        <div>
            <h2>Your Playlists</h2>
            <div>
                <input
                    type="text"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                    placeholder="Playlist Name"
                />
                {/* Add code to select songs */}
                <button onClick={handleAddPlaylist}>Add Playlist</button>
            </div>
        </div>
    );
};

export default Playlists;
