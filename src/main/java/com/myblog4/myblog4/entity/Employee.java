package com.myblog4.myblog4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name="employees")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String designation;
    private String studies;
    private String experience;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private List<Project> projects;
}
