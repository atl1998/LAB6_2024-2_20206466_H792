package com.example.lab6_20206466.entity;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "directores")
@Getter
@Setter
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "directorId")
    private int peliculaid;
    private String nombre;
    private int telefono;
    private String nacionalidad;

    @JoinTable(
            name="peliculas_directores",joinColumns = @JoinColumn(name="directorId",nullable=false),
            inverseJoinColumns = @JoinColumn(name="peliculaId")
    )
    @ManyToMany(cascade=CascadeType.ALL)
    private List<Pelicula> peliculas;


}
