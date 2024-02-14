package com.sideproject.timetrackingapp.entity;

import java.util.Set;
import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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

    /**
     * relationships
     */

    /**
     * users - roles
     * lazy collections are disabled, so role data is loaded immediately
     */
    // @ManyToMany
    // @LazyCollection(LazyCollectionOption.FALSE)
    // private Set<Role> roles;

    /**
     * getters and setters methods
     */

    public Long getId() 
    {
        return this.id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getPassword() 
    {
        return password;
    }
    
    public void setPassword(String password) 
    {
        this.password = password;
    }

    /* public Set<Role> getRoles() 
    {
        return roles;
    }
    
    public void setRoles(Set<Role> roles) 
    {
        this.roles = roles;
    } */
}
