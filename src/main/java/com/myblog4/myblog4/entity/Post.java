package com.myblog4.myblog4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="posts")
@AllArgsConstructor
@NoArgsConstructor

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String tittle;
    private String description;
    private String contenent;
}
