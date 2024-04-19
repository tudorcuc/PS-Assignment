package com.Springpro.Springpro.Repository;

import com.Springpro.Springpro.Entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The SongRepository interface provides methods for accessing and managing Song entities in the database.
 * It extends the JpaRepository interface, which provides CRUD (Create, Read, Update, Delete) operations for Song entities.
 */
public interface SongRepository extends JpaRepository<Song, Integer> {
}
