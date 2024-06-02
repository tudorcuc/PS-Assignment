import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { Carousel } from 'react-responsive-carousel';
import 'react-responsive-carousel/lib/styles/carousel.min.css';
import './Home.css';

const Home = () => {
  const navigate = useNavigate();
  const profile = JSON.parse(localStorage.getItem("profile"));
  const [recommendedSong, setRecommendedSong] = useState(null);
  const [selectedGenre, setSelectedGenre] = useState("Dance");

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
