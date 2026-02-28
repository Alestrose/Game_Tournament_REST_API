

The journey into learning Spring Boot and RESTful API's

This project documents my structured journey into learning Spring Boot and building RESTful APIs using layered architecture principles.
Rather than following a tutorial blindly, I focused on understanding how each component (JPA, Hibernate, Spring Data, etc.) fits into the overall system design.

Learnings
  JPA (Jakarta Persistence API)
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
    -Starts embedded Tomcat
    -Configures Hibernate
    -Configures DataSource
    -Scans packages


Architecture  Controller → Service → Repository → Database
REST architecture differs from web application MVC. Consider it "Layered Architecture with MVC principles"
  Controller
    -HTTP requests
    -Request validation (basic)
    -Response formatting
    -Status codes
  Service
    -Business rules
    -Domain validation
    -Orchestration
    -Transaction boundaries
  Repository
    -Database interaction
    -Persists data

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
  Create Player entity class with lombok and jakarta annotations
  test db table "players" is operational via web h2 console @ http://localhost:8080/h2-console

Step 3: The Repository Layer
  Create "PlayerRepository.java" interface
  extends JpaRepository<Player, Long>
    provides crud methods to database
    manages object persistence in database

Step 4: The Service Layer (business logic)
  Create PlayerService.java interface
    -Player createPlayer(Player player);
    -Player getPlayerById(Long id);
    -List<Player> getAllPlayers();
    -void deletePlayer(Long id);
  Create PlayerServiceImpl, extends PlayerService
    -Implement methods

Step 5: The Controller Layer
  Created PlayerController.java (RestController)
    -Maps Get, Post and Delete to Player methods

Step 6: Error Handling
  (Incorrect GET requests return 500 status code which indicates something is broken, instead of 404 status code which indicates something is not found)
  Create ResourceNotFoundException.java
  Create GlobalExceptionHandler.java (@RestControllerAdvice applies this to all controllers)
  Update the thrown exception for getPlayerById in PlayerServiceImpl.java with new ResourceNotFoundException
  
Step 7: Validation Layering
  Import to Player.java: jakarta.validation.constraints.Min; & jakarta.validation.constraints.NotBlank;
  Annotate variables in Player with @NotBlank or @Min where required
  Enable validation in controller
    -add @Valid annotation to createPlayer Method in PlayerController.java
      public Player createPlayer(@Valid @RequestBody Player player){
        return playerService.createPlayer(player);
      }
  
