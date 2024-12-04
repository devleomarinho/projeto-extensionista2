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



## Descrição das Entidades

1. **Aluno**
   
A entidade Aluno representa as crianças que utilizarão a plataforma para aprender idiomas.

Atributos:
- id: Identificador único do aluno (gerado automaticamente).
- nome: Nome completo do aluno.
- cpf: CPF do aluno
- email: Endereço de email do aluno.
- dataNascimento: Data de nascimento do aluno.
  
2. **Responsavel**
   
A entidade Responsavel representa os pais ou responsáveis pelas crianças.

Atributos:

- id: Identificador único do responsável (gerado automaticamente).
- nome: Nome completo do responsável.
- cpf: CPF do responsável
- email: Endereço de email do responsável.
- dataNascimento: Data de nascimento do responsável.
- telefone: Número de telefone do responsável.
  
3. **Atividade**
   
A entidade Atividade representa as atividades que os alunos podem realizar.

Atributos:

- id: Identificador único da atividade (gerado automaticamente).
- nome: Título da atividade.
- descricao: Descrição detalhada da atividade.
- scoreboard: Pontuação atribuída à atividade.


4. **Pergunta**
   
A entidade Pergunta representa um pergunta usada em uma atividade de exemplo.

Atributos:

- id: Identificador único da pergunta (gerado automaticamente).
- texto: Pergunta a ser armazenada e relacionada com uma atividade. 
- atividade: Relacionamento desta entidade com uma atividade, através da atividade_id (muitos-para-um).
- resposta: Relacionamento desta entidade com uma resposta, para verificação de acertos da pergunta (um-para-muitos).


5. **Resposta**
   
A entidade Resposta serve para armazenar a resposta correta de uma pergunta específica da atividade de exemplo.

Atributos:

- id: Identificador único da notificação (gerado automaticamente).
- texto: Texto da resposta corrreta.
- pergunta: Relacionamento com a entidade pergunta, através do atributo pergunta_id (um-para-um).

6. **DTOs**

O package de DTOs (Data Transfer Object) contém três classes usadas para transferência de dados usadas na camada Controller:

- PerguntaDTO: transfere os atributos **texto** e **resposta** da entidade Pergunta;
- RespostaDTO: transfere o atributo **texto** da entidade Resposta;
- AtividadeComPerguntas: transfere os atributos **nome**, **descricao** e uma lista de **PerguntaDTO** da entidade Atividade

## Endpoints do Backend

| Método HTTP | Endpoint                      | Descrição                                                    |
|-------------|-------------------------------|--------------------------------------------------------------|
| **POST**    | `/alunos`                     | Cadastra um novo aluno.                                      |
| **GET**     | `/alunos/{id}`                | Retorna informações de um aluno específico pelo ID.          |
| **GET**     | `/alunos`                     | Retorna uma lista de alunos.                                 |
| **PUT**     | `/alunos/{id}`                | Atualiza informações de um aluno.                            |
| **DELETE**  | `/alunos/{id}`                | Remove um aluno do sistema.                                  |
| **POST**    | `/responsaveis`               | Cadastra um novo responsável.                                |
| **GET**     | `/responsaveis/{id}`          | Retorna informações de um responsável específico pelo ID.    |
| **GET**     | `/responsaveis                | Retorna uma lista de responsáveis cadastrados.               |
| **POST**    | `/atividades/criar`           | Cadastra uma nova atividade.                                 |
| **POST**    | `/atividades/verificar/{perguntaId}`| Verificar a resposta de uma pergunta                   |
| **GET**     | `/atividades/{id}`            | Retorna informações de uma atividade específica pelo ID.     |
| **PUT**     | `/atividades/{id}`            | Atualiza informações de uma atividade.                       |
| **DELETE**  | `/atividades/{id}`            | Remove uma atividade do sistema.                             |
| **GET**     | `/atividades`                 | Lista todas as atividades cadastradas                        |

## Esquema de entidades

![image](https://github.com/user-attachments/assets/95012c33-a439-4a03-a54e-f4a1e2384592)



## Protótipos das telas:

![image](https://github.com/user-attachments/assets/786c7a67-da26-4d68-ad4e-464ea28e9f8f)


![image](https://github.com/user-attachments/assets/d4c15411-93c8-46a8-b7e8-b1c834c00645)
