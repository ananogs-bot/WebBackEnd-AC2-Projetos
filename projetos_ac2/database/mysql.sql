DROP DATABASE projetos;
CREATE DATABASE IF NOT EXISTS projetos;
USE projetos;

CREATE TABLE Setor (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Funcionario (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    setor_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_funcionario_setor
        FOREIGN KEY (setor_id)
        REFERENCES Setor(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE Projeto (
    id BIGINT NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(255) NOT NULL,
    data_inicio DATE NOT NULL,
    data_fim DATE NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Projeto_Funcionario (
    projeto_id BIGINT NOT NULL,
    funcionario_id BIGINT NOT NULL,
    PRIMARY KEY (projeto_id, funcionario_id),
    CONSTRAINT fk_pf_projeto
        FOREIGN KEY (projeto_id)
        REFERENCES Projeto(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT fk_pf_funcionario
        FOREIGN KEY (funcionario_id)
        REFERENCES Funcionario(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);


INSERT INTO Setor (nome) VALUES
    ('Tecnologia'),
    ('Recursos Humanos'),
    ('Financeiro');

INSERT INTO Funcionario (nome, setor_id) VALUES
    ('Ana Silva',    1),
    ('Bruno Costa',  1),
    ('Carla Mendes', 2),
    ('Diego Lima',   3);

INSERT INTO Projeto (descricao, data_inicio, data_fim) VALUES
    ('Sistema de Gestão',      '2024-01-15', '2024-06-30'),
    ('App Mobile RH',          '2024-03-01', '2024-09-01'),
    ('Relatório Financeiro',   '2024-02-10', '2024-04-30');

INSERT INTO Projeto_Funcionario (projeto_id, funcionario_id) VALUES
    (1, 1),
    (1, 2),
    (2, 1),
    (2, 3),
    (3, 4);