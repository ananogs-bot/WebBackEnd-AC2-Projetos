package com.facens.projetos_ac2.service;

import com.facens.projetos_ac2.entity.Projeto;
import com.facens.projetos_ac2.repository.ProjetoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository repository;

    // LISTAR TODOS
    public List<Projeto> listar() {
        return repository.findAll();
    }

    // BUSCAR POR ID
    public Projeto buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Projeto não encontrado"));
    }

    // CRIAR
    public Projeto criar(Projeto projeto) {
        return repository.save(projeto);
    }

    // ATUALIZAR
    public Projeto atualizar(Long id, Projeto projetoAtualizado) {

        Projeto projeto = buscarPorId(id);

        projeto.setDescricao(projetoAtualizado.getDescricao());
        projeto.setDataInicio(projetoAtualizado.getDataInicio());
        projeto.setDataFim(projetoAtualizado.getDataFim());

        return repository.save(projeto);
    }

    // DELETAR
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}