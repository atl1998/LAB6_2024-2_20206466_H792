package com.example.lab6_20206466.entity;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "peliculas")
@Getter
@Setter
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "peliculaid")
    private int peliculaid;
    @Column(nullable = false)
    @Size(min=3, max = 100,message = "El nombre debe tener entre 3 a 100 caracteres")
    private String titulo;
    @PastOrPresent(message="la fecha de estreno debe ser pasada o presente")
    private Date fechaestreno;
    @Positive(message ="la duracion debe ser un numero positivo")
    private int duracionminutos;
    @ManyToMany(mappedBy = "peliculas")
    private List<Director> directores;
}
