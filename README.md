# Human Resource Management System (HRM) – Spring Boot

## 📌 Project Overview
This is a **Spring Boot based HRM Backend Application** designed to manage:
- Departments
- Employees
- Attendance
- Leave Requests
- Employee Roles & Status

The project follows **layered architecture** with proper validation, exception handling, and clean API responses.

---

## 🛠️ Technology Stack
- **Language:** Java 8+
- **Framework:** Spring Boot
- **ORM:** Spring Data JPA (Hibernate)
- **Database:** MySQL
- **Build Tool:** Maven
- **Testing Tool:** Postman
- **Utilities:** Lombok

---

## 📂 Project Structure
com.company.hrm
├── controller
├── service
│ └── impl
├── repository
├── entity
├── dto
│ ├── request
│ └── response
├── exception
├── enums
├── util

📦 Standard API Response
{
  "status": "SUCCESS",
  "message": "Department created successfully",
  "data": {}
}

⚠️ Exception Handling

Custom Exceptions:

ResourceNotFoundException

DuplicateRecordException

Handled using @RestControllerAdvice.

🚀 How to Run

Clone repository

Configure MySQL in application.properties

Run Spring Boot application

Test APIs using Postman

🧪 Postman Collection
All APIs have been tested using Postman. You can import the collection here:
https://kharodeshivani-8323784.postman.co/workspace/Projects~fecadc94-39a9-49d8-83ac-7c04db37dc5a/collection/50745397-3526e206-8646-4c6f-a043-6a212790f6bc?action=share&source=copy-link&creator=50745397
