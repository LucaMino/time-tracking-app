package com.sideproject.timetrackingapp.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sideproject.timetrackingapp.entity.User;
import com.sideproject.timetrackingapp.repository.UserRepository;

/**
 * Service class that implements Spring Security's UserDetailsService interface
 * this class is responsible for loading user details from the database for authentication and authorization purposes
 */
@Service
public class UserDetail implements UserDetailsService 
{
    // Autowired annotation to automatically inject UserRepository dependency
    @Autowired
    UserRepository userRepo;

    /**
     * loads user details by username for authentication
     * 
     * @param username The username to load user details for
     * @return UserDetails object containing user details if the user is found.
     * @throws UsernameNotFoundException If no user is found with the specified username.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userRepo.findByEmail(username);
        
        if (user == null)
        {
            throw new UsernameNotFoundException("User not exists by Username");
        }
           
        Set<GrantedAuthority> authorities = user.getRoles().stream()
                .map((role) -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(
            username, user.getPassword(), authorities
        );
    }
}
