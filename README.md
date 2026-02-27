

The journay into learning Spring Boot and RESTful API's

Learnings
  JPA (Kakarta Persistence API)
    -Defines what each annotation means (@entity, @Id...)
    -Defines what EntityManager is
    -Defines how persistence should work
  Hibernate
    -Is the implementation of JPA (the engine doing the work)
    -Converts Java Objects -> SQL
    -Executes SQL queries
    -Converts SQL results -> Java Objects
    -Manages entity lifecycle
    -Handles caching, dirty checking, transactions
  H2
    - Lightweight in memory database
  Spring Data JPA
    -Abstraction layer the dev interacts with directly
    -Builds on top of JPA
    -Generates repository implementations
    -Provides JpaRepository
  Spring Boot
    -Auto configures everything
    -Wires dependencies together
    -Starts embeded Tomcat
    -Configures Hibernate
    -Configures DataSource
    -Scans packages

Step1: Project setup
  Create new Spring Boot project @ https://start.spring.io
    Properties:
      -Project: Maven
      -Language: Java
      -Spring Boot: default stable
      -Group: com.alanmcgillivray
      -Artifact: tournament
      -Packaging: Jar
      Java: 21
    Dependencies:
      -Spring Web
      -Spring Data JPA
      -H2 Database
      -Validation
      -Lombok (optional, but recommended)
  Application Properties:  enables auto creating of db tables for entity annotated classes, and enables devtool h2-console for web based sql queries
    # Application name
    spring.application.name=tournament
    # H2 Database Configuration
    spring.datasource.url=jdbc:h2:mem:tournamentdb
    spring.datasource.driverClassName=org.h2.Driver
    spring.datasource.username=sa
    spring.datasource.password=
    # Enable H2 Console
    spring.h2.console.enabled=true
    spring.h2.console.path=/h2-console
    # JPA / Hibernate
    spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true

Step 2: The Model Layer
  Create Player entity class with lombox and jakarta annotations
  test db table "players" is operational via web h2 console @ http://localhost:8080/h2-console
