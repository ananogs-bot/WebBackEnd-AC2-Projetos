package com.facens.projetos_ac2.controller;

import com.facens.projetos_ac2.entity.Funcionario;
import com.facens.projetos_ac2.entity.Setor;
import com.facens.projetos_ac2.repository.FuncionarioRepository;
import com.facens.projetos_ac2.repository.SetorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository repository;

    @Autowired
    private SetorRepository setorRepository;

    // GET ALL
    @GetMapping
    public List<Funcionario> listar() {
        return repository.findAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Funcionario buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
    }

    // POST
    @PostMapping
    public Funcionario criar(@RequestBody Funcionario funcionario) {
        return repository.save(funcionario);
    }

    // PUT
    @PutMapping("/{id}")
    public Funcionario atualizar(@PathVariable Long id,
                                 @RequestBody Funcionario funcionarioAtualizado) {

        Funcionario funcionario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        funcionario.setNome(funcionarioAtualizado.getNome());

        if (funcionarioAtualizado.getSetor() != null) {

            Long setorId = funcionarioAtualizado.getSetor().getId();

            Setor setor = setorRepository.findById(setorId)
                    .orElseThrow(() -> new RuntimeException("Setor não encontrado"));

            funcionario.setSetor(setor);
        }

        return repository.save(funcionario);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}