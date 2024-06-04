
import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { Carousel } from 'react-responsive-carousel';
import 'react-responsive-carousel/lib/styles/carousel.min.css';
import './Home.css';

const Home = () => {
  const navigate = useNavigate();
  const profile = JSON.parse(localStorage.getItem("profile"));
  const [recommendedSong, setRecommendedSong] = useState(null);
  const [selectedGenre, setSelectedGenre] = useState("Dance");
  const [isAdmin, setIsAdmin] = useState(false);
  const [newSongInfo, setNewSongInfo] = useState({
    title: '',
    artist: '',
    genre: ''
  });
  const [allSongs, setAllSongs] = useState([]);

  useEffect(() => {
    if (profile && profile.username === "admin") {
      setIsAdmin(true);
    } else {
      setIsAdmin(false);
    }
  }, [profile]);

  useEffect(() => {
    // Fetch all songs when component mounts
    fetchAllSongs();
  }, []);

  const fetchAllSongs = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/songs');
      if (response.ok) {
        const songs = await response.json();
        setAllSongs(songs);
      } else {
        console.error('Error fetching songs');
      }
    } catch (error) {
      console.error('Error fetching songs:', error);
    }
  };

  const handleAddSong = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/songs', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(newSongInfo),
      });
      if (response.ok) {
        // Song added successfully
        alert('New song added successfully!');
        // Clear the form fields
        setNewSongInfo({
          title: '',
          artist: '',
          genre: ''
        });
        // Fetch all songs again to update the list
        fetchAllSongs();
      } else {
        // Error occurred while adding song
        alert('Error adding new song');
      }
    } catch (error) {
      console.error('Error adding song:', error);
      alert('Error adding new song');
    }
  };

  // Function to handle input change for new song form
  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setNewSongInfo((prevInfo) => ({
      ...prevInfo,
      [name]: value
    }));
  };

  const handleLogout = () => {
    localStorage.removeItem("profile");
    navigate('/login');
  };

  const recommendSong = async () => {
    try {
      const response = await fetch(`http://localhost:8080/api/songs/recommend?genre=${selectedGenre}`);
      if (response.ok) {
        const song = await response.json();
        setRecommendedSong(song);
      } else {
        setRecommendedSong(null);
      }
    } catch (error) {
      console.error('Error fetching recommended song:', error);
    }
  };

  const songs = [
    { 
      title: 'On My Mind', 
      artist: 'Modestep & Hedex',
      streams: '15,000,000',
      backgroundClass: 'background-1'
    },
    { 
      title: 'Closer', 
      artist: 'The Chainsmokers feat. Halsey',
      streams: '2,300,000,000',
      backgroundClass: 'background-2'
    },
    { 
      title: 'Rumble', 
      artist: 'Skrillex & Fred Again...',
      streams: '31,000,000',
      backgroundClass: 'background-3'
    },
    { 
      title: 'Insidious', 
      artist: 'Subtronics & Grabbitz',
      streams: '5,000,000',
      backgroundClass: 'background-4'
    },
    { 
      title: 'Stay', 
      artist: 'Zedd & Alessia Cara',
      streams: '4,200,000,000',
      backgroundClass: 'background-5'
    },
    { 
      title: 'Loco Contigo', 
      artist: 'J Balvin & Skrillex',
      streams: '280,000,000',
      backgroundClass: 'background-6'
    },
    { 
      title: 'Realise', 
      artist: 'Sota & Primate',
      streams: '600,000',
      backgroundClass: 'background-7'
    },
  ];

  return (
    <div className="home">
      {isAdmin && (
        <div className="add-song-form">
          <h2>Add New Song</h2>
          <div>
            <label>Title:</label>
            <input
              className="styled-input"
              type="text"
              name="title"
              value={newSongInfo.title}
              onChange={handleInputChange}
              placeholder="Enter title"
            />
          </div>
          <div>
            <label>Artist:</label>
            <input
              className="styled-input"
              type="text"
              name="artist"
              value={newSongInfo.artist}
              onChange={handleInputChange}
              placeholder="Enter artist"
            />
          </div>
          <div>
            <label>Genre:</label>
            <input
              className="styled-input"
              type="text"
              name="genre"
              value={newSongInfo.genre}
              onChange={handleInputChange}
              placeholder="Enter genre"
            />
          </div>
          <button className="styled-button" onClick={handleAddSong}>Add Song</button>
        </div>
      )}
      <div className="hero">
        <h1>MUSIC IS THE ART OF THE PROPHETS AND THE GIFTS OF GOD</h1>
        <p>Musica est lux animae.</p>
        {profile ? (
          <div>
            <p>Welcome, {profile.username}</p>
            <button className="join-btn" onClick={handleLogout}>Log Out</button>
          </div>
        ) : (
          <button className="join-btn" onClick={() => navigate('/login')}>Join Now!</button>
        )}
      </div>
      {profile && (
        <div className="recommendation-section">
          <h2>Recommend me new music</h2>
          <div className="genre-select">
            <label htmlFor="genre">Choose a genre:</label>
            <select id="genre" value={selectedGenre} onChange={(e) => setSelectedGenre(e.target.value)}>
              <option value="Dance">Dance</option>
              <option value="Pop">Pop</option>
              <option value="Drum and Bass">Drum & Bass</option>
            </select>
            <button className="recommend-button" onClick={recommendSong}>Recommend</button>
          </div>
          {recommendedSong && (
            <div className="recommended-song">
              <h3>Recommended Song</h3>
              <p><strong>Title:</strong> {recommendedSong.title}</p>
              <p><strong>Artist:</strong> {recommendedSong.artist}</p>
            </div>
          )}
        </div>
      )}
      {isAdmin && (
        <div className="admin-section">
          <h2>All Songs</h2>
          <div className="all-songs">
            {allSongs.map((song, index) => (
              <div key={index} className="song-item">
                <div className="song-info">
                  <h3 className="song-title">{song.title}</h3>
                  <p className="song-artist">{song.artist}</p>
                  <p className="song-genre">{song.genre}</p>
                </div>
              </div>
            ))}
          </div>
        </div>
      )}
      <div className="popular-songs">
        <h2>Our Popular Songs</h2>
        <Carousel showThumbs={false} infiniteLoop useKeyboardArrows autoPlay>
          {songs.map((song, index) => (
            <div key={index} className={`song-item ${song.backgroundClass}`}>
              <div className="song-info">
                <h3 className="song-title">{song.title}</h3>
                <p className="song-artist">{song.artist}</p>
                <p className="song-streams">{song.streams} streams</p>
                <button className="play-button">Play</button>
              </div>
            </div>
          ))}
        </Carousel>
      </div>
    </div>
  );
};

export default Home;
