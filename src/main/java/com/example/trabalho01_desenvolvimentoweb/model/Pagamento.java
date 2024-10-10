package com.example.trabalho01_desenvolvimentoweb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import javax.validation.constraints.Positive;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codPagamento;

    @NotNull(message = "O ano é obrigatório.")
    @Min(value = 1900, message = "O ano deve ser maior que 1900.")
    @Max(value = 2100, message = "O ano deve ser menor que 2100.")
    private Integer ano;

    @NotNull(message = "O mês é obrigatório.")
    @Min(value = 1, message = "O mês deve ser entre 1 e 12.")
    @Max(value = 12, message = "O mês deve ser entre 1 e 12.")
    private Integer mes;

    @NotNull(message = "O valor é obrigatório.")
    @Positive(message = "O valor deve ser positivo.")
    @Column(precision = 10, scale = 2)
    private BigDecimal valor;

    // Adicionar o campo cod_jogador que se refere ao ID do jogador
    @Column(name = "cod_jogador")
    @NotNull(message = "O jogador é obrigatório.")
    private Long cod_jogador;

    @ManyToOne
    @JoinColumn(name = "cod_jogador", insertable = false, updatable = false)
    @JsonIgnore // Adicione esta anotação
    private Jogador jogador;

    // Getters e Setters

    public Long getCodPagamento() {
        return codPagamento;
    }

    public void setCodPagamento(Long codPagamento) {
        this.codPagamento = codPagamento;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Long getCod_jogador() {
        return cod_jogador;
    }

    public void setCod_jogador(Long cod_jogador) {
        this.cod_jogador = cod_jogador;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }
}
