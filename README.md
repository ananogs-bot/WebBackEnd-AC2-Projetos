# Sistema de Projetos – AC2 (Ana Araujo e Isabela Jacob)

Projeto desenvolvido para a disciplina de Desenvolvimento Web Back-End utilizando Spring Boot, JPA e banco de dados relacional (MySQL).

O sistema realiza o gerenciamento de:

- Projetos
- Funcionários
- Setores
- Vínculos entre funcionários e projetos

---

# Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Lombok
- MySQL
- Maven
- HTML, CSS e JavaScript
- Postman

---

# Funcionalidades

## Projetos
- Cadastro de projetos
- Busca de projetos por ID
- Busca de projetos por período
- Listagem de projetos
- Atualização de projetos
- Exclusão de projetos
- Vínculo de funcionários ao projeto
- Busca de projetos por funcionário

## Funcionários
- Cadastro de funcionários
- Listagem de funcionários
- Busca por ID
- Atualização
- Exclusão

## Setores
- Cadastro de setores
- Listagem de setores
- Busca por ID
- Atualização
- Exclusão
- Listagem de setores com funcionários

---

# Estrutura do Projeto

```text
src/main/java/com/facens/projetos_ac2
├── controller
├── entity
├── repository
├── service
└── ProjetosAc2Application.java

src/main/resources
├── static
│   ├── index.html
│   ├── style.css
│   └── app.js
└── application.properties
```

---

# Arquitetura Utilizada

O projeto foi desenvolvido utilizando arquitetura em camadas:

## Entity
Representa as tabelas do banco de dados.

## Repository
Responsável pela comunicação com o banco utilizando JPA.

## Service
Responsável pelas regras de negócio e validações.

## Controller
Responsável pelos endpoints da API REST.

---

# Relacionamentos

## Projeto ↔ Funcionário
Relacionamento ManyToMany.

## Funcionário ↔ Setor
Relacionamento ManyToOne.

## Setor ↔ Funcionário
Relacionamento OneToMany.

---

# Endpoints Principais

## Projetos

```http
GET    /projetos
GET    /projetos/{id}
GET    /projetos/funcionario/{id}
GET    /projetos/periodo
POST   /projetos
PUT    /projetos/{id}
DELETE /projetos/{id}
PUT    /projetos/{id}/funcionarios
```

## Funcionários

```http
GET    /funcionarios
GET    /funcionarios/{id}
POST   /funcionarios
PUT    /funcionarios/{id}
DELETE /funcionarios/{id}
```

## Setores

```http
GET    /setores
GET    /setores/{id}
GET    /setores/funcionarios
POST   /setores
PUT    /setores/{id}
DELETE /setores/{id}
```

---


# Regras de Negócio

- Projeto deve possuir descrição
- Setor deve possuir nome
- Funcionário deve possuir nome
- Não é permitido vincular funcionários inexistentes ao projeto
- Busca por ID retorna erro caso o recurso não exista

---

# Frontend

O projeto possui um frontend simples utilizando:

- HTML
- CSS
- JavaScript

Funcionalidades da interface:

- Cadastro de projetos
- Listagem de projetos
- Integração com API REST

---

# Autor

Projeto desenvolvido para a AC2 da disciplina de Desenvolvimento Web Back-End – ADS, por Ana Luiza Nogueira de Araujo e Isabela de Oliveira Jacob.
