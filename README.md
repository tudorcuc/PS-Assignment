[Music Recommendation Platform.md](https://github.com/tudorcuc/PS-Assigment/files/14675841/Music.Recommendation.Platform.md)

# Music Streaming Platform
## 

This project aims to develop a platform that recommends new music to users based on their preferences. It utilizes a database to store user profiles, listening history, and music data.

## Features

- Personalized music recommendations based on user preferences and listening history.
- User registration and profile management.
- Database management for storing user profiles, listening history, and music data.
- Search functionality to discover new music based on various criteria.

## Tech

- Programming Languages: Java
- Database: MySQL
- Frontend: Not decided yet

## Usage
1. Register as a new user or log in with existing credentials.
2. Explore the available features such as searching for music, viewing recommendations, and managing your profile.
3. Add music to your albums to create personalized collections.
4. Enjoy discovering new music tailored to your tastes!

## Observer Pattern Implementation

In this project, we've leveraged the Observer design pattern to efficiently manage notifications and updates within the system. The Observer pattern facilitates a one-to-many dependency relationship between objects, where multiple observers (listeners) are notified automatically of any state changes in the subject (publisher).

### How it Works

- **Subject (Publisher)**: In our implementation, the subject represents the component responsible for tracking changes in the music database or user preferences. Whenever there's a relevant change, the subject notifies all registered observers.
  
- **Observers (Listeners)**: Observers are entities interested in receiving notifications about changes in the system. In our case, these could include components responsible for generating personalized music recommendations, updating user profiles, or refreshing the user interface.

### Benefits

Utilizing the Observer pattern offers several advantages:

- **Loose Coupling**: By decoupling the subject from its observers, we ensure that changes in one component don't directly impact others. This promotes modularity and flexibility within our system.

- **Scalability**: Adding new observers or modifying existing ones becomes simpler as they're independent of each other and the subject.

- **Real-time Updates**: With the Observer pattern, our system can provide real-time updates to users, ensuring that they receive timely recommendations and notifications.

### Example Scenario

Consider a scenario where a user adds a new music genre to their preferences. With the Observer pattern, the system's recommendation engine, profile manager, and UI components can be notified of this change simultaneously. The recommendation engine can update its algorithms accordingly, the profile manager can adjust the user's profile, and the UI can reflect the changes instantly.

### Implementation Details

Our implementation of the Observer pattern adheres to the following key principles:

- **Registration and Deregistration**: Observers can dynamically register and deregister themselves with the subject based on their relevance to the current state of the system.

- **Event Handling**: The subject efficiently manages the propagation of events to all registered observers, ensuring that each observer receives relevant notifications in a timely manner.
