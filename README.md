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

---

# Captura de Tela (Evidências)

## Postman

<img width="1917" height="1019" alt="Postman (1)" src="https://github.com/user-attachments/assets/2664067e-09b5-4a51-8f2c-dea8383c4ee3" />

<img width="1914" height="1022" alt="Postman (2)" src="https://github.com/user-attachments/assets/33e7e543-8529-4bb1-97b8-b74902b87fc8" />

<img width="1915" height="1018" alt="Postman (3)" src="https://github.com/user-attachments/assets/a1e8f387-06d7-4bf3-84ac-a7dda19cc603" />

<img width="1919" height="1018" alt="Postman (4)" src="https://github.com/user-attachments/assets/fb58beb7-fb41-4b2d-96f1-acfe8be0715c" />


## Estrutura das Pastas
<img width="1919" height="1024" alt="Código" src="https://github.com/user-attachments/assets/647fc064-e0ce-4457-903c-987f2fe63e3b" />

## Banco de Dados
<img width="1916" height="1019" alt="Banco de Dados (1)" src="https://github.com/user-attachments/assets/9163a616-3e70-48da-b080-8c98f4f65a91" />

<img width="1917" height="1020" alt="Banco de Dados (2)" src="https://github.com/user-attachments/assets/78ad97fc-34ca-4df1-a457-3a97672f4383" />

<img width="1918" height="1018" alt="Banco de Dados (3)" src="https://github.com/user-attachments/assets/1697f11a-c14a-483a-8163-851e5f076099" />


## Frontend
<img width="1919" height="973" alt="Frontend (1)" src="https://github.com/user-attachments/assets/071b4462-ad09-435b-9a38-c8e29b5aa207" />

<img width="1911" height="965" alt="Frontend (2)" src="https://github.com/user-attachments/assets/63ba0ef5-a24b-4923-9708-385039b832a6" />

<img width="1894" height="971" alt="Frontend (3)" src="https://github.com/user-attachments/assets/9f5d55e3-2057-4b58-ab6a-4bdf07f7b6a0" />
