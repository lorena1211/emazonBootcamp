package com.example.emazon.infrastructure.persistence.jpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JpaCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 50)
    private String name;

    @Column(length = 90)
    private String description;
}

