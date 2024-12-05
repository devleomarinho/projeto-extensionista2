# Projeto Extensionista - Pac-Kids

## Descrição do Projeto

**Pac-kids** é uma plataforma de aprendizado voltada para o ensino de inglês para crianças. A plataforma permite que os alunos realizem atividades e acumulem pontuações em um sistema de scoreboard, enquanto os responsáveis têm acesso a informações importantes, como boletins e atividades. O sistema é construído com uma arquitetura de backend em Java/Spring Boot e frontend em React.

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

# Frontend

As interfaces de usuário foram desenvolvidas com React em conjunto com Vite e TypeScript, e a navegação entre as telas utiliza react-router-dom.

## Funcionalidades Principais

Navegação entre páginas com react-router-dom, utilizando componentes modulares e reutilizáveis para melhor organização e manutenção do código. A interface é intuitiva e responsiva, voltada para o público infantil.

## Tecnologias Utilizadas

- React: Biblioteca para construção de interfaces de usuário
- Vite: Ferramenta de desenvolvimento para projetos front-end com foco em velocidade e eficiência
- TypeScript: Superset do JavaScript que adiciona tipagem estática
- react-router-dom: Biblioteca para navegação entre páginas no React

## Documentação das Telas
Cada tela da aplicação foi projetada com um fluxo amigável para crianças e inclui elementos visuais atrativos. 

-Tela Inicial: Tela de boas-vindas com acesso ao menu principal. 
- Aulas: Interface de seleção de aulas com conteúdos organizados.
- Jogos Interativos: Tela de atividades para praticar vocabulário e gramática.


### Protótipos das telas:

![image](https://github.com/user-attachments/assets/786c7a67-da26-4d68-ad4e-464ea28e9f8f)


![image](https://github.com/user-attachments/assets/d4c15411-93c8-46a8-b7e8-b1c834c00645)


### Telas finalizadas

- Tela inicial: 

![packids_telainicial](https://github.com/user-attachments/assets/1c9243c1-f1a0-480a-aa00-00e1f4246a97)

- Tela de login:

![packids_cadastro](https://github.com/user-attachments/assets/cd8fa138-2f6b-47fb-b0c7-014e88bcbe11)

- Telas de cadastro:

![packids_login](https://github.com/user-attachments/assets/2234cd20-3a5b-4c3a-8415-8c441831b2d5)

- Tela de iniciar atividade:

![packids_iniciaratividade](https://github.com/user-attachments/assets/ba4d0ad7-fb4f-4f13-9c50-f1b267df9638)

- Tela de atividade:
  
![packids_atividade](https://github.com/user-attachments/assets/a6b7af48-af05-4c30-b304-958095efd0f0)

- Tela de pontuação

![packids_pontuacao](https://github.com/user-attachments/assets/d51a2290-c86f-4b28-8d66-6b8f0bc6078a)

# Backend 

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


