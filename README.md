# 📚 Bookstore API

Bookstore API is a Spring Boot application for managing books, categories, and orders. It provides RESTful APIs for CRUD operations, authentication, and efficient data management.

---

## 🚀 Features
- ✅ Manage **Categories**: Create, update, delete, and search
- ✅ Manage **Books**: CRUD operations, filter by category
- ✅ Manage **Users**: Register, login, and role-based access
- ✅ **JWT Authentication** and Authorization
- ✅ **Advanced Search** by keyword
- ✅ **Global Exception Handling** following REST best practices
- ✅ **Swagger/OpenAPI** documentation

---

## 🛠️ Tech Stack
- **Java 21**
- **Spring Boot 3.x**
- **Spring Data JPA / Hibernate**
- **MySQL 8.x**
- **Lombok**
- **MapStruct**
- **Spring Security + JWT**
- **Swagger UI (OpenAPI)**

---

## 📂 Project Structure

bookstore/
├── src/main/java/BookStore/khaiJava/
│ ├── controller/ # REST Controllers
│ ├── dto/ # Data Transfer Objects
│ │ ├── request/
│ │ └── response/
│ ├── entity/ # JPA Entities
│ ├── mapper/ # MapStruct Mappers
│ ├── repository/ # Spring Data JPA Repositories
│ ├── service/ # Business Logic Services
│ └── config/ # Security & App Config
├── src/main/resources/
│ ├── application.properties
│ └── schema.sql # (Optional) Database initialization
└── pom.xml


## ⚙️ Installation & Setup

### 1️⃣ Requirements
- **Java 21+**
- **Maven 3.9+**
- **MySQL 8+**

### 2️⃣ Clone the Repository

git clone https://github.com/your-username/bookstore.git
cd bookstore
3️⃣ Configure Database
Edit src/main/resources/application.properties:
properties
Copy
Edit
spring.datasource.url=jdbc:mysql://localhost:3306/bookstore_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

4️⃣ Build & Run
mvn clean install
mvn spring-boot:run
The application will be available at:
http://localhost:8080/bookstore

🔑 Main API Endpoints
Method	Endpoint	Description
POST	/api/categories	Create a new category
GET	/api/categories	Get all categories
POST	/api/books	Create a new book
GET	/api/books	Get all books
POST	/api/auth/register	Register a new user
POST	/api/auth/login	Login and get JWT token

📄 Full documentation: Swagger UI

🧪 API Testing
Use Postman or Swagger UI.

Import Bookstore.postman_collection.json (if provided).

🛡️ Security
JWT Authentication is enabled.

Each request requires:

Authorization: Bearer <JWT_TOKEN>
✅ Roadmap
 Add Spring Validation

 Implement Order and Payment modules

 Add Docker Compose (MySQL + App)

 Deploy to Render / Railway / AWS

🤝 Contributing
Fork this repo

Create a new branch (feature/your-feature)

Commit your changes (git commit -m "Add new feature")

Push to the branch and create a Pull Request

📜 License
This project is licensed under the MIT License.

👨‍💻 Author
Minh Khai
📧 Email: your-email@example.com
🌐 GitHub: your-username

