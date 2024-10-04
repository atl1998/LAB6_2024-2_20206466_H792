package com.example.lab6_20206466.repository;

import com.example.lab6_20206466.entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {
}
