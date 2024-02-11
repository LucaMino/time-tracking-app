package com.sideproject.timetrackingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sideproject.timetrackingapp.model.User;

public interface UserRepository extends JpaRepository<User, Long>
{
    
} 
