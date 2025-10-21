# Sistema de Gestión de Biblioteca - Arquitectura de Microservicios

## 🎓 Trabajo de Maestría
**Asignatura**: Microservicios y Orquestación  
**Autor**: Christian Raúl Vazquez  
**Fecha**: 2025

## 📋 Descripción
Sistema completo de gestión bibliotecaria implementado con arquitectura de microservicios, contenerizado con Docker y orquestado mediante Docker Compose. Incluye Kong API Gateway como punto único de entrada.

## 🏗️ Arquitectura del Sistema
### Diagrama de Componentes
<img width="2135" height="1686" alt="Diagrama de Arquitectura" src="https://github.com/user-attachments/assets/ec544ccd-86a3-4a13-bc0b-bfafdf315c57" />

### Microservicios
| Servicio | Puerto | Descripción | Base de Datos |
|----------|--------|-------------|---------------|
| **User Service** | 8081 | Gestión de usuarios y autenticación | users_db |
| **Book Service** | 8082 | Catálogo e inventario de libros | books_db |
| **Loan Service** | 8083 | Préstamos, devoluciones y multas | loans_db |

## 🛠️ Stack Tecnológico

### Backend
- **Java 17** + Spring Boot 3.x
- **Spring Data JPA** - Persistencia
- **Maven** - Gestión de dependencias

### Infraestructura
- **Docker** + Docker Compose
- **Kong API Gateway** - Enrutamiento y gestión de APIs
- **MySQL** - Bases de datos (una por servicio)

### Frontend
- HTML5, CSS3, JavaScript vanilla
- Interfaz modular por microservicio

## 🚀 Despliegue Rápido

### Prerrequisitos
- Docker 20.10+
- Docker Compose 2.0+

### Ejecución
```bash
# Clonar proyecto
git clone https://github.com/Christianrvdv/sistema-biblioteca-microservicios.git
cd sistema-biblioteca-microservicios

# Desplegar todos los servicios
docker-compose up -d

# Verificar servicios
docker-compose ps
```

### URLs de Acceso
Kong Admin API: http://localhost:8001

Kong Proxy: http://localhost:8000

User Service: http://localhost:8081

Book Service: http://localhost:8082

Loan Service: http://localhost:8083

### Estado del Proyecto
Arquitectura base

Contenerización completa

Kong Gateway configurado

Microservicios funcionales

Autenticación JWT

Tests automatizados

Monitoring y logs


### API Documentation
Los servicios exponen los siguientes endpoints principales:

### Book Service
**GET** /api/books - Listar libros

**POST** /api/books - Crear libro

**GET** /api/books/{id} - Obtener libro por ID

### User Service
**GET** /api/users - Listar usuarios

**POST** /api/users - Registrar usuario

**PUT** /api/users/{id} - Actualizar usuario

### Loan Service
**POST** /api/loans - Crear préstamo

**PUT** /api/loans/{id}/return - Devolver libro

🤝 Contribución
Este proyecto es parte de un trabajo académico. Las contribuciones son bienvenidas mediante issues y pull requests.
