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
   git clone https://github.com/devleomarinho/projeto-extensionista2.git

2. **Acesse o diretório:**
   ```bash
   cd  projeto-extensionista2

3. **Alternar para a branch de desenvolvimento:**
  ```bash
  git checkout dev
  ```


## Descrição das Entidades

1. **Aluno**
   
A entidade Aluno representa as crianças que utilizarão a plataforma para aprender idiomas.

Atributos:
- id: Identificador único do aluno (gerado automaticamente).
- nome: Nome completo do aluno.
- usuario: Nome de usuário para login no sistema.
- senha: Senha para acesso ao sistema (armazenada de forma segura).
- responsavel: Relacionamento com a entidade Responsavel (muitos-para-um).
- atividades: Lista de atividades associadas ao aluno (um-para-muitos).
- scoreboard: Relacionamento com a entidade Scoreboard (um-para-um).

2. **Responsavel**
   
A entidade Responsavel representa os pais ou responsáveis pelas crianças.

Atributos:

- id: Identificador único do responsável (gerado automaticamente).
- nome: Nome completo do responsável.
- usuario: Nome de usuário para login no sistema.
- senha: Senha para acesso ao sistema (armazenada de forma segura).
- alunos: Lista de alunos sob responsabilidade (um-para-muitos).

3. **Atividade**
   
A entidade Atividade representa as atividades que os alunos podem realizar.

Atributos:

- id: Identificador único da atividade (gerado automaticamente).
- titulo: Título da atividade.
- descricao: Descrição detalhada da atividade.
- pontuacao: Pontuação atribuída à atividade.
- aluno: Relacionamento com a entidade Aluno (muitos-para-um).


4. **Scoreboard**
   
A entidade Scoreboard representa o sistema de pontuação dos alunos.

Atributos:

- id: Identificador único do scoreboard (gerado automaticamente).
- aluno: Relacionamento com a entidade Aluno (um-para-um).
- pontuacaoTotal: Total de pontos acumulados pelo aluno.
- atividades: Lista de atividades que contribuíram para a pontuação (um-para-muitos).


5. **Notificacao**
   
A entidade Notificacao representa as notificações que podem ser enviadas aos responsáveis e alunos.

Atributos:

- id: Identificador único da notificação (gerado automaticamente).
- mensagem: Texto da notificação.
- data: Data em que a notificação foi enviada.
- responsavel: Relacionamento com a entidade Responsavel (muitos-para-um).
- aluno: Relacionamento com a entidade Aluno (muitos-para-um).


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


