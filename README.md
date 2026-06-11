#  Treino API - Gerenciamento de Rotina de Academia

Esta é uma API RESTful desenvolvida com Spring Boot para gerenciar fichas de treino e exercícios de academia. O foco principal é acompanhar a progressão de carga e organizar os treinos diários.

##  Propósito do Microserviço
O objetivo deste sistema é permitir que o usuário organize sua rotina de treinos (focada na divisão Push, Pull e Legs), registrando exercícios, séries e controlando a carga atual de cada movimento para monitorar a evolução física ao longo do tempo.

##  Tecnologias Utilizadas
- **Java 21**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **H2 Database** (Ambiente de Desenvolvimento/Testes)
- **MySQL** (Ambiente de Produção)
- **JUnit 5 & Mockito** (Testes Unitários)
- **Swagger / Springdoc OpenAPI** (Documentação Automática)

##  Como executar o projeto localmente

### Pré-requisitos
- Ter o Java 21 instalado na máquina.
- O projeto utiliza o Maven Wrapper, portanto não é obrigatório ter o Maven instalado globalmente.

### Passos para execução

1. Clone o repositório para o seu computador:
   git clone https://github.com/GagaJB/treino-api.git

2. Acesse a pasta do projeto:
   cd treino-api

3. Execute o projeto usando o Maven Wrapper:
   ./mvnw spring-boot:run

4. A API estará rodando em http://localhost:8080.
5. O banco de dados H2 pode ser acessado em http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:treinodb).

##  Documentação da API (Swagger)
Com o projeto rodando localmente, você pode acessar a documentação interativa através do navegador:
👉 **http://localhost:8080/swagger-ui.html**

##  Exemplos de Utilização (cURL)

Criar uma Ficha (POST):
curl -X POST http://localhost:8080/fichas -H "Content-Type: application/json" -d '{"nome": "Ficha A", "focoMuscular": "Peito e Tríceps"}'

Criar um Exercício (POST):
curl -X POST http://localhost:8080/exercicios -H "Content-Type: application/json" -d '{"nomeMovimento": "Supino", "series": 4, "cargaAtual": 60.0, "fichaId": 1}'

##  Autoria e Divisão de Tarefas
- Isaque Rocha - Estruturação do projeto e criação das entidades (Ficha e Exercício)
- Nicolas Pereia - Configuração de perfis de base de dados e desenvolvimento das rotas REST
- Kaio Vinicyus - Tratamento de exceções e implementação de testes unitários
- Arthur Augusto - Documentação
- Gabriel Botelho - Documentação e deploy na nuvem

##  Deploy
* https://treino-api-btno.onrender.com/swagger-ui/index.html
* **Plataforma utilizada:** RENDER
* **Guia rápido:**
1. **Conteinerização:** Criação de um arquivo `Dockerfile` multi-stage na raiz do projeto para compilar o código com Maven e disponibilizar o artefato `.jar` final utilizando a imagem base estável do Eclipse Temurin (Java 21).
2. **Conexão com GitHub:** Criação de um novo *Web Service* na plataforma Render diretamente conectado ao repositório oficial do projeto.
3. **Ambiente:** Configuração do ambiente de execução (*Language*) definido como **Docker** sob o plano gratuito (*Free*).
4. **Variáveis de Ambiente:** Adição da variável de ambiente global `PORT` com valor `8080` nas configurações avançadas para o correto direcionamento do tráfego web do servidor Tomcat.
