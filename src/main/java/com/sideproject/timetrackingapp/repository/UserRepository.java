package com.sideproject.timetrackingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sideproject.timetrackingapp.entity.User;

/**
 * Interface that defines a repository for the User entity
 * User represents the entity type, and Long is the type of the ID variable
 */
public interface UserRepository extends JpaRepository<User, Long> 
{    
    /**
     * finds a user by email
     * 
     * @param email
     * @return The user found by email, or null if no user is found.
     */
    User findByEmail(String email);

    /**
     * 
     * @param email
     * @return
     */
    boolean existsByEmail(String email);
}
