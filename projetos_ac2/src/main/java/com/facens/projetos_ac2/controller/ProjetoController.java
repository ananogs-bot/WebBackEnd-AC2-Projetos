package com.facens.projetos_ac2.controller;


import com.facens.projetos_ac2.entity.Projeto;
import com.facens.projetos_ac2.service.ProjetoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService service;

    // GET
    @GetMapping
    public List<Projeto> listar() {
        return service.listar();
    }

    // GET POR ID
    @GetMapping("/{id}")
    public Projeto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // GET POR PERIODO
    @GetMapping("/periodo")
    public List<Projeto> buscarPorPeriodo(
            @RequestParam LocalDate dataInicio,
            @RequestParam LocalDate dataFim) {

        return service.buscarPorPeriodo(dataInicio, dataFim);
    }

    // GET PROJETOS POR FUNCIONÁRIO
    @GetMapping("/funcionario/{id}")
    public List<Projeto> buscarPorFuncionario(@PathVariable Long id) {
        return service.buscarPorFuncionario(id);
    }

    // POST
    @PostMapping
    public Projeto criar(@RequestBody Projeto projeto) {
        return service.criar(projeto);
    }

    // PUT
    @PutMapping("/{id}")
    public Projeto atualizar(@PathVariable Long id,
                             @RequestBody Projeto projetoAtualizado) {

        return service.atualizar(id, projetoAtualizado);
    }

    // PUT PARA ALTERAR FUNCIONÁRIOS A UM PROJETO
     @PutMapping("/{id}/funcionarios")
    public Projeto adicionarFuncionarios(
            @PathVariable Long id,
            @RequestBody List<Long> funcionariosIds) {

        return service.adicionarFuncionarios(id, funcionariosIds);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}