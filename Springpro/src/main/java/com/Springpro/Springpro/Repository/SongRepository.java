package com.Springpro.Springpro.Repository;

import com.Springpro.Springpro.Entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The SongRepository interface provides methods for accessing and managing Song entities in the database.
 * It extends the JpaRepository interface, which provides CRUD (Create, Read, Update, Delete) operations for Song entities.
 */
@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {
    // Add this method in SongRepository interface
    List<Song> findByGenre(String genre);

}
