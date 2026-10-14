package com.example.actions;

import com.opensymphony.xwork2.ActionSupport;

public class ProfileAction extends ActionSupport {
    private String name = "Student User";
    private String program = "B.Tech - Computer Science";

    @Override
    public String execute() {
        return SUCCESS;
    }

    public String getName() { return name; }
    public String getProgram() { return program; }
}
