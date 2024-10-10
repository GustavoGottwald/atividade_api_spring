package com.example.trabalho01_desenvolvimentoweb.repository;

import com.example.trabalho01_desenvolvimentoweb.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Integer> {
}