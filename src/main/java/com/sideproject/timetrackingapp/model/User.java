package com.sideproject.timetrackingapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")

public class User 
{
    // id
    @Id // define primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // define auto increment
    private Long id; // long more bit than int

    // email
    @Column(nullable = false, unique = true, length = 45)
    private String email;

    // password
    @Column(nullable = false, length = 64)
    private String password;
     
    // firstName
    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;
     
    // lastName
    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;

    /* 
    * getters and setters methods
    */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }; 
}
