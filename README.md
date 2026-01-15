# 📝 Full-Stack Todo Management System

[![Spring Boot](https://img.shields.io/badge/Backend-Spring%20Boot%204.x-brightgreen)](https://spring.io/projects/spring-boot)
[![Angular](https://img.shields.io/badge/Frontend-Angular%2016%2B-red)](https://angular.io/)
[![Java](https://img.shields.io/badge/Language-Java%2025-orange)](https://www.oracle.com/java/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

A feature-rich, end-to-end Todo application built with a modern decoupled architecture. This project showcases a RESTful API backend and a reactive Single Page Application (SPA) frontend.

---

## 🌟 Key Features

* **✨ Full CRUD Support**: Seamlessly create, read, update, and delete tasks with real-time state updates.
* **🔍 Dynamic Filtering**: Quickly toggle between *All*, *Pending*, and *Completed* tasks to stay organized.
* **📱 Responsive UI**: A mobile-first design built with Bootstrap, ensuring a smooth experience on desktops, tablets, and smartphones.
* **🛡️ Error Handling**: Robust backend validation with standardized API error responses and user-friendly frontend alerts.

---

## 🏗️ Architecture Overview

The application follows a standard client-server model:
* **Frontend**: Angular components communicate with the backend via RESTful services.
* **Backend**: Spring Boot handles business logic, persistence, and exposes endpoints.
* **Database**: H2 In-memory database (default) for easy setup and testing.

---

## 🛠️ Tech Stack

### Backend (todo-backend)
- **Java 25** & **Spring Boot 4.x**
- **Spring Data JPA** (ORM for database interaction)
- **H2 / MySQL** (Database)
- **Maven** (Build and dependency management)

### Frontend (todo-frontend)
- **Angular 16+** (Framework)
- **RxJS** (Reactive programming)
- **Bootstrap 5** (Styling & Responsive UI)
- **Node.js & NPM**

---

## 📁 Project Structure

```text
.
├── todo-backend/           # Spring Boot Application
│   ├── src/main/java       # Source code (Controllers, Services, Entities)
│   ├── src/main/resources  # Configuration (application.properties)
│   └── Dockerfile          # Backend Containerization
├── todo-frontend/          # Angular Application
│   ├── src/app             # UI Components & Services
│   ├── src/environments    # Environment configs
│   └── Dockerfile          # Frontend Containerization
└── docker-compose.yml      # Multi-container orchestration

ar CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).
```
---

## ⚙️ Getting Started

### Prerequisites
Before you begin, ensure you have the following installed:
- [Java Development Kit (JDK) 17+](https://www.oracle.com/java/technologies/downloads/)
- [Node.js (LTS version)](https://nodejs.org/)
- [Angular CLI](https://angular.io/cli) (`npm install -g @angular/cli`)
- [Maven](https://maven.apache.org/download.cgi)

---

### 🚀 Running the Application

#### 1. Start the Backend
```bash
cd todo-backend
mvn clean install
mvn spring-boot:run
```
The API will be available at http://localhost:8080.

#### 2. Start the Frontend
```bash
cd todo-frontend
npm install
ng serve
```
Open your browser and navigate to http://localhost:4200.

---

## 🔌 API Documentation

The backend provides a standardized RESTful API for the frontend to consume. By default, the base URL is `http://localhost:8080`.

### Endpoints Summary

| Method | Endpoint | Description | Status Code |
| :--- | :--- | :--- | :--- |
| **GET** | `/api/v1/todos` | Retrieve a list of all todo items | `200 OK` |
| **GET** | `/api/v1/todos/{id}` | Retrieve details of a specific todo by ID | `200 OK` |
| **POST** | `/api/v1/todos` | Create and save a new task | `201 Created` |
| **PUT** | `/api/v1/todos/{id}` | Update title, description, or status of a task | `200 OK` |
| **DELETE** | `/api/v1/todos/{id}` | Permanently remove a task from the system | `204 No Content` |

### Data Models

#### Todo Object
The API expects and returns data in the following JSON format:

```json
{
  "id": 1,
  "title": "Finish Project Documentation",
  "description": "Complete the README.md and API docs",
  "completed": false,
  "createdAt": "2024-05-20T10:00:00"
}
```

---

## 🤝 Contributing

Contributions are what make the open-source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.



1.  **Fork** the Project.
2.  **Create** your Feature Branch:
    ```bash
    git checkout -b feature/AmazingFeature
    ```
3.  **Commit** your Changes:
    ```bash
    git commit -m 'Add some AmazingFeature'
    ```
4.  **Push** to the Branch:
    ```bash
    git push origin feature/AmazingFeature
    ```
5.  **Open** a Pull Request.

---

## 📄 License

Distributed under the **MIT License**. See `LICENSE` for more information.

---

### 👤 Author: **Lipi Prajapati**


---
