package com.example.trabalho01_desenvolvimentoweb.controller;

import com.example.trabalho01_desenvolvimentoweb.model.Jogador;
import com.example.trabalho01_desenvolvimentoweb.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    @Autowired
    private JogadorRepository jogadorRepository;

    @GetMapping
    public List<Jogador> listarTodos() {
        return jogadorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Jogador> buscarPorId(@PathVariable Integer id) {
        return jogadorRepository.findById(id);
    }

    @PostMapping
    public Jogador criarJogador(@RequestBody Jogador jogador) {
        return jogadorRepository.save(jogador);
    }

    @PutMapping("/{id}")
    public Jogador atualizarJogador(@PathVariable Integer id, @RequestBody Jogador jogadorAtualizado) {
        return jogadorRepository.findById(id)
                .map(jogador -> {
                    jogador.setNome(jogadorAtualizado.getNome());
                    jogador.setEmail(jogadorAtualizado.getEmail());
                    jogador.setDataNasc(jogadorAtualizado.getDataNasc());
                    return jogadorRepository.save(jogador);
                }).orElseGet(() -> {
                    jogadorAtualizado.setCodJogador(id);
                    return jogadorRepository.save(jogadorAtualizado);
                });
    }

    @DeleteMapping("/{id}")
    public void deletarJogador(@PathVariable Integer id) {
        jogadorRepository.deleteById(id);
    }
}
