# Projeto Extensionista 2 - Pac-Kids

## Descrição do Projeto

**Pac-kids** é uma plataforma de aprendizado voltada para o ensino de idiomas (Português e Inglês) para crianças. A plataforma permite que os alunos realizem atividades e acumulem pontuações em um sistema de scoreboard, enquanto os responsáveis têm acesso a informações importantes, como boletins, atividades e notificações. O sistema é construído com uma arquitetura de backend em Java/Spring Boot e frontend em React.

## Tecnologias Utilizadas

- **Backend:** Java 21 e Spring Boot
- **Frontend:** React.js
- **Banco de Dados:** PostgreSQL
- **Ferramentas de Desenvolvimento:** Lombok, Spring DevTools, Spring Data JPA, Postman para testes de API

## Estrutura de Branches

- `main`: Branch principal, utilizada apenas após a finalização do desenvolvimento.
- `dev`: Branch de desenvolvimento, onde todas as alterações e novas funcionalidades serão implementadas e testadas antes de serem integradas à `main`.

## Como Clonar o Projeto

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/dev-leomarinho/projeto-extensionista2.git

2. **Acesse o diretório:**
   ```bash
   cd  projeto-extensionista2

3. **Alternar para a branch de desenvolvimento:**
  ```bash
  git checkout dev
  ```


## Endpoints do Backend

| Método HTTP | Endpoint                      | Descrição                                                    |
|-------------|-------------------------------|-------------------------------------------------------------|
| **POST**    | `/api/alunos`                 | Cadastra um novo aluno.                                      |
| **GET**     | `/api/alunos/{id}`            | Retorna informações de um aluno específico pelo ID.          |
| **GET**     | `/api/alunos/{id}/scoreboard` | Retorna o scoreboard do aluno.                               |
| **PUT**     | `/api/alunos/{id}`            | Atualiza informações de um aluno.                            |
| **DELETE**  | `/api/alunos/{id}`            | Remove um aluno do sistema.                                  |
| **POST**    | `/api/responsaveis`           | Cadastra um novo responsável.                                |
| **GET**     | `/api/responsaveis/{id}`      | Retorna informações de um responsável específico pelo ID.    |
| **GET**     | `/api/responsaveis/{id}/scoreboards` | Retorna scoreboards de todos os alunos sob a responsabilidade do responsável. |
| **POST**    | `/api/atividades`             | Cadastra uma nova atividade.                                 |
| **GET**     | `/api/atividades/{id}`        | Retorna informações de uma atividade específica pelo ID.     |
| **PUT**     | `/api/atividades/{id}`        | Atualiza informações de uma atividade.                       |
| **DELETE**  | `/api/atividades/{id}`        | Remove uma atividade do sistema.                             |
| **GET**     | `/api/notificacoes`           | Lista todas as notificações enviadas.                        |


