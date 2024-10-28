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
4. **Alterar as configurações do banco de dados:**
   
   Edite o arquivo application.properties, substituindo os campos abaixo pelo nome do banco, host, usuário e senha de acordo com as configurações locais da sua máquina:
   ```bash
       spring.application.name=pac-kids
      spring.datasource.url=jdbc:postgresql://localhost:5432/pac-kids
      spring.datasource.username=seuusuario
      spring.datasource.password=suasenha
   ```
## Descrição das Entidades

1. **Aluno**
   
A entidade Aluno representa as crianças que utilizarão a plataforma para aprender idiomas.

Atributos:
- id: Identificador único do aluno (gerado automaticamente).
- nome: Nome completo do aluno.
- email: Email do aluno.
- CPF: CPF do Aluno.
- dataNascimento: Data de nascimento do aluno.
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
- email: Email do responsável.
- CPF: CPF do responsável.
- telefone: Telefone do responsável.
- usuario: Nome de usuário para login no sistema.
- senha: Senha para acesso ao sistema (armazenada de forma segura).
- alunos: Lista de alunos sob responsabilidade (um-para-muitos).
- notificacoes: Lista de notificações recebidas pelo responsável (um-para-muitos).

3. **Atividade**
   
A entidade Atividade representa as atividades que os alunos podem realizar.

Atributos:

- id: Identificador único da atividade (gerado automaticamente).
- titulo: Título da atividade.
- descricao: Descrição detalhada da atividade.
- tipo: Tipo da atividade realizada.
- pontuacao: Pontuação atribuída à atividade.
- dataConclusao: Data de conclusão da atividade
- aluno: Relacionamento com a entidade Aluno (muitos-para-um).


4. **Scoreboard**
   
A entidade Scoreboard representa o sistema de pontuação dos alunos.

Atributos:

- id: Identificador único do scoreboard (gerado automaticamente).
- pontuacaoTotal: Total de pontos acumulados pelo aluno.
- ultimaAtualizacao: Data da atualização mais recente.
- aluno: Relacionamento com a entidade Aluno (um-para-um).
- atividades: Lista de atividades que contribuíram para a pontuação (um-para-muitos).


5. **Notificacao**
   
A entidade Notificacao representa as notificações que podem ser enviadas aos responsáveis e alunos.

Atributos:

- id: Identificador único da notificação (gerado automaticamente).
- mensagem: Texto da notificação.
- dataEnvio: Data em que a notificação foi enviada.
- responsavel: Relacionamento com a entidade Responsavel (muitos-para-um).
- aluno: Relacionamento com a entidade Aluno (muitos-para-um).


## Endpoints do Backend

| Método HTTP | Endpoint                      | Descrição                                                    |
|-------------|-------------------------------|-------------------------------------------------------------|
| **POST**    | `/alunos`                     | Cadastra um novo aluno.                                      |
| **GET**     | `/alunos`                     | Retorna informações sobre todos os alunos cadastrados        |
| **GET**     | `/alunos/{id}`                | Retorna informações de um aluno específico pelo ID.          |
| **GET**     | `/alunos/{id}/scoreboard`     | Retorna o scoreboard do aluno.                               |
| **PUT**     | `/alunos/{id}`                | Atualiza informações de um aluno.                            |
| **DELETE**  | `/alunos/{id}`                | Remove um aluno do sistema.                                  |
| **POST**    | `/responsaveis`               | Cadastra um novo responsável.                                |
| **GET**     | `/responsaveis`               | Retorna informações sobre todos os responsáveis.             |
| **GET**     | `/responsaveis/{id}`          | Retorna informações de um responsável específico pelo ID.    |
| **GET**     | `/responsaveis/{id}/scoreboards` | Retorna scoreboards de todos os alunos sob a responsabilidade do responsável. |
| **POST**    | `/atividades`                 | Cadastra uma nova atividade.                                 |
| **GET**     | `/atividades/{id}`            | Retorna informações de uma atividade específica pelo ID.     |
| **PUT**     | `/atividades/{id}`            | Atualiza informações de uma atividade.                       |
| **DELETE**  | `/atividades/{id}`            | Remove uma atividade do sistema.                             |
| **GET**     | `/notificacoes`               | Lista todas as notificações enviadas.                        |


