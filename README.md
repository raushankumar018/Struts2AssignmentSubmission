# Struts2 Assignment Submission (Struts2 + Hibernate + MySQL)

## Quickstart
1. Create MySQL DB:
```sql
CREATE DATABASE assignmentdb CHARACTER SET utf8mb4;
```
2. Update `src/main/resources/hibernate.cfg.xml` with your MySQL username/password.
3. Build & run:
```bash
mvn clean package
```
Deploy the generated WAR to Tomcat 9+ (or use `mvn tomcat7:run` with the appropriate plugin if you prefer).
4. Visit: `http://localhost:8080/Struts2AssignmentSubmission/`

## Notes
- Uploads are saved under `<webapp>/uploads` at runtime.
- Allowed files: PDF, DOC, DOCX.
- Student ID format enforced: `S12345`.
- Minimum content length: 300 words; otherwise redirects to `failure.jsp` with details.
- Success redirects to `success.jsp` with buttons for profile, view submissions, export CSV, or submit another.
