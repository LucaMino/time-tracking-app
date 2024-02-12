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
     * finds a user by username or email
     * 
     * @param username
     * @param email
     * @return The user found by username or email, or null if no user is found.
     */
    User findByUsernameOrEmail(String username, String email);
}
