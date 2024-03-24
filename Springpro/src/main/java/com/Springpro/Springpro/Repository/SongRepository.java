package com.Springpro.Springpro.Repository;

import com.Springpro.Springpro.Entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Integer> {
}
