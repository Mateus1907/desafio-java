# Desafio Técnico — Microserviço Java

API REST desenvolvida com **Spring Boot 3** e **Java 17**.

---

## ✅ Pré-requisitos

| Ferramenta | Versão mínima | Download |
|---|---|---|
| Java (JDK) | 17 | https://adoptium.net |
| Maven | 3.8 | https://maven.apache.org/download.cgi |
| Git | qualquer | https://git-scm.com |

Verifique antes de começar:
```bash
java -version
mvn -version
```

---

## 🚀 Como clonar e rodar

```bash
# 1. Clonar
git clone https://github.com/Mateus1907/desafio_java.git
cd desafio_java

# 2. Rodar
mvn spring-boot:run
```

A API estará disponível em: `http://localhost:8080`

---

## 📡 Endpoints

### POST `/api/media` — Calcular média do aluno

**Corpo da requisição:**
```json
{
  "nome": "João",
  "nota1": 7.0,
  "nota2": 8.0
}
```

**Respostas possíveis:**

| Condição | Resposta |
|---|---|
| Média > 5 | `Parabéns João, você foi aprovado.` |
| Média < 5 | `João, você foi reprovado.` |
| Média = 5 | `João, você não atingiu a nota de corte e foi reprovado.` |

**Exemplo (Linux/Mac):**
```bash
curl -X POST http://localhost:8080/api/media \
  -H "Content-Type: application/json" \
  -d '{"nome":"Maria","nota1":6.0,"nota2":7.0}'
```

**Exemplo (Windows CMD):**
```cmd
curl -X POST http://localhost:8080/api/media -H "Content-Type: application/json" -d "{\"nome\":\"Maria\",\"nota1\":6.0,\"nota2\":7.0}"
```

---

### GET `/api/datetime` — Data e hora atual

```bash
curl http://localhost:8080/api/datetime
```

**Resposta:**
```json
{
  "mensagem": "Data e hora local: 09/06/2026 18:45:00"
}
```

---

## 🏗️ Estrutura do Projeto

```
src/main/java/com/desafio/api/
├── DesafioApiApplication.java      # Ponto de entrada Spring Boot
├── controller/
│   ├── DesafioController.java      # Endpoints REST
│   └── GlobalExceptionHandler.java # Tratamento global de erros
├── service/
│   ├── MediaService.java           # Interface (contrato)
│   └── MediaServiceImpl.java       # Implementação da lógica
├── model/
│   └── Aluno.java                  # Modelo de domínio
└── dto/
    ├── AlunoRequestDTO.java        # Dados de entrada
    └── RespostaDTO.java            # Dados de saída
```

---

## 🧱 Conceitos de OOP Aplicados

| Conceito | Onde está aplicado |
|---|---|
| **Classe** | `Aluno`, `MediaServiceImpl`, `DesafioController` |
| **Objeto** | `new Aluno(...)` em `MediaServiceImpl` |
| **Interface** | `MediaService` — contrato do serviço |
| **Encapsulamento** | Atributos `private` + getters/setters |
| **Implementação** | `MediaServiceImpl implements MediaService` |
| **Construtor** | `Aluno(String, double, double)` |

---

## ✅ Validações

- `nome`: obrigatório, não pode ser vazio
- `nota1` e `nota2`: obrigatórias, entre `0.0` e `10.0`

Em caso de erro de validação, a API retorna **HTTP 400** com a descrição do problema.
