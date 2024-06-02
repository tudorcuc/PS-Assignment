# Sonar - Music Recommendation Platform

## Overview

Sonar is a full-stack music recommendation platform designed to enhance user experience by providing personalized music recommendations, playlist management, and profile handling. The platform uses Spring Boot for the backend and a modern front-end framework to deliver a seamless user experience.

## Features

- **User Profiles**: Create and manage user profiles.
- **Playlists**: Create, update, delete, and retrieve playlists.
- **Music Recommendations**: Get personalized music recommendations based on user preferences and listening history.
- **Cross-Origin Resource Sharing (CORS)**: Enabled for seamless integration with various clients.

## Technologies Used

- **Backend**: Spring Boot, Spring Data JPA
- **Database**: MySQL
- **Frontend**: React.js
- **Other**: Lombok, RESTful API

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven
- Node.js (for frontend)

### Setup

1. **Backend Setup:**
    ```sh
    cd backend
    mvn install
    mvn spring-boot:run
    ```

2. **Frontend Setup:**
    ```sh
    cd frontend
    npm install
    npm start
    ```

3. **Access the application:**
    - Backend API: `http://localhost:8080`
    - Frontend: `http://localhost:3000`

## API Endpoints

### Profile Management

- **Create Profile**
    ```http
    POST /api/profiles
    ```

- **Get Profile by ID**
    ```http
    GET /api/profiles/{id}
    ```

- **Get All Profiles**
    ```http
    GET /api/profiles
    ```

- **Update Profile**
    ```http
    PUT /api/profiles/{id}
    ```

- **Delete Profile**
    ```http
    DELETE /api/profiles/{id}
    ```

### Playlist Management

- **Create Playlist**
    ```http
    POST /api/playlists
    ```

- **Get Playlist by ID**
    ```http
    GET /api/playlists/{id}
    ```

- **Get Playlists by Profile ID**
    ```http
    GET /api/playlists/profile/{profileId}
    ```

- **Update Playlist**
    ```http
    PUT /api/playlists/{id}
    ```

- **Delete Playlist**
    ```http
    DELETE /api/playlists/{id}
    ```

## Code Structure

### Backend

- **Controller**: Handles HTTP requests and responses.
- **Service**: Contains business logic.
- **Repository**: Manages database interactions.

### Frontend

- **Components**: UI components.
- **Services**: Handles API calls.
- **State Management**: Manages global state.


## Acknowledgements

- Spring Boot Documentation
- React/Vue.js/Angular Documentation
- Lombok Documentation
