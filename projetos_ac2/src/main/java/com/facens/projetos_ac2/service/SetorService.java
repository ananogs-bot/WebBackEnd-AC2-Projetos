package com.facens.projetos_ac2.service;

import com.facens.projetos_ac2.entity.Setor;
import com.facens.projetos_ac2.repository.SetorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetorService {

    @Autowired
    private SetorRepository repository;

    // LISTAR TODOS
    public List<Setor> listar() {
        return repository.findAll();
    }


    // BUSCAR POR ID
    public Setor buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Setor não encontrado"));
    }

    // CRIAR
    public Setor criar(Setor setor) {

        if (setor.getNome() == null ||
                setor.getNome().isBlank()) {

            throw new RuntimeException("Nome do setor é obrigatório");
        }

        return repository.save(setor);
    }

    // ATUALIZAR
    public Setor atualizar(Long id, Setor setorAtualizado) {

        Setor setor = buscarPorId(id);

        setor.setNome(setorAtualizado.getNome());

        return repository.save(setor);
    }

    // DELETAR
    public void deletar(Long id) {

        Setor setor = buscarPorId(id);

        repository.delete(setor);
    }
}