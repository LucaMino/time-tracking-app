package com.sideproject.timetrackingapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "organizations")
public class Organization 
{
    // id
    @Id // define primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // define auto increment
    private Long id; // long more bit than int
}
