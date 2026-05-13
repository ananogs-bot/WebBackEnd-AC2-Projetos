package com.facens.projetos_ac2.repository;

import com.facens.projetos_ac2.entity.Setor;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Long> {

    // LISTAR SETORES COM FUNCIONÁRIOS
    @EntityGraph(attributePaths = "funcionarios")
    List<Setor> findAll();
}