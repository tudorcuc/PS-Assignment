package com.Springpro.Springpro.Entity;
import jakarta.persistence.*;
import lombok.*;

/**
 * The Profile class represents a profile entity in the application.
 * This class is mapped to the "Profile_DB" table in the database.
 */
@Getter
@Setter
@AllArgsConstructor
@Entity
@Data
@Table(name="Profile_DB")
@NoArgsConstructor
public class Profile {

    /**
     * The unique identifier for the profile.
     */
    @Id
    @Column(name="ID")
    @GeneratedValue
    private int id;

    /**
     * The username of the profile.
     */
    @Column(name="USERNAME", nullable = false)
    private String username;

    /**
     * The email of the profile.
     */
    @Column(name="EMAIL",nullable = false)
    private String email;

    /**
     * The password of the account.
     */
    @Column(name="PASSWORD",nullable = false)
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
