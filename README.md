# Quarkus API - Transaction Management

Esta é uma API desenvolvida com o framework Quarkus para gerenciar transações financeiras. A API fornece endpoints para criar, listar, atualizar e excluir transações, tipos de transações e contas bancárias.

## Endpoints

### Transações (`/transactions`)

#### Listar todas as transações
**GET** `/transactions`  
Retorna uma lista de todas as transações.

**Resposta de exemplo:**
```json
[
  {
    "id": 1,
    "name": "Compra no supermercado",
    "transactionTypeId": 1,
    "transactionDate": "2023-10-01",
    "amount": -150.75,
    "category": "Alimentação"
  }
]
```

---

#### Buscar lista de transações por ID do tipo
**GET** `/transactions/{transactionTypeId}`  
Retorna uma lista com transações de um tipo específico.

**Parâmetros:**
- `transactionTypeId` (Long): ID do tipo da transação.

**Resposta de exemplo:**
```json
[
  {
    "id": 1,
    "name": "Compra no supermercado",
    "transactionTypeId": 1,
    "transactionDate": "2023-10-01",
    "amount": -150.75,
    "category": "Alimentação"
  },
  {
    "id": 2,
    "name": "Ifood",
    "transactionTypeId": 1,
    "transactionDate": "2025-03-26",
    "amount": -52.0,
    "category": "Food"
  }
]
```

---

#### Criar uma nova transação
**POST** `/transactions`  
Cria uma nova transação.

**Corpo da requisição:**
```json
{
  "name": "Compra no supermercado",
  "transactionTypeId": 1,
  "transactionDate": "2023-10-01",
  "amount": -150.75,
  "category": "Alimentação"
}
```

**Resposta de exemplo:**
- Status: `201 Created`
- Corpo: A transação criada.

---

#### Atualizar uma transação existente
**PUT** `/transactions/{id}`  
Atualiza os dados de uma transação existente.

**Parâmetros:**
- `id` (Long): ID da transação.

**Corpo da requisição:**
```json
{
  "name": "Compra no supermercado",
  "transactionTypeId": 1,
  "transactionDate": "2023-10-02",
  "amount": -200.00,
  "category": "Lazer"
}
```

**Resposta de exemplo:**
```json
{
  "name": "Compra no supermercado",
  "transactionTypeId": 1,
  "transactionDate": "2023-10-02",
  "amount": -200.00,
  "category": "Lazer"
}
```

---

#### Excluir uma transação
**DELETE** `/transactions/{id}`  
Exclui uma transação pelo ID.

**Parâmetros:**
- `id` (Long): ID da transação.

**Resposta de exemplo:**
- Status: `204 No Content`

---

### Tipos de Transações (`/transaction-types`)

#### Listar todos os tipos de transações
**GET** `/transaction-types`  
Retorna uma lista de todos os tipos de transações.

**Resposta de exemplo:**
```json
[
  {
    "transactionTypeId": 1,
    "name": "Despesa"
  },
  {
    "transactionTypeId": 2,
    "name": "Receita"
  }
]
```

---

#### Buscar tipo de transação por ID
**GET** `/transaction-types/{transactionTypeId}`  
Retorna os detalhes de um tipo de transação específico.

**Parâmetros:**
- `transactionTypeId` (Long): ID do tipo de transação.

**Resposta de exemplo:**
```json
{
  "transactionTypeId": 1,
  "name": "Despesa"
}
```

---

#### Criar um novo tipo de transação
**POST** `/transaction-types`  
Cria um novo tipo de transação.

**Corpo da requisição:**
```json
{
  "name": "Investimento"
}
```

**Resposta de exemplo:**
- Status: `201 Created`
- Corpo: O tipo de transação criado.

---

#### Atualizar um tipo de transação existente
**PUT** `/transaction-types/{transactionTypeId}`  
Atualiza os dados de um tipo de transação existente.

**Parâmetros:**
- `transactionTypeId` (Long): ID do tipo de transação.

**Corpo da requisição:**
```json
{
  "name": "Despesa"
}
```

**Resposta de exemplo:**
```json
{
  "transactionTypeId": 1,
  "name": "Despesa"
}
```

---

#### Excluir um tipo de transação
**DELETE** `/transaction-types/{transactionTypeId}`  
Exclui um tipo de transação pelo ID.

**Parâmetros:**
- `transactionTypeId` (Long): ID do tipo de transação.

**Resposta de exemplo:**
- Status: `204 No Content`

---

### Contas Bancárias (`/bank-accounts`)

#### Listar todas as contas bancárias
**GET** `/bank-accounts`  
Retorna uma lista de todas as contas bancárias.

**Resposta de exemplo:**
```json
[
  {
    "bankAccountId": 1,
    "name": "José",
    "accountNumber": "123456-7",
    "agencyNumber": "001"
  },
  {
    "bankAccountId": 2,
    "name": "Conta Poupança",
    "accountNumber": "987654-3",
    "agencyNumber": "001"
  }
]
```

---

#### Buscar conta bancária por ID
**GET** `/bank-accounts/{bankAccountId}`  
Retorna os detalhes de uma conta bancária específica.

**Parâmetros:**
- `bankAccountId` (Long): ID da conta bancária.

**Resposta de exemplo:**
```json
{
  "bankAccountId": 1,
  "name": "José",
  "accountNumber": "123456-7",
  "agencyNumber": "001"
}
```

---

#### Criar uma nova conta bancária
**POST** `/bank-accounts`  
Cria uma nova conta bancária.

**Corpo da requisição:**
```json
{
  "name": "José",
  "accountNumber": "123456-7",
  "agencyNumber": "001"
}
```

**Resposta de exemplo:**
- Status: `201 Created`
- Corpo: A conta bancária criada.

---

#### Atualizar uma conta bancária existente
**PUT** `/bank-accounts/{bankAccountId}`  
Atualiza os dados de uma conta bancária existente.

**Parâmetros:**
- `bankAccountId` (Long): ID da conta bancária.

**Corpo da requisição:**
```json
{
  "name": "José",
  "accountNumber": "123456-8",
  "agencyNumber": "001"
}
```

**Resposta de exemplo:**
```json
{
  "bankAccountId": 1,
  "name": "José",
  "accountNumber": "123456-8",
  "agencyNumber": "001"
}
```

---

#### Excluir uma conta bancária
**DELETE** `/bank-accounts/{bankAccountId}`  
Exclui uma conta bancária pelo ID.

**Parâmetros:**
- `bankAccountId` (Long): ID da conta bancária.

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