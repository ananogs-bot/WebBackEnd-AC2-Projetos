package com.facens.projetos_ac2.controller;

import com.facens.projetos_ac2.entity.Funcionario;
import com.facens.projetos_ac2.service.FuncionarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    // GET
    @GetMapping
    public List<Funcionario> listar() {
        return service.listar();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Funcionario buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // POST
    @PostMapping
    public Funcionario criar(@RequestBody Funcionario funcionario) {
        return service.criar(funcionario);
    }

    // PUT
    @PutMapping("/{id}")
    public Funcionario atualizar(
            @PathVariable Long id,
            @RequestBody Funcionario funcionarioAtualizado) {

        return service.atualizar(id, funcionarioAtualizado);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}