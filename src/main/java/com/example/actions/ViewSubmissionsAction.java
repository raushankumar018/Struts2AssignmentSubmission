package com.example.actions;

import com.example.dao.AssignmentDAO;
import com.example.model.AssignmentSubmission;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class ViewSubmissionsAction extends ActionSupport {
    private List<AssignmentSubmission> submissions;

    @Override
    public String execute() {
        submissions = new AssignmentDAO().findAll();
        return SUCCESS;
    }

    public List<AssignmentSubmission> getSubmissions() {
        return submissions;
    }
}
