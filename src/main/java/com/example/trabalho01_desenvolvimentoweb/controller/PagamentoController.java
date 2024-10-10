package com.example.trabalho01_desenvolvimentoweb.controller;

import com.example.trabalho01_desenvolvimentoweb.model.Pagamento;
import com.example.trabalho01_desenvolvimentoweb.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @GetMapping
    public List<Pagamento> listarTodos() {
        return pagamentoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Pagamento> buscarPorId(@PathVariable Long id) {
        return pagamentoRepository.findById(id);
    }

    @PostMapping
    public Pagamento criarPagamento(@RequestBody Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    @PutMapping("/{id}")
    public Pagamento atualizarPagamento(@PathVariable Long id, @RequestBody Pagamento pagamentoAtualizado) {
        return pagamentoRepository.findById(id)
                .map(pagamento -> {
                    pagamento.setAno(pagamentoAtualizado.getAno());
                    pagamento.setMes(pagamentoAtualizado.getMes());
                    pagamento.setValor(pagamentoAtualizado.getValor());
                    pagamento.setJogador(pagamentoAtualizado.getJogador());
                    return pagamentoRepository.save(pagamento);
                }).orElseGet(() -> {
                    pagamentoAtualizado.setCodPagamento(id);
                    return pagamentoRepository.save(pagamentoAtualizado);
                });
    }

    @DeleteMapping("/{id}")
    public void deletarPagamento(@PathVariable Long id) {
        pagamentoRepository.deleteById(id);
    }
}
