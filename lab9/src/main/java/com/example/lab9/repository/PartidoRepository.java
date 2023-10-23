package com.example.lab9.repository;

import com.example.lab9.entity.Partido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartidoRepository extends JpaRepository<Partido,Integer> {
}
