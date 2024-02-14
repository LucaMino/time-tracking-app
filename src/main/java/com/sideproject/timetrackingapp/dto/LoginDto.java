package com.sideproject.timetrackingapp.dto;

/**
 * Data Transfer Object (DTO) representing login credentials
 * contains fields for username and password
 */
public class LoginDto 
{
    // setup attribute
    private String username;
    private String password;

    // default constructor
    public LoginDto() {}

    /**
     * getters and setters
     */

    public String getUsername() 
    {      
        return username;   
    }   

    public void setUsername(String username)
    {      
        this.username = username;   
    }   

    public String getPassword() 
    {      
        return password;   
    }   

    public void setPassword(String password) 
    {      
        this.password = password;   
    }
}