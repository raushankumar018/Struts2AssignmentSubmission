package com.example.actions;

import com.example.dao.AssignmentDAO;
import com.example.model.AssignmentSubmission;
import com.opensymphony.xwork2.ActionSupport;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ExportCSVAction extends ActionSupport {

    private InputStream inputStream; // <-- must match struts.xml inputName

    public InputStream getInputStream() {
        return inputStream;
    }

    @Override
    public String execute() {
        try {
            List<AssignmentSubmission> submissions = new AssignmentDAO().findAll();

            StringBuilder sb = new StringBuilder();
            // ✅ Write header
            sb.append("ID,Student Name,Student ID,Course Name,Assignment Title,File Path\n");

            // ✅ Write rows
            for (AssignmentSubmission sub : submissions) {
                sb.append(sub.getId()).append(",");
                sb.append(safe(sub.getStudentName())).append(",");
                sb.append(safe(sub.getStudentId())).append(",");
                sb.append(safe(sub.getCourseName())).append(",");
                sb.append(safe(sub.getAssignmentTitle())).append(",");
                sb.append(safe(sub.getFilePath())).append("\n");
            }

            // ✅ Convert to InputStream for Struts
            inputStream = new ByteArrayInputStream(sb.toString().getBytes(StandardCharsets.UTF_8));

            return SUCCESS;

        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    private String safe(String val) {
        return (val == null) ? "" : val.replace(",", " "); // prevent CSV break
    }
}
	