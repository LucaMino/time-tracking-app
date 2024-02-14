package com.sideproject.timetrackingapp.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sideproject.timetrackingapp.dto.LoginDto;
import com.sideproject.timetrackingapp.dto.SignUpDto;
import com.sideproject.timetrackingapp.entity.Role;
import com.sideproject.timetrackingapp.entity.User;
import com.sideproject.timetrackingapp.repository.RoleRepository;
import com.sideproject.timetrackingapp.repository.UserRepository;

@RestController
@RequestMapping("/api") // route group api
public class AuthController 
{
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    /**
     * authenticates a user using the provided login credentials
     * 
     * @param loginDto The LoginDto object containing the username and password for authentication
     * @return ResponseEntity<String> indicating the status of the authentication attempt
     */
    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto)
    {
        /**
         * authenticationManager is responsible for authenticating the user
         * 
         * @param loginDto loginDto object containing the username and password for authentication
         * @return Authentication object representing the authenticated user's identity
         * @throws AuthenticationException If the authentication process fails
         * 
         */
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword())
        );

        // set the authenticated user's security context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // return a ResponseEntity
        return new ResponseEntity<>(
            "User login successfully!...", 
            HttpStatus.OK
        );
    }

    /**
     * 
     * @param signUpDto
     * @return 
     */
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto)
    {
        // checking for email exists in a database
        if (userRepository.existsByEmail(signUpDto.getEmail()))
        {
            return new ResponseEntity<>("Email is already exist!", HttpStatus.BAD_REQUEST);
        }

        // creating user object
        User user = new User();
        // user.setName(signUpDto.getName());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

        Role roles = roleRepository.findByName("ROLE_ADMIN").get();

        user.setRoles(Collections.singleton(roles));

        userRepository.save(user);

        return new ResponseEntity<>(
            "User is registered successfully!", 
            HttpStatus.OK
        );
    }
}
