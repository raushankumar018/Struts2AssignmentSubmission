<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Submit Assignment</title>
  <link rel="stylesheet" href="assets/css/style.css"/>
</head>
<body class="gradient-bg">
<div class="container slide-up">
  <h1>Submit Assignment</h1>

  <!-- Struts2 form mapped to SubmitAssignmentAction -->
  <s:form action="submitAssignment" method="post" enctype="multipart/form-data" theme="simple" cssClass="card">

    <label>Student Name</label>
    <s:textfield name="studentName" cssClass="input" required="true"/>

    <label>Student ID (e.g., S12345)</label>
    <s:textfield name="studentId" cssClass="input" required="true"/>

    <label>Course Name</label>
    <s:textfield name="courseName" cssClass="input" required="true"/>

    <label>Assignment Title</label>
    <s:textfield name="assignmentTitle" cssClass="input" required="true"/>

    <label>Assignment Content (min 300 words)</label>
    <!-- ✅ Correct field name must match private String content in Action -->
    <s:textarea name="content" cssClass="textarea" rows="10" required="true"></s:textarea>

    <label>Upload File (PDF/DOC/DOCX)</label>
    <s:file name="upload" cssClass="input"/>

    <div class="actions">
      <s:submit cssClass="btn" value="Submit"/>
      <button type="button" class="btn-outlined" onclick="location.href='index.jsp'">Cancel</button>
    </div>
  </s:form>
</div>
</body>
</html>
