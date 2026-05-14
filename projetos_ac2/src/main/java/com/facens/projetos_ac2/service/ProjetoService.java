package com.facens.projetos_ac2.service;

import com.facens.projetos_ac2.entity.Funcionario;
import com.facens.projetos_ac2.entity.Projeto;
import com.facens.projetos_ac2.repository.FuncionarioRepository;
import com.facens.projetos_ac2.repository.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProjetoService {

    private final ProjetoRepository projetoRepository;
    private final FuncionarioRepository funcionarioRepository;

    public ProjetoService(ProjetoRepository projetoRepository,
                          FuncionarioRepository funcionarioRepository) {
        this.projetoRepository = projetoRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    // LISTAR TODOS
    public List<Projeto> listar() {
        return projetoRepository.findAll();
    }

    // BUSCAR POR ID
    public Projeto buscarPorId(Long id) {
        return projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));
    }

    public List<Projeto> buscarPorPeriodo(LocalDate inicio, LocalDate fim) {
        return projetoRepository.findByDataInicioBetween(inicio, fim);
    }

    // CRIAR PROJETO
    public Projeto criar(Projeto projeto) {
        if (projeto.getDescricao() == null ||
                projeto.getDescricao().isBlank()) {

            throw new RuntimeException("Descrição do projeto é obrigatória");
        }

        if (projeto.getDataInicio().isAfter(projeto.getDataFim())) {

            throw new RuntimeException(
                    "A data de início não pode ser maior que a data fim"
            );
        }
        return projetoRepository.save(projeto);
    }

    // ATUALIZAR PROJETO
    public Projeto atualizar(Long id, Projeto atualizado) {

        Projeto projeto = buscarPorId(id);

        if (atualizado.getDescricao() != null &&
                !atualizado.getDescricao().isBlank()) {

            projeto.setDescricao(atualizado.getDescricao());
        }

        if (atualizado.getDataInicio().isAfter(atualizado.getDataFim())) {

            throw new RuntimeException(
                    "A data de início não pode ser maior que a data fim"
            );
        }

        projeto.setDataInicio(atualizado.getDataInicio());
        projeto.setDataFim(atualizado.getDataFim());

        return projetoRepository.save(projeto);
    }

    // DELETAR
    public void deletar(Long id) {
        projetoRepository.deleteById(id);
    }

    // VINCULAR FUNCIONÁRIOS
    public Projeto adicionarFuncionarios(Long idProjeto, List<Long> funcionariosIds) {

        Projeto projeto = buscarPorId(idProjeto);

        List<Funcionario> funcionarios = funcionarioRepository.findAllById(funcionariosIds);

        if (funcionarios.isEmpty()) {
            throw new RuntimeException("Nenhum funcionário válido encontrado");
        }

        projeto.setFuncionarios(funcionarios);

        return projetoRepository.save(projeto);
    }

    // BUSCAR PROJETOS POR FUNCIONÁRIO
    public List<Projeto> buscarPorFuncionario(Long funcionarioId) {

        Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        return projetoRepository.findAll()
                .stream()
                .filter(p -> p.getFuncionarios().contains(funcionario))
                .toList();
    }
}