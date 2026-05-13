package com.facens.projetos_ac2.repository;

import com.facens.projetos_ac2.entity.Projeto;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

    // Buscar projeto com funcionários
    @EntityGraph(attributePaths = "funcionarios")
    Optional<Projeto> findWithFuncionariosById(Long id);

    // Buscar projetos por período
    List<Projeto> findByDataInicioBetween(
            LocalDate inicio,
            LocalDate fim
    );

    // Buscar projetos por funcionário
    @Query("""
            SELECT p
            FROM Projeto p
            JOIN p.funcionarios f
            WHERE f.id = :funcionarioId
            """)
    List<Projeto> buscarProjetosPorFuncionario(
            @Param("funcionarioId") Long funcionarioId
    );
}