package com.facens.projetos_ac2.controller;

import com.facens.projetos_ac2.entity.Setor;
import com.facens.projetos_ac2.repository.SetorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/setores")
public class SetorController {

    @Autowired
    private SetorRepository repository;

    @GetMapping
    public List<Setor> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Setor> buscarPorId(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public Setor salvar(@RequestBody Setor setor) {
        return repository.save(setor);
    }

    @PutMapping("/{id}")
    public Setor atualizar(@PathVariable Long id, @RequestBody Setor setor) {

        setor.setId(id);

        return repository.save(setor);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}