package com.facens.projetos_ac2.controller;

import com.facens.projetos_ac2.entity.Funcionario;
import com.facens.projetos_ac2.entity.Projeto;
import com.facens.projetos_ac2.repository.FuncionarioRepository;
import com.facens.projetos_ac2.repository.ProjetoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoRepository repository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    // GET ALL
    @GetMapping
    public List<Projeto> listar() {
        return repository.findAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Projeto buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));
    }

    // POST
    @PostMapping
    public Projeto criar(@RequestBody Projeto projeto) {
        return repository.save(projeto);
    }

    // PUT
    @PutMapping("/{id}")
    public Projeto atualizar(@PathVariable Long id,
                             @RequestBody Projeto projetoAtualizado) {

        Projeto projeto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

        projeto.setDescricao(projetoAtualizado.getDescricao());

        return repository.save(projeto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }

    // ADICIONAR FUNCIONÁRIOS AO PROJETO
    @PutMapping("/{id}/funcionarios")
    public Projeto adicionarFuncionarios(
            @PathVariable Long id,
            @RequestBody List<Long> funcionariosIds) {

        Projeto projeto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

        List<Funcionario> funcionarios =
                funcionarioRepository.findAllById(funcionariosIds);

        projeto.setFuncionarios(funcionarios);

        return repository.save(projeto);
    }
}