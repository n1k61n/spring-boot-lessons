## Purpose
This file gives concise, actionable guidance for AI coding agents working on this Spring Boot project so they become productive immediately.

## Big Picture
- **Architecture**: A small Spring Boot web app (package `com.example.bootStrap`) using MVC + JPA. Controllers render Thymeleaf templates located in `src/main/resources/templates` and static assets live in `src/main/resources/static`.
- **Data layer**: JPA entities in `src/main/java/com/example/bootStrap/models` with Spring Data repositories under `src/main/java/com/example/bootStrap/repostories` (note the package name typo — see "Gotchas").
- **Why this structure**: The app is a blog-style site (Clean Blog theme) where controllers return template names directly and the persistence layer persists posts/users to PostgreSQL.

## Key Files (quick map)
- **App entry**: `src/main/java/com/example/bootStrap/BootStrapApplication.java`
- **Controllers**: `src/main/java/com/example/bootStrap/controllers/*` (return template filenames like `index.html`)
- **Models**: `src/main/java/com/example/bootStrap/models/*` (JPA entities using Lombok)
- **Repositories**: `src/main/java/com/example/bootStrap/repostories/*` (Spring Data JPA interfaces)
- **Services**: `src/main/java/com/example/bootStrap/services/*` (service interfaces; implementations may be missing/added)
- **Templates**: `src/main/resources/templates/*` (Thymeleaf with `thymeleaf-layout-dialect`)
- **Config**: `src/main/resources/application.properties` (Postgres connection, `spring.jpa.hibernate.ddl-auto=update`)
- **Build**: `pom.xml` (Java 25, Spring Boot 4, Lombok/annotation processing configured)

## Project-specific conventions & patterns
- **Controller returns include `.html`**: Controller methods return strings like `"index.html"` (instead of the more common `"index"`). When adding new controllers, follow this pattern.
- **Repository package name**: Repositories use package `repostories` (misspelling). Do not rename packages lightly — Spring Boot scans from the main package so this works, but renaming will require updating imports and possibly component scanning.
- **Lombok in use**: Models use Lombok (`@Data`, `@Builder`, etc.). Ensure annotation processing is enabled in IDE and the `maven-compiler-plugin` is present in `pom.xml`.
- **Thymeleaf layout**: The project uses `thymeleaf-layout-dialect` and the `layout.html` template as the base. Keep partials and static paths consistent with current templates.
- **DB auto-update**: `spring.jpa.hibernate.ddl-auto=update` — schema changes are applied automatically at runtime. Be cautious with destructive schema changes in production.

## Build / Run / Test (Windows PowerShell)
- **Run with Maven wrapper (Windows PowerShell)**:
  - `./mvnw.cmd spring-boot:run`
- **Package jar**:
  - `./mvnw.cmd -DskipTests package`
  - Run: `java -jar target\bootStrap-0.0.1-SNAPSHOT.jar`
- **Run tests**:
  - `./mvnw.cmd test`
- **IDE**: Import as a Maven project; main class: `com.example.bootStrap.BootStrapApplication`.

## Database & credentials (local dev)
- DB config in `src/main/resources/application.properties`:
  - `spring.datasource.url=jdbc:postgresql://localhost:5432/BootStrap`
  - `spring.datasource.username=postgres`
  - `spring.datasource.password=12345`
- Uses PostgreSQL driver runtime scope (`pom.xml`). If DB is unavailable tests or run will fail — either run a local Postgres or change to an in-memory DB for testing.

## Debugging tips
- **Startup failures**: Look at the stacktrace (main class is `BootStrapApplication`). Common issues: DB connectivity, Lombok annotation processing not enabled, or missing bean implementations for service interfaces.
- **Template errors**: Controller methods return exact template names (e.g., `"post.html"`) — missing or misnamed files in `templates/` produce 500 errors.

## Typical change guidelines
- To add a new page: add `templates/newpage.html`, add an endpoint in a controller that `return "newpage.html"`, and add any model/repository/service as needed under the existing packages.
- To add persistence: create JPA entity under `models/`, create `repostories/YourRepository extends JpaRepository<...>`, inject into a service under `services/` and call from a controller.

## Small gotchas to watch for
- **`repostories` vs `repositories`**: This repo uses `repostories` package name. Keep imports consistent; renaming will require updates across the codebase.
- **Controller visibility**: Some controllers are package-private (no `public`), e.g., `HomeController` — Spring still detects them because component scan finds classes annotated with `@Controller`. Preserve visibility unless you understand the scan semantics.
- **Return values include `.html`**: Be consistent with existing controllers when returning template names.

If any part of this guidance is unclear or you'd like me to expand examples (e.g., a template + controller + repository scaffold), tell me which section to improve and I'll iterate.
