import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './Login.css';

function Login() {
  const [isLogin, setIsLogin] = useState(true);
  const [formData, setFormData] = useState({
    username: '',
    email: '',
    password: '',
  });
  const [message, setMessage] = useState('');
  const navigate = useNavigate();

  const queryParams = new URLSearchParams(window.location.search);
  const redirectedFromPlaylists = queryParams.get('redirectedFromPlaylists');

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({ ...prevData, [name]: value }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (isLogin) {
      fetch("http://localhost:8080/api/profiles/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ username: formData.username, password: formData.password }),
      })
        .then(response => response.json().then(data => ({ status: response.status, body: data })))
        .then(res => {
          if (res.status === 200) {
            setMessage("Login successful");
            localStorage.setItem("profile", JSON.stringify({ username: formData.username }));
            navigate('/');
          } else {
            setMessage("Invalid username or password");
          }
        })
        .catch(error => {
          console.error("Error during login:", error);
          setMessage("Username or password is incorrect");
        });
    } else {
      fetch("http://localhost:8080/api/profiles", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(formData),
      })
        .then(response => response.json().then(data => ({ status: response.status, body: data })))
        .then(res => {
          if (res.status === 201) {
            setMessage("Account created successfully");
            setIsLogin(true);
          } else {
            setMessage("Error creating account");
          }
        })
        .catch(error => {
          console.error("Error during sign-up:", error);
          setMessage("An error occurred during sign-up");
        });
    }
  };

  return (
    <div className="login">
      <div className="login-container">
        {redirectedFromPlaylists && (
          <p>You need to log in to access the playlists page.</p>
        )}
        {message && <p>{message}</p>}
        {isLogin ? (
          <div className="form-container">
            <h1>Login</h1>
            <form onSubmit={handleSubmit}>
              <input
                type="text"
                name="username"
                placeholder="Username"
                value={formData.username}
                onChange={handleInputChange}
              />
              <input
                type="password"
                name="password"
                placeholder="Password"
                value={formData.password}
                onChange={handleInputChange}
              />
              <button type="submit">Login</button>
            </form>
            <p>
              Don't have an account?{' '}
              <span onClick={() => setIsLogin(false)}>Sign up</span>
            </p>
          </div>
        ) : (
          <div className="form-container">
            <h1>Sign Up</h1>
            <form onSubmit={handleSubmit}>
              <input
                type="text"
                name="username"
                placeholder="Username"
                value={formData.username}
                onChange={handleInputChange}
              />
              <input
                type="email"
                name="email"
                placeholder="Email"
                value={formData.email}
                onChange={handleInputChange}
              />
              <input
                type="password"
                name="password"
                placeholder="Password"
                value={formData.password}
                onChange={handleInputChange}
              />
              <button type="submit">Sign Up</button>
            </form>
            <p>
              Already have an account?{' '}
              <span onClick={() => setIsLogin(true)}>Login</span>
            </p>
          </div>
        )}
      </div>
    </div>
  );
}

export default Login;
