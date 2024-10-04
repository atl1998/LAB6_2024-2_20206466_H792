package com.example.lab6_20206466.repository;
import com.example.lab6_20206466.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer>{

}

