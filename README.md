# 📚 Digital Library Book Management System  

## 📌 Overview  
The **Digital Library Book Management System** is a **Java Console Application** that allows users to manage a collection of books. It provides functionalities to **add, view, search, update, and delete books** using a simple command-line interface.  

---

## 🚀 Features  
✅ **Add a Book** – Ensures unique book IDs and mandatory fields.  
✅ **View All Books** – Lists all books in the library.  
✅ **Search for a Book** – Allows searching by book ID or title.  
✅ **Update Book Details** – Modify title, author, and availability status.  
✅ **Delete a Book** – Removes a book from the system.  
---

## 🛠️ Technologies Used  
- **Java SE 11+**  
- **JUnit 5** (for unit testing)  
- **Maven** (for build & dependency management)  

---

## 📂 Project Structure  
```
DigitalLibraryBookManagementSystem/
│── src/
│   ├── main/
│   │   ├── LibraryApplication.java   # Main application entry point (console-based)
│   ├── models/
│   │   ├── Book.java                 # Book entity model
│   ├── services/
│   │   ├── LibraryService.java       # Core business logic for book management
│   ├── test/
│   │   ├── LibraryServiceTest.java   # JUnit test cases
│── module-info.java                   # Java module system configuration
```

---

## 🏗️ Setup & Installation  

### ✅ Prerequisites  
Ensure you have the following installed:  
- **Java JDK 11+** ([Download JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html))  

### 🔽 Clone the Repository  
```sh
git clone https://github.com/yogananda222/DigitalLibraryBookManagementSystem.git
cd DigitalLibraryBookManagementSystem
```

### 🔨 Build the Project (if using Maven)  
```sh
mvn clean install
```

---

## 🎯 Running the Application  

### ▶️ Option 1: Run from Command Line  
1. **Compile the Java files**  
   ```sh
   javac -d out src/main/*.java src/models/*.java src/services/*.java
   ```

2. **Run the application**  
   ```sh
   java -cp out main.LibraryApplication
   ```

---

### ▶️ Option 2: Run Using Maven  
```sh
mvn exec:java -Dexec.mainClass="main.LibraryApplication"
```

---

## ✅ Running Tests  
To execute unit tests, run the following command:  
```sh
mvn test
```

---

---

## 👨‍💻 Contributors  
- **Yogananda Naidu** – Developer  

---
