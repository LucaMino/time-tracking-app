package com.sideproject.timetrackingapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name="roles")

public class Role 
{
    // id
    @Id // define primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // define auto increment
    private Integer id;

    // name
    @Column(name = "name", nullable = false, length = 20)
    private String name;

    /* 
    * getters and setters methods
    */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
