package com.example.trabalho01_desenvolvimentoweb.repository;

import com.example.trabalho01_desenvolvimentoweb.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}