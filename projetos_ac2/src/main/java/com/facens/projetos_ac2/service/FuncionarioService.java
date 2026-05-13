package com.facens.projetos_ac2.service;

import com.facens.projetos_ac2.entity.Funcionario;
import com.facens.projetos_ac2.entity.Setor;
import com.facens.projetos_ac2.repository.FuncionarioRepository;
import com.facens.projetos_ac2.repository.SetorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    @Autowired
    private SetorRepository setorRepository;

    // LISTAR TODOS
    public List<Funcionario> listar() {
        return repository.findAll();
    }

    // BUSCAR POR ID
    public Funcionario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Funcionário não encontrado"));
    }

    // CRIAR
    public Funcionario criar(Funcionario funcionario) {

        if (funcionario.getNome() == null ||
                funcionario.getNome().isBlank()) {

            throw new RuntimeException("Nome do funcionário é obrigatório");
        }

        if (funcionario.getSetor() != null) {

            Long setorId = funcionario.getSetor().getId();

            Setor setor = setorRepository.findById(setorId)
                    .orElseThrow(() ->
                            new RuntimeException("Setor não encontrado"));

            funcionario.setSetor(setor);
        }
        return repository.save(funcionario);
    }

    // ATUALIZAR
    public Funcionario atualizar(Long id, Funcionario funcionarioAtualizado) {

        Funcionario funcionario = buscarPorId(id);

        funcionario.setNome(funcionarioAtualizado.getNome());

        if (funcionarioAtualizado.getSetor() != null) {

            Long setorId = funcionarioAtualizado.getSetor().getId();

            Setor setor = setorRepository.findById(setorId)
                    .orElseThrow(() ->
                            new RuntimeException("Setor não encontrado"));

            funcionario.setSetor(setor);
        }

        return repository.save(funcionario);
    }

    // DELETAR
    public void deletar(Long id) {
        Funcionario funcionario = buscarPorId(id);
        repository.deleteById(funcionario.getId());
    }
}