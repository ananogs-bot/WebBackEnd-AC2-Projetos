package com.facens.projetos_ac2.controller;

import com.facens.projetos_ac2.entity.Setor;
import com.facens.projetos_ac2.service.SetorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/setores")
public class SetorController {

    @Autowired
    private SetorService service;

    // GET
    @GetMapping
    public List<Setor> listar() {
        return service.listar();
    }

    // GET POR ID
    @GetMapping("/{id}")
    public Setor buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }


    // POST
    @PostMapping
    public Setor salvar(@RequestBody Setor setor) {
        return service.criar(setor);
    }

    // PUT
    @PutMapping("/{id}")
    public Setor atualizar(@PathVariable Long id, @RequestBody Setor setor) {
        return service.atualizar(id, setor);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}