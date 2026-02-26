# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

JBMP is a desktop BMP image editor built with Java SE 8 and Swing. It supports opening, editing (filters, transforms, color channels), and saving BMP files.

## Build Commands

```bash
mvn clean compile          # Compile
mvn test                   # Run unit tests (JUnit 4)
mvn verify                 # Run integration tests (*IT.java)
mvn clean package          # Build JAR
```

Run the application:
```bash
java -cp target/Jbmp-1.0.0-SNAPSHOT.jar com.maxicorrea.jbmp.configuration.Application
```

## Architecture

The codebase follows MVP (Model-View-Presenter) with Clean Architecture layering:

- **`configuration/`** — Entry point (`Application.java`) and XML config loading. Bootstraps Swing EDT, creates views, wires use cases.
- **`domain/`** — Core models: `Image` (2D pixel array), `Pixel` (immutable RGB with validation), `Size` (dimensions). Copy-on-write semantics.
- **`persistence/`** — BMP binary format I/O (`ImageReader`/`ImageWriter`). Handles 24-bit RGB, little-endian headers, bottom-to-top pixel order.
- **`presentation/`** — View interfaces (`AppView`, `ImageView`, `OperationView`) abstracting UI from logic. `AppViewContext` is a static service locator holding view references.
- **`usecases/`** — Command pattern: `UseCase` interface with `execute()`. `AbstractUseCase` provides template for image filters. `AppUseCasesContext` is the factory that instantiates all ~18 use cases (filters, transforms, flips, rotations, file ops).
- **`swing/`** — Concrete Swing implementation of the presentation interfaces.
- **`utilswing/`** — Reusable Swing components (collapsible menus, draggable title bar, icon loading, color/text constants).

**Data flow:** User clicks menu button → `UseCase.execute()` → reads image from `AppViewContext.imageView` → applies pixel transformation → calls `updateImage()` → canvas repaints.

## Key Conventions

- Java 8 target, Maven build with three profiles: `develop` (default), `preproduction`, `production`
- Domain objects use copy constructors for immutability
- All image operations are implemented as separate `UseCase` classes
- Test dependencies available: JUnit 4.13.1, JUnitParams, Mockito
- Integration tests use `*IT.java` naming convention (Maven Failsafe)
- Resources: icons in `src/main/resources/images/`, icon paths mapped in `application.xml`
