package com.sideproject.timetrackingapp.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sideproject.timetrackingapp.entity.Role;

/**
 * interface that defines a repository for the Role entity
 * Role represents the entity type, and Integer is the type of the ID variable
 */
public interface RoleRepository extends JpaRepository<Role, Integer> 
{
    /**
    * finds a role by the specified name
    * 
    * @param name name of the role to search
    * @return Optional containing the role with the specified name, if found; otherwise, an empty Optional
    * @throws IllegalArgumentException if the provided name is null
    */
    Optional<Role> findByName(String name);
}