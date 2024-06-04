import React from 'react';
import { BrowserRouter as Router, Route, Routes, Link, useLocation } from 'react-router-dom';
import Home from './pages/Home';
import Playlists from './pages/Playlists';
import Login from './pages/Login';
import './App.css';
import logo from './logo.png';
import AddPlaylist from './pages/AddPlaylist';

function App() {
  const profile = JSON.parse(localStorage.getItem("profile"));
  const profileId = profile ? profile.id : null;
  const handleLogout = () => {
    localStorage.removeItem("profile");
    window.location.href = '/login';
  };

  return (
    <Router>
      <div className="app">
        <nav className="navbar">
          <div className="logo">
            <img src={logo} alt="Logo" className="logo-img" />
            SONAR
          </div>
          <div className="nav-links">
            <Link to="/">Home</Link>
            <Link to="/playlists">Playlists</Link>
            {profile ? (
              <>
                <span className="username">{profile.username}</span>
                <button className="logout-btn" onClick={handleLogout}>Logout</button>
              </>
            ) : (
              <Link to="/login">Authentication</Link>
            )}
          </div>
        </nav>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/add-playlist" element={<AddPlaylist profileId={profileId} />} />
          <Route path="/playlists" element={<Playlists profileId={profileId} />} />
          <Route path="/login" element={<Login />} />
        </Routes>
      </div>
    </Router> 
  );
}

export default App;
