package com.Springpro.Springpro.Repository;

import com.Springpro.Springpro.Entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * The ProfileRepository interface provides methods for accessing and managing Profile entities in the database.
 * It extends the JpaRepository interface, which provides CRUD (Create, Read, Update, Delete) operations for Profile entities.
 */
@Repository
public interface ProfileRepository extends JpaRepository<Profile,Integer> {

}

