package com.example.models;

import jakarta.persistence.*;

@Entity
public class SubCategory
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
