# Struts2 Assignment Submission System

A web-based student assignment submission portal built using **Apache Struts 2**, **Hibernate ORM**, **MySQL**, and **Maven**.

---

## 📋 Features

- **Assignment Submission**: Form submission with metadata (Student Name, Student ID, Course Name, Assignment Title, Content).
- **Form & Input Validation**:
  - Required fields verification.
  - Student ID format validation (enforces `S12345` format using regex `^S\d{5}$`).
  - Content length validation.
- **File Upload Support**:
  - Supports uploading document files: `.pdf`, `.doc`, `.docx`.
  - Max file size limit: 10 MB.
  - Uploaded files are automatically saved with timestamp prefixes to prevent file name collisions.
- **Submissions Management**:
  - View all student submissions in an interactive dashboard table.
  - Direct download links for attached assignment files.
- **CSV Data Export**:
  - Export submission records to CSV (`submissions.csv`) via Struts2 stream results.
- **Student Profile View**:
  - Dedicated student profile overview.
- **Modern Responsive UI**:
  - Clean card-based design, gradient backgrounds, and responsive layout.

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| **Framework** | Apache Struts 2 (v2.5.33) |
| **ORM / Persistence** | Hibernate Core (v5.6.15.Final) |
| **Database** | MySQL Server 8.0+ |
| **Java Version** | Java 8 (1.8) or higher |
| **Build Tool** | Apache Maven 3.6+ |
| **Application Server** | Apache Tomcat 9+ (or any Servlet 3.1+ compatible container) |
| **Frontend** | JSP, Struts2 Tags, HTML5, CSS3, Vanilla JavaScript |

---

## 🚀 Quickstart & Setup Guide

### 1. Prerequisites
- **Java Development Kit (JDK)**: Java 8+ installed and configured (`JAVA_HOME`).
- **Apache Maven**: Maven 3.6+ installed.
- **MySQL Server**: Running instance (v8.0 recommended).
- **Apache Tomcat**: Tomcat 9 or compatible application server.

---

### 2. Database Setup
Create the MySQL database for the application:

```sql
CREATE DATABASE assignmentdb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

> **Note:** Hibernate is configured with `hibernate.hbm2ddl.auto = update`, meaning database tables (`assignment_submissions`) will be automatically created or updated on startup.

---

### 3. Configure Database Credentials
Open [`src/main/resources/hibernate.cfg.xml`](file:///d:/Struts2AssignmentSubmission/Struts2AssignmentSubmission/src/main/resources/hibernate.cfg.xml) and update the database connection properties with your MySQL credentials:

```xml
<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/assignmentdb?useSSL=false&amp;serverTimezone=UTC</property>
<property name="hibernate.connection.username">your_mysql_username</property>
<property name="hibernate.connection.password">your_mysql_password</property>
```

---

### 4. Build the Application
Compile the code and generate the `.war` package using Maven:

```bash
mvn clean package
```

This generates `Struts2AssignmentSubmission.war` in the `target/` directory.

---

### 5. Deployment & Execution

#### Option A: Deploy to Apache Tomcat
1. Copy the generated `Struts2AssignmentSubmission.war` from `target/` into your Tomcat `webapps/` folder:
   - On Windows: `<Tomcat_Home>/webapps/`
2. Start Apache Tomcat:
   ```cmd
   <Tomcat_Home>/bin/startup.bat
   ```
3. Open your browser and navigate to:
   ```
   http://localhost:8080/Struts2AssignmentSubmission/
   ```

#### Option B: Eclipse / IntelliJ IDE
1. Import the project as an **Existing Maven Project**.
2. Configure Apache Tomcat 9 Server runtime.
3. Run or Debug on Server.

---

## 🧭 Application Routes & Actions

| URL / Action | Target / View | Description |
|---|---|---|
| `/` or `index.jsp` | `index.jsp` | Welcome landing page with links to get started |
| `showForm` | `submit-assignment.jsp` | Assignment submission form |
| `submitAssignment` | `success.jsp` / `failure.jsp` | Action processing submission and file upload |
| `viewSubmissions` | `view-submissions.jsp` | Lists all submitted assignments |
| `profile` | `profile.jsp` | Displays student profile details |
| `exportCsv` | Stream (`submissions.csv`) | Streams CSV export download |

---

## 🔒 Form Constraints & Validation Rules

- **Student Name**: Required field.
- **Student ID**: Required; must match format `S12345` (starts with uppercase `S` followed by 5 digits).
- **Course Name**: Required field.
- **Assignment Title**: Required field.
- **Content**: Required field with word count verification.
- **File Upload**:
  - Optional attachment.
  - Allowed MIME types: PDF (`application/pdf`), MS Word (`application/msword`, `application/vnd.openxmlformats-officedocument.wordprocessingml.document`).
  - Maximum upload size: 10 MB.
  - Uploaded files are persisted under the application's `/uploads` directory at runtime.

---

## 📁 Project Structure

```
Struts2AssignmentSubmission/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │           ├── actions/
│       │           │   ├── ExportCSVAction.java        # Action to stream CSV export
│       │           │   ├── ProfileAction.java          # Student profile action
│       │           │   ├── ShowFormAction.java         # Renders the submission form
│       │           │   ├── SubmitAssignmentAction.java # Processes upload & submission
│       │           │   └── ViewSubmissionsAction.java  # Queries & lists submissions
│       │           ├── dao/
│       │           │   └── AssignmentDAO.java          # Hibernate data access layer
│       │           ├── model/
│       │           │   └── AssignmentSubmission.java   # JPA/Hibernate entity model
│       │           └── util/
│       │               └── HibernateUtil.java          # SessionFactory singleton
│       ├── resources/
│       │   ├── hibernate.cfg.xml                       # Hibernate & DB configuration
│       │   └── struts.xml                              # Struts2 action mappings & interceptors
│       └── webapp/
│           ├── assets/
│           │   ├── css/style.css                       # Application styles & animations
│           │   └── js/app.js                           # Frontend script utilities
│           ├── WEB-INF/
│           │   └── web.xml                             # Struts2 filter mapping configuration
│           ├── failure.jsp                             # Submission error display
│           ├── index.jsp                               # Home landing page
│           ├── profile.jsp                             # Student profile view
│           ├── submit-assignment.jsp                   # Assignment submission form
│           ├── success.jsp                             # Submission success confirmation
│           └── view-submissions.jsp                   # Submissions dashboard table
├── .gitignore                                          # Git ignore configuration
├── pom.xml                                             # Maven project dependencies & build plugins
└── README.md                                           # Project documentation
```

---

## 📄 License
This project is for educational and assignment submission purposes.
