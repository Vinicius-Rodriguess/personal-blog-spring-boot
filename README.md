# 📝 **Back-End para Blog Pessoal (Spring Boot)**

Este projeto é a API back-end para um sistema de blog pessoal. Desenvolvido com **Spring Boot** e **Java**, ele fornece endpoints REST para gerenciamento de postagens e temas, com autenticação JWT, documentação Swagger e testes automatizados.

---

## 🚀 **Funcionalidades**

### **Back-End**
- API REST para criação, edição, exclusão e listagem de postagens.
- Organização de postagens por temas.
- Sistema de autenticação com **JWT** (JSON Web Token).
- Segurança com **Spring Security**.
- Documentação automática da API com **Swagger**.
- Testes automatizados com **JUnit 5**.
- Integração com banco de dados relacional para persistência de dados.

---

## 🛠️ **Tecnologias Utilizadas**

- **Spring Boot**: Framework para criação de aplicações Java modernas.
- **Java 17+**: Linguagem de programação utilizada.
- **Spring Data JPA**: ORM para interação com o banco de dados.
- **MySQL**: Banco de dados relacional utilizado.
- **H2**: Banco de dados em memória utilizado para testes.
- **Hibernate**: Framework para mapeamento objeto-relacional (JPA).
- **Jakarta Bean Validation**: Validação automática de campos.
- **Spring Security + JWT**: Autenticação e autorização.
- **Springdoc OpenAPI (Swagger)**: Documentação da API.
- **JUnit 5**: Testes automatizados.
- **Maven**: Gerenciador de dependências.

---

## 🔧 **Como o Sistema Funciona**

1. **Autenticação JWT**: O sistema gera um token JWT ao realizar login, protegendo os endpoints sensíveis.
2. **Gerenciamento de Postagens**: Endpoints protegidos para criação, atualização, exclusão e listagem de postagens.
3. **Organização por Temas**: Postagens são organizadas e categorizadas por temas.
4. **Documentação Swagger**: Interface gráfica interativa acessível via navegador para testar os endpoints.
5. **Testes com JUnit**: Cobertura de funcionalidades com testes unitários e de integração.

---

## 📋 **Requisitos**

- **Java 17** ou superior.
- **Maven** para gerenciamento de dependências.
- **MySQL** como banco de dados.

---

## 🔧 **Como Configurar o Projeto**

1. Clone este repositório:
   ```bash
   git clone https://github.com/Vinicius-Rodriguess/personal-blog-spring-boot.git
   cd personal-blog-spring-boot
   ```

2. Configure o banco de dados:
   - Crie um banco de dados no MySQL.
   - Atualize o arquivo `src/main/resources/application.properties` com as credenciais do seu banco de dados.

3. Compile e execute o projeto:
   ```bash
   ./mvnw spring-boot:run
   ```
   ou
   ```bash
   mvn spring-boot:run
   ```

4. Acesse a documentação da API via Swagger:
   ```
   http://localhost:8080/swagger-ui.html
   ```

---

## 💾 **Exemplo de Uso**

- **Autenticação**: Realize login via endpoint `/user/login` e utilize o token JWT para acessar as rotas protegidas.
- **Postagens**: Utilize os endpoints `/posts` para criar, listar, atualizar e excluir postagens.
- **Temas**: Utilize os endpoints `/theme` para criar, listar, atualizar e excluir temas.

---

## ✅ **Testes**

- Testes automatizados estão localizados na pasta `src/test/java/`.
- Executar com:
   ```bash
   mvn test
   ```

---

## 📌 **Limitações Atuais**

- Ainda **não possui upload de imagens**.
- Interface de usuário não está inclusa (somente back-end).

---

## 📈 **Melhorias Futuras**

- Upload de imagens para postagens.
- Interface web ou mobile para consumo da API.
- Perfis de usuário com roles diferenciadas (admin, autor, leitor).
- Paginação e ordenação nos endpoints de listagem.

---

## 👨‍💻 **Autor**

**Vinicius Rodrigues**

- GitHub: [Vinicius-Rodriguess](https://github.com/Vinicius-Rodriguess)
- Email: rodrigues.vini.2004@gmail.com
