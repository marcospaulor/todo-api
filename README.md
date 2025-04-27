# To-Do List RESTful API

Uma API RESTful para gerenciamento de tarefas (To-Do List), desenvolvida com Spring Boot, Gradle, PostgreSQL e Docker. Este projeto foi criado como uma prática para aprender conceitos de desenvolvimento de APIs, containerização e boas práticas de engenharia de software.

## 📋 Sobre o Projeto

A API permite criar, listar, visualizar, atualizar e excluir tarefas, com uma estrutura simples e endpoints REST bem definidos. O projeto utiliza tecnologias modernas e inclui containerização com Docker para facilitar a configuração e execução em diferentes ambientes.

### Funcionalidades
- Criar uma tarefa com título, descrição e status.
- Listar todas as tarefas.
- Visualizar uma tarefa específica por ID.
- Atualizar os dados de uma tarefa.
- Excluir uma tarefa.

### Tecnologias Utilizadas
- **Java 17**: Linguagem principal.
- **Spring Boot 3.x**: Framework para construção da API.
- **Gradle (Kotlin DSL)**: Gerenciador de dependências.
- **PostgreSQL 15**: Banco de dados relacional.
- **Docker**: Containerização da aplicação e banco de dados.
- **Insomnia**: Ferramenta para testes manuais dos endpoints.

## 🚀 Como Executar

### Pré-requisitos
- [JDK 17](https://adoptium.net/) instalado.
- [Docker](https://www.docker.com/) e [Docker Compose](https://docs.docker.com/compose/) instalados.
- [Gradle](https://gradle.org/) (opcional, o projeto inclui o Gradle Wrapper).
- [Insomnia](https://insomnia.rest/) para testar os endpoints.

### Passos para Configuração
1. **Clone o repositório**:
   ```bash
   git clone https://github.com/<seu-usuario>/todo-api.git
   cd todo-api
   ```

2. **Construa o projeto**:
   ```bash
   ./gradlew build
   ```

3. **Execute com Docker**:
   ```bash
   docker-compose up --build
   ```
    - A API estará disponível em `http://localhost:8080`.
    - O PostgreSQL estará disponível em `localhost:5432` (banco: `tododb`, usuário: `postgres`, senha: `postgres`).

4. **Parar a aplicação**:
    - Pressione `Ctrl+C` ou execute:
      ```bash
      docker-compose down
      ```

## 🛠️ Endpoints da API

A API está disponível em `http://localhost:8080/api/tasks`. Abaixo estão os endpoints disponíveis:

| Método | Endpoint                | Descrição                     | Exemplo de Body (JSON)                              |
|--------|-------------------------|-------------------------------|----------------------------------------------------|
| `POST` | `/api/tasks`           | Criar uma nova tarefa         | `{"title": "Estudar", "description": "Spring Boot", "completed": false}` |
| `GET`  | `/api/tasks`           | Listar todas as tarefas       | -                                                  |
| `GET`  | `/api/tasks/{id}`      | Obter uma tarefa por ID       | -                                                  |
| `PUT`  | `/api/tasks/{id}`      | Atualizar uma tarefa          | `{"title": "Estudar", "description": "Concluído", "completed": true}` |
| `DELETE` | `/api/tasks/{id}`    | Excluir uma tarefa            | -                                                  |

### Exemplo de Requisição (POST)
```json
POST http://localhost:8080/api/tasks
Content-Type: application/json

{
  "title": "Estudar Spring Boot",
  "description": "Completar o tutorial de API REST",
  "completed": false
}
```

**Resposta** (status 200):
```json
{
  "id": 1,
  "title": "Estudar Spring Boot",
  "description": "Completar o tutorial de API REST",
  "completed": false,
  "createdAt": "2025-04-27T10:00:00"
}
```

## 🧪 Testando com Insomnia
1. Abra o Insomnia e crie uma nova coleção chamada "To-Do API".
2. Adicione requisições para cada endpoint (veja a tabela acima).
3. Envie as requisições e verifique as respostas.
4. Certifique-se de que os dados estão sendo persistidos no PostgreSQL.

## 📂 Estrutura do Projeto
```
todo-api/
├── src/
│   ├── main/
│   │   ├── java/com/example/todoapi/
│   │   │   ├── model/        # Entidades JPA (Task)
│   │   │   ├── repository/   # Repositórios Spring Data JPA
│   │   │   ├── service/      # Lógica de negócios
│   │   │   ├── controller/   # Controladores REST
│   │   │   └── TodoApiApplication.java
│   │   └── resources/
│   │       └── application.properties
├── Dockerfile                # Configuração da imagem Docker
├── docker-compose.yml        # Orquestração de serviços
├── .dockerignore             # Arquivos ignorados pelo Docker
├── .gitignore                # Arquivos ignorados pelo Git
├── build.gradle.kts          # Configuração do Gradle
└── README.md                 # Documentação do projeto
```

## 🐳 Docker
- **Dockerfile**: Define a imagem da aplicação (baseada em `openjdk:17-jdk-slim`).
- **docker-compose.yml**: Configura dois serviços:
    - `app`: A aplicação Spring Boot (porta 8080).
    - `db`: Banco PostgreSQL (porta 5432).
- Os dados do PostgreSQL são persistidos no volume `pgdata`.

## 🔒 Boas Práticas Aplicadas
- Estrutura MVC para separação de responsabilidades.
- Injeção de dependência via construtores.
- Respostas HTTP com códigos de status apropriados (200, 404, etc.).
- Containerização para portabilidade.
- Documentação clara e versionamento com Git.
- Configurações sensíveis gerenciadas via variáveis de ambiente.

## 📚 Próximos Passos
- Adicionar validações com Bean Validation (`@NotBlank`, `@Valid`).
- Implementar autenticação com Spring Security.
- Criar testes unitários e de integração com JUnit e Mockito.
- Integrar Swagger/OpenAPI para documentação automática.
- Implantar a API em um serviço como AWS, GCP ou Heroku.

## 🤝 Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests com melhorias.

## 📧 Contato
Para dúvidas ou sugestões, entre em contato via [dev.silva.marcos@gmail.com] ou abra uma issue no repositório.

---

**Desenvolvido com 💻 e ☕ por Marcos Paulo Rodrigues**