# Quarkus API - Transaction Management

Esta é uma API desenvolvida com o framework Quarkus para gerenciar transações financeiras. A API fornece endpoints para criar, listar, atualizar e excluir transações.

## Endpoints

### Listar todas as transações
**GET** `/transactions`  
Retorna uma lista de todas as transações.

**Resposta de exemplo:**
```json
[
  {
    "id": 1,
    "name": "Compra no supermercado",
    "transactionTypeId": 0,
    "transactionDate": "2023-10-01",
    "amount": -150.75,
    "category": "Alimentação"
  }
]
```

---

### Buscar lista transações por ID do tipo
**GET** `/transactions/{id}`  
Retorna uma lista com transações de um tipo específico.

**Parâmetros:**
- `transactionTypeId` (Integer): ID do tipo da transação.

**Resposta de exemplo:**
```json
[
  {
    "id": 1,
    "name": "Compra no supermercado",
    "transactionTypeId": 0,
    "transactionDate": "2023-10-01",
    "amount": -150.75,
    "category": "Alimentação"
  },
  {
    "id": 2,
    "name": "Ifood",
    "transactionTypeId": 0,
    "transactionDate": "2025-03-26",
    "amount": -52.0,
    "category": "Food"
  }
]
```

---

### Criar uma nova transação
**POST** `/transactions`  
Cria uma nova transação.

**Corpo da requisição:**
```json
{
  "name": "Compra no supermercado",
  "transactionTypeId": 0,
  "transactionDate": "2023-10-01",
  "amount": -150.75,
  "category": "Alimentação"
}
```

**Resposta de exemplo:**
- Status: `201 Created`
- Corpo: A transação criada.

---

### Atualizar uma transação existente
**PUT** `/transactions/{id}`  
Atualiza os dados de uma transação existente.

**Parâmetros:**
- `id` (Long): ID da transação.

**Corpo da requisição:**
```json
{
  "name": "Compra no supermercado atualizada",
  "transactionTypeId": 0,
  "transactionDate": "2023-10-02",
  "amount": -200.00,
  "category": "Lazer"
}
```

**Resposta de exemplo:**
```json
{
  "name": "Compra no supermercado atualizada",
  "transactionTypeId": 0,
  "transactionDate": "2023-10-02",
  "amount": -200.00,
  "category": "Lazer"
}
```

---

### Excluir uma transação
**DELETE** `/transactions/{id}`  
Exclui uma transação pelo ID.

**Parâmetros:**
- `id` (Long): ID da transação.

**Resposta de exemplo:**
- Status: `204 No Content`

---

## Como executar o projeto

### Pré-requisitos
- Java 17 ou superior
- Maven 3.8.1 ou superior

### Passos para inicializar
1. Clone o repositório:
   ```bash
   git clone <URL_DO_REPOSITORIO>
   cd <NOME_DO_REPOSITORIO>
   ```

2. Compile o projeto:
   ```bash
   ./mvnw clean package
   ```

3. Execute a aplicação em modo de desenvolvimento:
   ```bash
   ./mvnw quarkus:dev
   ```

4. Acesse a API em: [http://localhost:8080](http://localhost:8080)

---

## Tecnologias utilizadas
- **Quarkus**: Framework Java para aplicações nativas em nuvem.
- **Jakarta RESTful Web Services (JAX-RS)**: Para criação dos endpoints REST.
- **Jakarta Transactions**: Para gerenciamento de transações.

---

## Estrutura do projeto
- **`src/main/java`**: Código-fonte principal.
- **`src/test/java`**: Testes unitários.
- **`src/main/resources`**: Arquivos de configuração e recursos.

---

## Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests.

---

## Licença
Este projeto está licenciado sob a licença MIT.