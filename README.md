

Project setup

Step1:
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
  Application Properties:
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

Step 2:
  Create Player entity class with lombox and jakarta annotations
    test db table "players" is operational via web h2 console @ http://localhost:8080/h2-console
