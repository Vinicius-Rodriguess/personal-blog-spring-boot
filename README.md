# 📝 **Back-End para Blog Pessoal (Spring Boot)**

Este projeto é a API back-end para um sistema de blog pessoal. Desenvolvido com **Spring Boot** e **Java**, ele fornece endpoints para gerenciamento de postagens e temas.

---

## 🚀 **Funcionalidades**

### **Back-End**
- API REST para criação, edição, exclusão e listagem de postagens.
- Organização de postagens por temas.
- Integração com banco de dados relacional para persistência de dados.

---

## 🛠️ **Tecnologias Utilizadas**

- **Spring Boot**: Framework para criação de aplicações Java modernas.
- **Java 17+**: Linguagem de programação utilizada.
- **Spring Data JPA**: ORM para interação com o banco de dados.
- **MySQL**: Banco de dados relacional utilizado.
- **Hibernate**: Framework para mapeamento objeto-relacional (JPA).
- **Jakarta Bean Validation**: Validação automática de campos.
- **Maven**: Gerenciador de dependências.

---

## 🔧 **Como o Sistema Funciona**

1. **Gerenciamento de Postagens**: Endpoints para criação, atualização, exclusão e listagem de postagens.
2. **Organização por Temas**: Postagens podem ser categorizadas por temas específicos.
3. **Persistência de Dados**: Todas as informações são armazenadas no banco de dados relacional.

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

---

## 💾 **Exemplo de Uso**

- **Postagens**: Utilize os endpoints `/posts` para criar, listar, atualizar e excluir postagens.
- **Temas**: Utilize os endpoints `/theme` para criar, listar, atualizar e excluir temas.

---

## 📌 **Limitações**

- Ainda **não possui sistema de autenticação**.
- Não possui upload de imagens.
- Não possui interface de usuário (apenas a API).

---

## ✅ **Melhorias Futuras**

- Implementação de autenticação e autorização (JWT).
- Documentação da API com Swagger.
- Relacionamento com entidade Usuário.
- Upload de imagens para postagens.

---

## 👨‍💻 **Autor**

**Vinicius Rodrigues**

- GitHub: [Vinicius-Rodriguess](https://github.com/Vinicius-Rodriguess)
- Email: rodrigues.vini.2004@gmail.com
