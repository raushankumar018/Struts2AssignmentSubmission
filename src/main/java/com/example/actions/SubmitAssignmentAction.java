package com.example.actions;

import com.example.dao.AssignmentDAO;
import com.example.model.AssignmentSubmission;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.util.ServletContextAware;   // ✅ fixed import

import javax.servlet.ServletContext;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class SubmitAssignmentAction extends ActionSupport implements ServletContextAware {
    private String studentName;
    private String studentId;
    private String courseName;
    private String assignmentTitle;
    private String content;

    // File upload fields
    private File upload;
    private String uploadContentType;
    private String uploadFileName;

    private ServletContext servletContext;

    // For messages
    private String failureReason;

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public String getFailureReason() { return failureReason; }

    public String execute() {
        try {
            // Word count validation (you can keep this check just for validation)
            int wordCount = countWords(content);
            if (wordCount < 5) { // or whatever minimum you want
                failureReason = "assignment content has only " + wordCount + " words (minimum 50).";
                return INPUT;
            }

            String savedPath = null;
            if (upload != null) {
                List<String> allowed = Arrays.asList(
                    "application/pdf",
                    "application/msword",
                    "application/vnd.openxmlformats-officedocument.wordprocessingml.document"
                );
                if (!allowed.contains(uploadContentType)) {
                    failureReason = "uploaded file type must be PDF or DOC/DOCX.";
                    return INPUT;
                }

                String uploadDirPath = servletContext.getRealPath("/uploads");
                File uploadDir = new File(uploadDirPath);
                if (!uploadDir.exists()) uploadDir.mkdirs();
                String destName = System.currentTimeMillis() + "_" + uploadFileName.replaceAll("\\s+","_");
                File dest = new File(uploadDir, destName);
                FileUtils.copyFile(upload, dest);
                savedPath = "uploads/" + destName;
            }

            AssignmentSubmission sub = new AssignmentSubmission();
            sub.setStudentName(studentName);
            sub.setStudentId(studentId);
            sub.setCourseName(courseName);
            sub.setAssignmentTitle(assignmentTitle);
            sub.setFilePath(savedPath);

            new AssignmentDAO().save(sub);
            return SUCCESS;

        } catch (Exception e) {
            failureReason = "server error: " + e.getMessage();
            e.printStackTrace();
            return ERROR;
        }
    }

    @Override
    public void validate() {
        if (isBlank(studentName)) addFieldError("studentName", "Student Name is required.");
        if (isBlank(studentId)) {
            addFieldError("studentId", "Student ID is required.");
        } else if (!studentId.matches("^S\\d{5}$")) {
            addFieldError("studentId", "Student ID must match format S12345.");
        }
        if (isBlank(courseName)) addFieldError("courseName", "Course Name is required.");
        if (isBlank(assignmentTitle)) addFieldError("assignmentTitle", "Assignment Title is required.");
        if (isBlank(content)) addFieldError("content", "Assignment content is required.");
        if (hasFieldErrors()) {
            StringBuilder sb = new StringBuilder();
            getFieldErrors().forEach((k,v)->{
                if (!v.isEmpty()) sb.append(v.get(0)).append(" ");
            });
            failureReason = sb.toString().trim();
        }
    }

    private boolean isBlank(String s) { return s == null || s.trim().isEmpty(); }

    private int countWords(String s) {
        if (s == null) return 0;
        String[] parts = s.trim().split("\\s+");   // ✅ fixed
        int count = 0;
        for (String p : parts) if (!p.isEmpty()) count++;
        return count;
    }

    // Getters and setters
    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public String getAssignmentTitle() { return assignmentTitle; }
    public void setAssignmentTitle(String assignmentTitle) { this.assignmentTitle = assignmentTitle; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public File getUpload() { return upload; }
    public void setUpload(File upload) { this.upload = upload; }
    public String getUploadContentType() { return uploadContentType; }
    public void setUploadContentType(String uploadContentType) { this.uploadContentType = uploadContentType; }
    public String getUploadFileName() { return uploadFileName; }
    public void setUploadFileName(String uploadFileName) { this.uploadFileName = uploadFileName; }
}
