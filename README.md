# Wells Fargo Software Engineering – Task 2: Implement a Data Model

This project is part of the **Wells Fargo Software Engineering Virtual Experience** on Forage. The goal of Task 2 is to implement the data model designed in Task 1 as JPA-annotated Java entity classes within a Spring Boot application.

---

## Project Overview

The system is a **financial advisor portfolio management platform**. It allows financial advisors to manage their clients and track securities held across client portfolios.

---

## Data Model

The entity relationship follows this hierarchy:

```
FinancialAdvisor
    └── Client (many)
            └── Portfolio (many)
                    └── PortfolioSecurity (many) ──► Security
```

### Entities

| Entity | Description |
|---|---|
| `FinancialAdvisor` | A registered advisor who manages one or more clients |
| `Client` | A client belonging to an advisor, with contact information |
| `Portfolio` | A named portfolio owned by a client, with a creation date |
| `Security` | A financial instrument (stock, bond, ETF) identified by ticker |
| `PortfolioSecurity` | Join entity linking a portfolio to a security, recording quantity, purchase price, and purchase date |

---

## Tech Stack

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **H2 (in-memory database)** — used for development/testing

---

## Project Structure

```
src/
└── main/
    └── java/
        └── com/wellsfargo/counselor/
            ├── CounselorApplication.java
            └── entity/
                ├── FinancialAdvisor.java
                ├── Client.java
                ├── Portfolio.java
                ├── Security.java
                └── PortfolioSecurity.java
```

---

## Getting Started

### Prerequisites

- Java 17+
- Maven

### Running the Application

```bash
# Clone the repo
git clone https://github.com/<your-username>/wells-fargo-task-2.git
cd wells-fargo-task-2

# Build and run
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`.

---

## JPA Implementation Notes

Each entity follows these conventions required by the task:

- Annotated with `@Entity` from `javax.persistence`
- Primary key auto-generated via `@GeneratedValue(strategy = GenerationType.IDENTITY)`
- Every field annotated with `@Column` or a relationship annotation (`@OneToMany`, `@ManyToOne`)
- A full constructor initializing all instance variables
- A protected no-arg constructor for JPA
- Getters and setters for all fields (no setter for ID fields)

---

## Resources

- [Spring Boot JPA Docs](https://docs.spring.io/spring-boot/docs/3.0.4/reference/htmlsingle/#data.sql.jpa-and-spring-data)
- [Spring Accessing Data with JPA Guide](https://spring.io/guides/gs/accessing-data-jpa)
- [Starter Repo](https://github.com/vagabond-systems/wells-fargo-task-2)
